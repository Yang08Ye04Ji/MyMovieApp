package com.example.mymoveleview.Event;

public class EventInfo {

    int images;
    String tv_event;


    public EventInfo( int images, String tv_event) {
        this.images = images;
        this.tv_event = tv_event;

    }

    public String getTv_event() {
        return tv_event;
    }

    public void setTv_event(String tv_event) {
        this.tv_event = tv_event;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
