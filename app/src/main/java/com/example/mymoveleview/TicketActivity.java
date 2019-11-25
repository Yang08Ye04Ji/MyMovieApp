package com.example.mymoveleview;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mymoveleview.main.ViewPagerMain;

public class TicketActivity extends AppCompatActivity {


    LinearLayout linear;
    Button btn_close;
    Button backButton;

    int x;

    SensorManager sensorM;
    SensorEventListener sensorL;
    Sensor acc;


    //휴대폰을 흔드르었을 때 발생하는 순간속도를 임의로 지정
    final int SHAKE_X = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(TicketActivity.this, ViewPagerMain.class);
                startActivity(i);
            }
        });


        linear = findViewById(R.id.linear);
        btn_close = findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linear.setVisibility(View.GONE); //닫기버튼 누르면 GONE으로 숨기기
            }
        });

        sensorM = (SensorManager)getSystemService(SENSOR_SERVICE);
        acc = sensorM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorL = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                if (event.values[0] > SHAKE_X ) {

                    linear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };



    }


    @Override
    protected void onResume() {
        super.onResume();

        sensorM.registerListener(sensorL,acc, SensorManager.SENSOR_DELAY_FASTEST);

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (sensorM != null) {
            sensorM.unregisterListener(sensorL);
        }

    }
}
