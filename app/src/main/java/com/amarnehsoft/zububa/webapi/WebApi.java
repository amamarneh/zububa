package com.amarnehsoft.zububa.webapi;

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

/**
 * Created by ALa on 3/17/2018.
 */

public interface WebApi {
    void getBlog(ICallBack<Blog> callBack); // get list of blog from web server
    void getTaxiList(ICallBack<Taxi> callBack); // get list of taxi contacts
    void getWeddings(ICallBack<Wedding> callBack); // get list of weddings
    void getGallery(ICallBack<GalleryItem> callBack); // get list of gallery items
    void getBabies(ICallBack<Baby> callBack); // get list of babies
    void getPosts(ICallBack<Post> callBack); // get list of posts

    /**
     * this method used to write a new taxi member from user
     * @param taxi : input taxi object
     * @param callBack : output is true if operation succeed else it's false
     */
    void writeTaxiItem(Taxi taxi,@Nullable ICallBack<Boolean> callBack);
    void writeBabyItem(Baby baby,@Nullable ICallBack<Boolean> callBack);
    void writeWeddingItem(Wedding wedding,@Nullable ICallBack<Boolean> callBack);
    void writeGalleryItem(GalleryItem galleryItem,@Nullable ICallBack<Boolean> callBack);
    void writePost(Post post,@Nullable ICallBack<Boolean> callBack);

    /**
     * this method send like for selected post
     * @param post : selected post
     * @param callBack : output is true if operation succeed else it's false
     */
    void sendLikeForPost(Post post,@Nullable ICallBack<Boolean> callBack);
    void sendLikeForBaby(Baby baby,@Nullable ICallBack<Boolean> callBack);
    void sendLikeForBlog(Blog blog,@Nullable ICallBack<Boolean> callBack);
    void sendLikeForGallery(GalleryItem galleryItem,@Nullable ICallBack<Boolean> callBack);
    void sendLikeForWedding(Wedding wedding,@Nullable ICallBack<Boolean> callBack);

    /**
     * this method send a comment for a post
     * @param post : selected post
     * @param comment : input comment
     * @param callBack : output is true if operation succeed else it's false
     */
    void sendCommentForPost(Post post, Comment comment,@Nullable ICallBack<Boolean> callBack);
    void sendCommentForBaby(Baby baby, Comment comment,@Nullable ICallBack<Boolean> callBack);
    void sendCommentForBlog(Blog blog, Comment comment,@Nullable ICallBack<Boolean> callBack);
    void sendCommentForGalley(GalleryItem galleryItem, Comment comment,@Nullable ICallBack<Boolean> callBack);
    void sendCommentForWedding(Wedding wedding, Comment comment,@Nullable ICallBack<Boolean> callBack);


    // ..
}
