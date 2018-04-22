package com.amarnehsoft.zububa.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.fragments.GalleryListFragment;
import com.amarnehsoft.zububa.fragments.ListFragment;
import com.amarnehsoft.zububa.fragments.PostListFragment;
import com.amarnehsoft.zububa.fragments.TaxiListFragment;
import com.amarnehsoft.zububa.fragments.WeddingsListFragments;
import com.amarnehsoft.zububa.model.Wedding;

public class DashboardActivity extends AppCompatActivity implements ListFragment.IFragmentListener,WeddingsListFragments.IListener {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Binding
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout= (TabLayout) findViewById(R.id.tabLayout);

        //setup tabsLayout and ViewPager
        PagerAdapter pagerAdapter=new FragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onItemClicked(Object item) {

    }

    @Override
    public void onWeddingClicked(Wedding wedding) {

    }

    // TODO: 3/21/2018 when fragments done
    // For Tabs
    class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new PostListFragment();
                case 1:
                    return new WeddingsListFragments();
                case 2:
                    return new TaxiListFragment();
                case 3:
                    return new GalleryListFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                //
                //Your tab titles
                //
                case 0:return "Posts";
                case 1:return "Weddings";
                case 2:return "Taxis";
                case 3:return "Gallery";
                default:return null;
            }
        }
    }

}
