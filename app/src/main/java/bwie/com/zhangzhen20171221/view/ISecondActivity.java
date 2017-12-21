package bwie.com.zhangzhen20171221.view;

import java.util.List;

import bwie.com.zhangzhen20171221.bean.ShowCarBean;

/**
 * Created by dell on 2017/12/21.
 */

public interface ISecondActivity {
    public void show(String str);
    public void showCar(List<ShowCarBean.DataBean> group, List<List<ShowCarBean.DataBean.ListBean>> child);
}