package com.example.nazkar.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nazkar.R;
import com.example.nazkar.animals.animalsFragment;
import com.example.nazkar.animals.animalsViewModel;
import com.example.nazkar.crops.cropsFragment;
import com.example.nazkar.traders.tradersFragment;

public class homeFragment extends Fragment {

    private animalsViewModel animalsViewModel;
    TextView textview;
    private Spanned Text;
    Button animals;
    Button crops;
    Button traders;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        animalsViewModel =
                ViewModelProviders.of(this).get(animalsViewModel.class);
        View root = inflater.inflate(R.layout.home, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        getActivity().setTitle("");
        animals = root.findViewById(R.id.animalsButton);
        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animalsFragment fragment = new animalsFragment();
                replaceFragment(fragment);
            }
        });
        crops = root.findViewById(R.id.cropsButton);
        crops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cropsFragment fragment = new cropsFragment();
                replaceFragment(fragment);
            }
        });
        traders = root.findViewById(R.id.tradersButton);
        traders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tradersFragment fragment = new tradersFragment();
                replaceFragment(fragment);
            }
        });

        return root;
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(getId() , fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
