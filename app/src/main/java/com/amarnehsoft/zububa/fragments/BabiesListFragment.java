package com.amarnehsoft.zububa.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.abstractAdapters.Holder;
import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.webapi.WebFactory;
import com.amarnehsoft.zububa.webapi.WebService;
import com.bumptech.glide.Glide;

/**
 * Created by ALa on 3/22/2018.
 */

public class BabiesListFragment extends ListFragmentWithAdapter<Baby> {
    @Override
    protected int getLayout() {
        return R.layout.item_baby;
    }

    @Override
    protected Holder getHolder(View view) {
        return new MyHolder(view);
    }

    @Override
    protected void loadDataFromWeb() {
        WebFactory.getWebService().getBabies(this);
    }

    private class MyHolder extends Holder<Baby>{
        private TextView tvDescription;
        private ImageView imageView;
        public MyHolder(View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imageView = itemView.findViewById(R.id.imageView);
        }

        @Override
        public void bind(Baby item, int pos) {
            super.bind(item, pos);
            tvDescription.setText(item.getDesc());
            Glide.with(itemView).load(item.getImgUrl()).into(imageView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
