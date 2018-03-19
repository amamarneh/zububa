package com.amarnehsoft.zububa.model.FBModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class FBBlog extends FBUploadable implements Parcelable {
    private String title,content,imgUrl;

    public FBBlog() {
    }

    public FBBlog(long creationDate, String macAddress, String username, String adminCode, long approveDate, String title, String content, String imgUrl) {
        super(creationDate, macAddress, username, adminCode, approveDate);
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
    }

    public FBBlog(Parcel in) {
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
