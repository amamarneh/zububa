package com.amarnehsoft.zububa.data.webapi.fb;

import com.amarnehsoft.zububa.data.webapi.fb.constants.FB_REF;

/**
 * Created by user on 3/19/2018.
 */

public class FBFactory {

    public static BlogFBApi getBlogApi(boolean approved){
       return new BlogFBApi(approved);
    }

    public static TaxiFBApi getTaxiApi(boolean approved){
        return new TaxiFBApi(approved);
    }

    public static BabyFBApi getBabyFBApi(boolean approved){
        return new BabyFBApi(approved);
    }

    public static WeddingFBApi getWeddingFBApi(boolean approved){
        return new WeddingFBApi(approved);
    }

    public static GalleryFBApi getGalleryFBApi(boolean approved){
        return new GalleryFBApi(approved);
    }

    public static LikesFBApi getLikesFBApi(FB_REF ref, String childId){
        return new LikesFBApi(ref.name(),childId);
    }

    public static CommentFBApi getCommentsFBApi(FB_REF ref,String childId,boolean approved){
        return new CommentFBApi(ref.name(),childId,approved);
    }

    public static VillagesFBApi getVillagesApi(){
        return new VillagesFBApi();
    }

    public static PostFBApi getPostFBApi(boolean approved){
        return new PostFBApi(approved);
    }
}
