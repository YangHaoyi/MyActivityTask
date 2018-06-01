package com.yanghaoyi.myactivitytask.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.yanghaoyi.myactivitytask.presenter.TaskPresenter;

/**
 * @author : YangHaoYi on 2018/5/29.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/5/29.
 *         Version : V 1.0
 */
public class SingleTaskActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText("SingleTaskActivity");
    }


    @Override
    public void onBackPressed() {
        TaskPresenter.INSTANCE.popActivityTask();
        super.onBackPressed();
    }
}
