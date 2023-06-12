package com.example.kyrsovaya2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;
public class thi_frag extends Fragment{
    public thi_frag(){
        super(R.layout.third_fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment, container, false);

        List<Item> itemList = new ArrayList<Item>();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_thi);

        for(int i = 0; i < 200; i++) {
            itemList.add(new Item( R.drawable.book, "book " + i));
        }

        AdapterRecyclerView adapterRecyclerView = new AdapterRecyclerView(getContext(), itemList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterRecyclerView);

        return view;
    }
}