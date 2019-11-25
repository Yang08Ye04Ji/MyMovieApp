package com.example.mymoveleview.store;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mymoveleview.R;
import com.example.mymoveleview.main.ViewPagerMain;

public class StoreActivity extends AppCompatActivity {


    private Context mContext;
    private TabLayout mTabLayout;

    private ViewPager mViewPager;
    private StorePagerAdapter mStorePagerAdapter;

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(StoreActivity.this, ViewPagerMain.class);
                startActivity(i);
                finish();

            }
        });

        mContext = getApplicationContext();

        mTabLayout = (TabLayout)findViewById(R.id.layout_tab);

        mTabLayout.addTab(mTabLayout.newTab().setText("팝콘"));
        mTabLayout.addTab(mTabLayout.newTab().setText("음료"));
        mTabLayout.addTab(mTabLayout.newTab().setText("스낵"));
        mTabLayout.addTab(mTabLayout.newTab().setText("콤보"));

        mViewPager = (ViewPager)findViewById(R.id.pager_content);
        mStorePagerAdapter = new StorePagerAdapter(
                getSupportFragmentManager(),mTabLayout.getTabCount());
        mViewPager.setAdapter(mStorePagerAdapter);

        mViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private View createTabView(String tabName){
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab,null);
        TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);
        txt_name.setText(tabName);

        return tabView;

    }
}
