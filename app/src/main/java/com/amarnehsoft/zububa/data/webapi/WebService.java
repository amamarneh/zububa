package com.amarnehsoft.zububa.data.webapi;

import android.content.Context;
import android.support.annotation.Nullable;

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
import com.amarnehsoft.zububa.data.webapi.fb.FBFactory;

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
    public void getNewsFeed(IListCallBack<MItem> callBack) {

    }

    @Override
    public void writeTaxiItem(Taxi taxi, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getTaxiApi(false).saveItem(taxi, success -> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        });
    }

    @Override
    public void writeBabyItem(Baby baby, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getBabyFBApi(false).saveItem(baby,(success)-> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        });
    }

    @Override
    public void writeWeddingItem(Wedding wedding, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getWeddingFBApi(false).saveItem(wedding,(success -> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        }));
    }

    @Override
    public void writeGalleryItem(GalleryItem galleryItem, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getGalleryFBApi(false).saveItem(galleryItem,(success -> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        }));
    }

    @Override
    public void writePost(Post post, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getPostFBApi(false).saveItem(post,success -> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        });
    }

    @Override
    public void sendLikeForPost(Post post, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getPostFBApi(true).putLike(post, mContext, success -> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        });
    }

    @Override
    public void sendLikeForBaby(Baby baby, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getBabyFBApi(true).putLike(baby,mContext,success -> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        });
    }

    @Override
    public void sendLikeForBlog(Blog blog, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getBlogApi(true).putLike(blog,mContext,success -> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        });
    }

    @Override
    public void sendLikeForGallery(GalleryItem galleryItem, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getGalleryFBApi(true).putLike(galleryItem,mContext,success -> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        });
    }

    @Override
    public void sendLikeForWedding(Wedding wedding, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getWeddingFBApi(true).putLike(wedding,mContext,success -> {
                if (callBack != null) {
                    if (success)
                        callBack.onResponse(true);
                    else
                        callBack.onResponse(false);
                }
        });
    }

    @Override
    public void sendCommentForPost(Post post, Comment comment, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getPostFBApi(true).putComment(post,comment,success -> {
                if (callBack != null) {
                    if (success)
                        callBack.onResponse(true);
                    else
                        callBack.onResponse(false);
                }
        });
    }

    @Override
    public void sendCommentForBaby(Baby baby, Comment comment, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getBabyFBApi(true).putComment(baby,comment,success -> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        });
    }

    @Override
    public void sendCommentForBlog(Blog blog, Comment comment, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getBlogApi(true).putComment(blog,comment,success -> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        });
    }

    @Override
    public void sendCommentForGalley(GalleryItem galleryItem, Comment comment, @Nullable ICallBack<Boolean> callBack) {
        //not allowed
        throw new RuntimeException("the gallery item not allowed to have a comments, it has just a likes");
    }

    @Override
    public void sendCommentForWedding(Wedding wedding, Comment comment, @Nullable ICallBack<Boolean> callBack) {
        FBFactory.getWeddingFBApi(true).putComment(wedding,comment,success -> {
            if (callBack != null) {
                if (success)
                    callBack.onResponse(true);
                else
                    callBack.onResponse(false);
            }
        });
    }

    @Override
    public void getBlogComments(Blog model, IListCallBack<Comment> callBack) {
        FBFactory.getBlogApi(true).getComments(model.getCode(),true,callBack);
    }

    @Override
    public void getPostComments(Post model, IListCallBack<Comment> callBack) {
        FBFactory.getPostFBApi(true).getComments(model.getCode(),true,callBack);
    }

    @Override
    public void getBabyComments(Baby model, IListCallBack<Comment> callBack) {
        FBFactory.getBabyFBApi(true).getComments(model.getCode(),true,callBack);
    }

    @Override
    public void getWeddingComments(Wedding model, IListCallBack<Comment> callBack) {
        FBFactory.getWeddingFBApi(true).getComments(model.getCode(),true,callBack);
    }


}
