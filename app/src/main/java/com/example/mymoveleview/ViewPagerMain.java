package com.example.mymoveleview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mymoveleview.CustomerService.CustomerServiceActivity;
import com.example.mymoveleview.Event.EventActivity;
import com.example.mymoveleview.Login.LoginActivity;
import com.example.mymoveleview.fragment.Fragment1;
import com.example.mymoveleview.fragment.Fragment2;
import com.example.mymoveleview.fragment.Fragment3;
import com.example.mymoveleview.fragment.Fragment4;
import com.example.mymoveleview.fragment.Fragment5;
import com.example.mymoveleview.store.StoreActivity;

import java.util.ArrayList;

public class ViewPagerMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager pager;
    DrawerLayout drawer;
    MoviePagerAdapter adapter;
    Button log_btn,log_out;
    TextView tv_id;

    int num = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_pager_main);


        pager = (ViewPager)findViewById(R.id.viewpager);
        drawer = (DrawerLayout)findViewById(R.id.drawelayout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pager.setOffscreenPageLimit(3); // 미리 담아두기

        adapter = new MoviePagerAdapter(getSupportFragmentManager());

         Fragment1 fragment1 = new Fragment1();
        adapter.addItem(fragment1);

         Fragment2 fragment2 = new Fragment2();
        adapter.addItem(fragment2);

       Fragment3 fragment3 = new Fragment3();
        adapter.addItem(fragment3);

        Fragment4 fragment4 = new Fragment4();
        adapter.addItem(fragment4);

        Fragment5 fragment5 = new Fragment5();
        adapter.addItem(fragment5);


        pager.setAdapter(adapter);



            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                            R.string.navigation_drawer_open, R.string.navigation_drawer_close);
         drawer.addDrawerListener(toggle);
         toggle.syncState();

         NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
         navigationView.setNavigationItemSelectedListener(this);

         View header = navigationView.getHeaderView(0);

         final Button log_btn = (Button)header.findViewById(R.id.log_btn);
         final TextView tv_id = (TextView)header.findViewById(R.id.tv_id);
         final TextView text = (TextView)header.findViewById(R.id.text);

        Intent intent2 = getIntent();
        String userID = intent2.getStringExtra("userID");
        tv_id.setText(userID);


        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ViewPagerMain.this, LoginActivity.class);
                startActivity(i);


            }
        });


    }

    class MoviePagerAdapter extends FragmentStatePagerAdapter{

        ArrayList<Fragment> items = new ArrayList<Fragment>();

            public MoviePagerAdapter(FragmentManager fm) {
                super(fm);
            }

            public void addItem (Fragment item){
                items.add(item);
            }

            @Override
            public Fragment getItem(int i) {
                return items.get(i);
            }

            @Override
            public int getCount() {
                return items.size();
            }

            public void getView(){

            }
        }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


         int id = menuItem.getItemId();

          if(id == R.id.fr1) {

            Intent intent = new Intent(ViewPagerMain.this, TicketActivity.class);
            startActivity(intent);

        }else if(id == R.id.fr2){

            Intent intent = new Intent(ViewPagerMain.this, EventActivity.class);
            startActivity(intent);


        }else if(id == R.id.fr3){

             Intent intent = new Intent(ViewPagerMain.this, StoreActivity.class);
             startActivity(intent);

        }else if (id == R.id.go) {

            Intent intent = new Intent(ViewPagerMain.this, CustomerServiceActivity.class);
            startActivity(intent);

        }else if (id == R.id.close) {
            finish();
        }


        drawer.closeDrawer(GravityCompat.START);




        return true;
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawelayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
        }

        if (num != 3 ){
            AlertDialog.Builder alBuilder = new AlertDialog.Builder(this);
            alBuilder.setMessage("앱을 종료하시겠습니까?");

            alBuilder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            alBuilder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            });
            alBuilder.setTitle("종료");
            alBuilder.show();
        } else {

            handler.sendEmptyMessage(0);
        }
    }

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {

            handler.sendEmptyMessageDelayed(0,1000);

            if( num > 0 ){
                --num;
            }else {
                num = 3;
                handler.removeMessages(0);
            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return  super.onOptionsItemSelected(item);

    }


}
