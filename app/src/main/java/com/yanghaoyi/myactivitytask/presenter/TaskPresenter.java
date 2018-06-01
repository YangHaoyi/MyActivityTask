package com.yanghaoyi.myactivitytask.presenter;

import android.app.Application;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yanghaoyi.myactivitytask.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : YangHaoYi on 2018/5/29.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/5/29.
 *         Version : V 1.0
 */
public enum  TaskPresenter {

    INSTANCE;

    public LinearLayout llFloatWindow;
    public LinearLayout llTaskParent;
    public LinearLayout llTask;
    public LinearLayout llNewTask;
    public LinearLayout llNewTaskParent;
    private List<String> activityList;


    TaskPresenter() {
    }

    public void initWindow(Application application){
        activityList = new ArrayList<>();
        initNewTask(application);
        initTask(application);
        initFloatWindow(application);
    }

    private void initTask(Application application) {
        llTaskParent = new LinearLayout(application.getApplicationContext());
        llTaskParent.setOrientation(LinearLayout.VERTICAL);
        TextView textView = new TextView(application.getApplicationContext());
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(application.getResources().getColor(R.color.colorText));
        textView.setBackgroundColor(application.getResources().getColor(R.color.colorTask));
        textView.setPadding(20,20,20,20);
        textView.setText("Activity任务栈");
        llTask = new LinearLayout(application.getApplicationContext());
        llTask.setOrientation(LinearLayout.VERTICAL);
        llTaskParent.addView(textView);
        llTaskParent.addView(llTask);
    }

    private void initNewTask(Application application) {
        llNewTaskParent = new LinearLayout(application.getApplicationContext());
        llNewTaskParent.setOrientation(LinearLayout.VERTICAL);
        llNewTaskParent.setVisibility(View.GONE);
        llNewTask = new LinearLayout(application.getApplicationContext());
        llNewTask.setOrientation(LinearLayout.VERTICAL);
        TextView textView = new TextView(application.getApplicationContext());
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(application.getResources().getColor(R.color.colorText));
        textView.setBackgroundColor(application.getResources().getColor(R.color.colorTask));
        textView.setPadding(20,20,20,20);
        textView.setText("NewInstance的Activity任务栈");
        llNewTaskParent.addView(textView);
        llNewTaskParent.addView(llNewTask);
    }

    private void initFloatWindow(Application application) {
        llFloatWindow = new LinearLayout(application.getApplicationContext());
        llFloatWindow.setOrientation(LinearLayout.HORIZONTAL);
        llFloatWindow.addView(llNewTaskParent);
        llFloatWindow.addView(llTaskParent);
        WindowManager windowManager = (WindowManager)application.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.type = WindowManager.LayoutParams.TYPE_PHONE;
        params.format = PixelFormat.RGBA_8888;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL;
        windowManager.addView(TaskPresenter.INSTANCE.llFloatWindow, params);
    }


    public void addStandardView(TextView view){
        activityList.add("StandardActivity");
        llTask.addView(view,0);
    }

    public void addSingleTopView(TextView view){
        if(activityList.size()>0&&activityList.get(activityList.size()-1).equals("SingleTopActivity")){
            System.out.println("栈顶复用");
        }else {
            activityList.add("SingleTopActivity");
            llTask.addView(view,0);
        }
    }

    public void addSingleTaskView(TextView view){
        int singleTask = -1;
        Collections.reverse(activityList);
        for(int i=0;i<activityList.size();i++){
            if(activityList.get(i).equals("SingleTaskActivity")){
                singleTask = i;
            }
        }
        if(singleTask!=-1){
            for(int i=0;i<singleTask;i++){
                llTask.removeViewAt(0);
            }
            activityList = activityList.subList(singleTask, activityList.size());
            Collections.reverse(activityList);
        }else {
            Collections.reverse(activityList);
            activityList.add("SingleTaskActivity");
            llTask.addView(view,0);
        }
    }

    public void addSingleInstanceView(TextView view){
        if(llNewTask.getChildCount()==0){
            llNewTaskParent.setVisibility(View.VISIBLE);
            llNewTask.addView(view);
        }
    }

    public void popNewInstanceTask(){
        llNewTask.removeViewAt(0);
        llNewTaskParent.setVisibility(View.GONE);
    }


    public void popActivityTask(){
        llTask.removeViewAt(0);
        activityList.remove(activityList.size()-1);
    }

}
