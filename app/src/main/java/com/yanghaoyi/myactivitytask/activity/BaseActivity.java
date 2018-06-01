package com.yanghaoyi.myactivitytask.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.yanghaoyi.myactivitytask.R;
import com.yanghaoyi.myactivitytask.presenter.TaskPresenter;

public class BaseActivity extends FragmentActivity implements View.OnClickListener {

    protected TextView tvTitle;

    private TextView tvStandard;
    private TextView tvSingleTop;
    private TextView tvSingleTask;
    private TextView tvSingleInstance;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        initView();
        initEvent();
    }

    private void initView(){
        tvTitle = findViewById(R.id.tvTitle);
        tvStandard = findViewById(R.id.tvStandard);
        tvSingleTop = findViewById(R.id.tvSingleTop);
        tvSingleTask = findViewById(R.id.tvSingleTask);
        tvSingleInstance = findViewById(R.id.tvSingleInstance);
    }

    private void initEvent(){
        tvStandard.setOnClickListener(this);
        tvSingleTop.setOnClickListener(this);
        tvSingleTask.setOnClickListener(this);
        tvSingleInstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvStandard:
                toStandard(this);
                break;
            case R.id.tvSingleTop:
                toSingleTop(this);
                break;
            case R.id.tvSingleTask:
                toSingleTask(this);
                break;
            case R.id.tvSingleInstance:
                toSingleInstance(this);
                break;
            default:
                break;
        }
    }

    private void toStandard(FragmentActivity activity){
        TextView textView = new TextView(getApplicationContext());
        textView.setTextColor(getResources().getColor(R.color.colorText));
        textView.setBackgroundColor(getResources().getColor(R.color.colorStandard));
        textView.setPadding(20,20,20,20);
        textView.setText("StandardActivity");
        textView.setGravity(Gravity.CENTER);
        TaskPresenter.INSTANCE.addStandardView(textView);
        Intent intent = new Intent(activity, StandardActivity.class);
        startActivity(intent);
    }
    private void toSingleTop(FragmentActivity activity){
        TextView textView = new TextView(getApplicationContext());
        textView.setPadding(20,20,20,20);
        textView.setTextColor(getResources().getColor(R.color.colorText));
        textView.setBackgroundColor(getResources().getColor(R.color.colorSingleTop));
        textView.setText("SingleTopActivity");
        textView.setGravity(Gravity.CENTER);
        TaskPresenter.INSTANCE.addSingleTopView(textView);
        Intent intent = new Intent(activity, SingleTopActivity.class);
        startActivity(intent);
    }
    private void toSingleTask(FragmentActivity activity){
        TextView textView = new TextView(getApplicationContext());
        textView.setPadding(20,20,20,20);
        textView.setTextColor(getResources().getColor(R.color.colorText));
        textView.setBackgroundColor(getResources().getColor(R.color.colorSingleTask));
        textView.setText("SingleTaskActivity");
        textView.setGravity(Gravity.CENTER);
        TaskPresenter.INSTANCE.addSingleTaskView(textView);
        Intent intent = new Intent(activity, SingleTaskActivity.class);
        startActivity(intent);
    }

    private void toSingleInstance(FragmentActivity activity){
        TextView textView = new TextView(getApplicationContext());
        textView.setTextColor(getResources().getColor(R.color.colorText));
        textView.setBackgroundColor(getResources().getColor(R.color.colorStandard));
        textView.setPadding(20,20,20,20);
        textView.setText("SingleInstanceActivity");
        textView.setGravity(Gravity.CENTER);
        TaskPresenter.INSTANCE.addSingleInstanceView(textView);
        Intent intent = new Intent(activity, SingleInstanceActivity.class);
        startActivity(intent);
    }



}
