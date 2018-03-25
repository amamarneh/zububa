package com.amarnehsoft.zububa.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by user on 3/19/2018.
 */

public class GalleryItem extends HasLikes implements Parcelable{
    private String imgUrl,desc;
    public final static int TYPE = 3;

    public GalleryItem() {
        super();
    }


    public GalleryItem(Context context) {
        super(context);
    }

    public GalleryItem(Context context,String imgUrl, String desc) {
        super(context);
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
