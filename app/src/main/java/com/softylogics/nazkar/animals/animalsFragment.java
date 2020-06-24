package com.softylogics.nazkar.animals;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.softylogics.nazkar.ItemFragment;
import com.softylogics.nazkar.R;
import com.softylogics.nazkar.RVAdapterFroAds;
import com.softylogics.nazkar.adslist.DummyData;

import java.util.ArrayList;
import java.util.List;

public class animalsFragment extends Fragment {

    private animalsViewModel animalsViewModel;
    ImageView bull;
    private Spanned Text;
    private int mColumnCount = 2;
    private ItemFragment.OnListFragmentInteractionListener mListener;
    List<DummyData> list = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        makelist(R.drawable.quail, "Quail" , "Rs.1000/-");
        makelist(R.drawable.quail2, "Quail" , "Rs.2000/-");
        makelist(R.drawable.pigeon, "Pigeon" , "Rs.5000/-");
        makelist(R.drawable.pelican, "Pelican" , "Rs.7000/-");
        makelist(R.drawable.penguin, "Penguin" , "Rs.12000/-");
        makelist(R.drawable.seagull, "Seagull" , "Rs.13000/-");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.animals, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);



            Context context = root.getContext();
            RecyclerView recyclerView =  root.findViewById(R.id.listre);
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new RVAdapterFroAds( list, mListener));

        showBackButton();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Animals");
        bull = root.findViewById(R.id.bull);
        bull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment animalList = new ItemFragment();
                replaceFragment(animalList);
            }
        });
        return root;
    }
    public void showBackButton() {
        if (getActivity() instanceof AppCompatActivity) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(getId() , fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void makelist(int drawable , String title , String price) {
        DummyData d = new DummyData();
        Bitmap image = BitmapFactory.decodeResource(this.getResources() , drawable);
        d.setImage(image);
        d.setPrice(price);
        d.setTitle(title);
        list.add(d);
    }
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyData item);
    }
}
