package com.amarnehsoft.zububa.dummy;

import com.amarnehsoft.zububa.model.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 3/19/2018.
 */

public class Dummy {
    public static List<Blog> dummyBlogs(){
        List<Blog> result = new ArrayList<>();
        for (int i=0;i<10;i++){
            result.add(new Blog());
        }
        return result;
    }
}
