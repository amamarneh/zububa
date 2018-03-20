package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/20/2018.
 */

public class Uprovable extends BaseModel implements Parcelable{
    private String adminCode; //if approved -> whos admin that approved this
    private long approveDate;

    public Uprovable(){}

    public Uprovable(long creationDate, String adminCode, long approveDate) {
        super(creationDate);
        this.adminCode = adminCode;
        this.approveDate = approveDate;
    }

    public Uprovable(Parcel in) {
        super(in);
        adminCode = in.readString();
        approveDate = in.readLong();
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public long getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(long approveDate) {
        this.approveDate = approveDate;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(adminCode);
        parcel.writeLong(approveDate);
    }
}
