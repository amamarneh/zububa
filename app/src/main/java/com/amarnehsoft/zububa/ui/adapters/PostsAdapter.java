package com.amarnehsoft.zububa.ui.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amarnehsoft.zububa.R;
import com.amarnehsoft.zububa.controllers.SPController;
import com.amarnehsoft.zububa.data.webapi.WebFactory;
import com.amarnehsoft.zububa.model.Post;
import com.amarnehsoft.zububa.ui.activities.CommentsListActivity;
import com.amarnehsoft.zububa.ui.base.BaseViewHolder;
import com.amarnehsoft.zububa.ui.fragments.CommentsFragment;
import com.bumptech.glide.Glide;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final static int TYPE_POST =0;
    private final static int TYPE_AD =1;
    private List<Post> posts;

    public PostsAdapter(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public int getItemViewType(int position) {
        if(posts.get(position).getType() == Post.TYPE_POST)
            return TYPE_POST;
        return TYPE_AD;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case TYPE_POST:{
                View view = layoutInflater.inflate(R.layout.item_post, parent, false);
                return new PostHolder(view);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return posts==null?0:posts.size();
    }

    class PostHolder extends BaseViewHolder{
        private TextView tvDescription;
        private TextView tvDate;
        private TextView tvLoveCount;
        private View layoutComment;
        private ImageView imageView;
        private ImageView imgLove;
        private boolean loved = false;

        public PostHolder(View itemView) {
            super(itemView);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            imageView = itemView.findViewById(R.id.imageView);
            layoutComment = itemView.findViewById(R.id.layoutComment);
            tvDate = itemView.findViewById(R.id.tvDate);
            imgLove = itemView.findViewById(R.id.imgLove);
            tvLoveCount = itemView.findViewById(R.id.tvLoveCount);

        }

        @Override
        public void onBind(int position) {
            Post item = posts.get(getAdapterPosition());
            tvDate.setText(DateUtils.getRelativeTimeSpanString(item.getCreationDate()));
            tvDescription.setText(item.getContent());
            Glide.with(itemView).load(item.getImgUrl()).into(imageView);
            tvLoveCount.setText(item.getLikesCount() + "");

            loved = SPController.isLiked(itemView.getContext(),item);

            if(loved)
                imgLove.setImageResource(R.drawable.ic_favorite_black_24dp);
            else
                imgLove.setImageResource(R.drawable.ic_favorite_border_black_24dp);

            layoutComment.setOnClickListener( v -> {
                Intent i =  CommentsListActivity.getIntent(itemView.getContext(), CommentsFragment.TYPE_POST,posts.get(getAdapterPosition()));
                itemView.getContext().startActivity(i);
            });
            imgLove.setOnClickListener( v -> {
                SPController.setLike(itemView.getContext(),posts.get(getAdapterPosition()));
                imgLove.setImageResource(R.drawable.ic_favorite_black_24dp);
                WebFactory.getWebService().sendLikeForPost(posts.get(getAdapterPosition()),null);
            });
        }
    }
}
