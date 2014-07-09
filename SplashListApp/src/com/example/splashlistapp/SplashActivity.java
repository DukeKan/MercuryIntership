package com.example.splashlistapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

	public final int FLASH_TIME = 2000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_splash_activity);
	}
	
	Thread splashScreen = new Thread(){
		public void run(){
				try{
					sleep(FLASH_TIME);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					startActivity(new Intent(getApplicationContext(),HomeActivity.class));
					finish();
				}
		}
		
	};
	{
		splashScreen.start();
	}
	
}
