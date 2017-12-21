package bwie.com.zhangzhen20171221.model;

import bwie.com.zhangzhen20171221.bean.BaseBean;
import bwie.com.zhangzhen20171221.net.OnNetListener;

/**
 * Created by dell on 2017/12/21.
 */

public interface IBaseModel {
    public void doCar(OnNetListener<BaseBean> onNetListener);
}