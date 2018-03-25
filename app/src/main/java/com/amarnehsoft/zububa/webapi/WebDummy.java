package com.amarnehsoft.zububa.webapi;

import android.content.Context;
import android.support.annotation.Nullable;

import com.amarnehsoft.zububa.abstractAdapters.MItem;
import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.model.GalleryItem;
import com.amarnehsoft.zububa.model.Post;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.model.Wedding;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ALa on 3/22/2018.
 */

public class WebDummy implements WebApi {
    private static WebDummy instance;
    private Context mContext;

    // initializing
    public static void init(Context context){
        if(instance == null)
            instance = new WebDummy(context);
    }
    public static WebDummy getInstance(){return instance;}



    public WebDummy(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void getBlog(IListCallBack<Blog> callBack) {

    }

    @Override
    public void getTaxiList(IListCallBack<Taxi> callBack) {

    }

    @Override
    public void getWeddings(IListCallBack<Wedding> callBack) {
        Wedding wedding = new Wedding();
        wedding.setPersonName("ALa");
        wedding.setContent("conconconcon");
        wedding.setWeddingDate(new Date().getTime());
        ArrayList<Wedding> weddings = new ArrayList<>();
        weddings.add(wedding);
        weddings.add(wedding);
        weddings.add(wedding);
        callBack.onResponse(weddings);
    }

    @Override
    public void getGallery(IListCallBack<GalleryItem> callBack) {

    }

    @Override
    public void getBabies(IListCallBack<Baby> callBack) {

    }

    @Override
    public void getPosts(IListCallBack<Post> callBack) {

    }

    @Override
    public void getNewsFeed(IListCallBack<MItem> callBack) {
        ArrayList<MItem> list = new ArrayList<>();

        Post post1 = new Post();
        post1.setImgUrl("https://www.owlstalk.co.uk/forums/uploads/monthly_2018_01/post.jpg.afa4665cc9a85cd8275d5bd50658cf00.jpg");
        post1.setContent("post content");
        Post post2 = new Post();
        post2.setImgUrl("https://www.owlstalk.co.uk/forums/uploads/monthly_2018_01/post.jpg.afa4665cc9a85cd8275d5bd50658cf00.jpg");
        post2.setContent("post content2");


        Taxi taxi = new Taxi();
        taxi.setPhone("0599");
        taxi.setName("ALa Taxi");
        taxi.setDesc("description of my taxi");

        list.add(taxi);
        list.add(post1);
        list.add(taxi);
        list.add(post2);
        list.add(taxi);

        callBack.onResponse(list);
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

    @Override
    public void getBlogComments(Blog model, IListCallBack<Comment> callBack) {

    }

    @Override
    public void getPostComments(Post model, IListCallBack<Comment> callBack) {

    }

    @Override
    public void getBabyComments(Baby model, IListCallBack<Comment> callBack) {

    }

    @Override
    public void getWeddingComments(Wedding model, IListCallBack<Comment> callBack) {

    }
}
