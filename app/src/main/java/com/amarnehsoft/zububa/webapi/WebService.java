package com.amarnehsoft.zububa.webapi;

import android.content.Context;
import android.support.annotation.Nullable;

import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.model.GalleryItem;
import com.amarnehsoft.zububa.model.Post;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.model.Wedding;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;
import com.amarnehsoft.zububa.webapi.fb.FBFactory;

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

    }

    @Override
    public void writeTaxiItem(Taxi taxi, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void writeBabyItem(Baby baby, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void writeWeddingItem(Wedding wedding, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void writeGalleryItem(GalleryItem galleryItem, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void writePost(Post post, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void sendLikeForPost(Post post, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void sendLikeForBaby(Baby baby, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void sendLikeForBlog(Blog blog, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void sendLikeForGallery(GalleryItem galleryItem, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void sendLikeForWedding(Wedding wedding, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void sendCommentForPost(Post post, Comment comment, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void sendCommentForBaby(Baby baby, Comment comment, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void sendCommentForBlog(Blog blog, Comment comment, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void sendCommentForGalley(GalleryItem galleryItem, Comment comment, @Nullable ICallBack<Boolean> callBack) {

    }

    @Override
    public void sendCommentForWedding(Wedding wedding, Comment comment, @Nullable ICallBack<Boolean> callBack) {

    }


}
