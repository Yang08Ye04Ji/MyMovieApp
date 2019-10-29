package com.example.mymoveleview.Event;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymoveleview.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageview;
        TextView tv_event;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageview = itemView.findViewById(R.id.imageview);
            tv_event = itemView.findViewById(R.id.tv_event);

        }
    }

        private ArrayList<EventInfo> eventInfoArrayList;
        EventAdapter(ArrayList<EventInfo> eventInfoArrayList) {
            this.eventInfoArrayList = eventInfoArrayList;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_item,viewGroup,false);

            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;

            myViewHolder.imageview.setImageResource(eventInfoArrayList.get(i).images);
            myViewHolder.tv_event.setText(eventInfoArrayList.get(i).tv_event);

        }

        @Override
        public int getItemCount() {
            return eventInfoArrayList.size();
        }

}
