package com.amarnehsoft.zububa.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
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
import com.amarnehsoft.zububa.ui.base.BaseFragment;
import com.bumptech.glide.Glide;
import com.gturedi.views.StatefulLayout;

import butterknife.BindView;
import butterknife.ButterKnife;


public abstract class ListFragment extends BaseFragment {
    @BindView(R.id.stateful)
    StatefulLayout statefulLayout;

    protected RecyclerView mRecyclerView;
    protected View layoutMessage,layoutAddItem;
    protected ImageView imgMessage;
    protected TextView tvMessage,tvDescription;
    protected IFragmentListener mListener;
    protected NestedScrollView mNestedScrollView;
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
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mRecyclerView = view.findViewById(R.id.rv);
        layoutAddItem = view.findViewById(R.id.layoutAddItem);
        tvDescription = view.findViewById(R.id.tvDescription);
        mNestedScrollView = view.findViewById(R.id.nestedScrollView);

        if(getDescription() == null){
            layoutAddItem.setVisibility(View.GONE);

        }else{
            layoutAddItem.setVisibility(View.VISIBLE);
            tvDescription.setText(getDescription());
        }

        initRecyclerView();
        setupRecyclerViewAdapter();
        loadDataFromWeb();

        checkConnection();
    }
    protected String getDescription(){return null;}

    private void checkConnection() {
    }


    protected void showLoading(){
        statefulLayout.showLoading("Loading");
    }
    protected void showContent(){
        statefulLayout.showContent();
    }
    public void showError(String err){
        statefulLayout.showError(err, v->{
            setupRecyclerViewAdapter();
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



}