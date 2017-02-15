package com.express.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.express.main.express.login.LoginActivity;
import com.express.main.global.app.BaseActivity;

public class MainActivity extends BaseActivity {

    LinearLayout customer;
    LinearLayout express;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);

        initView();

    }

    private void initView() {
        customer = (LinearLayout) findViewById(R.id.customer);
        express = (LinearLayout) findViewById(R.id.express);

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(LoginActivity.class);
                finish();
            }
        });

        express.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(LoginActivity.class);
                finish();
            }
        });

    }

}
