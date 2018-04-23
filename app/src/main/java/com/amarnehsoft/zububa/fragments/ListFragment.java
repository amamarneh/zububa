package com.amarnehsoft.zububa.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.amarnehsoft.zububa.R;
import com.bumptech.glide.Glide;


public abstract class ListFragment extends Fragment {
    public static final String ARG_ITEM = "item";
    protected RecyclerView mRecyclerView;
    protected ProgressBar progressBarLoading;
    protected View layoutMessage,layoutAddItem;
    protected ImageView imgMessage;
    protected TextView tvMessage,tvDescription;
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
        return  inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.rv);
        layoutMessage = view.findViewById(R.id.layoutMessage);
        imgMessage = view.findViewById(R.id.imgMessage);
        tvMessage = view.findViewById(R.id.tvMessage);
        layoutAddItem = view.findViewById(R.id.layoutAddItem);
        tvDescription = view.findViewById(R.id.tvDescription);
        progressBarLoading = view.findViewById(R.id.progressBarLoading);

        if(getDescription() == null){
            layoutAddItem.setVisibility(View.GONE);

        }else{
            layoutAddItem.setVisibility(View.VISIBLE);
            tvDescription.setText(getDescription());
        }

        hideMessageLayout();
        initRecyclerView();
        setupRecyclerViewAdapter();
        loadDataFromWeb();

        checkConnection();
    }
    protected String getDescription(){return null;}

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
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof IFragmentListener){
            mListener = (IFragmentListener) context;
        }else{
            throw new RuntimeException(context.toString() + " must implement IFragmentListener");
        }
    }
    protected void setLoading(boolean loading){
        progressBarLoading.setVisibility(loading?View.VISIBLE:View.GONE);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface IFragmentListener<T>{
        void onItemClicked(T item);
    }



}