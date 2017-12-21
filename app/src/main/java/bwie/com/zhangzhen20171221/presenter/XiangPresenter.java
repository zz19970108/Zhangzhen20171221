package bwie.com.zhangzhen20171221.presenter;

import java.util.HashMap;

import bwie.com.zhangzhen20171221.bean.GoodXiangBean;
import bwie.com.zhangzhen20171221.model.Model;
import bwie.com.zhangzhen20171221.net.Api;
import bwie.com.zhangzhen20171221.net.OnNetListener;
import bwie.com.zhangzhen20171221.view.IMainActivity;

/**
 * Created by dell on 2017/12/21.
 */

public class XiangPresenter {
    private IMainActivity iMainActivity;
    private final Model model;

    public XiangPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        model=new Model();
    }
    public  void getGood(String pid){
        HashMap<String, String> map = new HashMap<>();
        map.put("pid",pid);
        model.doPost(Api.GOOD_XIANG, map, new OnNetListener<GoodXiangBean>() {
            @Override
            public void OnSuccess(GoodXiangBean goodXiangBean) {
                iMainActivity.showNews(goodXiangBean);
            }

            @Override
            public void OnFailed(Exception e) {

            }
        });
    }
}