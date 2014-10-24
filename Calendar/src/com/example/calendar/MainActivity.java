package com.example.calendar;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainActivity extends ActionBarActivity {
    
	public Calendar cal = new GregorianCalendar();
	public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(dateFormat.format(cal.getTime()));

        //setUpChangeToCalendarViewActivityButton();
    }
    
    /*private void setUpChangeToCalendarViewActivityButton(){
    	Button btnCalendarView = (Button) findViewById(R.id.btn_view_calendar);
    	btnCalendarView.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v){
    			Toast.makeText(MainActivity.this, getEditText(), Toast.LENGTH_LONG).show();
    			startActivity(new Intent(MainActivity.this, ViewCalendar.class));
    		}
    	});
    }*/
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
    		Toast.makeText(MainActivity.this, "You have clicked it!!!!!!!", Toast.LENGTH_LONG).show();
			startActivity(new Intent(MainActivity.this, ViewCalendar.class));
			return true;
    	} else if( id == R.id.action_settings){
			startActivity(new Intent(MainActivity.this, ViewCalendar.class));
    		return true;
    	}
    	return super.onOptionsItemSelected(item);
    }

    private String getEditText(){
    	EditText edTxtMainActivity = (EditText) findViewById(R.id.edit_message);
    	if(!edTxtMainActivity.getText().toString().equals("")){
    		return (String) edTxtMainActivity.getText().toString();
    	} else {
    		return getString(R.string.you_clicked_it);
    	}
    }
}
