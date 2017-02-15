package com.express.main.express.send;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.express.main.R;
import com.express.main.global.app.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2017-02-15.
 */

public class SendActivity  extends BaseActivity{


    private TextView tv_pkgInfo;
    private TextView tv_rcvPhone;
    private EditText et_verifyCode;
    private Button btn_getCode;
    private Button btn_rcv;

    private String rcvPhone;
    private String message;

    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        rcvPhone = getIntent().getStringExtra("rcvPhone");
        message = getIntent().getStringExtra("message");

        initView();
    }

    private void initView() {
        tv_pkgInfo = (TextView) findViewById(R.id.pkg_info);
        tv_rcvPhone = (TextView) findViewById(R.id.rcv_phone);
        et_verifyCode = (EditText) findViewById(R.id.verify_code);
        btn_getCode = (Button) findViewById(R.id.get_code);
        btn_rcv = (Button) findViewById(R.id.btn_rcv);

        tv_pkgInfo.setText(message);
        tv_rcvPhone.setText(rcvPhone);
        btn_getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_getCode.setEnabled(false);
                doPostVerifyMsg();
            }
        });
        btn_rcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress("正在操作，请稍后...");
                doReceive();
            }
        });

        setGetCodeButton();
    }

    private void setGetCodeButton() {
        btn_getCode.setBackgroundColor(ContextCompat.getColor(this, R.color.light_gray));
        btn_getCode.setEnabled(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 60; i > 0; i--) {
                    final int finalI = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            btn_getCode.setText(finalI + "s");
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        btn_getCode.setBackgroundColor(ContextCompat.getColor(SendActivity.this,
                                R.color.orange));
                        btn_getCode.setEnabled(true);
                        btn_getCode.setText("重新获取");
                    }
                });
            }
        }).start();
    }

    private void doPostVerifyMsg() {

    }

    private void doReceive() {

    }
}
