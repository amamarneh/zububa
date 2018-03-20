package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class GalleryItem extends Uploadable implements Parcelable{
    private String imgUrl,desc;

    public GalleryItem() {
    }

    public GalleryItem(long creationDate, String macAddress, String username, String adminCode, long approveDate, String imgUrl, String desc) {
        super(creationDate, macAddress, username, adminCode, approveDate);
        this.imgUrl = imgUrl;
        this.desc = desc;
    }

    public GalleryItem(Parcel in) {
        super(in);
        imgUrl = in.readString();
        desc = in.readString();
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
        parcel.writeString(imgUrl);
        parcel.writeString(desc);
    }
}
