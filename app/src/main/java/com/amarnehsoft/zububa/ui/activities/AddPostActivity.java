package com.amarnehsoft.zububa.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.model.Post;
import com.bumptech.glide.Glide;

public class AddPostActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;
    private ImageView imageView;
    private EditText txtDescription;
    private Uri mUriImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        //binding
        imageView = findViewById(R.id.imageView);
        txtDescription = findViewById(R.id.txtDescription);

        imageView.setOnClickListener( view ->{

        });
    }
    private void openGallery() {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");
        startActivityForResult(getIntent, PICK_IMAGE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            mUriImage = data.getData();
            Glide.with(this).load(mUriImage).into(imageView);


            startUpload();
        }
    }

    private void startUpload() {
        if(mUriImage == null){
            Toast.makeText(this, "choose an image", Toast.LENGTH_SHORT).show();
            return;
        }

//        showProgress(true);
        Post post = new Post();


//        WebFactory.getWebService().writePost();

    }
}
