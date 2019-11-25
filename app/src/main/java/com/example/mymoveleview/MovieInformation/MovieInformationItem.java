package com.example.mymoveleview.MovieInformation;

public class MovieInformationItem {

    String name; //id
    String text; //revieText
    String rating_txt2;
    float rating2;



    public MovieInformationItem(String name, String text , String rating_txt2, float rating2){
        this.name = name;
        this.text = text;
        this.rating_txt2 = rating_txt2;
        this.rating2 = rating2;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRating_txt2() {
        return rating_txt2;
    }

    public void setRating_txt2(String rating_txt2) {
        this.rating_txt2 = rating_txt2;
    }

    public float getRating2() {
        return rating2;
    }

    public void setRating2(float rating2) {
        this.rating2 = rating2;
    }
}
