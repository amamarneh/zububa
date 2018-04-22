package com.amarnehsoft.zububa.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.abstractAdapters.CustomHolder;
import com.amarnehsoft.zububa.abstractAdapters.Holder;
import com.amarnehsoft.zububa.abstractAdapters.MItem;
import com.amarnehsoft.zububa.abstractAdapters.RecyclerAdapter;
import com.amarnehsoft.zububa.abstractAdapters.RecyclerAdapterMultipleTypes;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;

import java.util.List;

/**
 * Created by ALa on 3/22/2018.
 */

public abstract class ListFragmentWithAdapter<T> extends ListFragment implements IListCallBack<T>{
    protected List<T> mItems;
    @Override
    public void onResponse(List<T> value) {
        mItems = value;
        MyAdapter adapter = new MyAdapter(value);
        mRecyclerView.setAdapter(adapter);

        progressBarLoading.setVisibility(View.GONE);
    }

    @Override
    public void onError(String err) {
        progressBarLoading.setVisibility(View.GONE);

    }

    @Override
    public void setupRecyclerViewAdapter() {

    }


    protected abstract int getLayout();
    protected abstract Holder getHolder(View view);

    private class MyAdapter extends RecyclerAdapter<T> {


        public MyAdapter(List<T> items) {
            super(items);
        }

        @Override
        public int getLayoutId() {
            return getLayout();
        }

        @Override
        public Holder getNewHolder(View v) {
            return getHolder(v);
        }
    }
}
