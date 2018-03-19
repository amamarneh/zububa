package com.amarnehsoft.zububa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.amarnehsoft.zububa.model.FBModels.FBBlog;
import com.amarnehsoft.zububa.webapi.ICallBack;
import com.amarnehsoft.zububa.webapi.ISaveCallBack;
import com.amarnehsoft.zububa.webapi.WebService;
import com.amarnehsoft.zububa.webapi.fb.FBFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test
        FBBlog blog = new FBBlog();
        blog.setTitle("test title");
        blog.setContent("test content");
        blog.setImgUrl("image url");
        blog.setAdminCode("admin");
        blog.setUsername("ahmad");
        blog.setApproveDate(0L);
        blog.setCreationDate(0L);
        blog.setMacAddress("asdfggfd");

        WebService.getInstance().getBlog(new ICallBack<FBBlog>() {
            @Override
            public void onResponse(List<FBBlog> value) {

            }

            @Override
            public void onError(String err) {

            }
        });
    }
}
