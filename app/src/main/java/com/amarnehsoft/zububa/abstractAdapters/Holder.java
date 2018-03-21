package com.amarnehsoft.zububa.abstractAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ALa on 2/1/2018.
 */

public abstract class Holder<T> extends RecyclerView.ViewHolder implements View.OnClickListener{
    protected T mItem;

    public Holder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onClicked(v);
    }

    public abstract void onClicked(View v);

    public void bind(T item, int pos){
        mItem = item;
    }
}