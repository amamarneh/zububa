package com.amarnehsoft.zububa.ui.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.ui.abstractAdapters.Holder;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.data.webapi.WebFactory;
import com.bumptech.glide.Glide;

/**
 * Created by ALa on 3/22/2018.
 */

public class BlogListFragment extends ListFragmentWithAdapter<Blog> {
    @Override
    protected int getLayout() {
        return R.layout.item_blog;
    }

    @Override
    protected Holder getHolder(View view) {
        return new MyHolder(view);
    }

    @Override
    protected void loadDataFromWeb() {
        WebFactory.getWebService().getBlog(this);
    }

    private class MyHolder extends Holder<Blog>{
        private TextView tvDescription;
        private ImageView imageView;
        public MyHolder(View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imageView = itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public void bind(Blog item, int pos) {
            super.bind(item, pos);
            tvDescription.setText(item.getContent());
            Glide.with(itemView).load(item.getImgUrl()).into(imageView);
        }
    }
}
