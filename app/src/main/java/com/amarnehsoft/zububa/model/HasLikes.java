package com.amarnehsoft.zububa.model;

import android.content.Context;
import android.os.Parcel;

/**
 * Created by user on 3/22/2018.
 */

public abstract class HasLikes extends Uploadable{
    private int likesCount;

    public HasLikes(){
        super();
    }

    public HasLikes(Context context) {
        super(context);
    }

    public HasLikes(Parcel in) {
        super(in);
        likesCount = in.readInt();
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(likesCount);
    }
}
