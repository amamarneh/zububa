package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.webapi.callBacks.ISuccessCallBack;

/**
 * Created by user on 3/20/2018.
 */

public interface Uprovable<T> {
    void approve(T bean, ISuccessCallBack callBack);
}
