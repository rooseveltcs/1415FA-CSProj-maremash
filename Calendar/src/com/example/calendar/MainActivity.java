package com.example.calendar;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setUpChangeToCalendarViewActivityButton();
    }
    
    private void setUpChangeToCalendarViewActivityButton(){
    	Button btnCalendarView = (Button) findViewById(R.id.btn_view_calendar);
    	btnCalendarView.setOnClickListener(new View.OnClickListener() {
    		@Override
    		public void onClick(View v){
    			Toast.makeText(MainActivity.this, getEditText(), Toast.LENGTH_LONG).show();
    			startActivity(new Intent(MainActivity.this, ViewCalendar.class));
    		}
    	});
    }

    private String getEditText(){
    	EditText edTxtMainActivity = (EditText) findViewById(R.id.edit_message);
    	if(!edTxtMainActivity.getText().toString().equals("")){
    		return (String) edTxtMainActivity.getText().toString();
    	} else {
    		return getString(R.string.you_clicked_it);
    	}
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
