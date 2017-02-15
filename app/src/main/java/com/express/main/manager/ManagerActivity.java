package com.express.main.manager;

import android.os.Bundle;
import android.view.View;

import com.express.main.R;
import com.express.main.global.app.BaseActivity;

/**
 * Created by Administrator on 2017-02-15.
 */

public class ManagerActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_main);
    }

    public void initView(){
        View manager_left=findViewById(R.id.manager_left);
        manager_left.setOnClickListener(this);
        View manager_right=findViewById(R.id.manager_right);
        manager_right.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.manager_left:

                break;
            case R.id.manager_right:

                break;
        }
    }
}
