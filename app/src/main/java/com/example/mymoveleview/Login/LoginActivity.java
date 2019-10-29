package com.example.mymoveleview.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mymoveleview.R;
import com.example.mymoveleview.ViewPagerMain;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText re_id, re_pwd;
    private Button log_btn,log_regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        re_id = findViewById(R.id.re_id);
        re_pwd = findViewById(R.id.re_pwd);
        log_btn = findViewById(R.id.log_btn);
        log_regbtn = findViewById(R.id.log_regbtn);


        log_regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userID = re_id.getText().toString();
                final String userPass = re_pwd.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success){
                                String userId = jsonObject.getString("userID");
                                String userPass = jsonObject.getString("userPassword");

                                Toast.makeText(getApplicationContext(),"로그인에 성공하였습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, ViewPagerMain.class);
                                intent.putExtra("userID",userID);
                                intent.putExtra("userPass",userPass);
                                startActivity(intent);
                            }else {
                                Toast.makeText(getApplicationContext(),"로그인에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(userID,userPass,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });

    }
}
