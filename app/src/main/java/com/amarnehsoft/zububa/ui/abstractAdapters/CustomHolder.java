package com.amarnehsoft.zububa.ui.abstractAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ALa on 3/22/2018.
 */

public abstract class CustomHolder<T extends MItem> extends RecyclerView.ViewHolder  implements View.OnClickListener {
    protected T mItem;
    public CustomHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }
    public void renderItem(T item){
        mItem = item;
    }
}
