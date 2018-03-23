package com.amarnehsoft.zububa.model;

import android.content.Context;
import android.os.Parcel;

/**
 * Created by user on 3/22/2018.
 */

public abstract class HasComments extends HasLikes{
    private int commentsCount;

    public HasComments(Context context) {
        super(context);
    }

    public HasComments(Parcel in) {
        super(in);
        commentsCount = in.readInt();
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public HasComments(){
        super();
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(commentsCount);
    }
}
