package com.example.nazkar.animals;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.nazkar.ItemFragment;
import com.example.nazkar.R;

public class animalsFragment extends Fragment {

    private animalsViewModel animalsViewModel;
    ImageView bull;
    private Spanned Text;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        animalsViewModel =
                ViewModelProviders.of(this).get(animalsViewModel.class);
        View root = inflater.inflate(R.layout.animals, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);

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
}
