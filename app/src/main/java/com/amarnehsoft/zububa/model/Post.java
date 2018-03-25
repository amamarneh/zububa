package com.amarnehsoft.zububa.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.amarnehsoft.zububa.abstractAdapters.MItem;

import java.util.List;

/**
 * Created by user on 3/19/2018.
 */

public class Post extends HasComments implements Parcelable,MItem{

    public static final int VIEW_TYPE= 1;
    public static final int TYPE_POST= 0;
    public static final int TYPE_AD =1;

    private String title,content,imgUrl;
    private int type;

    public Post(){
        super();
    }

    public Post(Context context) {
        super(context);
    }

    public Post(Context context,String title, String content, String imgUrl, int type) {
        super(context);
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

    @Override
    public int getViewType() {
        return VIEW_TYPE;
    }
}
