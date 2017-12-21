package bwie.com.zhangzhen20171221.presenter;

import bwie.com.zhangzhen20171221.bean.BaseBean;
import bwie.com.zhangzhen20171221.model.BaseModel;
import bwie.com.zhangzhen20171221.net.OnNetListener;
import bwie.com.zhangzhen20171221.view.ILieBiaoActivity;

/**
 * Created by dell on 2017/12/21.
 */

public class BasePresenter {
    private ILieBiaoActivity activity1;
    private final BaseModel baseModel;

    public BasePresenter(ILieBiaoActivity activity1) {
        this.activity1 = activity1;
        baseModel = new BaseModel();
    }
    public void dopost(){
        baseModel.doCar(new OnNetListener<BaseBean>() {
            @Override
            public void OnSuccess(BaseBean baseBean) {
                activity1.showNews(baseBean);
            }

            @Override
            public void OnFailed(Exception e) {

            }
        });
    }
}