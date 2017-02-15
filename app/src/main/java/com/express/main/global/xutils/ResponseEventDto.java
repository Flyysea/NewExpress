package com.express.main.global.xutils;

/**
 * Created by 江俊超 on 2016/3/21.
 */
public class ResponseEventDto {
    private int tag;
    private String result;

    public ResponseEventDto(int tag, String result) {
        this.tag = tag;
        this.result = result;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
