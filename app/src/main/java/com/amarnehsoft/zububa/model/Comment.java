package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class Comment extends Uploadable implements Parcelable{
    private String comment;

    public Comment() {
    }

    public Comment(long creationDate, String macAddress, String username, String adminCode, long approveDate, String comment) {
        super(creationDate, macAddress, username, adminCode, approveDate);
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
