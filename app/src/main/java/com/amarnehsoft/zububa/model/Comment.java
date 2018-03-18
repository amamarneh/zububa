package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/17/2018.
 */

public class Comment extends Uploadable implements Parcelable{
    private String srcCode,comment;

    public Comment() {
    }

    public Comment(String code, long creationDate, String macAddress, String username, String adminCode, boolean approved, long approveDate, String srcCode, String comment) {
        super(code, creationDate, macAddress, username, adminCode, approved, approveDate);
        this.srcCode = srcCode;
        this.comment = comment;
    }

    public Comment(Parcel in) {
        super(in);
        srcCode = in.readString();
        comment = in.readString();
    }

    public String getSrcCode() {
        return srcCode;
    }

    public void setSrcCode(String srcCode) {
        this.srcCode = srcCode;
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
        parcel.writeString(srcCode);
        parcel.writeString(comment);
    }
}
