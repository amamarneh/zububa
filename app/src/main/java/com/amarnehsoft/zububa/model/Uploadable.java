package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class Uploadable extends Uprovable implements Parcelable{
    private String macAddress,username; //if approved -> whos admin that approved this

    public Uploadable(){}

    public Uploadable(long creationDate, String macAddress, String username, String adminCode, long approveDate) {
        super(creationDate,adminCode,approveDate);
        this.macAddress = macAddress;
        this.username = username;
    }

    public Uploadable(Parcel in) {
        super(in);
        macAddress = in.readString();
        username = in.readString();
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

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(macAddress);
        parcel.writeString(username);
    }
}
