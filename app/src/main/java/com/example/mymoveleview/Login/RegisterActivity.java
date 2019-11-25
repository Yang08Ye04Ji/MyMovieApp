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

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText re_id, re_pwd, re_name, re_age;
    private Button re_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        re_id = findViewById(R.id.re_id);
        re_pwd = findViewById(R.id.re_pwd);
        re_name = findViewById(R.id.re_name);
        re_age = findViewById(R.id.re_age);
        re_btn = findViewById(R.id.re_btn);


        re_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userID = re_id.getText().toString();
                String userPass = re_pwd.getText().toString();
                String userName = re_name.getText().toString();
                int userAge = Integer.parseInt(re_age.getText().toString());


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success){
                                Toast.makeText(getApplicationContext(),"회원등록확인",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                                finish();

                            }else {
                                Toast.makeText(getApplicationContext(),"회원등록실패",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };

                //서보로 볼리를 이용해서 요청을 함
                RegisterRequest registerRequest = new RegisterRequest(userID,userPass,userName,userAge,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

            }
        });



    }

}
