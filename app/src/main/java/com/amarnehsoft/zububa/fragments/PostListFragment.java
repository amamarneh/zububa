package com.amarnehsoft.zububa.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.abstractAdapters.CustomHolder;
import com.amarnehsoft.zububa.abstractAdapters.Holder;
import com.amarnehsoft.zububa.abstractAdapters.MItem;
import com.amarnehsoft.zububa.abstractAdapters.RecyclerAdapterMultipleTypes;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.Post;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.webapi.WebFactory;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALa on 3/22/2018.
 */

/**
 * NewsFeed Fragment
 * it has multiple types of models
 */
public class PostListFragment extends ListFragment {


    @Override
    public void setupRecyclerViewAdapter() {
        WebFactory.getWebService().getNewsFeed(new IListCallBack<MItem>() {
            @Override
            public void onResponse(List<MItem> value) {
                MyAdapter adapter = new MyAdapter(value);
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String err) {

            }
        });
    }

    @Override
    protected void loadDataFromWeb() {}

    private class PostHolder extends CustomHolder<Post>{
        private TextView tvDescription;
        private ImageView imageView;
        public PostHolder(View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imageView = itemView.findViewById(R.id.imageView);
        }

        @Override
        public void renderItem(Post item) {
            super.renderItem(item);
            tvDescription.setText(item.getContent());
            Glide.with(itemView).load(item.getImgUrl()).into(imageView);
        }

        @Override
        public void onClick(View view) {

        }
    }
    private class TaxiHolder extends CustomHolder<Taxi>{
        private TextView tvName,tvPhone,tvDescription;
        public TaxiHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        @Override
        public void renderItem(Taxi item) {
            super.renderItem(item);
            tvName.setText(item.getName());
            tvPhone.setText(item.getPhone());
            tvDescription.setText(item.getDesc());
        }

        @Override
        public void onClick(View view) {
            if(mListener != null)
                mListener.onItemClicked(mItem);
        }
    }

    private class MyAdapter extends RecyclerAdapterMultipleTypes{

        public MyAdapter(List<MItem> items) {
            super(items);
        }
        @Override
        public CustomHolder getHolder(int type, ViewGroup parent) {
            if(type == Post.VIEW_TYPE){
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                View view = layoutInflater.inflate(R.layout.item_post, parent, false);
                return new PostHolder(view);
            }
            if(type == Taxi.VIEW_TYPE){
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                View view = layoutInflater.inflate(R.layout.item_taxi, parent, false);
                return new TaxiHolder(view);
            }
            return null;
        }
    }

}
