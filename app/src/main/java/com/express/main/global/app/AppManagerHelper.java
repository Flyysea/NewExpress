package com.express.main.global.app;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class AppManagerHelper {
    private AppManagerHelper() {
    }

    /**
     * 存放所有已经启动的活动
     */
    private static List<Activity> onStartActivity;
    /**
     * 是否登录
     */
    public static boolean isLogin = false;

    /**
     * 添加一个活动
     */
    public static void addOnStartActivity(Activity activity) {
        if (onStartActivity == null) {
            onStartActivity = new ArrayList<>();
        }
        onStartActivity.add(activity);
    }

    /**
     * 移除一个活动
     */
    public static void removeOnStartActivity(Activity activity) {
        if (onStartActivity.contains(activity)) {
            onStartActivity.remove(activity);
            activity.finish();
        }
    }

    /**
     * 退出应用程序
     */
    public static void exitApplication() {

        if (onStartActivity != null) {
            for (Activity activity : onStartActivity) {
                if (activity != null) {
                    activity.finish();
                }
            }
            onStartActivity.clear();
            onStartActivity = null;
        }
    }
}
