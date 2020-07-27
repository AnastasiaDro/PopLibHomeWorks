package com.geekbrains.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Year {
    @Expose
    @SerializedName("time_of_year")
    public String timeOfYear;

    @Expose
    @SerializedName("year")
    public Integer yearName;
}
