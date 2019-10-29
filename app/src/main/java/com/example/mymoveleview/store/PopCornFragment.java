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


public class PopCornFragment extends Fragment {

    RecyclerView store_popcorn_recyclerview;
    RelativeLayout relativeLayout;
    GridLayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_pop_corn, container, false);

        store_popcorn_recyclerview = layout.findViewById(R.id.store_popcorn_recyclerview);
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

        storeInfoArrayList.add(new StoreInfo(R.drawable.popcorn_01,"고소팝콘(L)","5,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.popcorn_02,"달콤팝콘(L)","6,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.popcorn_03,"더블치즈팝콘(L)","6,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.popcorn_04,"바질어니언팝콘(L)","6,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.popcorn_05,"바질어니언팝콘(M)","5,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.popcorn_06,"더블치즈팝콘(M)","5,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.popcorn_07,"고소팝콘(M)","4,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.popcorn_08,"달콤팝콘(M)","5,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.popcorn_09,"크리미카라멜팝콘(L)","6,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.popcorn_10,"리얼치즈팝콘(L)","6,000원"));


        store_popcorn_recyclerview.setLayoutManager(layoutManager);
        StoreAdapter storeAdapter = new StoreAdapter(storeInfoArrayList);
        store_popcorn_recyclerview.setAdapter(storeAdapter);


        return layout;

    }



}
