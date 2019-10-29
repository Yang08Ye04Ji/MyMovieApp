package com.example.mymoveleview.Event;

import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.mymoveleview.R;
import com.example.mymoveleview.ViewPagerMain;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    FragmentPagerAdapter fragmentPagerAdapter;

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        //ViewPager viewPager = (ViewPager)findViewById(R.id.vpPager);
       // viewPager.setAdapter(fragmentPagerAdapter);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(EventActivity.this, ViewPagerMain.class);
                startActivity(i);
                finish();
            }
        });


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<EventInfo> eventInfoArrayList = new ArrayList<>();

        eventInfoArrayList.add(new EventInfo( R.drawable.event_1,"#로튼토마모 100%   #2019.10"));
        eventInfoArrayList.add(new EventInfo( R.drawable.event_2,"#스스로 빛나고 싶었나 봐요   #2019.10 "));
        eventInfoArrayList.add(new EventInfo( R.drawable.event_3,"#시대가 놓친 진범을 찾아라   #2019.10"));
        eventInfoArrayList.add(new EventInfo( R.drawable.event_4,"#대한민국을 뒤흔들 금융번죄   #2019.11"));
        eventInfoArrayList.add(new EventInfo( R.drawable.event_5,"#국가가 숨긴 충격적 진실   #2019.11"));
        eventInfoArrayList.add(new EventInfo( R.drawable.event_6,"#전세계를 사로잡은 오드 판타지   #2019.10"));

        EventAdapter eventAdapter = new EventAdapter(eventInfoArrayList);

        mRecyclerView.setAdapter(eventAdapter);

    }


}
