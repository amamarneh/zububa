package com.amarnehsoft.zububa.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by user on 3/19/2018.
 */

public class Blog extends HasComments implements Parcelable {
    public final static int VIEW_TYPE = 2;
    private String title,content,imgUrl;

    public Blog(){
        super();
    }
    public Blog(Context context) {
        super(context);
    }

    public Blog(Context context,String title, String content, String imgUrl) {
        super(context);
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
    }

    public Blog(Parcel in) {
        super(in);
        title = in.readString();
        content = in.readString();
        imgUrl = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(imgUrl);
    }
}
