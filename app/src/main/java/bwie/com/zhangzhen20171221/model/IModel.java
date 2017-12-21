package bwie.com.zhangzhen20171221.model;

import java.util.Map;

import bwie.com.zhangzhen20171221.bean.GoodXiangBean;
import bwie.com.zhangzhen20171221.net.OnNetListener;

/**
 * Created by dell on 2017/12/21.
 */

public interface IModel {
    public void doPost(String url, Map<String,String> map, OnNetListener<GoodXiangBean> onNetListener);
}