package com.amarnehsoft.zububa.model;

import android.os.Parcel;

/**
 * Created by user on 3/19/2018.
 */

public class Wedding extends Uploadable {
    private String personName,title,content,imgUrl;
    private long weddingDate;

    public Wedding() {
    }

    public Wedding(long creationDate, String macAddress, String username, String adminCode, long approveDate, String personName, String title, String content, String imgUrl, long weddingDate) {
        super(creationDate, macAddress, username, adminCode, approveDate);
        this.personName = personName;
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.weddingDate = weddingDate;
    }

    public Wedding(Parcel in) {
        super(in);
        personName = in.readString();
        title = in.readString();
        content = in.readString();
        imgUrl = in.readString();
        weddingDate = in.readLong();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
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

    public long getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(long weddingDate) {
        this.weddingDate = weddingDate;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(personName);
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(imgUrl);
        parcel.writeLong(weddingDate);
    }
}
