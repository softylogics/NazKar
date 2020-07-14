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
    private int mColumnCount = 1;
    private ItemFragment.OnListFragmentInteractionListener mListener;
    List<DummyData> list = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        makelist(R.drawable.index, "Quail" , "Rs.1000/-");
        makelist(R.drawable.index, "Quail" , "Rs.2000/-");
        makelist(R.drawable.index, "Pigeon" , "Rs.5000/-");
        makelist(R.drawable.index, "Pelican" , "Rs.7000/-");
        makelist(R.drawable.index, "Penguin" , "Rs.12000/-");
        makelist(R.drawable.index, "Seagull" , "Rs.13000/-");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.animals, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);



            Context context = root.getContext();
            RecyclerView recyclerViewads =  root.findViewById(R.id.listre);
        RecyclerView recyclerViewanimals =  root.findViewById(R.id.animalsRecycler);
        RecyclerView recyclerViewcrops =  root.findViewById(R.id.cropsRecycler);
        RecyclerView recyclerViewtraders =  root.findViewById(R.id.tradersRecycler);


        recyclerViewads.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL , false));
        recyclerViewads.setAdapter(new RVAdapterFroAds( list, mListener));
        recyclerViewanimals.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL , false));
        recyclerViewanimals.setAdapter(new RVAdapterFroAds( list, mListener));
        recyclerViewcrops.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL , false));
        recyclerViewcrops.setAdapter(new RVAdapterFroAds( list, mListener));
        recyclerViewtraders.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL , false));
        recyclerViewtraders.setAdapter(new RVAdapterFroAds( list, mListener));

        showBackButton();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Latest Ads");

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
