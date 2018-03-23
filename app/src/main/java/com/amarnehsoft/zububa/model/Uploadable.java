package com.amarnehsoft.zububa.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.amarnehsoft.zububa.controllers.SPController;
import com.amarnehsoft.zububa.utils.SystemUtils;

/**
 * Created by user on 3/19/2018.
 */

public abstract class Uploadable extends Uprovable implements Parcelable{
    private String macAddress,username; //if approved -> whos admin that approved this

    public Uploadable(){
        super();
    }

    public Uploadable(Context context) {
        super();
        this.macAddress = SystemUtils.getDeviceId(context);
        this.username = SPController.getInstance(context).getLastName();
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
