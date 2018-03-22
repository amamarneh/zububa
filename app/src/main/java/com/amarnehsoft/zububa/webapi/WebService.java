package com.amarnehsoft.zububa.webapi;

import android.content.Context;
import android.support.annotation.Nullable;

import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.model.GalleryItem;
import com.amarnehsoft.zububa.model.Like;
import com.amarnehsoft.zububa.model.Post;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.model.Wedding;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.ICompleteCallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.webapi.fb.FBFactory;

import java.util.Date;

/**
 * Created by ALa on 3/17/2018.
 */

/**
 * WebApi implementations
 */
public class WebService implements WebApi{
    private static WebService instance;
    private Context mContext;

    // initializing
    public static void init(Context context){
        if(instance == null)
            instance = new WebService(context);
    }

    public WebService(Context mContext) {
        this.mContext = mContext;
    }
    public static WebService getInstance(){return instance;}


    @Override
    public void getBlog(final IListCallBack<Blog> callBack) {
        FBFactory.getBlogApi(true).getList(callBack);
    }

    @Override
    public void getTaxiList(final IListCallBack<Taxi> callBack) {
        FBFactory.getTaxiApi(true).getList(callBack);
    }

    @Override
    public void getWeddings(final IListCallBack<Wedding> callBack) {
        FBFactory.getWeddingFBApi(true).getList(callBack);
    }

    @Override
    public void getGallery(final IListCallBack<GalleryItem> callBack) {
        FBFactory.getGalleryFBApi(true).getList(callBack);
    }

    @Override
    public void getBabies(final IListCallBack<Baby> callBack) {
        FBFactory.getBabyFBApi(true).getList(callBack);
    }

    @Override
    public void getPosts(IListCallBack<Post> callBack) {
        FBFactory.getPostFBApi(true).getList(callBack);
    }

    @Override
    public void writeTaxiItem(Taxi taxi, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getTaxiApi(false).saveItem(taxi, success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

    @Override
    public void writeBabyItem(Baby baby, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getBabyFBApi(false).saveItem(baby,(success)-> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

    @Override
    public void writeWeddingItem(Wedding wedding, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getWeddingFBApi(false).saveItem(wedding,(success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        }));
    }

    @Override
    public void writeGalleryItem(GalleryItem galleryItem, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getGalleryFBApi(false).saveItem(galleryItem,(success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        }));
    }

    @Override
    public void writePost(Post post, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getPostFBApi(false).saveItem(post,success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

    @Override
    public void sendLikeForPost(Post post, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getPostFBApi(true).putLike(post.getCode(), new Like(new Date().getTime(), mContext), success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

    @Override
    public void sendLikeForBaby(Baby baby, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getBabyFBApi(true).putLike(baby.getCode(),new Like(new Date().getTime(),mContext),success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

    @Override
    public void sendLikeForBlog(Blog blog, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getBlogApi(true).putLike(blog.getCode(),new Like(new Date().getTime(),mContext),success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

    @Override
    public void sendLikeForGallery(GalleryItem galleryItem, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getGalleryFBApi(true).putLike(galleryItem.getCode(),new Like(new Date().getTime(),mContext),success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

    @Override
    public void sendLikeForWedding(Wedding wedding, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getWeddingFBApi(true).putLike(wedding.getCode(),new Like(new Date().getTime(),mContext),success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

    @Override
    public void sendCommentForPost(Post post, Comment comment, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getPostFBApi(true).putComment(post.getCode(),comment,success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

    @Override
    public void sendCommentForBaby(Baby baby, Comment comment, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getBabyFBApi(true).putComment(baby.getCode(),comment,success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

    @Override
    public void sendCommentForBlog(Blog blog, Comment comment, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getBlogApi(true).putComment(blog.getCode(),comment,success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

    @Override
    public void sendCommentForGalley(GalleryItem galleryItem, Comment comment, @Nullable ICallBack<Boolean> callBack) {
        //not allowed
        throw new RuntimeException("the gallery item not allowed to have a comments, it has just a likes");
    }

    @Override
    public void sendCommentForWedding(Wedding wedding, Comment comment, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getWeddingFBApi(true).putComment(wedding.getCode(),comment,success -> {
            if (success)
                callBack.onResponse(true);
            else
                callBack.onResponse(false);
        });
    }

}
