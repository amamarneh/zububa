package com.amarnehsoft.zububa.repo;


import android.os.Handler;

import com.amarnehsoft.zububa.data.webapi.WebFactory;
import com.amarnehsoft.zububa.data.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.data.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.data.webapi.fb.FBFactory;
import com.amarnehsoft.zububa.model.Post;

import java.util.List;

public class PostsRepo {
    public Task<List<Post>> getNewsFeed(){
        Task<List<Post>> task = new Task<>();
            WebFactory.getWebService().getPosts(new IListCallBack<Post>() {
                @Override
                public void onResponse(List<Post> value) {
                    task.response(value,true);
                }

                @Override
                public void onError(String err) {
                    task.response(null,false);
                }
            });

        return task;
    }
    public Task<Void> writePost(Post post){
        Task<Void> task = new Task<>();

        WebFactory.getWebService().writePost(post, new ICallBack<Boolean>() {
            @Override
            public void onResponse(Boolean value) {
                task.response(null,true);
            }

            @Override
            public void onError(String err) {
                task.response(null,false);
            }
        });

        return task;
    }
}
