package com.example.androidadvanced.entities;

public class Car {
    String mImgUrl;
    String mTitle;

    public Car() {
    }

    public Car(String mImgUrl, String mTitle) {
        this.mImgUrl = mImgUrl;
        this.mTitle = mTitle;
    }

    public String getImgUrl() {
        return mImgUrl;
    }

    public void setImgUrl(String mImgUrl) {
        this.mImgUrl = mImgUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
