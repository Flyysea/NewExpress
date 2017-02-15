package com.express.main.global.xutils.i;

/**
 * <p>作者：江俊超 on 2016/5/23 17:15</p>
 * <p>邮箱：aohanyao@gmail.com</p>
 * <p>网络请求回调接口</p>
 */
public interface HttpResponseListener {
    /**
     * 请求成功
     */
    void success(String result);

    /**
     * 请求失败
     *
     * @param failMsg
     */
    void fail(String failMsg);

}
