package com.example.mymoveleview.MovieInformation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymoveleview.R;

public class MovieInformationItemView extends LinearLayout {

    TextView nicname;
    TextView review;
    Button recommend;
    TextView reco_txt, ratxt;
    RatingBar com_ratingbar;
    Button report;

    boolean up = false;
    int uptxt = 0;

    int temp;


    String msg = null;





    public MovieInformationItemView(Context context) {
        super(context);

        init(context);

    }

    public MovieInformationItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(final Context context){

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.commentitem,this,true);


        nicname = (TextView)findViewById(R.id.nicname);
        review = (TextView)findViewById(R.id.review);
        reco_txt = (TextView)findViewById(R.id.reco_txt);
        recommend = (Button)findViewById(R.id.recommend);
        report = (Button)findViewById(R.id.report);
        ratxt = (TextView)findViewById(R.id.ratxt);
        com_ratingbar = (RatingBar)findViewById(R.id.com_ratingbar);

        recommend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(up){

                    uptxt --;
                    reco_txt.setText(String.valueOf(uptxt));

                }else  {

                    uptxt ++ ;
                    reco_txt.setText(String.valueOf(uptxt));
                }

                 up =! up;

                Toast.makeText(context,"리스트 클릭",Toast.LENGTH_SHORT).show();

            }
        });


        report.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                final CharSequence[] item = {"부적절한 홍보 게시물"
                                              ,"음란성 또는 청소년에게 부적합한 내용"
                                              ,"명예훼손/사생활 침해 및 저작권침해 등"};


                new AlertDialog.Builder(context)
                        .setTitle("신고하기")
                        .setIcon(R.drawable.report)
                        .setSingleChoiceItems(item, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                               temp = which;
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
                Toast.makeText(context,"신고하기 클릭",Toast.LENGTH_SHORT).show();

            }
        });







    }


    public void setName(String name){

        nicname.setText(name);
    }

    public void setText(String text){

        review.setText(text);

    }

    public void setRating_txt2 (String rating_txt2){

        ratxt.setText(rating_txt2);
    }




}
