package com.example.mymoveleview.MovieInformation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MovieInformationAdapter extends BaseAdapter {


    ArrayList<MovieInformationItem> items = new ArrayList<MovieInformationItem>();

    @Override
    public int getCount() {
        return items.size();
    }

    public void addItem(MovieInformationItem item){
        items.add(item);
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        MovieInformationItemView view = null;

        if(convertView == null){
            view = new MovieInformationItemView(parent.getContext());

        }else {

            view = (MovieInformationItemView) convertView;

        }


        MovieInformationItem item = items.get(position);
        view.setName(item.getName());
        view.setText(item.getText());
        view.setRating_txt2(item.getRating_txt2());
        view.setRating2(item.getRating2());




        return view;
    }


}
