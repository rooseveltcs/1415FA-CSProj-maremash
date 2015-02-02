package com.example.calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewCalendar extends ActionBarActivity {

	private Calendar cal;
	private ArrayList<LinearLayout> dateCells;
	private TextView monthTitle;
	private int currentYear;
	private RelativeLayout viewCalLayout;
	private String[] monthsString = {"January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	private int[] monthsNum = {Calendar.JANUARY, Calendar.FEBRUARY, Calendar.MARCH, Calendar.APRIL, Calendar.MAY, Calendar.JUNE, Calendar.JULY, Calendar.AUGUST, Calendar.SEPTEMBER, Calendar.OCTOBER, Calendar.NOVEMBER, Calendar.DECEMBER};
	private int[] monthsNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private final int columnsWeeks = 7;
	private int setMonth;
	private GregorianCalendar gregCurrentFirstDay;
	private int daysInMonth;
	private int firstDayOfMonth;
	private int toDay;
	private int toMonth;
	private int toYear;
	private ArrayList<Task> taskList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_calendar);
		dateCells = settingUpDateArrayList();
		monthTitle  = (TextView) findViewById(R.id.txtMonthTitle);
		viewCalLayout = (RelativeLayout) findViewById(R.id.viewCalendarLayout);
		gregCurrentFirstDay = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		settingCurrentMonth();
		settingWidth(dateCells);
		settingDates(dateCells);
		setRowColorBackground(dateCells, columnsWeeks);
		Thread v = new Thread(){
	        	@Override
	        	public void run(){
	        		try{
	                    while (!isInterrupted()) {
	        				Thread.sleep(1000);
	                        runOnUiThread(new Runnable() {
	        					@Override
	        					public void run(){
	        						cal = Calendar.getInstance();
	        					}
	        				});
	        			}
	        		}catch (InterruptedException e){
	        		}
	        	}
	        };
	        v.start();
	} 
	@Override
	
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.to_main){
    		Toast.makeText(ViewCalendar.this, "Btn Pressed", Toast.LENGTH_LONG).show();
			startActivity(new Intent(ViewCalendar.this, MainActivity.class));
			return true;
		} else if (id == R.id.add_task){
			startActivity(new Intent(ViewCalendar.this, AddTask.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.view_calendar, menu);
    	return super.onCreateOptionsMenu(menu);
    }
	
    public void onBtnClicked(View v){
    	int vId = v.getId();
    	if(vId == R.id.btnMonthPrevious){
    		settingCurrentMonth(-1);
    		settingDates(dateCells);
    	} else if (vId == R.id.btnMonthNext){
    		settingCurrentMonth(1);   
    		settingDates(dateCells);
    	}
    }
	//can move
	public void settingCurrentMonth(){
		SimpleDateFormat sdfDate = new SimpleDateFormat("MMMM", Locale.getDefault());		
		String currentMonth = sdfDate.format(Calendar.getInstance().getTime());
		currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for(int l = 0; l < monthsNumbers.length; l++){
			if(currentMonth.equals(monthsString[l])){
				currentMonth = monthsString[l];
				monthTitle.setText(monthsString[l]+ " " + currentYear);//DateFormat.format("yyyy", gregCurrentFirstDay.getInstance().getTime())
				setMonth = l;
			}
		}	
	}
	

	
	public void settingCurrentMonth(int change){
		int placeHolder = 0;
		for(int m = 0; m < monthsString.length; m++){
			if(setMonth == monthsNum[m]){
				placeHolder = m;
			}
		}
		if(change < 0){
			if(placeHolder == 0){
				placeHolder = 11;
				currentYear--;
			} else {
				placeHolder--;
			}
		} else if (change > 0){
			if(placeHolder == 11){
				placeHolder= 0;
				currentYear++;
			} else {
				placeHolder++;
			} 
		}
		setMonth = monthsNum[placeHolder];
		monthTitle.setText(monthsString[placeHolder] + " " + currentYear);	
	}
	
	
	public void settingDates(ArrayList<LinearLayout> cells){
		gregCurrentFirstDay.set(currentYear, setMonth, 1, cal.HOUR, cal.MINUTE);
		daysInMonth = gregCurrentFirstDay.getActualMaximum(gregCurrentFirstDay.DAY_OF_MONTH);				
		firstDayOfMonth = gregCurrentFirstDay.get(gregCurrentFirstDay.DAY_OF_WEEK) - 1;
		int currentDay = 1;		
		boolean started = false;
		boolean finished = false;		
		for(int c = 0; c < cells.size(); c++){
			TextView txtView = null;
			View now = (View) cells.get(c).getChildAt(0);
				try{
					txtView = (TextView) now; 
					if(firstDayOfMonth <= c && finished == false){
						started = true;
						txtView.setText("" + currentDay);
					} else {
						txtView.setText("");
					}
				} catch (Exception e){
					monthTitle.setText("Error");
					return;
				}
				if(started == true){
					currentDay++;
				}
				if(currentDay > daysInMonth){
					finished = true;
				}				
		}
	}
	
	
	private void settingWidth(ArrayList<LinearLayout> cells){
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);		
		int screenWidth = metrics.widthPixels;		
		LinearLayout test = cells.get(0);	
		int widthPadding = viewCalLayout.getPaddingRight()+ viewCalLayout.getPaddingLeft()+ (columnsWeeks * (test.getPaddingRight() + test.getPaddingLeft()));					
		int width = (screenWidth - widthPadding)/columnsWeeks;
		for(int i = 0; i < cells.size(); i++){
			LinearLayout current = (LinearLayout) cells.get(i);			
			int count = current.getChildCount();
			TextView t = null;
			for(int j = 0; j < count; j++){
					t = (TextView) current.getChildAt(j);
					t.setMinimumWidth(width);
			}
		}
	}
	
	
	private void setRowColorBackground(ArrayList<LinearLayout> cells, int columns){
		for(int k = 0; k < cells.size(); k++){
			LinearLayout now = cells.get(k);
			int childCount = now.getChildCount();
			TextView current = null;
			View v = null;
			for(int p = 0; p < childCount; p++){
				v = now.getChildAt(p);
				try{
					current = (TextView) v;
					//current.setText("" + (k + 1));
					if(k%columns == 0){
						current.setBackgroundColor(Color.parseColor("#3399ff"));
					}else if (k%columns == 1){
						current.setBackgroundColor(Color.parseColor("#66ffff"));
					} else if (k%columns == 2){
						current.setBackgroundColor(Color.parseColor("#cc99ff"));
					} else if (k%columns == 3){
						current.setBackgroundColor(Color.parseColor("#ff99ff"));						
					} else if (k%columns == 4){
						current.setBackgroundColor(Color.parseColor("#ff6666"));
					} else if (k%columns == 5){
						current.setBackgroundColor(Color.parseColor("#ff9933"));
					} else if (k%columns == 6){
						current.setBackgroundColor(Color.parseColor("#ccff66"));
					} 
					
					String currentDay = (String) current.getText().subSequence(0, current.getText().length());

					if(currentDay.equals("" + toDay)){
						current.setBackgroundColor(Color.parseColor("#cccccc"));
					}
				} catch (Exception e){
					System.out.println("Was not a TextView");
				}
			}
		}
	}
	

	private ArrayList<LinearLayout> settingUpDateArrayList(){
		ArrayList<LinearLayout> dateTitles = new ArrayList<LinearLayout>();
		dateTitles.add((LinearLayout) findViewById(R.id.dater1c1));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater1c2));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater1c3));			
		dateTitles.add((LinearLayout) findViewById(R.id.dater1c4));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater1c5));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater1c6));	
		dateTitles.add((LinearLayout) findViewById(R.id.dater1c7));					
		dateTitles.add((LinearLayout) findViewById(R.id.dater2c1));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater2c2));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater2c3));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater2c4));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater2c5));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater2c6));
		dateTitles.add((LinearLayout) findViewById(R.id.dater2c7));				
		dateTitles.add((LinearLayout) findViewById(R.id.dater3c1));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater3c2));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater3c3));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater3c4));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater3c5));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater3c6));
		dateTitles.add((LinearLayout) findViewById(R.id.dater3c7));								
		dateTitles.add((LinearLayout) findViewById(R.id.dater4c1));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater4c2));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater4c3));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater4c4));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater4c5));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater4c6));	
		dateTitles.add((LinearLayout) findViewById(R.id.dater4c7));	
		dateTitles.add((LinearLayout) findViewById(R.id.dater5c1));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater5c2));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater5c3));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater5c4));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater5c5));		
		dateTitles.add((LinearLayout) findViewById(R.id.dater5c6));	
		dateTitles.add((LinearLayout) findViewById(R.id.dater5c7));	
		dateTitles.add((LinearLayout) findViewById(R.id.dater6c1));
		dateTitles.add((LinearLayout) findViewById(R.id.dater6c2));
		dateTitles.add((LinearLayout) findViewById(R.id.dater6c3));
		dateTitles.add((LinearLayout) findViewById(R.id.dater6c4));
		dateTitles.add((LinearLayout) findViewById(R.id.dater6c5));
		dateTitles.add((LinearLayout) findViewById(R.id.dater6c6));
		dateTitles.add((LinearLayout) findViewById(R.id.dater6c7));
		return dateTitles;
	}	
}


