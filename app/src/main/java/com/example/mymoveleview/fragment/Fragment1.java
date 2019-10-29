package com.example.mymoveleview.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mymoveleview.MovieInformation.AppHelper;
import com.example.mymoveleview.ImageLodeTask;
import com.example.mymoveleview.MovieInformation.MovieInformationActivity;
import com.example.mymoveleview.R;
import com.example.mymoveleview.MovieInformation.MovieInfo;
import com.example.mymoveleview.MovieInformation.MovieList;
import com.example.mymoveleview.MovieInformation.ResponseInfo;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;


public class Fragment1 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment1,container,false);


         final TextView frg_title = (TextView) rootView.findViewById(R.id.frg_title);
         final TextView frg_reservation_grade = (TextView)rootView.findViewById(R.id.frg_reservation_grade);
         final TextView frg_reservation_rate = (TextView)rootView.findViewById(R.id.frg_reservation_rate);
         final TextView frg_grade = (TextView)rootView.findViewById(R.id.frg_grade);
         final TextView frg_date = (TextView)rootView.findViewById(R.id.frg_date);

        ImageView imageView = (ImageView)rootView.findViewById(R.id.imageView);

        String url3= "https://movie-phinf.pstatic.net/20171107_251/1510033896133nWqxG_JPEG/movie_image.jpg";
        ImageLodeTask task = new ImageLodeTask(url3,imageView);
        task.execute();


        if(AppHelper.requestQueue == null){
            AppHelper.requestQueue = Volley.newRequestQueue(getContext());
        }


       String url ="http://" + AppHelper.host + ":" + AppHelper.port + "/movie/readMovieList";
       url += "?" + "type=1";


        StringRequest request = new StringRequest(

                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Gson gson = new Gson();

                        ResponseInfo info = gson.fromJson(response, ResponseInfo.class);
                        if (info.code == 200){

                            MovieList movieList = gson.fromJson(response,MovieList.class);


                                MovieInfo movieInfo = movieList.result.get(0);

                                frg_title.append(movieInfo.title);
                                frg_reservation_grade .append(movieInfo.reservation_grade);
                                frg_grade.append(movieInfo.grade);
                                frg_date.append(movieInfo.date);


                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //println("에러발생" + error.getMessage());

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                return params;
            }
        };

        request.setShouldCache(false);
        AppHelper.requestQueue.add(request);


        Button button = (Button)rootView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), MovieInformationActivity.class);
                startActivity(intent);

            }
        });

        return rootView;

    }

}
