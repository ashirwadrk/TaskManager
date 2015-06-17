package com.favworks.taskmanager;

import android.app.Activity;

/**
 * Created by User on 6/11/15.
 */
public class TaskManagerActivity extends Activity {
    protected TaskManagerApplication getTaskManagerApplication(){
        TaskManagerApplication tma = (TaskManagerApplication)getApplication();
        return tma;
    }
}
