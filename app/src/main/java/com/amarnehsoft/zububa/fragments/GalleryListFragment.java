package com.amarnehsoft.zububa.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.abstractAdapters.Holder;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.GalleryItem;
import com.amarnehsoft.zububa.webapi.WebFactory;
import com.bumptech.glide.Glide;

/**
 * Created by ALa on 3/22/2018.
 */

public class GalleryListFragment extends ListFragmentWithAdapter<GalleryItem> {
    @Override
    protected int getLayout() {
        return R.layout.item_gallery;
    }

    @Override
    protected Holder getHolder(View view) {
        return new MyHolder(view);
    }

    @Override
    protected void loadDataFromWeb() {
        WebFactory.getWebService().getGallery(this);
    }

    private class MyHolder extends Holder<GalleryItem>{
        private TextView tvDescription;
        private ImageView imageView;
        public MyHolder(View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imageView = itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClicked(View v) {

        }

        @Override
        public void bind(GalleryItem item, int pos) {
            super.bind(item, pos);
            tvDescription.setText(item.getDesc());
            Glide.with(itemView).load(item.getImgUrl()).into(imageView);
        }
    }
}
