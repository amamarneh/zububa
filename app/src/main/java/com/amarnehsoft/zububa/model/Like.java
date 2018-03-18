package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/17/2018.
 */

public class Like extends BaseModel implements Parcelable{
    //srcCode-> the source where the user hit 'like' , eg: Blog.code, Post.code, etc...
    private String srcCode,macAddress;

    public Like() {
    }

    public Like(String code, long creationDate, String srcCode, String macAddress) {
        super(code, creationDate);
        this.srcCode = srcCode;
        this.macAddress = macAddress;
    }

    public Like(Parcel in) {
        super(in);
        srcCode = in.readString();
        macAddress = in.readString();
    }

    public String getSrcCode() {
        return srcCode;
    }

    public void setSrcCode(String srcCode) {
        this.srcCode = srcCode;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(srcCode);
        parcel.writeString(macAddress);
    }
}
