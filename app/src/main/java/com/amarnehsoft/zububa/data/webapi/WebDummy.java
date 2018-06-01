package com.amarnehsoft.zububa.data.webapi;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.amarnehsoft.zububa.repo.Task;
import com.amarnehsoft.zububa.ui.abstractAdapters.MItem;
import com.amarnehsoft.zububa.model.Baby;
import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.model.GalleryItem;
import com.amarnehsoft.zububa.model.Post;
import com.amarnehsoft.zububa.model.Taxi;
import com.amarnehsoft.zububa.model.Wedding;
import com.amarnehsoft.zububa.data.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.data.webapi.callBacks.IListCallBack;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

        Taxi taxi = new Taxi();
        taxi.setPhone("0592358722");
        taxi.setName("ALa Taxi");
        taxi.setDesc("description of my taxi");

        ArrayList<Taxi> taxis = new ArrayList<>();
        taxis.add(taxi);
        taxis.add(taxi);
        taxis.add(taxi);
        taxis.add(taxi);
        callBack.onResponse(taxis);
    }

    @Override
    public void getWeddings(IListCallBack<Wedding> callBack) {
        Wedding wedding = new Wedding();
        wedding.setPersonName("ALa");
        wedding.setContent("conconconcon");
        wedding.setImgUrl("https://images.vexels.com/media/users/3/137493/preview2/debb0b6a8c388d2560cc5ef013675a56-wedding-card-maker-design.jpg");
        wedding.setWeddingDate(new Date().getTime());
        ArrayList<Wedding> weddings = new ArrayList<>();
        weddings.add(wedding);
        weddings.add(wedding);
        weddings.add(wedding);
        callBack.onResponse(weddings);
    }

    @Override
    public void getGallery(IListCallBack<GalleryItem> callBack) {
            ArrayList<GalleryItem> list = new ArrayList<>();
            GalleryItem g1= new GalleryItem();
            g1.setImgUrl("https://images.pexels.com/photos/459225/pexels-photo-459225.jpeg?auto=compress&cs=tinysrgb&h=350");
            g1.setDesc("description 1");
            GalleryItem g2= new GalleryItem();
            g2.setImgUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWvN98PxohhhCwqbMi2av4oTYtG5xLWT0bGhbctCmIRrN9ldjfXQ");
            g2.setDesc("desc 2");

            list.add(g1);
            list.add(g2);
            list.add(g2);
            list.add(g1);
            list.add(g2);

            callBack.onResponse(list);

    }

    @Override
    public void getBabies(IListCallBack<Baby> callBack) {

    }

    @Override
    public void getPosts(IListCallBack<Post> callBack) {
        Post post1 = new Post();
        post1.setCode("cc1");
        post1.setImgUrl("https://www.owlstalk.co.uk/forums/uploads/monthly_2018_01/post.jpg.afa4665cc9a85cd8275d5bd50658cf00.jpg");
        post1.setContent("post content");
        post1.setType(Post.TYPE_POST);

        Post post2 = new Post();
        post2.setCode("cc21");
        post2.setImgUrl("https://scontent.fjrs3-1.fna.fbcdn.net/v/t1.0-9/30740589_634375100234866_6002984800242593092_n.jpg?_nc_cat=0&oh=a074de9e00679d713f4d0f4c7d72ae85&oe=5B5CE566");
        post2.setContent("post content2");
        post2.setType(Post.TYPE_POST);

        List<Post> posts = Arrays.asList(post1,post2);
        callBack.onResponse(posts);
    }

    @Override
    public void getNewsFeed(IListCallBack<MItem> callBack) {
        ArrayList<MItem> list = new ArrayList<>();

        Post post1 = new Post();
        post1.setCode("cc1");
        post1.setImgUrl("https://www.owlstalk.co.uk/forums/uploads/monthly_2018_01/post.jpg.afa4665cc9a85cd8275d5bd50658cf00.jpg");
        post1.setContent("post content");

        Post post2 = new Post();
        post2.setCode("cc21");
        post2.setImgUrl("https://scontent.fjrs3-1.fna.fbcdn.net/v/t1.0-9/30740589_634375100234866_6002984800242593092_n.jpg?_nc_cat=0&oh=a074de9e00679d713f4d0f4c7d72ae85&oe=5B5CE566");
        post2.setContent("post content2");


        Taxi taxi = new Taxi();
        taxi.setPhone("0599");
        taxi.setName("ALa Taxi");
        taxi.setDesc("description of my taxi");


        list.add(post1);
        list.add(post1);
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

    @Override
    public Task<String> uploadImage(Uri url) {
        Task<String> task = new Task<>();
        task.response("https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg",true);
        return task;
    }
}
