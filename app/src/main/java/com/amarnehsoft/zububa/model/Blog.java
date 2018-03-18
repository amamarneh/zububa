package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/17/2018.
 */

public class Blog extends Uploadable implements Parcelable{
    private String title,content,imgUrl;

    public Blog() {
    }

    public Blog(String code, long creationDate, String macAddress, String username, String adminCode, boolean approved, long approveDate, String title, String content, String imgUrl) {
        super(code, creationDate, macAddress, username, adminCode, approved, approveDate);
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
