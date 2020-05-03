package com.example.androidadvanced.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.example.androidadvanced.entities.data.Data;

public class Children {

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("data")
    @Expose
    private Data data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
