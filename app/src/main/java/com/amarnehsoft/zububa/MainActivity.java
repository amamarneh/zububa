package com.amarnehsoft.zububa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.amarnehsoft.zububa.ui.activities.DashboardActivity;
import com.amarnehsoft.zububa.model.Blog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test
        Blog blog = new Blog();
        blog.setTitle("test title");
        blog.setContent("test content");
        blog.setImgUrl("image url");
        blog.setAdminCode("admin");
        blog.setUsername("ahmad");
        blog.setApproveDate(0L);
        blog.setCreationDate(0L);
        blog.setMacAddress("asdfggfd");

//        WebService.getInstance().getBlog(new ICallBack<Blog>() {
//            @Override
//            public void onResponse(List<Blog> value) {
//
//            }
//
//            @Override
//            public void onError(String err) {
//
//            }
//        });





//        dont use webService
//        use the factory pattern
/*
        BlogFBApi blogsApi = FBFactory.getBlogApi(true);
        blogsApi.getList(new IListCallBack<Blog>() {
            @Override
            public void onResponse(List<Blog> value) {
                //got all approved blogs
                for (Blog b : value){
                    blogsApi.getLikes(b.getCode(), new IListCallBack<Like>() {
                        @Override
                        public void onResponse(List<Like> value) {
                            //likes for the blog
                        }

                        @Override
                        public void onError(String err) {
                            //error while getting the likes for the blog
                        }
                    });

//                    blogsApi.getComments(b.getCode(), new ICallBack<Comment>() {
//                        @Override
//                        public void onResponse(List<Comment> value) {
//                            //got comments for the blog
//                        }
//
//                        @Override
//                        public void onError(String err) {
//                            //error while getting the comments for the blog
//                        }
//                    });
                }
            }

            @Override
            public void onError(String err) {
                //error while getting the blogs
            }
        });
        */

        //Dummy.dummyScenario();
    }

    public void click(View view) {
        startActivity(new Intent(this, DashboardActivity.class));
    }
}
