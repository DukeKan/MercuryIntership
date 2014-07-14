package com.example.splashlistapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

	/**
	 * How many milliseconds will be SplashScreen shown on display
	 */
	public int SPLASH_TIME = 10000;
	

	private boolean timer_started = false;

	final String LOG_TAG = "myLogs";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_splash_activity);
	}

	private void createSplashTimer() {
		
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				/* Create an Intent that will start the Menu-Activity. */
				Intent mainIntent = new Intent(SplashActivity.this,
						HomeActivity.class);
				SplashActivity.this.startActivity(mainIntent);
				SplashActivity.this.finish();
			}
		}, this.SPLASH_TIME);

	}

	// At the second time we see this screen application must be stopped
	@Override
	protected void onRestart() {
		super.onRestart();
		this.finish();

	}

	protected void onResume() {
		super.onResume();
		if (!this.timer_started) {
			createSplashTimer();
		}
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean("timer_started", true);
	}

	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		timer_started = savedInstanceState.getBoolean("timer_started");
	}

}
