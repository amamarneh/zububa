package com.amarnehsoft.zububa.webapi.fb;

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

    public static LikesFBApi getLikesFBApi(String ref,String childId){
        return new LikesFBApi(ref,childId);
    }
}
