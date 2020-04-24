package com.example.nazkar.animals;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
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


import com.example.nazkar.ItemFragment;
import com.example.nazkar.MyItemRecyclerViewAdapter;
import com.example.nazkar.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class animalsFragment extends Fragment {

    private animalsViewModel animalsViewModel;
    ImageView bull;
    private Spanned Text;
    private int mColumnCount = 2;
    private ItemFragment.OnListFragmentInteractionListener mListener;
    List<String> list = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        makelist();
        View root = inflater.inflate(R.layout.animals, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        if (root instanceof RecyclerView) {
            Context context = root.getContext();
            RecyclerView recyclerView =  root.findViewById(R.id.listre);
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter( list, mListener));
        }
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
    private void makelist() {

        list = Arrays.asList(getResources().getStringArray(R.array.book_titles));

    }
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(String item);
    }
}
