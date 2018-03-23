package com.amarnehsoft.zububa.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.amarnehsoft.zububa.utils.DeviceUtils;
import com.amarnehsoft.zububa.utils.SystemUtils;

/**
 * Created by user on 3/19/2018.
 */

public class Like extends BaseModel implements Parcelable{
    private String macAddress;

    public Like(){
        super();
    }

    public Like(Context context) {
        super();
        this.macAddress = SystemUtils.getDeviceId(context);
    }

    public Like(Parcel in) {
        super(in);
        macAddress = in.readString();
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(macAddress);
    }
}
