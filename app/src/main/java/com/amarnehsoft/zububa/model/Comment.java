package com.amarnehsoft.zububa.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class Comment extends HasLikes implements Parcelable{
    private String comment;

    public Comment(){
        super();
    }

    public Comment(Context context) {
        super(context);
    }

    public Comment(Context context,String comment) {
        super(context);
        this.comment = comment;
    }

    public Comment(Parcel in) {
        super(in);
        comment = in.readString();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(comment);
    }
}
