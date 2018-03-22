package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by user on 3/19/2018.
 */

public class Blog extends Uploadable implements Parcelable {
    private String title,content,imgUrl;
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

    public Blog() {
    }

    public Blog(long creationDate, String macAddress, String username, String adminCode, long approveDate, String title, String content, String imgUrl) {
        super(creationDate, macAddress, username, adminCode, approveDate);
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
