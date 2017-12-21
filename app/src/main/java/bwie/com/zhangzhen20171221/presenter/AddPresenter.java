package bwie.com.zhangzhen20171221.presenter;

import java.util.HashMap;

import bwie.com.zhangzhen20171221.bean.AddCarBean;
import bwie.com.zhangzhen20171221.model.AddModel;
import bwie.com.zhangzhen20171221.net.Api;
import bwie.com.zhangzhen20171221.net.OnNetListener;
import bwie.com.zhangzhen20171221.view.IMainActivity;

/**
 * Created by dell on 2017/12/21.
 */

public class AddPresenter {
    private IMainActivity iMainActivity;
    private final AddModel addModel;

    public AddPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        addModel = new AddModel();
    }
    public void addShop(int pid){
        HashMap<String, String> map = new HashMap<>();
        map.put("pid",pid+"");
        map.put("uid","71");
        addModel.doCar(Api.ADDCART, map, new OnNetListener<AddCarBean>() {
            @Override
            public void OnSuccess(AddCarBean addCarBean) {
                iMainActivity.show(addCarBean.getMsg());
            }

            @Override
            public void OnFailed(Exception e) {

            }
        });
    }
}