package com.amarnehsoft.zububa.webapi.fb;

import com.amarnehsoft.zububa.webapi.callBacks.ICompleteCallBack;

/**
 * Created by user on 3/20/2018.
 */

public interface IUprovable<T> {
    void approve(T bean, ICompleteCallBack callBack);
}
