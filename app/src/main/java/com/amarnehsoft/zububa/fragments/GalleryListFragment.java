package com.amarnehsoft.zububa.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.abstractAdapters.Holder;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.GalleryItem;
import com.amarnehsoft.zububa.webapi.WebFactory;
import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.stfalcon.frescoimageviewer.ImageViewer;

/**
 * Created by ALa on 3/22/2018.
 */

public class GalleryListFragment extends ListFragmentWithAdapter<GalleryItem> {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getContext().getApplicationContext());
    }

    @Override
    protected int getLayout() {
        return R.layout.item_gallery;
    }

    @Override
    protected Holder getHolder(View view) {
        return new MyHolder(view);
    }


    @Override
    protected int getNumberOfCols() {
        return 2;
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
        public void onClick(View v) {
            new ImageViewer.Builder<>(getContext(), mItems)
                    .setFormatter(new ImageViewer.Formatter<GalleryItem>() {
                        @Override
                        public String format(GalleryItem galleryItem) {
                            return galleryItem.getImgUrl();
                        }
                    })
                    .setStartPosition(getAdapterPosition())
                    .show();
        }

        @Override
        public void bind(GalleryItem item, int pos) {
            super.bind(item, pos);
            tvDescription.setText(item.getDesc());
            Glide.with(itemView).load(item.getImgUrl()).into(imageView);
        }
    }
}
