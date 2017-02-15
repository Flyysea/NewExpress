package com.express.main.global.xutils.i;

/**
 * <p>作者：江俊超 on 2016/6/4 15:36</p>
 * <p>邮箱：aohanyao@gmail.com</p>
 * <p>PresenterCallBack 基类</p>
 */
public interface BasePresenterCallBack {

    /**
     * 请求失败等
     */
    void fial(String fialMsg);

    /**
     * 关闭弹窗,真个请求完成
     */
    void complete(String completeMsg);
    /**
     * 处理错误码
     */
    void handlerErrorCode(String errorCode);
}
