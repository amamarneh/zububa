package com.amarnehsoft.zububa.webapi;

import com.amarnehsoft.zububa.model.BaseModel;
import com.amarnehsoft.zububa.webapi.callBacks.ICallBack;
import com.amarnehsoft.zububa.webapi.callBacks.ICompleteCallBack;
import com.amarnehsoft.zububa.webapi.callBacks.IListCallBack;

/**
 * Created by user on 3/19/2018.
 */

public interface API<T extends BaseModel> {
    void getList(IListCallBack<T> callBack);
    void saveItem(T item,ICompleteCallBack callBack);
    void delete(String childId, ICompleteCallBack callBack);
}
