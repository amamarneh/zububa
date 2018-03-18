package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/17/2018.
 */

public class Uploadable extends BaseModel implements Parcelable{
    //from BaseModel:
    // - code
    // - creationDate

    private String macAddress,username,adminCode; //if approved -> whos admin that approved this
    private boolean approved;
    private long approveDate;

    public Uploadable(){}

    public Uploadable(String code, long creationDate, String macAddress, String username, String adminCode, boolean approved, long approveDate) {
        super(code, creationDate);
        this.macAddress = macAddress;
        this.username = username;
        this.adminCode = adminCode;
        this.approved = approved;
        this.approveDate = approveDate;
    }

    public Uploadable(Parcel in) {
        super(in);
        macAddress = in.readString();
        username = in.readString();
        adminCode = in.readString();
        approved = in.readByte() != 0;
        approveDate = in.readLong();
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
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
        parcel.writeString(macAddress);
        parcel.writeString(username);
        parcel.writeString(adminCode);
        parcel.writeByte((byte) (approved ? 1 : 0));
        parcel.writeLong(approveDate);
    }
}
