package com.amarnehsoft.zububa.model.FBModels;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class FBBaseModel implements Parcelable{
    private long creationDate;

    public FBBaseModel(long creationDate) {
        this.creationDate = creationDate;
    }

    protected FBBaseModel(Parcel in) {
        creationDate = in.readLong();
    }

    public FBBaseModel() {
    }

    public static final Creator<FBBaseModel> CREATOR = new Creator<FBBaseModel>() {
        @Override
        public FBBaseModel createFromParcel(Parcel in) {
            return new FBBaseModel(in);
        }

        @Override
        public FBBaseModel[] newArray(int size) {
            return new FBBaseModel[size];
        }
    };

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(creationDate);
    }
}
