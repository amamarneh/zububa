package com.amarnehsoft.zububa.fragments;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.abstractAdapters.Holder;
import com.amarnehsoft.zububa.abstractAdapters.RecyclerAdapter;
import com.amarnehsoft.zububa.model.Wedding;
import com.amarnehsoft.zububa.webapi.WebApi;
import com.amarnehsoft.zububa.webapi.WebService;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;

import java.util.Date;
import java.util.List;

/**
 * Created by ALa on 3/21/2018.
 */

public class WeddingsListFragments extends ListFragment {
    @Override
    public void setupRecyclerViewAdapter() {
        WebApi webApi = WebService.getInstance();
        webApi.getWeddings(new IListCallBack<Wedding>() {
            @Override
            public void onResponse(List<Wedding> value) {
                MyAdapter adapter = new MyAdapter(value);
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String err) {

            }
        });
    }

    @Override
    protected void loadDataFromWeb() {

    }


    private class MyHolder extends Holder<Wedding>{
        private TextView tvName,tvDate,tvDateDay,tvDateMonth;
        public MyHolder(View itemView) {
            super(itemView);
            tvName= itemView.findViewById(R.id.tvName);
            tvDate= itemView.findViewById(R.id.tvDate);
            tvDateDay= itemView.findViewById(R.id.tvDateDay);
            tvDateMonth= itemView.findViewById(R.id.tvDateMonth);
        }

        @Override
        public void bind(Wedding item, int pos) {
            super.bind(item, pos);
            tvName.setText(item.getTitle());
            tvDate.setText(DateUtils.getRelativeTimeSpanString(item.getWeddingDate()));
            tvDateDay.setText(new Date(item.getWeddingDate()).getDay() +"");
            tvDateMonth.setText(new Date(item.getWeddingDate()).getMonth() +"");
        }

        @Override
        public void onClicked(View v) {
            if(mListener != null)
                mListener.onItemClicked(mItem);
        }
    }
    private class  MyAdapter  extends RecyclerAdapter<Wedding>{

        public MyAdapter(List<Wedding> items) {
            super(items);
        }

        @Override
        public int getLayoutId() {
            return R.layout.item_wedding;
        }

        @Override
        public Holder getNewHolder(View v) {
            return new MyHolder(v);
        }
    }
}
