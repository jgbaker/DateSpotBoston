package com.datespotboston;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

public class Splash extends FragmentActivity	{
	
	private FrameLayout frame;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.splash_layout);
		
		frame = (FrameLayout) findViewById(R.id.splash_frame_layout);
		frame.setClickable(true);
		
		frame.setOnClickListener(new OnClickListener()	{
			@Override
			public void onClick(View v) {
				Intent launcher = new Intent(getApplicationContext(),MainActivity.class);
				launcher.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(launcher);	
			//	((globalState) this.getApplication()).setMapState(0);
				
			}
		});
}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}