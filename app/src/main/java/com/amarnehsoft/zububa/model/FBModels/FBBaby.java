package com.amarnehsoft.zububa.model.FBModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class FBBaby extends FBUploadable implements Parcelable{
    private String name,imgUrl,desc;

    public FBBaby(long creationDate, String macAddress, String username, String adminCode, boolean approved, long approveDate, String name, String imgUrl, String desc) {
        super(creationDate, macAddress, username, adminCode, approveDate);
        this.name = name;
        this.imgUrl = imgUrl;
        this.desc = desc;
    }

    public FBBaby() {
    }

    public FBBaby(Parcel in) {
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
