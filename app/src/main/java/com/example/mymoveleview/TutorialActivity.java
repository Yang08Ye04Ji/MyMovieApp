package com.example.mymoveleview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class TutorialActivity extends AppCompatActivity {

    CheckBox check;
    Button button;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);


        check = findViewById(R.id.check);
        button = findViewById(R.id.button);

        /*pref = PreferenceManager.getDefaultSharedPreferences(this);

        boolean b = pref.getBoolean("save",false);

        if (b){
            moveIntent();
        }*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveIntent();

              /* SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("save",check.isChecked());
                editor.commit();
              */
            }
        });


    }
    private void moveIntent(){
        Intent intent = new Intent(TutorialActivity.this,ViewPagerMain.class);
        startActivity(intent);
        finish();
    }
}
