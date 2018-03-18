package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/17/2018.
 */

public class Baby extends Uploadable implements Parcelable{
    private String name,imgUrl,desc;

    public Baby(String code, long creationDate, String macAddress, String username, String adminCode, boolean approved, long approveDate, String name, String imgUrl, String desc) {
        super(code, creationDate, macAddress, username, adminCode, approved, approveDate);
        this.name = name;
        this.imgUrl = imgUrl;
        this.desc = desc;
    }

    public Baby() {
    }

    public Baby(Parcel in) {
        super(in);
        name = in.readString();
        imgUrl = in.readString();
        desc = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(name);
        parcel.writeString(imgUrl);
        parcel.writeString(desc);
    }
}
