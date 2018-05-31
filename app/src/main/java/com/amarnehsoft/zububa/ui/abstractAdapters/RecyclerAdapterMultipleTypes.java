package com.amarnehsoft.zububa.ui.abstractAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALa on 2/1/2018.
 */

public abstract class RecyclerAdapterMultipleTypes extends RecyclerView.Adapter<CustomHolder>
{
    private List<MItem> mItems;
    public abstract CustomHolder getHolder(int type,ViewGroup parent);

    public RecyclerAdapterMultipleTypes(List<MItem> items)
    {
        mItems = items;
        if(mItems == null)
            mItems = new ArrayList<>();
    }

    @Override
    public CustomHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return getHolder(viewType,parent);
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(CustomHolder holder, int position)
    {
        MItem item = mItems.get(position);
        holder.renderItem(item);
    }

    @Override
    public int getItemCount() {
        if(mItems == null) return 0;
        return mItems.size();
    }
    public void setList(List<MItem> items){
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

}