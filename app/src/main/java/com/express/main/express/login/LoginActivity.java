package com.express.main.express.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.express.main.MainActivity;
import com.express.main.R;
import com.express.main.Util.T;
import com.express.main.express.ExpressMainActivity;
import com.express.main.express.register.RegisterActivity;
import com.express.main.global.app.BaseActivity;
import com.express.main.global.app.Constant;
import com.express.main.global.service.GlobalService;
import com.idcard.CardInfo;
import com.idcard.TFieldID;
import com.idcard.TengineID;
import com.ui.card.TRCardScan;

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    EditText deliverPhone;
    EditText deliverId;

    private String key;

    public int RESULT_GET_CARD_OK = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_express_verify, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.verify:
                openActivity(RegisterActivity.class);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        deliverPhone = (EditText) findViewById(R.id.deliver_phone);
        deliverId = (EditText) findViewById(R.id.deliver_id);
        Button ocrBtn= (Button) findViewById(R.id.ocrBtn);
        ocrBtn.setOnClickListener(this);
        Button subBtn= (Button) findViewById(R.id.subBtn);
        subBtn.setOnClickListener(this);
    }

    private void doVerify(){
        dismissProgress();
        openActivity(ExpressMainActivity.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ocrBtn:
                initE(TengineID.TIDCARD2, RESULT_GET_CARD_OK);
                break;
            case R.id.subBtn:
                if (deliverPhone.getText().length() == 11 && !deliverId.getText().toString().equals("")) {
                    showProgress("正在操作，请稍后...");
                    doVerify();
                } else{
                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            CardInfo cardInfo = (CardInfo) data.getSerializableExtra("cardinfo");
            //拍取身份证
            if (requestCode == RESULT_GET_CARD_OK && resultCode != 1 && !TextUtils.isEmpty(cardInfo.getAllinfo())) {
                // 获取人头像
                Bitmap headimg = TRCardScan.HeadImgBitmap;// 人头像
                // 获得身份信息
                String name = cardInfo.getFieldString(TFieldID.NAME);
                String idNumber = cardInfo.getFieldString(TFieldID.NUM);
                String birthDay = cardInfo.getFieldString(TFieldID.BIRTHDAY);
                String han = cardInfo.getFieldString(TFieldID.FOLK) + "族  " + cardInfo.getFieldString(TFieldID.SEX);
                if (cardInfo != null && !TextUtils.isEmpty(han) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(idNumber) && !TextUtils.isEmpty(birthDay)) {
                    T.showToast(mActivity, "成功");
                } else {
                    T.showToast(mActivity, "识别失败");
                }
            }
        }
    }
}
