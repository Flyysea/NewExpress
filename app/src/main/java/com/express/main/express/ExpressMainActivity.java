package com.express.main.express;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.express.main.R;
import com.express.main.express.receiving.ReceivingActivity;
import com.express.main.express.send.SendActivity;
import com.express.main.express.system.SystemActivity;
import com.express.main.global.app.BaseActivity;

/**
 * Created by Administrator on 2017-02-15.
 */

public class ExpressMainActivity extends BaseActivity{

    private String deliverID;
    private String deliverPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_express_main);

//        deliverID = getIntent().getStringExtra("deliverID");
//        deliverPhone = getIntent().getStringExtra("deliverPhone");

        initView();
    }

    private void initView() {
//        TextView info=(TextView)findViewById(R.id.deliver_info);
//        info.setText("我的信息:\n手机号 "+deliverPhone+"\nID "+deliverID);

        LinearLayout print = (LinearLayout) findViewById(R.id.print);
        LinearLayout track = (LinearLayout) findViewById(R.id.track);
        LinearLayout send_message = (LinearLayout) findViewById(R.id.send_message);

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SystemActivity.class);
            }
        });

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SendActivity.class);
            }
        });

        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(ReceivingActivity.class);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
