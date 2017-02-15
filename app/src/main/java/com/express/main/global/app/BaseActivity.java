package com.express.main.global.app;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.idcard.TRECAPIImpl;
import com.idcard.TStatus;
import com.idcard.TengineID;
import com.ui.card.TRCardScan;

/**
 * Created by Administrator on 2017-02-14.
 */

public class BaseActivity extends AppCompatActivity {


    /**
     * 当前上下文
     */
    protected AppCompatActivity mActivity;
    /**
     * OCR识别引擎
     */
    public TRECAPIImpl engineDemo;
    /**
     * 是否支持OCR
     */
    protected boolean isOCR;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化上下文
        mActivity = this;

    }
    /**
     * 打开新Activity
     * */
    protected void  openActivity(Class<?> cls){
        Intent intent=new Intent();
        intent.setClass(this, cls);
        startActivity(intent);

    }
    public void showProgress(String msg) {
        if (pd == null) {
            pd = new ProgressDialog(this);
        }
        pd.setMessage(msg);
        pd.show();
    }

    public void dismissProgress() {
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }
    private  AlertDialog  dialog;
    public void showDialog(String title,String msg) {
        dialog= new   AlertDialog.Builder(mActivity)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    /**
     * 初始化引
     */
    protected void initE(TengineID tID, int RESULT_GET_CARD_OK) {
        try {
            engineDemo = new TRECAPIImpl();
            TStatus tStatus = engineDemo.TR_StartUP();
            if (tStatus == TStatus.TR_TIME_OUT) {
                Toast.makeText(mActivity, "引擎过期", Toast.LENGTH_SHORT).show();
            } else if (tStatus == TStatus.TR_FAIL) {
                Toast.makeText(mActivity, "引擎初始化失败", Toast.LENGTH_SHORT).show();
            }
            //身份证
            TRCardScan.SetEngineType(tID);
            //发起请求
            Intent intent = new Intent(mActivity, TRCardScan.class);
            intent.putExtra("engine", engineDemo);
            startActivityForResult(intent, RESULT_GET_CARD_OK);
            isOCR = true;
        } catch (Exception e) {
            e.printStackTrace();
            showDialog("不支持", "对不起，您的手机不支持OCR识别");
            isOCR = false;
        } catch (UnsatisfiedLinkError r) {
            showDialog("不支持", "对不起，您的手机不支持OCR识别");
            engineDemo = null;
            isOCR = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(engineDemo!=null)
            engineDemo.TR_ClearUP();

    }
}
