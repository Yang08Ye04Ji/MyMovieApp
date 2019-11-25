package com.example.mymoveleview.MovieInformation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mymoveleview.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.gson.Gson;

public class MovieInformationActivity extends AppCompatActivity  {


    ImageView movie_image;
    ImageView mImage01,mImage02,mImage03,mImage04,mImage05;
    TextView likeUpText, likeDownText,rating_txt;
    TextView summary,mov_title ,mov_pubDate;
    TextView mov_director ,mov_actor,mov_audience_rating;
    TextView mov_genre, mov_duration, mov_reservation_grade;
    TextView mov_reservation_rate, mov_audience;
    EditText edit_id,edit_txt;
    Button likeUp, likeDown, reviewButton, button;
    Button movie_button,cancelButton;
    RatingBar rating;
    ListView listView;
    MovieInformationAdapter adapter;

    int likeCount = 15;
    int unlikeCount  = 6;

    boolean thumbsUpState = false;
    boolean thumbsDownState = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movieinformation);


        likeUp = (Button)findViewById(R.id.likeUp);
        likeDown = (Button)findViewById(R.id.likeDown);
        likeUpText = (TextView)findViewById(R.id.likeUpText);
        likeDownText = (TextView)findViewById(R.id.likeDownText);
        reviewButton = (Button)findViewById(R.id.reviewButton);
        cancelButton = (Button)findViewById(R.id.cancelButton);
        edit_id = (EditText)findViewById(R.id.edit_id);
        edit_txt = (EditText)findViewById(R.id.edit_txt);
        button = (Button)findViewById(R.id.button);
        rating = (RatingBar)findViewById(R.id.rating);
        rating_txt = (TextView)findViewById(R.id.rating_txt);
        summary = (TextView)findViewById(R.id.summary);
        mov_title = (TextView)findViewById(R.id.mov_title);
        mov_actor =  (TextView)findViewById(R.id.mov_actor);
        mov_pubDate = (TextView)findViewById(R.id.mov_pubDate);
        mov_director = (TextView)findViewById(R.id.mov_director);
        mov_genre = (TextView)findViewById(R.id.mov_genre);
        mov_duration = (TextView)findViewById(R.id.mov_duration);
        mov_reservation_grade = (TextView)findViewById(R.id.mov_reservation_grade);
        mov_reservation_rate = (TextView)findViewById(R.id.mov_reservation_rate);
        mov_audience = (TextView)findViewById(R.id.mov_audience);
        mov_audience_rating = (TextView)findViewById(R.id.mov_audience_rating);
        movie_image = (ImageView)findViewById(R.id.mov_image) ;


        mImage01 = (ImageView)findViewById(R.id.images01);
        mImage02 = (ImageView)findViewById(R.id.images02);
        mImage03 = (ImageView)findViewById(R.id.images03);
        mImage04 = (ImageView)findViewById(R.id.images04);
        mImage05 = (ImageView)findViewById(R.id.images05);
        movie_button = (Button)findViewById(R.id.movie_button);




        mImage01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MovieInformationActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.imageview_custom,null);
                PhotoView photoView = mView.findViewById(R.id.custom_imageView);
                photoView.setImageResource(R.drawable.movie1_still_image_01);
                mBuilder.setView(mView);
                AlertDialog mDIalog = mBuilder.create();
                mDIalog.show();

            }
        });

        mImage02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MovieInformationActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.imageview_custom,null);
                PhotoView photoView = mView.findViewById(R.id.custom_imageView);
                photoView.setImageResource(R.drawable.movie1_still_image_02);
                mBuilder.setView(mView);
                AlertDialog mDIalog = mBuilder.create();
                mDIalog.show();

            }
        });

        mImage03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MovieInformationActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.imageview_custom,null);
                PhotoView photoView = mView.findViewById(R.id.custom_imageView);
                photoView.setImageResource(R.drawable.movie1_still_image_03);
                mBuilder.setView(mView);
                AlertDialog mDIalog = mBuilder.create();
                mDIalog.show();

            }
        });


        mImage04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MovieInformationActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.imageview_custom,null);
                PhotoView photoView = mView.findViewById(R.id.custom_imageView);
                photoView.setImageResource(R.drawable.movie1_still_image_04);
                mBuilder.setView(mView);
                AlertDialog mDIalog = mBuilder.create();
                mDIalog.show();


            }
        });


        mImage05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MovieInformationActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.imageview_custom,null);
                PhotoView photoView = mView.findViewById(R.id.custom_imageView);
                photoView.setImageResource(R.drawable.movie1_still_image_05);
                mBuilder.setView(mView);
                AlertDialog mDIalog = mBuilder.create();
                mDIalog.show();

            }
        });

        movie_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://youtu.be/CCYl_7lUU2A";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);


            }
        });


        if(AppHelper.requestQueue == null){
            AppHelper.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }



    String url ="http://" + AppHelper.host + ":" + AppHelper.port + "/movie/readMovie";
        url += "?" + "id=1";


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

                               summary.append(movieInfo.title);
                               mov_title.append(movieInfo.title);
                               mov_pubDate.append(movieInfo.date);
                               summary.append(movieInfo.synopsis);
                               mov_director.append(movieInfo.director);
                               mov_actor.append(movieInfo.actor);
                               mov_genre.append(movieInfo.genre);
                               mov_duration.append(movieInfo.duration);
                               mov_reservation_grade.append(movieInfo.reservation_grade);
                               mov_reservation_rate.append(movieInfo.reservation_rate);
                               mov_audience.append(movieInfo.audience);
                               mov_audience_rating.append(movieInfo.audience_rating);

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       Log.e(this.getClass().getName(),"오류류");

                    }
                }
        );

        request.setShouldCache(false);
        AppHelper.requestQueue.add(request);



        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                rating_txt.setText(""+rating);

            }
        });


        listView = (ListView)findViewById(R.id.listview);

        adapter = new MovieInformationAdapter();

        listView.setAdapter(adapter);


        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RatingBar ratingBar = findViewById(R.id.rating);

                String name = edit_id.getText().toString();
                String text = edit_txt.getText().toString();
                String rating_txt2 = rating_txt.getText().toString();
                float rating2 = rating.getRating();

                edit_txt.setText("");
                edit_id.setText("");
                rating_txt.setText("");
                rating.setRating(0);

                adapter.addItem(new MovieInformationItem(name,text,rating_txt2,rating2));
                adapter.notifyDataSetChanged();

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edit_id.setText("");
                edit_txt.setText("");
                rating_txt.setText("");
                rating.setRating(0);

            }
        });




     likeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (thumbsUpState) {

                    decrUnLikeCount();
                    incrLikeCount();

                } else if (thumbsDownState){

                    decrLikeCount();

                }else {
                    incrLikeCount();
                }

                thumbsDownState =! thumbsDownState;



            }

        });


        likeDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (thumbsDownState) {

                    decrLikeCount();
                    incrUnLikeCount();

                } else if (thumbsUpState){

                    decrUnLikeCount();

                }else {

                    incrUnLikeCount();
                }

                thumbsUpState =! thumbsUpState;


            }
        });


    }



    public void incrLikeCount() {


        likeCount += 1;

        likeUpText.setText(String.valueOf(likeCount));
        thumbsDownState = false;
        likeUp.setBackgroundResource(R.drawable.ic_thumb_up_selected);


    }

    public void decrLikeCount() {


        likeCount -= 1;

        likeUpText.setText(String.valueOf(likeCount));
        thumbsDownState = false;
        likeUp.setBackgroundResource(R.drawable.ic_thumb_up);


    }

    public void incrUnLikeCount() {


        unlikeCount += 1;

        likeDownText.setText(String.valueOf(unlikeCount));
        thumbsUpState = false;
        likeDown.setBackgroundResource(R.drawable.ic_thumb_down_selected);


    }

    public void decrUnLikeCount() {

        unlikeCount -= 1;

        likeDownText.setText(String.valueOf(unlikeCount));
        thumbsUpState = false;
        likeDown.setBackgroundResource(R.drawable.ic_thumb_down);

    }



}



