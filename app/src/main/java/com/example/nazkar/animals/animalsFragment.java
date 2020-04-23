package com.example.nazkar.animals;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


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
