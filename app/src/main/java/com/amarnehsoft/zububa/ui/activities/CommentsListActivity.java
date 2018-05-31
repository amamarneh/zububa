package com.amarnehsoft.zububa.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

import com.amarnehsoft.zububa.ui.activities.abstractActivities.EmptyActivity;
import com.amarnehsoft.zububa.ui.fragments.CommentsFragment;

/**
 * Created by ALa on 3/25/2018.
 */

public class CommentsListActivity extends EmptyActivity<Parcelable> {
    private int type;

    public static Intent getIntent(Context context, int type, Parcelable model){
        Intent intent = new Intent(context,CommentsListActivity.class);
        intent.putExtra("type",type);
        intent.putExtra(ARG_BEAN,model);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getIntent().getIntExtra("type",0);
    }

    @Override
    protected String getBarTitle() {
        return "Comments";
    }

    @Override
    public Fragment getFragment() {
        return CommentsFragment.newInstance(type,mBean);
    }
}
