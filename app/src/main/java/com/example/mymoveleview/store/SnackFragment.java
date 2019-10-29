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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SnackFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SnackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SnackFragment extends Fragment {

    RecyclerView store_snack_recyclerview;
    RelativeLayout relativeLayout;
    GridLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout layout =(LinearLayout) inflater.inflate(R.layout.fragment_snack, container, false);


        store_snack_recyclerview = layout.findViewById(R.id.store_snack_recyclerview);
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

        storeInfoArrayList.add(new StoreInfo(R.drawable.snack_01,"크리미갈릭핫도그","4,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.snack_02,"즉석구이오징어(몸통)","5,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.snack_03,"칠리치즈나쵸","4,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.snack_04,"죠스튀김범벅","4,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.snack_05,"즉석구이오징어(왕다리)","5,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.snack_6,"치즈볼","4,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.snack_07,"스쿨푸드 스팸계란말이","4,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.snack_08,"플레인핫도그","4,000원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.snack_09,"칠리치즈핫도그","4,500원"));
        storeInfoArrayList.add(new StoreInfo(R.drawable.snack_10,"맛밤","3,500원"));


        store_snack_recyclerview.setLayoutManager(layoutManager);
        StoreAdapter storeAdapter = new StoreAdapter(storeInfoArrayList);
        store_snack_recyclerview.setAdapter(storeAdapter);




        return layout;
    }


}
