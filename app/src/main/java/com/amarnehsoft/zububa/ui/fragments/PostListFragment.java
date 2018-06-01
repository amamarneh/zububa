package com.amarnehsoft.zububa.ui.fragments;

import android.content.Intent;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.repo.PostsRepo;
import com.amarnehsoft.zububa.ui.abstractAdapters.CustomHolder;
import com.amarnehsoft.zububa.ui.abstractAdapters.MItem;
import com.amarnehsoft.zububa.ui.abstractAdapters.RecyclerAdapterMultipleTypes;
import com.amarnehsoft.zububa.ui.activities.AddPostActivity;
import com.amarnehsoft.zububa.ui.activities.CommentsListActivity;
import com.amarnehsoft.zububa.controllers.SPController;
import com.amarnehsoft.zububa.model.Post;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.data.webapi.WebApi;
import com.amarnehsoft.zububa.data.webapi.WebFactory;
import com.amarnehsoft.zububa.data.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.ui.adapters.PostsAdapter;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ALa on 3/22/2018.
 */

public class PostListFragment extends ListFragment {
    @Override
    public void setupRecyclerViewAdapter() {
        showLoading();
        new PostsRepo().getNewsFeed()
                .addOnCompleteListener( task -> {
                    showContent();
                    if(task.isSuccessful()){
                        PostsAdapter adapter = new PostsAdapter(task.getResult());
                        mRecyclerView.setAdapter(adapter);
                    }else{
                        showError("Error");
                    }
                });
    }

    @Override
    protected String getDescription() {
        layoutAddItem.setOnClickListener(view -> {
            Intent i = new Intent(getContext(), AddPostActivity.class);
            startActivity(i);
        });
        return "Click here to add new Post";
    }

    @Override
    protected void loadDataFromWeb() {}
}
