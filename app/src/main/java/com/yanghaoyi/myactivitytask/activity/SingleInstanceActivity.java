package com.yanghaoyi.myactivitytask.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.yanghaoyi.myactivitytask.presenter.TaskPresenter;

/**
 * @author : YangHaoYi on 2018/5/29.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/5/29.
 *         Version : V 1.0
 */
public class SingleInstanceActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText("SingleInstanceActivity");
    }

    @Override
    public void onBackPressed() {
        TaskPresenter.INSTANCE.popNewInstanceTask();
        super.onBackPressed();
    }
}
