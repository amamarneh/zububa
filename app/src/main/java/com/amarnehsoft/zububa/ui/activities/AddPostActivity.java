package com.amarnehsoft.zububa.ui.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.data.webapi.WebFactory;
import com.amarnehsoft.zububa.model.Post;
import com.amarnehsoft.zububa.repo.PostsRepo;
import com.amarnehsoft.zububa.repo.Task;
import com.amarnehsoft.zububa.ui.base.BaseActivity;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddPostActivity extends BaseActivity {
    private ImageView imageView;
    private EditText txtDescription;
    private Uri mUriImage;
    private Task<String> taskUpload;

    @BindView(R.id.progressBarLoading)
    ProgressBar progressBarLoading;

    @OnClick(R.id.btnSend)
    void send(){
        startUpload();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        ButterKnife.bind(this);
        showBackArrow();
        setTitle("Add new post");
        //binding
        imageView = findViewById(R.id.imageView);
        txtDescription = findViewById(R.id.txtDescription);

        imageView.setOnClickListener( view ->{
            openGallery();
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            mUriImage = data.getData();
            Glide.with(this).load(mUriImage).into(imageView);
        }
    }

    private void startUpload() {
        if(mUriImage == null){
            Toast.makeText(this, "choose an image", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBarLoading.setVisibility(View.VISIBLE);
        taskUpload = WebFactory.getWebService().uploadImage(mUriImage)
                .addOnCompleteListener(task -> {
                    progressBarLoading.setVisibility(View.GONE);
                    if(task.isSuccessful()){
                        Post post = new Post();
                        post.setImgUrl(task.getResult());
                        post.setContent(TextUtils.isEmpty(txtDescription.getText())?"": txtDescription.getText().toString().trim());
                        new PostsRepo().writePost(post);
                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                    }
                    finish();
                });

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(taskUpload != null)
            taskUpload.cancel();
    }
}
