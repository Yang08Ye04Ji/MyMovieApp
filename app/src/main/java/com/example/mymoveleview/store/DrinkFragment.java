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


public class DrinkFragment extends Fragment {

    RecyclerView store_drink_recyclerview;
    RelativeLayout relativeLayout;
    GridLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.fragment_drink, container, false);



        store_drink_recyclerview = layout.findViewById(R.id.store_dfink_recyclerview);
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

        storeInfoArrayList.add(new StoreInfo(R.drawable.drink_01,"탄산음료(M)","2,200원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.drink_02,"자몽에이드(L)","4,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.drink_03,"아메리카노(HOT)","3,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.drink_04,"아메리카노(ICE)","4,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.drink_05,"블루베리에이드(M)","3,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.drink_06,"자몽에이드(M)","3,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.drink_07,"오렌지에이드(M)","3,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.drink_08,"아이스티(M)","3,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.drink_09,"탄산음료(L)","2,700원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.drink_10,"오렌지에이드(L)","4,500원"));


        store_drink_recyclerview.setLayoutManager(layoutManager);
        StoreAdapter storeAdapter = new StoreAdapter(storeInfoArrayList);
        store_drink_recyclerview.setAdapter(storeAdapter);


        return layout;
    }


}
