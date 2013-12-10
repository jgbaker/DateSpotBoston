package com.datespotboston;



//import java.io.IOException;
//import java.util.List;

//import android.location.Address;
//import android.location.Geocoder;
//import android.os.AsyncTask;
import android.os.Bundle;
import com.datespotboston.MapTab;
//import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v4.app.*;
import android.view.Menu;
import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.EditText;
import android.widget.RadioButton;
//import android.widget.Toast;


public class MainActivity extends FragmentActivity {
		private FragmentTabHost mTabHost;
	    static char state = '4';
	    MarkerOptions markerOptions;
	    LatLng latLng;
	   
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
        
        
    
    //radio buttons case machine to filter out date spots
    
	public static void onRadioButtonClicked(View view) {
	    // Is the button checked?
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
	
	
	//kill process on back button to keep app from crashing
	@Override
	public void onBackPressed() {
		int id = android.os.Process.myPid();
		android.os.Process.killProcess(id);
	}
	
	
	
	
	
	/******* CODE TO IMPLEMENT SEARCH FEATURE **********/
	/*******    		SOON!				 *********
	private class GeocoderTask extends AsyncTask<String, Void, List<Address>>{
		
		
		
	//Search bar function
	@Override	
	protected List<Address> doInBackground(String... locationName) {
	 // Creating an instance of Geocoder class
		Geocoder geocoder = new Geocoder(getBaseContext()); 
		List<Address> addresses = null;
		try {
			// Getting a maximum of 3 Address that matches the input text
addresses = geocoder.getFromLocationName(locationName[0], 3); 
		} 
		catch (IOException e) { 
			e.printStackTrace();
			}
		return addresses;
		}
	
	
	


	@Override
	protected void onPostExecute(List<Address> addresses) { 
		if(addresses==null || addresses.size()==0){ 
			Toast.makeText(getBaseContext(), "No Location found", Toast.LENGTH_SHORT).show();
			} 
		
		// Adding Markers on Google Map for each matching address 
		for(int i=0;i<addresses.size();i++){ 
			Address address = (Address) addresses.get(i);
			// Creating an instance of GeoPoint, to display in Google Map
			latLng = new LatLng(address.getLatitude(), address.getLongitude());
			String addressText = String.format("%s, %s",
					address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "", 
							address.getCountryName()); 
			markerOptions = new MarkerOptions(); 
			markerOptions.position(latLng); 
			markerOptions.title(addressText); 
			MapTab.mMap.addMarker(markerOptions);
			
			if(i==0)
				MapTab.mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
			
		}
	}
	
	}******/
	
	
}


