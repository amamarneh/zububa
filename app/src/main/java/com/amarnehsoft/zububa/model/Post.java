package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by user on 3/19/2018.
 */

public class Post extends Uploadable implements Parcelable{

    public static final int TYPE_POST= 0;
    public static final int TYPE_AD =1;
    private List<Like> likes;
    private List<Comment> comments;

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    //etc

    private String title,content,imgUrl;
    private int type;

    public Post() {
    }

    public Post(long creationDate, String macAddress, String username, String adminCode, long approveDate, String title, String content, String imgUrl, int type) {
        super(creationDate, macAddress, username, adminCode, approveDate);
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.type = type;
    }

    public Post(Parcel in) {
        super(in);
        title = in.readString();
        content = in.readString();
        imgUrl = in.readString();
        type = in.readInt();
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
