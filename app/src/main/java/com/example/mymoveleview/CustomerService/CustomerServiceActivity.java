package com.example.mymoveleview.CustomerService;

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
import com.example.mymoveleview.ViewPagerMain;

public class CustomerServiceActivity extends AppCompatActivity {



    private Context mContext;
    private TabLayout mTabLayout;

    private ViewPager mViewPager;
    private CustomerServicePagerAdapter mCustomerServicePagerAdapter;

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(CustomerServiceActivity.this, ViewPagerMain.class);
                startActivity(i);
                finish();

            }
        });


        mContext = getApplicationContext();

        mTabLayout = (TabLayout)findViewById(R.id.tab_layout);


        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("자주찾는질문")));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("스토어")));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("할인혜택")));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("VIP관련")));


        mViewPager = (ViewPager) findViewById(R.id.pager_content);

        mCustomerServicePagerAdapter = new CustomerServicePagerAdapter(
                getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager.setAdapter(mCustomerServicePagerAdapter);



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
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.customer_custorm_tab,null);
        TextView txt_name = (TextView)tabView.findViewById(R.id.txt_name);
        txt_name.setText(tabName);

        return tabView;
    }


}
