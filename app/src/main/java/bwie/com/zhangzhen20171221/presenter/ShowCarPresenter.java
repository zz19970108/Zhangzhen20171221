package bwie.com.zhangzhen20171221.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bwie.com.zhangzhen20171221.bean.ShowCarBean;
import bwie.com.zhangzhen20171221.model.ShowModel;
import bwie.com.zhangzhen20171221.net.Api;
import bwie.com.zhangzhen20171221.net.OnNetListener;
import bwie.com.zhangzhen20171221.view.ISecondActivity;

/**
 * Created by dell on 2017/12/21.
 */

public class ShowCarPresenter {
    private ISecondActivity iSecondActivity;
    private final ShowModel showModel;

    public ShowCarPresenter(ISecondActivity iSecondActivity) {
        this.iSecondActivity = iSecondActivity;
        showModel = new ShowModel();
    }
    public void show(){
        HashMap<String, String> map = new HashMap<>();
        map.put("uid","72");
        showModel.showCar(Api.ShowCar, map, new OnNetListener<ShowCarBean>() {
            @Override
            public void OnSuccess(ShowCarBean showCarBean) {
                List<ShowCarBean.DataBean> group = showCarBean.getData();
                List<List<ShowCarBean.DataBean.ListBean>> child = new ArrayList<>();
                for (int i = 0; i <group.size() ; i++) {
                    child.add(group.get(i).getList());
                }
                iSecondActivity.showCar(group,child);
            }

            @Override
            public void OnFailed(Exception e) {

            }
        });
    }
    //解决内存泄漏
    public void Dettouch() {
        if (iSecondActivity != null) {
            iSecondActivity = null;
        }
    }
}