package com.example.calendar;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewCalendar extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_calendar);
		calendarLayoutHeightAndWidth();
		//setUpChangeToMainActivityButton();
	}
	
	private void calendarLayoutHeightAndWidth(){
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		//LinearLayout viewCalLayout = (LinearLayout) findViewById(R.id.viewCalendarLayout);
		//int padding = viewCalLayout.getDividerPadding();
		ArrayList<TextView> cells = new ArrayList<TextView>();
		cells.add((TextView) findViewById(R.id.sundaytxt));		
		cells.add((TextView) findViewById(R.id.mondaytxt));
		cells.add((TextView) findViewById(R.id.tuesdaytxt));
		cells.add((TextView) findViewById(R.id.wednesdaytxt));
		cells.add((TextView) findViewById(R.id.thursdaytxt));
		cells.add((TextView) findViewById(R.id.fridaytxt));
		cells.add((TextView) findViewById(R.id.saturdaytxt));
		for(int i = 0; i < cells.size(); i++){
			cells.get(i).setWidth((width)/7);
			cells.get(i).setHeight(60);
		}
	}
	/*private void setUpChangeToMainActivityButton(){
		Button btnMainActivity = (Button) findViewById(R.id.btn_title_activity);
		btnMainActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(ViewCalendar.this, getString(R.string.you_clicked_it), Toast.LENGTH_LONG).show();
				startActivity(new Intent(ViewCalendar.this, MainActivity.class));
				
			}
		});
	}*/
	
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main, menu);
    	return super.onCreateOptionsMenu(menu);
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			startActivity(new Intent(ViewCalendar.this, MainActivity.class));
			Toast.makeText(ViewCalendar.this, "You have clicked it!!!!!!!", Toast.LENGTH_LONG).show();
			return true;
		} else if (id == R.id.action_new){
    		Toast.makeText(ViewCalendar.this, "You have clicked it!!!!!!!", Toast.LENGTH_LONG).show();
			startActivity(new Intent(ViewCalendar.this, MainActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
