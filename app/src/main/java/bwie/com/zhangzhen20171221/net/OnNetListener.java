package bwie.com.zhangzhen20171221.net;

/**
 * Created by dell on 2017/12/21.
 */

public interface OnNetListener <T>{
        void OnSuccess(T t);
        void OnFailed(Exception e);
}