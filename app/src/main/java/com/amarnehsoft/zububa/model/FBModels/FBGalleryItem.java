package com.amarnehsoft.zububa.model.FBModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class FBGalleryItem extends FBUploadable implements Parcelable{
    private String imgUrl,desc;

    public FBGalleryItem() {
    }

    public FBGalleryItem(long creationDate, String macAddress, String username, String adminCode, long approveDate, String imgUrl, String desc) {
        super(creationDate, macAddress, username, adminCode, approveDate);
        this.imgUrl = imgUrl;
        this.desc = desc;
    }

    public FBGalleryItem(Parcel in) {
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
