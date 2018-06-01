package com.yanghaoyi.myactivitytask.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yanghaoyi.myactivitytask.R;
import com.yanghaoyi.myactivitytask.presenter.TaskPresenter;

public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTaskWindow();
        tvTitle.setText("MainActivity");
    }


    private void initTaskWindow(){
        TaskPresenter.INSTANCE.initWindow(getApplication());
        TextView textView = new TextView(getApplicationContext());
        textView.setTextColor(getResources().getColor(R.color.colorText));
        textView.setBackgroundColor(getResources().getColor(R.color.colorStandard));
        textView.setPadding(20,20,20,20);
        textView.setText("StandardActivity");
        TaskPresenter.INSTANCE.addStandardView(textView);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        WindowManager windowManager = (WindowManager)getApplication().getSystemService(Context.WINDOW_SERVICE);
        windowManager.removeView(TaskPresenter.INSTANCE.llFloatWindow);
    }
}
