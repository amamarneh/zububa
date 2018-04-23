package com.amarnehsoft.zububa.fragments;

import android.content.Context;
import android.media.Image;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.abstractAdapters.Holder;
import com.amarnehsoft.zububa.abstractAdapters.RecyclerAdapter;
import com.amarnehsoft.zububa.controllers.SPController;
import com.amarnehsoft.zububa.model.Wedding;
import com.amarnehsoft.zububa.utils.DateUtil;
import com.amarnehsoft.zububa.webapi.WebApi;
import com.amarnehsoft.zububa.webapi.WebFactory;
import com.amarnehsoft.zububa.webapi.WebService;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;
import com.bumptech.glide.Glide;

import java.util.Date;
import java.util.List;

/**
 * Created by ALa on 3/21/2018.
 */

public class WeddingsListFragments extends ListFragment {
    private IListener mListener;
    @Override
    public void setupRecyclerViewAdapter() {
        WebApi webApi = WebFactory.getWebService();
        webApi.getWeddings(new IListCallBack<Wedding>() {
            @Override
            public void onResponse(List<Wedding> value) {
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


    private class MyHolder extends Holder<Wedding>{
        private TextView tvName,tvDate,tvDateDay,tvDateMonth,tvLoveCount;
        private ImageView imageView,imgLove;
        public MyHolder(View itemView) {
            super(itemView);
            tvName= itemView.findViewById(R.id.tvName);
            tvDate= itemView.findViewById(R.id.tvDate);
            tvDateDay= itemView.findViewById(R.id.tvDateDay);
            tvDateMonth= itemView.findViewById(R.id.tvDateMonth);
            imageView= itemView.findViewById(R.id.imageView);
            tvLoveCount= itemView.findViewById(R.id.tvLoveCount);
            imgLove= itemView.findViewById(R.id.imgLove);

        }

        @Override
        public void bind(Wedding item, int pos) {
            super.bind(item, pos);
            tvName.setText(item.getTitle());
            tvDate.setText(DateUtil.formatDate(new Date(item.getWeddingDate())));
            tvDateDay.setText(DateUtil.getDayOfMonth(new Date(item.getWeddingDate())));
            tvDateMonth.setText(DateUtil.getMonthName(new Date(item.getWeddingDate())));
            tvLoveCount.setText(item.getLikesCount() + "");

            Glide.with(itemView).load(item.getImgUrl()).into(imageView);

            if(SPController.isLiked(itemView.getContext(),item))
                imgLove.setImageResource(R.drawable.ic_favorite_black_24dp);
            else
                imgLove.setImageResource(R.drawable.ic_favorite_border_black_24dp);

            imgLove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgLove.setImageResource(R.drawable.ic_favorite_black_24dp);
                    SPController.setLike(itemView.getContext(),item);
                    WebFactory.getWebService().sendLikeForWedding(item,null);
                }
            });

        }

        @Override
        public void onClick(View v) {
            if(mListener != null)
                mListener.onWeddingClicked(mItem);
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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof IListener){
            mListener = (IListener) context;
        }else{
            throw new RuntimeException(context.toString() + " must implement IFragmentListener");
        }
    }

    public interface IListener{
        void onWeddingClicked(Wedding wedding);
    }
}
