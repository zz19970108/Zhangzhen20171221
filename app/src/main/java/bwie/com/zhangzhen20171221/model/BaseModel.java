package bwie.com.zhangzhen20171221.model;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;

import bwie.com.zhangzhen20171221.bean.BaseBean;
import bwie.com.zhangzhen20171221.net.Api;
import bwie.com.zhangzhen20171221.net.OnNetListener;
import bwie.com.zhangzhen20171221.utils.HttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by dell on 2017/12/21.
 */

public class BaseModel implements IBaseModel {
        private Handler handler = new Handler(Looper.getMainLooper());
        @Override
        public void doCar(final OnNetListener<BaseBean> onNetListener) {
            HttpUtils.getHttpUtils().doGet(Api.getAd, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    onNetListener.OnFailed(e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String string = response.body().string();

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            BaseBean baseBean = new Gson().fromJson(string, BaseBean.class);
                            onNetListener.OnSuccess(baseBean);
                        }
              });
           }});
        }
}
