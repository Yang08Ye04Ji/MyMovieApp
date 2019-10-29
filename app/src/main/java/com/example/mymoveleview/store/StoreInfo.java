package com.example.mymoveleview.store;

public class StoreInfo {

    int store_image;
    String store_name;
    String store_price;

    public StoreInfo(int store_image, String store_name, String store_price) {
        this.store_image = store_image;
        this.store_name = store_name;
        this.store_price = store_price;
    }

    public int getStore_image() {
        return store_image;
    }

    public void setStore_image(int store_image) {
        this.store_image = store_image;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_price() {
        return store_price;
    }

    public void setStore_price(String store_price) {
        this.store_price = store_price;
    }
}
