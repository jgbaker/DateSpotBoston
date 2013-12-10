package com.datespotboston;



import android.os.Bundle;
import com.datespotboston.MapTab;
import android.support.v4.app.*;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;


public class MainActivity extends FragmentActivity {
		private FragmentTabHost mTabHost;
	    static char state = '4';
	   
	    public static char getState() {
			return state;
		}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
       
        //Android Support FragmentTabHost
        setContentView(R.layout.activity_main);
	
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        
        //Spot Fragment
        mTabHost.addTab(mTabHost.newTabSpec("Spots")
        		.setIndicator("Spots"),
                MapTab.class, null);
                
        //About Fragment
        mTabHost.addTab(mTabHost.newTabSpec("About")
        		.setIndicator("About"),
                AboutTab.class, null);
        
        mTabHost.setCurrentTab(0);
        
    }
    
	public static void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	   boolean checked = ((RadioButton) view).isChecked();
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radioFun:
	            if (checked)
	                // add fun markers
	            	state = '1';
	            for(int i=0;i<128;i++){
		            MapTab.returnMarkers()[i].setVisible(false);
	            }
	            for(int i = 53;i < 92;i++){
		            MapTab.returnMarkers()[i].setVisible(true);
	            }
	            
	            break;
	        case R.id.radioFood:
	            if (checked)
	                // add food markers
	            	state ='2';
	            for(int i=0;i<128;i++){
		            MapTab.returnMarkers()[i].setVisible(false);
	            }
	            for(int i = 0; i < 53; i++){
	            	MapTab.returnMarkers()[i].setVisible(true);
	            }
	            
	            
	            break;
	        case R.id.radioDrink:
	            if (checked)
	                // add drink markers
	            	state ='3';
	            for(int i=0;i<128;i++){
		            MapTab.returnMarkers()[i].setVisible(false);
	            }
	            for(int i = 92; i < 128; i++){
	            	MapTab.returnMarkers()[i].setVisible(true);
	            }
	            
	            
	            break;
	        case R.id.radioAll:
	            if (checked)
	                // add all markers
	            	state = '4';
	            for(int i=0;i<128;i++){
		            MapTab.returnMarkers()[i].setVisible(true);
	            }
	            
	            
	            break;
	    }
	}
    
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	protected void onPause()	{
		super.onPause();
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
	
	@Override
	public void onBackPressed() {
		int id = android.os.Process.myPid();
		android.os.Process.killProcess(id);
	}
	
	
}

