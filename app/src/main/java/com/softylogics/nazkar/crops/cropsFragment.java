package com.softylogics.nazkar.crops;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.softylogics.nazkar.R;

public class cropsFragment extends Fragment {

    private cropsViewModel cropsViewModel;
    private TextView textview;
    private Spanned Text;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cropsViewModel =
                ViewModelProviders.of(this).get(cropsViewModel.class);
        View root = inflater.inflate(R.layout.crops, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);


        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Crops");

        return root;
    }
}
