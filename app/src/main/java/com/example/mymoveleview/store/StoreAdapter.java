package com.example.mymoveleview.store;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymoveleview.R;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView store_item_image;
        TextView item_name;
        TextView item_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            store_item_image = itemView.findViewById(R.id.store_item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);

        }
    }

        private ArrayList<StoreInfo> storeInfoArrayList;
        StoreAdapter(ArrayList<StoreInfo> storeInfoArrayList){
            this.storeInfoArrayList = storeInfoArrayList;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.store_item,viewGroup,false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;

            myViewHolder.store_item_image.setImageResource(storeInfoArrayList.get(i).store_image);
            myViewHolder.item_name.setText(storeInfoArrayList.get(i).store_name);
            myViewHolder.item_price.setText(storeInfoArrayList.get(i).store_price);

        }

        @Override
        public int getItemCount() {
            return storeInfoArrayList.size();
        }

}
