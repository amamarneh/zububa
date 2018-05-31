package com.amarnehsoft.zububa.repo;


import android.os.Handler;

import com.amarnehsoft.zububa.data.webapi.WebFactory;
import com.amarnehsoft.zububa.data.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.data.webapi.fb.FBFactory;
import com.amarnehsoft.zububa.model.Post;

import java.util.List;

public class PostsRepo {
    public Task<List<Post>> getNewsFeed(){
        Task<List<Post>> task = new Task<>();
        new Handler().postDelayed( ()->{

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

        },1500);

        return task;
    }
}
