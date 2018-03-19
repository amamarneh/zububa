package com.amarnehsoft.zububa.model.FBModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class FBPost extends FBUploadable implements Parcelable{

    public static final int TYPE_POST= 0;
    public static final int TYPE_AD =1;
    //etc


    public FBPost() {
    }

    public FBPost(long creationDate, String macAddress, String username, String adminCode, long approveDate, String title, String content, String imgUrl, int type) {
        super(creationDate, macAddress, username, adminCode, approveDate);
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.type = type;
    }

    public FBPost(Parcel in) {
        super(in);
        title = in.readString();
        content = in.readString();
        imgUrl = in.readString();
        type = in.readInt();
    }

    private String title,content,imgUrl;
    private int type;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(imgUrl);
        parcel.writeInt(type);
    }
}
