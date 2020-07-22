package com.softylogics.nazkar;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class offering extends Fragment {

    private OfferingViewModel mViewModel;
    ImageView animalsButton;
    ImageView cropsButton;
    ImageView tradersButton;
    public static offering newInstance() {
        return new offering();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        View root =  inflater.inflate(R.layout.offering_fragment, container, false);
        animalsButton  = root.findViewById(R.id.animalsbutton);
        animalsButton.setClipToOutline(true);
        cropsButton =root.findViewById(R.id.cropsbutton);
        cropsButton.setClipToOutline(true);
        tradersButton =root.findViewById(R.id.tradersbutton);
        tradersButton.setClipToOutline(true);
        animalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment animals = new animalsFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, animals).addToBackStack(null).commit();
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OfferingViewModel.class);
        // TODO: Use the ViewModel
    }

}