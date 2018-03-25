package com.amarnehsoft.zububa.dummy;

import android.content.Context;
import android.util.Log;

import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.webapi.fb.BlogFBApi;
import com.amarnehsoft.zububa.webapi.fb.FBFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 3/19/2018.
 */

public class Dummy {

    public static void dummyScenario(){

//        case1(); //create a blog and push it to not approved blogs

        case2(); //show not approved blogs

//        case3();  //approve all not approved blogs

//        case4(); // //show approved blogs and like it and add a comment

//        case5();  //show not approved comments for the approved blogs and approve it

//        case6();  ////delete the blogs and ites likes and comments
    }

    private static void case1(Context context){
        //case1
        //create a blog and push it to not approved blogs

        Blog b = new Blog(context,"title", "content", "img");
        FBFactory.getBlogApi(false).saveItem(b, (success)-> {if (success) Log.e("Amarneh","saved successfully");} );
    }

    private static void case2(){
        //show not approved blogs
        FBFactory.getBlogApi(false).getList(new IListCallBack<Blog>() {
            @Override
            public void onResponse(List<Blog> value) {
                for (Blog b : value){
                    Log.e("Amarneh","not approved blog : title=" + b.getTitle());
                }
            }

            @Override
            public void onError(String err) {
                Log.e("Amarneh","error while getting the blogs");
            }
        });
    }

    private static void case3(){
        //approve all not approved blogs
        FBFactory.getBlogApi(false).getList(new IListCallBack<Blog>() {
            @Override
            public void onResponse(List<Blog> value) {
                for (Blog b : value){
                    FBFactory.getBlogApi(false).approve(b,(success)->{if (success) Log.e("Amarneh","approved");});
                }
            }

            @Override
            public void onError(String err) {
                Log.e("Amarneh","error while getting the blogs");
            }
        });
    }

    private static void case4(Context context){
        //show approved and like it and add a comment
        BlogFBApi blogsApi = FBFactory.getBlogApi(true);
        blogsApi.getList(new IListCallBack<Blog>() {
            @Override
            public void onResponse(List<Blog> value) {
                for (Blog b : value){
                    blogsApi.putLike(b, context, (success)->{ if (success) Log.e("Amarneh","liked");});
                    blogsApi.putComment(b, new Comment(context,"sdsd"),(success)->{});
                }
            }

            @Override
            public void onError(String err) {
                Log.e("Amarneh","error while getting the blogs");
            }
        });
    }

    public static void case5(){
        //show not approved comments for the approved blogs and approve it
        Log.e("Amarneh","hi");
        FBFactory.getBlogApi(true).getList(new IListCallBack<Blog>() {
            @Override
            public void onResponse(List<Blog> value) {
                for (Blog blog : value){
                    Log.e("Amarneh","blog:"+blog.getTitle());
                    FBFactory.getBlogApi(true).getComments(blog.getCode(), false, new IListCallBack<Comment>() {
                        @Override
                        public void onResponse(List<Comment> value) {
                            for (Comment comment : value){
                                Log.e("Amarneh","not approved comment:"+comment.getComment());
                                FBFactory.getBlogApi(true).approveComment(blog, comment, success -> {});
                            }
                        }

                        @Override
                        public void onError(String err) {
                            //error
                        }
                    });
                }
            }

            @Override
            public void onError(String err) {
                //error
                Log.e("Amarneh","error getting the blogs");
            }
        });
    }

    private static void case6(){
        //delete the blogs and ites likes and comments
        FBFactory.getBlogApi(true).getList(new IListCallBack<Blog>() {
            @Override
            public void onResponse(List<Blog> value) {
                for (Blog blog : value){
                    FBFactory.getBlogApi(true).delete(blog.getCode(), success -> {});
                }
            }

            @Override
            public void onError(String err) {
                //error
            }
        });
    }
}
