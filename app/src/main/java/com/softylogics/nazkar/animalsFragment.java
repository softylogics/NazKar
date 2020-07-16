package com.softylogics.nazkar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.softylogics.nazkar.adslist.DummyData;
import com.softylogics.nazkar.animals.latestAdsFragment;
import com.softylogics.nazkar.animals.latestAdsViewModel;

import java.util.ArrayList;
import java.util.List;

public class animalsFragment extends Fragment {

    private AnimalsViewModel mViewModel;
    private com.softylogics.nazkar.animals.latestAdsViewModel latestAdsViewModel;
    ImageView bull;
    private Spanned Text;
    private int mColumnCount = 3;

    List<DummyData> list = new ArrayList<>();

    public static animalsFragment newInstance() {
        return new animalsFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        makelist(R.drawable.index, "Quail" , "Rs.1000/-");
        makelist(R.drawable.index, "Quail" , "Rs.2000/-");
        makelist(R.drawable.index, "Pigeon" , "Rs.5000/-");
        makelist(R.drawable.index, "Pelican" , "Rs.7000/-");
        makelist(R.drawable.index, "Penguin" , "Rs.12000/-");
        makelist(R.drawable.index, "Seagull" , "Rs.13000/-");
        makelist(R.drawable.index, "Quail" , "Rs.1000/-");
        makelist(R.drawable.index, "Quail" , "Rs.2000/-");
        makelist(R.drawable.index, "Pigeon" , "Rs.5000/-");
        makelist(R.drawable.index, "Pelican" , "Rs.7000/-");
        makelist(R.drawable.index, "Penguin" , "Rs.12000/-");
        makelist(R.drawable.index, "Seagull" , "Rs.13000/-");
        makelist(R.drawable.index, "Quail" , "Rs.1000/-");
        makelist(R.drawable.index, "Quail" , "Rs.2000/-");
        makelist(R.drawable.index, "Pigeon" , "Rs.5000/-");
        makelist(R.drawable.index, "Pelican" , "Rs.7000/-");
        makelist(R.drawable.index, "Penguin" , "Rs.12000/-");
        makelist(R.drawable.index, "Seagull" , "Rs.13000/-");
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.animals_fragment, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);



        Context context = root.getContext();
        RecyclerView recyclerViewads =  root.findViewById(R.id.animalsads);
        RecyclerView recyclerViewanimals =  root.findViewById(R.id.recyclerviewanimals);

        recyclerViewanimals.setLayoutManager(new LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL, false));
        recyclerViewanimals.setAdapter(new RVAdapterForCircularAds( list));


        recyclerViewads.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        recyclerViewads.setAdapter(new RVAdapterFroAds( list));


        showBackButton();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Animals");

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AnimalsViewModel.class);
        // TODO: Use the ViewModel
    }

}