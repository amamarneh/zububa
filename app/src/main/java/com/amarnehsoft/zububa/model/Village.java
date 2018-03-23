package com.amarnehsoft.zububa.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 3/19/2018.
 */

public class Village extends BaseModel implements Parcelable{
    private String name;

    public Village(){}

    public Village(String name) {
        super();
        this.name = name;
    }

    public Village(Parcel in) {
        super(in);
        name = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(name);
    }
}
