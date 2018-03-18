package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/17/2018.
 */

public class Taxi extends Uploadable implements Parcelable{
    private String name,desc,phone;

    public Taxi() {
    }

    public Taxi(String code, long creationDate, String macAddress, String username, String adminCode, boolean approved, long approveDate, String name, String desc, String phone) {
        super(code, creationDate, macAddress, username, adminCode, approved, approveDate);
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
