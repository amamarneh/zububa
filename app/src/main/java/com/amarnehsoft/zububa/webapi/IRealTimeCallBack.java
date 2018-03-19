package com.amarnehsoft.zububa.webapi;

import com.amarnehsoft.zububa.webapi.ICallBack;

/**
 * Created by user on 3/19/2018.
 */

public interface IRealTimeCallBack<T> extends ICallBack<T> {
    void childAdded(T bean);
}
