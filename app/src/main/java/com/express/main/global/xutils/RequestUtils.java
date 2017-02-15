package com.express.main.global.xutils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;


import com.express.main.Util.L;
import com.express.main.Util.NetUtils;
import com.express.main.global.app.Constant;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 江俊超 on 2016/2/15.
 * <p>统一的网络请求工具</p>
 */
public abstract class RequestUtils {
    private static Context mContext;
    private static Callback.CommonCallback<String> callback;
    private static Timer timer;
    private static TimerTask timerTask;

    public static void initRequest(Context mContext) {
        RequestUtils.mContext = mContext;
    }

    private RequestUtils() {
    }

    /**
     * 网络数据请求
     */
    public static void rP(@NonNull final Handler mHandler, @NonNull String requsetJson)  {
        //------------------得到消息对象
        //------------------得到消息对象
        //TODO  没有做无网络判断
//        if (!NetUtils.isConnected(mContext)) {
//            message.what=Constant.NOT_NET_WORK;
//            mHandler.handleMessage(message);
//            return;
//        }
        L.e("RequestUtils rP", requsetJson);


        //实例化参数对象
        final RequestParams params = new RequestParams(Constant.URL);//TODO
        params.setConnectTimeout(15 * 1000);
        //------------------设置为JSON请求
        params.setAsJsonContent(true);
        //------------------设置为JSON请求
//
        //------------------存放值
        params.addBodyParameter("", requsetJson);
        //------------------存放值

        callback = new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {//成功
                //设置waht
                Message message=mHandler.obtainMessage();
                message.what = Constant.SUCCESS_DATA_KEY;
                //得到bundle
                Bundle bundle = new Bundle();
                //存放数据
                try {
                    bundle.putString(Constant.DATA_KEY, URLDecoder.decode(result, "utf-8"));
                    L.e("RequestUtils",URLDecoder.decode(result, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                message.setData(bundle);
                //发送消息
                mHandler.sendMessage(message);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {//错误
                //设置waht
                Message message=mHandler.obtainMessage();
                message.what = Constant.ERROR_DATA_KEY;

                if (!NetUtils.isConnected(mContext)) {
                    message.obj = "当前无网络连接";
                } else {
                    message.obj = "网络连接超时，请稍后重试";
                }
                //得到bundle
                Bundle bundle = new Bundle();
                bundle.putString(Constant.DATA_KEY, "13");
                message.setData(bundle);
                //发送消息
                try {
                    mHandler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                L.e("错误", ex.getMessage()+"");
                ex.printStackTrace();

            }

            @Override
            public void onCancelled(CancelledException cex) {//取消
            }

            @Override
            public void onFinished() {//完成
            }
        };

        //------------------发起请求
        x.http().post(params, callback);


//        }
    }



    private static void cancelTimer() {
        if (timer != null) {
            timer.cancel();
            timerTask.cancel();
            timer = null;
            timerTask = null;
        }
    }
}
