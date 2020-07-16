package com.softylogics.nazkar;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class animalsList extends Fragment {

    private AnimalsListViewModel mViewModel;
    ListView lv;
    ArrayAdapter<String> adapter;
    ArrayList list;

    public static animalsList newInstance() {
        return new animalsList();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.add("Goats");
        list.add("Cows");
        list.add("Cattle");
        list.add("Sheeps");
        list.add("Camel");
        list.add("Others");



    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.animals_list_fragment, container, false);
        lv = root.findViewById(R.id.listvanimalsnames);
        adapter = new ArrayAdapter<String>(getContext(), R.layout.animals_list_fragment ,list);
        lv.setAdapter(adapter);

        return root;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AnimalsListViewModel.class);

    }

}