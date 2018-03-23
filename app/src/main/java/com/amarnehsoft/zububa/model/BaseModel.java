package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by user on 3/19/2018.
 */

public class BaseModel implements Parcelable{
    private long creationDate;
    private String code;

    protected String generateCode(){
        return UUID.randomUUID().toString();
    }

    protected BaseModel(Parcel in) {
        creationDate = in.readLong();
        code = in.readString();
    }

    public BaseModel() {
        code = generateCode();
        creationDate = new Date().getTime();
    }

    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(creationDate);
        parcel.writeString(code);
    }
}
