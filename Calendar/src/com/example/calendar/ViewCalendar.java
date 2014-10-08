package com.example.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ViewCalendar extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_calendar);
		setUpChangeToMainActivityButton();
	}
	private void setUpChangeToMainActivityButton(){
		Button btnMainActivity = (Button) findViewById(R.id.btn_title_activity);
		btnMainActivity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(ViewCalendar.this, getString(R.string.you_clicked_it), Toast.LENGTH_LONG).show();
				startActivity(new Intent(ViewCalendar.this, MainActivity.class));
				
			}
		});
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
