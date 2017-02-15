package com.express.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.express.main.MainActivity;
import com.express.main.R;
import com.express.main.global.app.BaseActivity;

/**
 * Created by Administrator on 2017-02-14.
 */

public class SplashActivity  extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openActivity(MainActivity.class);
                finish();
            }
        }, 2000);
    }


}
