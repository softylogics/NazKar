package com.softylogics.nazkar;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.softylogics.nazkar.adslist.DummyData;

import java.util.List;

public class animalSubScreen extends Fragment {

    private AnimalSubScreenViewModel mViewModel;
    RecyclerView subscreenrecyclerv;
    RVAdapterForCircularAds adapter;
    ListView listView;
    ListViewAdapter adapterlistview;
    private List<DummyData> list;
    private ItemFragment.OnListFragmentInteractionListener listner;

    public static animalSubScreen newInstance() {
        return new animalSubScreen();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.animal_sub_screen_fragment, container, false);
        subscreenrecyclerv = root.findViewById(R.id.recyclerviewsubscreen);
        subscreenrecyclerv.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL, false));
        adapter = new RVAdapterForCircularAds(list, listner);
        subscreenrecyclerv.setAdapter(adapter);
        listView = root.findViewById(R.id.listviewsubscreen);
        listView.setAdapter(adapterlistview);


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AnimalSubScreenViewModel.class);
        // TODO: Use the ViewModel
    }

}