package com.favworks.taskmanager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.favworks.taskmanager.tasks.Task;

public class AddTaskActivity extends TaskManagerActivity {

    private EditText taskNameEditText;
    private Button addButton;
    private Button cancelButton;
    private boolean changesPending;
    private AlertDialog unsavedChangesDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        setUpViews();
    }

    protected void addTask(){
        String taskName = taskNameEditText.getText().toString();
        Task t = new Task(taskName);
        Validator v = new Validator(taskNameEditText);
        if(!v.checkLength(2, 4, "Min 2 Chars required")){
//            cancel();
        } else {
            getTaskManagerApplication().addTask(t);
            cancel();
        }

    }

    protected void cancel(){
        finish();
//        if(changesPending){
//            unsavedChangesDialog = new AlertDialog.Builder(this)
//                    .setTitle(R.string.unsaved_changes_title)
//                    .setMessage(R.string.unsaved_changes_message)
//                    .setPositiveButton(R.string.add_task,new AlertDialog.OnClickListener(){
//                        public void onClick(DialogInterface dialog,int which){
//                            addTask();
//                        }
//                    })
//                    .setNeutralButton(R.string.discard,new AlertDialog.OnClickListener(){
//                        public void onClick(DialogInterface dialog,int which){
//                            finish();
//                        }
//                    })
//                    .setNegativeButton(android.R.string.cancel,new AlertDialog.OnClickListener(){
//                       public void onClick(DialogInterface dialog,int which){
//                            unsavedChangesDialog.cancel();
//                        }
//                    })
//                    .create();
//            unsavedChangesDialog.show();
//        } else {
//            finish();
//        }
    }

    private void setUpViews() {
        taskNameEditText = (EditText) findViewById(R.id.task_name);
        addButton = (Button) findViewById(R.id.add_button);
        cancelButton = (Button) findViewById(R.id.cancel_button);

        Spinner spinner = (Spinner) findViewById(R.id.first_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

        taskNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                changesPending = true;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_task, menu);
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
