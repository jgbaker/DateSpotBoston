package com.datespotboston;


import android.os.Bundle;
import android.support.v4.app.*;
import android.view.Menu;


public class MainActivity extends FragmentActivity {
		private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //Set up the FragmentTabHost
        setContentView(R.layout.activity_main);
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        
        
        // Map Fragment
        mTabHost.addTab(mTabHost.newTabSpec("Spots")
        		.setIndicator("Spots",getResources()
        		.getDrawable(R.drawable.maptabicon)),
                MapTab.class, null);
        
        // List Fragment
        mTabHost.addTab(mTabHost.newTabSpec("List")
        		.setIndicator("List",getResources()
        		.getDrawable(R.drawable.settingstabicon)),
                SettingsTab.class, null);
                
        
        // About Fragment
        mTabHost.addTab(mTabHost.newTabSpec("About")
        		.setIndicator("About",getResources()
        		.getDrawable(R.drawable.abouttabicon)),
                AboutTab.class, null);
        

        mTabHost.setCurrentTab(0);
        
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	protected void onPause()	{
		super.onPause();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState)	{
		super.onSaveInstanceState(savedInstanceState);
		
		// TODO: Save stuff for next time you start app!!!
		//savedInstanceState.putString("SavedMapType","")		
	}
	
	@Override
	protected void onStop()	{
		super.onStop();
	}
	
	@Override
	protected void onResume()	{
		super.onResume();
	}
	
	@Override
	protected void onDestroy()	{
		super.onDestroy();
	}
}

