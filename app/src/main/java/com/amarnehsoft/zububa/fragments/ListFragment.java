package com.amarnehsoft.zububa.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.bumptech.glide.Glide;

public abstract class ListFragment extends Fragment {
    public static final String ARG_ITEM = "item";
    protected RecyclerView mRecyclerView;
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected View layoutMessage;
    protected ImageView imgMessage;
    protected TextView tvMessage;
    protected IFragmentListener mListener;
    public ListFragment() {
    }

    private void initRecyclerView(){
        mRecyclerView.setHasFixedSize(true);
        int numberOfCols = getNumberOfCols();
        if(numberOfCols <= 1)
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        else
            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),numberOfCols));
    }

    protected int getNumberOfCols(){
        return 1;
    }
    public abstract void setupRecyclerViewAdapter();
    protected abstract void loadDataFromWeb();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO: 3/22/2018
//        return  inflater.inflate(R.layout.fragment_list, container, false);
        return null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.rv);
        mSwipeRefreshLayout = view.findViewById(R.id.swiperefresh);
//        layoutMessage = view.findViewById(R.id.layoutMessage);
//        imgMessage = view.findViewById(R.id.imgMessage);
//        tvMessage = view.findViewById(R.id.tvMessage);

        hideMessageLayout();
        initRecyclerView();
        initSwipeToRefresh();
        setupRecyclerViewAdapter();
        loadDataFromWeb();

        checkConnection();
    }

    private void checkConnection() {
//        if(!MapUtil.isConnectionAvailable(getContext()))
//            showMessageLayout("No Internet Connection",R.drawable.ic_signal_wifi_off_black_48dp);
    }

    protected void showMessageLayout(String msg, String url){
        if(isAdded()) {
            tvMessage.setText(msg);
            if (url != null)
                Glide.with(getContext()).load(url).into(imgMessage);

            layoutMessage.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }
    }
    protected void showMessageLayout(String msg, int drawable){
        if(isAdded()){

        tvMessage.setText(msg);
            Glide.with(getContext()).load(drawable).into(imgMessage);

        layoutMessage.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
        }
    }
    protected void hideMessageLayout(){
        layoutMessage.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void initSwipeToRefresh() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadDataFromWeb();
            }
        });
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof IFragmentListener){
            mListener = (IFragmentListener) context;
        }else{
            throw new RuntimeException(context.toString() + " must implement IFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface IFragmentListener<T>{
        void onItemClicked(T item);
    }

//    public abstract class Holder<T> extends RecyclerView.ViewHolder implements View.OnClickListener{
//        protected T mItem;
//        public Holder(View itemView) {
//            super(itemView);
//            itemView.setOnClickListener(this);
//        }
//        @Override
//        public void onClick(View v) {
//            onClicked(v);
//        }
//        public  View details(){return null;}
//        public abstract void onClicked(View v);
//        public abstract void bind(T item, int pos);
//        public void setItem(T item){mItem = item;}
//    }
//
//
//    public abstract class Adapter<T> extends RecyclerView.Adapter<Holder>
//    {
//        private List<T> mItems;
//        private int mExpandedPosition =-1;
//        public Adapter(List<T> items)
//        {
//            mItems = items;
//        }
//
//        @Override
//        public Holder onCreateViewHolder(ViewGroup parent, int viewType)
//        {
//            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
//            View view = layoutInflater.inflate(getLayoutId(), parent, false);
//            return getNewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(Holder holder, final int position)
//        {
//            T item = mItems.get(position);
//            holder.setItem(item);
//            holder.bind(item,position);
//
////            final boolean isExpanded = position==mExpandedPosition;
////            if(holder.details() != null)
////            holder.details().setVisibility(isExpanded?View.VISIBLE:View.GONE);
////
////            holder.itemView.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    mExpandedPosition = isExpanded ? -1:position;
////                }
////            });
//        }
//
//        @Override
//        public int getItemCount() {
//            return mItems.size();
//        }
//        public void setList(List<T> items){
//            mItems=items;
//        }
//        public List<T> getList(){
//            return mItems;
//        }
//
//        public void clear(){
//            mItems.clear();
//            notifyDataSetChanged();
//        }
//
//        public abstract int getLayoutId();
//        public abstract Holder getNewHolder(View v);
//    }

}
