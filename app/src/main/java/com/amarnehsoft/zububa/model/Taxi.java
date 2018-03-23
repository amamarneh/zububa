package com.amarnehsoft.zububa.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class Taxi extends HasComments implements Parcelable{
    private String name,desc,phone;

    public Taxi(){
        super();
    }

    public Taxi(Context context) {
        super(context);
    }

    public Taxi(Context context,String name, String desc, String phone) {
        super(context);
        this.name = name;
        this.desc = desc;
        this.phone = phone;
    }

    public Taxi(Parcel in) {
        super(in);
        name = in.readString();
        desc = in.readString();
        phone = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(name);
        parcel.writeString(desc);
        parcel.writeString(phone);
    }
}
