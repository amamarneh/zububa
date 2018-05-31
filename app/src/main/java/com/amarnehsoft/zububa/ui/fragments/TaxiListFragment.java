package com.amarnehsoft.zububa.ui.fragments;

import android.view.View;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.ui.abstractAdapters.Holder;
import com.amarnehsoft.zububa.ui.abstractAdapters.RecyclerAdapter;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.data.webapi.WebApi;
import com.amarnehsoft.zububa.data.webapi.WebFactory;
import com.amarnehsoft.zububa.data.webapi.callBacks.IListCallBack;

import java.util.List;

/**
 * Created by ALa on 3/21/2018.
 */

public class TaxiListFragment extends ListFragment {
    @Override
    public void setupRecyclerViewAdapter() {
        WebApi webApi = WebFactory.getWebService();
        webApi.getTaxiList(new IListCallBack<Taxi>() {
            @Override
            public void onResponse(List<Taxi> value) {
                progressBarLoading.setVisibility(View.GONE);
                MyAdapter adapter = new MyAdapter(value);
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String err) {
                progressBarLoading.setVisibility(View.GONE);

            }
        });
    }

    @Override
    protected void loadDataFromWeb() {

    }

    private class MyHolder extends Holder<Taxi>{
        private TextView tvName,tvPhone,tvDescription;
        public MyHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        @Override
        public void bind(Taxi item, int pos) {
            super.bind(item, pos);
            tvName.setText(item.getName());
            tvPhone.setText(item.getPhone());
            tvDescription.setText(item.getDesc());
        }

        @Override
        public void onClick(View v) {
            tvDescription.setVisibility(tvDescription.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
            if(mListener != null)
                mListener.onItemClicked(mItem);
        }
    }

    private class MyAdapter extends RecyclerAdapter<Taxi>{

        public MyAdapter(List<Taxi> items) {
            super(items);
        }

        @Override
        public int getLayoutId() {
            return R.layout.item_taxi;
        }

        @Override
        public Holder getNewHolder(View v) {
            return new MyHolder(v);
        }
    }
}
