package com.example.calendar;

import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class MainActivity extends ActionBarActivity {
    
	public Date date;
	public ArrayList<Task> taskArray;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taskArray = new ArrayList<Task>();
        Thread t = new Thread(){
        	@Override
        	public void run(){
        		try{
                    while (!isInterrupted()) {
        				Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
        					@Override
        					public void run(){
        						updateDisplayTime();
        					}
        				});
        			}
        		}catch (InterruptedException e){
        		}
        	}
        };
        t.start();
        setTasksArray();
        getTextFromFile();
    }
    
    private void updateDisplayTime(){
    	TextView title = (TextView) findViewById(R.id.txt_title_message);
    	date = Calendar.getInstance().getTime();
    	String dateFormat = "MM dd yyyy";
        title.setText(DateFormat.format(dateFormat, date) + "  " + new SimpleDateFormat("E").format(date));
    }
    
    private void getTextFromFile(){
    	TextView displayTask = (TextView) findViewById(R.id.displayStuff);
    	Scanner scan = null;
		for(int s = 0; s < taskArray.size(); s++){
			Task task = taskArray.get(s);
			displayTask.setText(displayTask.getText() + "\n" + "\n" + task.toString());
		}	
    }
    public ArrayList<Task> getTaskList(){
    	return taskArray;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main, menu);
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	int id = item.getItemId();
    	if(id==R.id.to_view_calendar){
    		Toast.makeText(MainActivity.this, "Btn Pressed", Toast.LENGTH_LONG).show();
			startActivity(new Intent(MainActivity.this, ViewCalendar.class));
			return true;
    	} else if (id == R.id.add_task_main){
    		startActivity(new Intent(MainActivity.this, AddTask.class));
			return true;
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    public void setTasksArray(){
    	try {
			Scanner scanner = new Scanner(new File(CalendarApplication.filePath));
			while(scanner.hasNextLine()){
					String line = scanner.nextLine();
					String[] lineArray = line.split(",");
					Task task = new Task(lineArray);
					taskArray.add(task);
				}
		} catch (FileNotFoundException e) {
			
		}
	}
}
