package com.amarnehsoft.zububa.ui.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public abstract class BaseActivity extends AppCompatActivity {
    protected static final int PICK_IMAGE = 1999;
    protected void showBackArrow(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    protected void openGallery() {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");
        startActivityForResult(getIntent, PICK_IMAGE);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
