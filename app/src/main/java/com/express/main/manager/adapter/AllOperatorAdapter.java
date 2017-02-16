package com.express.main.manager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.express.main.R;
import com.express.main.manager.dto.AllOperatorResponseDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 江俊超 on 2016/2/27.
 */
public class AllOperatorAdapter extends RecyclerView.Adapter<AllOperatorAdapter.ViewHolders> {
    public final static int CALL_CL = 0;
    public final static int SETTING = 1;
    /**
     * 数据源
     */
    private List<AllOperatorResponseDto.DataEntity.ListEntity> operatoarList;
    /**
     * 上下文
     */
    private Context mContext;

    public AllOperatorAdapter(List<AllOperatorResponseDto.DataEntity.ListEntity> operatoarList, Context mContext) {
        this.operatoarList = operatoarList;
        this.mContext = mContext;
        if (operatoarList==null)
            this.operatoarList = new ArrayList<>();
    }

    @Override
    public ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_operator, null);
        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(ViewHolders holder, int position) {
        holder.setData(position);
    }


    @Override
    public int getItemCount() {
        return operatoarList.size();
    }

    class ViewHolders extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView ivState;
        private ImageView ivCall;
        private View ivSetting;

        public ViewHolders(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_operator_name);
//            ivCall = (ImageView) itemView.findViewById(R.id.iv_call);
            ivSetting = itemView.findViewById(R.id.iv_setting);


            ivSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onRecyclerViewItemClickListener(ivCall, getPosition(), SETTING);
                }
            });
        }

        /**
         * 设置数据
         *
         * @param position
         */
        public void setData(int position) {
            //获得数据
            AllOperatorResponseDto.DataEntity.ListEntity entity = operatoarList.get(position);
            tvName.setText(entity.getOperatorName());
            if (entity.getStatus() == 1) {
//                ivState.setImageResource(R.mipmap.state_blocked);
            } else {
//                ivState.setImageResource(R.mipmap.state_normal);
            }
        }
    }

    public void setmOnItemClickListener(OnRecyclerViewItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    /**
     * 点击监听的接口
     */
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    /**
     * 外接口
     */
    public  interface OnRecyclerViewItemClickListener {
        void onRecyclerViewItemClickListener(View view, int positon, int type);
    }
}
