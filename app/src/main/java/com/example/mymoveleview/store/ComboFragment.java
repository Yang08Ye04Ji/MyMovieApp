package com.example.mymoveleview.store;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mymoveleview.R;

import java.util.ArrayList;

public class ComboFragment extends Fragment {

    RecyclerView store_combo_recyclerview;
    RelativeLayout relativeLayout;
    GridLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_combo, container, false);

        store_combo_recyclerview = layout.findViewById(R.id.store_combo_recyclerview);
        layoutManager = new GridLayoutManager(getContext(),2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {

                int gridPosition = i % 2;
                switch (gridPosition){
                    case 0:
                    case 1:
                        return 1;
                    case 2:
                    case 3:
                        return 3;
                }

                return 0;
            }
        });

        ArrayList<StoreInfo> storeInfoArrayList = new ArrayList<>();

        storeInfoArrayList.add(new StoreInfo(R.drawable.combo_01,"기본콤보","8,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.combo_02,"더블콤보","11,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.combo_03,"스몰세트","6,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.combo_04,"라지세트","13,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.combo_05,"고메세트","9,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.combo_06,"고메더블콤보","11,500원"));



        store_combo_recyclerview.setLayoutManager(layoutManager);
        StoreAdapter storeAdapter = new StoreAdapter(storeInfoArrayList);
        store_combo_recyclerview.setAdapter(storeAdapter);




        return layout;
    }

}
