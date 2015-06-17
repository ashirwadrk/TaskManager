package com.favworks.taskmanager;

import android.app.Application;

import com.favworks.taskmanager.tasks.Task;

import java.util.ArrayList;

/**
 * Created by User on 6/11/15.
 */
public class TaskManagerApplication extends Application {
    private ArrayList<Task> currentTasks;

    @Override
    public void onCreate() {
        super.onCreate();
        if(null==currentTasks){
            currentTasks = new ArrayList<Task>();
        }
    }

    public void setCurrentTasks(ArrayList<Task> currentTasks){
        this.currentTasks = currentTasks;
    }

    public ArrayList<Task> getCurrentTasks(){
        return currentTasks;
    }

    public void addTask(Task t){
        assert (null!=t);

        if(null == currentTasks){
            currentTasks = new ArrayList<Task>();
        }

        currentTasks.add(t);

    }
}
