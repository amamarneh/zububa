package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.amarnehsoft.zububa.model.FBModels.FBBaseModel;

/**
 * Created by user on 3/17/2018.
 */

public class BaseModel extends FBBaseModel implements Parcelable{
    private String code;

    public BaseModel(){}

    public BaseModel(String code, long creationDate) {
        super(creationDate);
        this.code = code;
    }

    protected BaseModel(Parcel in) {
        super(in);
        code = in.readString();
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
        super.writeToParcel(parcel,i);
        parcel.writeString(code);
    }
}
