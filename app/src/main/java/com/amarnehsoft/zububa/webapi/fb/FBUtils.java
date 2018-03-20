package com.amarnehsoft.zububa.webapi.fb;

import android.util.Log;

import com.amarnehsoft.zububa.model.Blog;
import com.amarnehsoft.zububa.model.Comment;
import com.amarnehsoft.zububa.webapi.callBacks.ISuccessCallBack;

/**
 * Created by user on 3/20/2018.
 */

public class FBUtils {
    public static void approve(Object o, ISuccessCallBack callBack) {
        if (o instanceof Blog) {
            Blog bean = (Blog) o;
            FBFactory.getBlogApi(false).delete(bean.getCode(), new ISuccessCallBack() {
                @Override
                public void success() {
                    FBFactory.getBlogApi(true).saveItem(bean.getCode(), bean, new ISuccessCallBack() {
                        @Override
                        public void success() {
                            //deleted from not approved and pushed to approved
                            Log.e("Amarneh", "deleted from not approved and pushed to approved");
                            callBack.success();
                        }

                        @Override
                        public void error() {
                            //deleted from not approved but faild to push to approved
                            Log.e("Amarneh", "deleted from not approved but faild to push to approved");
                            callBack.error();
                        }
                    });
                }

                @Override
                public void error() {
                    //faild to remove from not approved
                    Log.e("Amarneh", "faild to remove from not approved");
                    callBack.error();
                }
            });
        }
    }
}
