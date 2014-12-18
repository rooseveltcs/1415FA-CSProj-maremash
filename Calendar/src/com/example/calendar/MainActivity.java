package com.example.calendar;

import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends ActionBarActivity {
    
	public Date date;
	TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView) findViewById(R.id.txt_title_message);
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
    }
    
    private void updateDisplayTime(){
    	date = Calendar.getInstance().getTime();
    	String timeFormat = "hh:mm:ss";
    	String dateFormat = "MM dd yyyy";
        title.setLines(2);
        title.setText(DateFormat.format(timeFormat, date) + "\n" + DateFormat.format(dateFormat, date) + "  " + new SimpleDateFormat("E").format(date));
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
    	if(id==R.id.action_new){
    		Toast.makeText(MainActivity.this, "Btn Pressed", Toast.LENGTH_LONG).show();
			startActivity(new Intent(MainActivity.this, ViewCalendar.class));
			return true;
    	} 
    	return super.onOptionsItemSelected(item);
    }

}
