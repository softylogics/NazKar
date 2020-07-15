package com.softylogics.nazkar.home;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.softylogics.nazkar.R;
import com.softylogics.nazkar.animals.latestAdsFragment;
import com.softylogics.nazkar.animals.latestAdsViewModel;
import com.softylogics.nazkar.crops.cropsFragment;
import com.softylogics.nazkar.traders.tradersFragment;

public class homeFragment extends Fragment {

    private latestAdsViewModel latestAdsViewModel;
    TextView textview;
    private Spanned Text;
    Button animals;
    Button crops;
    Button traders;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        latestAdsViewModel =
                ViewModelProviders.of(this).get(latestAdsViewModel.class);
        View root = inflater.inflate(R.layout.home, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        getActivity().setTitle("");
        animals = root.findViewById(R.id.animalsButton);
        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                latestAdsFragment fragment = new latestAdsFragment();
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
