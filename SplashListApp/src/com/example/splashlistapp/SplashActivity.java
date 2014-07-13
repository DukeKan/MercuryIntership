package com.example.splashlistapp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends Activity {

	/**
	 * How many milliseconds will be SplashScreen shown on display 
	 */
	public int SPLASH_TIME = 10000;
	/**
	 * When was application started 
	 */
	private long startTime = 0;
	/**
	 * Tag for own log
	 */
	final String LOG_TAG = "myLogs";
	/**
	 * Timer that will start HomeActivity
	 */
	private Timer timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_splash_activity);
		this.startTime = System.currentTimeMillis();
	}

	private void createTimer() {
		timer = new Timer();
		// What does the timer do?
		TimerTask task = new TimerTask() {
			public void run() {
				// Start HomeActivity
				startActivity(new Intent(getApplicationContext(),
						HomeActivity.class));
				// Stop timer
				timer.cancel();
			}
		};
		timer.schedule(task, this.SPLASH_TIME);
		Log.d(LOG_TAG, String.valueOf(this.SPLASH_TIME));
	}
	
	// At the second time we see this screen application must be stopped
	@Override
	protected void onRestart(){
		super.onRestart();
		this.finish();
	}

	// Destroy timer if activity was closed
	@Override
	protected void onPause() {
	    super.onPause();
	    this.timer.cancel();
	}
	
	
	// Starts after onRestoreInstanceState()
	@Override
	protected void onResume() {
		super.onResume();
		createTimer();
	}

	
	/* 
	 * Need for load how many milliseconds remained for starting HomeActivity
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		this.SPLASH_TIME = savedInstanceState.getInt("time_left");
	}

	
	
	/* 
	 * Need for save how many milliseconds remained for starting HomeActivity
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// Home many milliseconds remained for starting HomeActivity
		outState.putInt("time_left",
				this.SPLASH_TIME
						- (int) (System.currentTimeMillis() - this.startTime));
		timer.cancel();
	}

}
