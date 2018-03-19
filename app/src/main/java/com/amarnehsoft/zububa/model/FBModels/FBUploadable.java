package com.amarnehsoft.zububa.model.FBModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class FBUploadable extends FBBaseModel implements Parcelable{
    private String macAddress,username,adminCode; //if approved -> whos admin that approved this
    private long approveDate;

    public FBUploadable(){}

    public FBUploadable(long creationDate, String macAddress, String username, String adminCode, long approveDate) {
        super(creationDate);
        this.macAddress = macAddress;
        this.username = username;
        this.adminCode = adminCode;
        this.approveDate = approveDate;
    }

    public FBUploadable(Parcel in) {
        super(in);
        macAddress = in.readString();
        username = in.readString();
        adminCode = in.readString();
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
        parcel.writeLong(approveDate);
    }
}
