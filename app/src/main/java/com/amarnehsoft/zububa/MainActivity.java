package com.amarnehsoft.zububa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.fb.FBFactory;
import com.amarnehsoft.zububa.webapi.fb.constants.FB_REF;

import java.util.List;

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





        //dont use webService
        //use the factory pattern

        FBFactory.getBlogApi(true).getList(new ICallBack<Blog>() {
            @Override
            public void onResponse(List<Blog> value) {
                for (Blog b : value){
                    FBFactory.getLikesFBApi(FB_REF.blogs,b.getCode()).getList(new ICallBack<Like>() {
                        @Override
                        public void onResponse(List<Like> value) {
                            Log.e("Amarneh","the blog:"+b.getTitle() + ", has:" + value.size() + " Likes");
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
            }
        });

//        FBFactory.getBlogApi(false).getList(v-> {});
    }
}
