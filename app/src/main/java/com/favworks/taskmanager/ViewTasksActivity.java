package com.favworks.taskmanager;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.favworks.taskmanager.tasks.Task;

import java.util.ArrayList;


public class ViewTasksActivity extends TaskManagerActivity {

    private Button addButton;
    private TextView taskText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tasks);
        setUpViews();
    }

    protected void onResume(){
        super.onResume();
        showTasks();
    }

    private void showTasks(){
        ArrayList<Task> tasks = getTaskManagerApplication().getCurrentTasks();
        StringBuffer sb = new StringBuffer();
        for(Task t:tasks){
            sb.append(String.format("* %s\n",t.toString()));
        }
        taskText.setText(sb.toString());
    }

    private void setUpViews() {
        addButton = (Button) findViewById(R.id.add_button);
        taskText = (TextView)findViewById(R.id.task_list_text);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewTasksActivity.this,AddTaskActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_tasks, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
