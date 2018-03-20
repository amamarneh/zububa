package com.amarnehsoft.zububa.dummy;

import android.util.Log;

import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.ISuccessCallBack;
import com.amarnehsoft.zububa.webapi.fb.BlogFBApi;
import com.amarnehsoft.zububa.webapi.fb.FBFactory;
import com.amarnehsoft.zububa.webapi.fb.FBUtils;

import java.util.Date;
import java.util.List;
import java.util.function.LongFunction;

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

    private static void case1(){
        //case1
        //create a blog and push it to not approved blogs

        Blog b = new Blog(new Date().getTime(), "asd", "ahmad", "",0,"test title" , "test content", "");
        FBFactory.getBlogApi(false).saveItem(b.getCode(), b, new ISuccessCallBack() {
            @Override
            public void success() {
                Log.e("Amarneh","saved successfully");
            }

            @Override
            public void error() {
                Log.e("Amarneh","error while saving the blog!");
            }
        });
    }

    private static void case2(){
        //show not approved blogs
        FBFactory.getBlogApi(false).getList(new ICallBack<Blog>() {
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
        FBFactory.getBlogApi(false).getList(new ICallBack<Blog>() {
            @Override
            public void onResponse(List<Blog> value) {
                for (Blog b : value){
                    FBUtils.approve(b, new ISuccessCallBack() {
                        @Override
                        public void success() {
                            //approved
                        }

                        @Override
                        public void error() {
                            //faild
                        }
                    });
                }
            }

            @Override
            public void onError(String err) {
                Log.e("Amarneh","error while getting the blogs");
            }
        });
    }

    private static void case4(){
        //show approved and like it and add a comment
        BlogFBApi blogsApi = FBFactory.getBlogApi(true);
        blogsApi.getList(new ICallBack<Blog>() {
            @Override
            public void onResponse(List<Blog> value) {
                for (Blog b : value){
                    blogsApi.putLike(b.getCode(), new Like(new Date().getTime(), "assssddd"), new ISuccessCallBack() {
                        @Override
                        public void success() {
                            Log.e("Amarneh","liked");
                        }

                        @Override
                        public void error() {
                            //error
                        }
                    });

                    blogsApi.putComment(b.getCode(), new Comment(new Date().getTime(), "sdsd", "ahmad", "", new Date().getTime(), "test comment"), new ISuccessCallBack() {
                        @Override
                        public void success() {
                            Log.e("Amarneh","comment saved successfully");
                        }

                        @Override
                        public void error() {
                            //error
                        }
                    });
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
        FBFactory.getBlogApi(true).getList(new ICallBack<Blog>() {
            @Override
            public void onResponse(List<Blog> value) {
                for (Blog blog : value){
                    Log.e("Amarneh","blog:"+blog.getTitle());
                    FBFactory.getBlogApi(true).getComments(blog.getCode(), false, new ICallBack<Comment>() {
                        @Override
                        public void onResponse(List<Comment> value) {
                            for (Comment comment : value){
                                Log.e("Amarneh","not approved comment:"+comment.getComment());
                                FBFactory.getBlogApi(true).approveComment(blog.getCode(), comment, new ISuccessCallBack() {
                                    @Override
                                    public void success() {
                                        //approved
                                        Log.e("Amarneh","comment approved");
                                    }

                                    @Override
                                    public void error() {
                                        //error
                                    }
                                });
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
        FBFactory.getBlogApi(true).getList(new ICallBack<Blog>() {
            @Override
            public void onResponse(List<Blog> value) {
                for (Blog blog : value){
                    FBFactory.getBlogApi(true).delete(blog.getCode(), new ISuccessCallBack() {
                        @Override
                        public void success() {
                            Log.e("Amarneh","deleted");
                        }

                        @Override
                        public void error() {
                            //error
                        }
                    });
                }
            }

            @Override
            public void onError(String err) {
                //error
            }
        });
    }
}
