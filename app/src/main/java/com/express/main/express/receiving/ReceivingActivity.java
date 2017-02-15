package com.express.main.express.receiving;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.express.main.R;
import com.express.main.global.app.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-02-15.
 */

public class ReceivingActivity  extends BaseActivity{
    private Button btnSend;
    private EditText etMyName, etMyPhone,etMyCity, etMyAddress, etMyPostalCode, etExtraPrice, etRcvName, etRcvPhone,
            etRcvCity, etRcvAddress, etRcvPostalCode, etGoods, etExpressCompany, etRemarks;
    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving);
        initView();
    }

    private void initView() {
        etMyName = (EditText) findViewById(R.id.editTextMyName);
        etMyPhone = (EditText) findViewById(R.id.editTextMyPhone);
        etMyCity = (EditText) findViewById(R.id.editTextMyCity);
        etMyAddress = (EditText) findViewById(R.id.editTextMyAddress);
        etMyPostalCode = (EditText) findViewById(R.id.editTextMyPostalCode);
        etExtraPrice = (EditText) findViewById(R.id.editTextExtraPrice);
        etRcvName = (EditText) findViewById(R.id.editTextRcvName);
        etRcvPhone = (EditText) findViewById(R.id.editTextRcvPhone);
        etRcvCity = (EditText) findViewById(R.id.editTextRcvCity);
        etRcvAddress = (EditText) findViewById(R.id.editTextRcvAddress);
        etRcvPostalCode = (EditText) findViewById(R.id.editTextRcvPostalCode);
        etGoods = (EditText) findViewById(R.id.editTextGoods);
        etExpressCompany = (EditText) findViewById(R.id.editTextExpressCompany);
        etRemarks = (EditText) findViewById(R.id.editTextRemarks);
        btnSend = (Button) findViewById(R.id.buttonSubmit);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etMyName.getText())) {
                    Toast.makeText(ReceivingActivity.this, "请输入寄件人姓名~", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etMyPhone.getText())) {
                    Toast.makeText(ReceivingActivity.this, "请输入寄件人电话~", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etMyAddress.getText())) {
                    Toast.makeText(ReceivingActivity.this, "请输入寄件人地址~", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etMyPostalCode.getText())) {
                    Toast.makeText(ReceivingActivity.this, "请输入寄件人邮编~", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etExtraPrice.getText())) {
                    Toast.makeText(ReceivingActivity.this, "请输入保价金额~", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etRcvName.getText())) {
                    Toast.makeText(ReceivingActivity.this, "请输入收件人姓名~", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etRcvAddress.getText())) {
                    Toast.makeText(ReceivingActivity.this, "请输入收件人地址~", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etRcvPostalCode.getText())) {
                    Toast.makeText(ReceivingActivity.this, "请输入收件人邮编~", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etExpressCompany.getText())) {
                    Toast.makeText(ReceivingActivity.this, "请输入快递公司编号~", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(etRemarks.getText())) {
                    Toast.makeText(ReceivingActivity.this, "请输入备注信息~", Toast.LENGTH_SHORT).show();
                } else {
                    showProgress("正在提交，请稍后");

                }
            }

            ;
        });
    }

}
