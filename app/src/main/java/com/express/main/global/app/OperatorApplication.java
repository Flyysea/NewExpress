package com.express.main.global.app;

import android.app.Application;

import com.express.main.Util.L;

/**
 * Created by Administrator on 2017/1/26.
 * <p>应用程序</p>
 */
public class OperatorApplication extends Application {
    private boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();
        //开启log查看
        L.isDebug = isDebug;
    }


}
