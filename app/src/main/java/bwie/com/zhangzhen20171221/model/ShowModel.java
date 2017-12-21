package bwie.com.zhangzhen20171221.model;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import bwie.com.zhangzhen20171221.bean.ShowCarBean;
import bwie.com.zhangzhen20171221.net.OnNetListener;
import bwie.com.zhangzhen20171221.utils.HttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by dell on 2017/12/21.
 */

public class ShowModel implements IShowModel {
    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    public void showCar(String url, Map<String, String> map, final OnNetListener<ShowCarBean> onNetListener) {
        HttpUtils.getHttpUtils().doPost(url, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onNetListener.OnFailed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final ShowCarBean showCarBean = new Gson().fromJson(string, ShowCarBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnSuccess(showCarBean);
                    }
                });
            }
        });
    }
}