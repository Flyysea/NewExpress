package com.express.main.manager.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.express.main.R;
import com.express.main.Util.T;
import com.express.main.global.app.BaseActivity;
import com.express.main.manager.adapter.AllOperatorAdapter;
import com.express.main.manager.dto.AllOperatorResponseDto;

import android.support.v7.app.ActionBar;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by Administrator on 2017-02-16.
 */

public class ExpressListActivity extends BaseActivity {

    /**
     * 列表
     */
    private RecyclerView rvOperatorList;
    /**
     * 页数
     */
    private int page = 1;
    /**
     * 数据源
     */
    private List<AllOperatorResponseDto.DataEntity.ListEntity> operatoarList;
    /**
     * 数据适配器
     */
    private AllOperatorAdapter allOperatorAdapter;
    private boolean isMore = false;
    private boolean isRefresh = false;
    private final int SETTING = 88;
    private TextView tvTip;

    /**
     * 是否创建
     */
    protected boolean isCreate = false;
    private ActionBar actionBar;
    /**
     * 刷新列表
     */
    protected MaterialRefreshLayout refreshOperatorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expresslist);


        actionBar = getSupportActionBar();

        assignViews();
        refreshData();
        initEvent();
        initAdapter();
        isCreate = true;
//        EventBus.getDefault().register(this);
        refreshData();
    }

    private void initEvent() {
        //刷新
        refreshOperatorList.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                isMore = false;
                isRefresh = true;
                page = 1;
                //从服务器获得数据
                getDataOrRefreshDataFromServer();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                //super.onRefreshLoadMore(materialRefreshLayout);
                page++;
                isMore = true;
                getDataOrRefreshDataFromServer();
            }
        });


    }



    protected void getDataOrRefreshDataFromServer() {
        int isUpdateChangeSituation = 0;
        //创建数据对象
//        AllOperatorRequestDto.DataEntity dataEntity = new AllOperatorRequestDto.DataEntity(websiteId, ticket, imei, isUpdateChangeSituation, page,idNoCiphertext);
//        AllOperatorRequestDto requestDto = new AllOperatorRequestDto("GetOperatorPageManagerServiceAction", dataEntity);
        //发起请求
//        RequestUtils.rP(mHandler, gson.toJson(requestDto));
    }


    /**
     * 解析结果
     *
     * @param result
     */
    private void parserResponesData(String result) {
        try {
//            AllOperatorResponseDto operatorResponseDto = gson.fromJson(result, AllOperatorResponseDto.class);
//            //数据源
//            operatoarList = operatorResponseDto.getData().getList();
//            OperatorFragment.tvOperaoro1.setText("操作员(" + operatorResponseDto.getData().getTotalCount() + ")");
//            OperatorFragment.tvOperaoro2.setText("操作员(" + operatorResponseDto.getData().getTotalCount() + ")");
//            allOperatorAdapter.notifyDataSetChanged();
//            allOperatorAdapter.notifyDataSetChanged();
//            if (operatoarList != null && operatoarList.size() > 0) {
//                tvTip.setVisibility(View.GONE);
//            } else {
//                tvTip.setVisibility(View.VISIBLE);
//            }
//            initAdapter();
//            L.e(TAG, "通知更改：" + operatoarList.size());
        } catch (Exception e) {
            e.printStackTrace();
            //处理错误结果
//            ResponseErrorDto errorDto = gson.fromJson(result, ResponseErrorDto.class);
//            rE(errorDto.getData().getResult());
        }
        dismissProgress();
    }

    /**
     * 初始化数据源
     */
    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvOperatorList.setLayoutManager(linearLayoutManager);
        allOperatorAdapter = new AllOperatorAdapter(operatoarList, mActivity);
        //设置适配器
        rvOperatorList.setAdapter(allOperatorAdapter);
        //--------------------------条目点击事件
        allOperatorAdapter.setmOnItemClickListener(new AllOperatorAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onRecyclerViewItemClickListener(View view, int positon, int type) {
                if (type == AllOperatorAdapter.SETTING) {//设置

                }
            }
        });
        //--------------------------条目点击事件
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SETTING && data != null) {
            refreshData();
        }
    }

    private void assignViews() {
        refreshOperatorList = (MaterialRefreshLayout) findViewById(R.id.refresh_operator_list);
        rvOperatorList = (RecyclerView) findViewById(R.id.rv_operator_list);
        //-----------------------刷新视图
        refreshOperatorList.setWaveColor(mActivity.getResources().getColor(R.color.transparent));
        refreshOperatorList.setWaveShow(true);
        refreshOperatorList.setLoadMore(true);
        //-----------------------刷新视图
        tvTip = (TextView) findViewById(R.id.tv_tip);
    }

    protected void resultData(String result) {
        if (isRefresh) {
            refreshOperatorList.finishRefresh();
            isRefresh = false;
        }
        if (isMore) {//加载更多
            paserMoreData(result);
        } else {
            parserResponesData(result);
        }
    }

    /**
     * 解析更多数据
     *
     * @param result
     */
    private void paserMoreData(String result) {
        try {
            refreshOperatorList.finishRefreshLoadMore();
//            AllOperatorResponseDto operatorResponseDto = gson.fromJson(result, AllOperatorResponseDto.class);
//            //数据源
//            if (operatorResponseDto.getData().getList() != null && operatorResponseDto.getData().getList().size() > 0) {
//                operatoarList.addAll(operatorResponseDto.getData().getList());
//                allOperatorAdapter.notifyDataSetChanged();
//            } else {
//                T.showToast(mActivity, "没有更多数据了");
//            }
        } catch (Exception e) {
            e.printStackTrace();
            //处理错误结果
//            ResponseErrorDto errorDto = gson.fromJson(result, ResponseErrorDto.class);
//            rE(errorDto.getData().getResult());
        }

    }

//    @Subscribe
//    public void onEventMainThread(RefreshOpertorEvent opertorEvent) {
//        refreshData();
//    }

    private void refreshData() {
        showProgress("正在刷新数据...");
        isMore = false;
        page = 1;
        //从服务器获得数据
        getDataOrRefreshDataFromServer();
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser && isCreate) {
//            refreshData();
//        }
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }


    /**
     * 显示菜单（也是为了显示ActionBar上的图标菜单选项）
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }
}
