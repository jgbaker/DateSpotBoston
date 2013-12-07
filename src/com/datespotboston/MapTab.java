package com.datespotboston;

// MapTab.java

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;			//Add
import com.google.android.gms.maps.model.Marker;			//Add
import com.google.android.gms.maps.model.MarkerOptions;		//Add

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

public class MapTab extends Fragment	{
	GoogleMap mMap;
	SupportMapFragment mMapFragment;
	GoogleMapOptions mMapOptions;
	MapSelectedListener mCallback;
	
	// Container FragmentActivity must implement this interface.
	public interface MapSelectedListener	{
		// stub so far...
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState)	{
		
		
		return inflater.inflate(R.layout.map_layout, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)	{
		super.onActivityCreated(savedInstanceState);
		FragmentManager fm = getChildFragmentManager();
		mMapFragment = (SupportMapFragment) fm.findFragmentById(
				R.id.map_container);
		if(mMapFragment == null)	{
			
			mMapFragment = SupportMapFragment.newInstance();
			fm.beginTransaction().replace(R.id.map_container,
					mMapFragment).commit();
		}		
	}
	
	
	@Override
	public void onDestroyView()	{
		super.onDestroyView();
	}
	
	@Override
	public void onResume()	{
		super.onResume();
		if (mMap == null){
			mMap = mMapFragment.getMap();
			
			
				//This is where we grab the date & time from the android device
				//You can get all these with a Calendar object!
				Calendar current_daytime = Calendar.getInstance();
				int current_day = current_daytime.get(Calendar.DAY_OF_WEEK);
				String current_hour = Integer.toString(current_daytime.get(Calendar.HOUR_OF_DAY));
				String current_minute = Integer.toString(current_daytime.get(Calendar.MINUTE));

				
				if (current_day == 1) {
					current_day = 6;
				} else {
					current_day -= 2;
				}
				
				//Hardcoding the locations in, because we couldn't figure out how to
				//include a text file in an android app
				int num_locations = 48;
				Spots[] places = new Spots[num_locations];
				int iterator = 0;

				Spots b1 = new Spots("Massachusetts State House", "24 Beacon Street", 42.35773,-71.06356,0);
				String[] o_hours1 = {"9","9","9","9","9","0","0"};
				String[] c_hours1 = {"17","17","17","17","17","0","0"};
				b1.setHours(o_hours1,c_hours1);
				places[iterator] = b1;
				iterator++;

				Spots b2 = new Spots("Barnes and Noble @ BU", "660 Beacon Street", 42.34915,-71.09621,0);
				String[] o_hours2 = {"9","9","9","9","9","10","12"};
				String[] c_hours2 = {"21","21","21","21","17","17","17"};
				b2.setHours(o_hours2,c_hours2);
				places[iterator] = b2;
				iterator++;
				
				Spots b3 = new Spots("Charles Hotel", "1 Bennett Street", 42.37226,-71.12267,0);
				String[] o_hours3 = {"0","0","0","0","0","0","0"};
				String[] c_hours3 = {"2359","2359","2359","2359","2359","2359","2359"};
				b3.setHours(o_hours3,c_hours3);
				places[iterator] = b3;
				iterator++;
				
				Spots b4 = new Spots("Boston Public Library: Main Branch", "700 Boylston Street", 42.34948,-71.07774,0);
				String[] o_hours4 = {"9","9","9","9","9","9","1"};
				String[] c_hours4 = {"21","21","21","21","17","17","17"};
				b4.setHours(o_hours4,c_hours4);
				places[iterator] = b4;
				iterator++;
				
				Spots b5 = new Spots("Prudential Center", "800 Boylston Street", 42.34873,-71.08298,0);
				String[] o_hours5 = {"10","10","10","10","10","10","11"};
				String[] c_hours5 = {"21","21","21","21","21","21","18"};
				b5.setHours(o_hours5,c_hours5);
				places[iterator] = b5;
				iterator++;
				
				Spots b6 = new Spots("Cambridgeside Galleria", "100 Cambridgeside Place", 42.36815,-71.07615,0);
				String[] o_hours6 = {"10","10","10","10","10","10","12"};
				String[] c_hours6 = {"21","21","21","21","21","21","19"};
				b6.setHours(o_hours6,c_hours6);
				places[iterator] = b6;
				iterator++;
				
				Spots b7 = new Spots("Boston University College of Arts and Sciences", "725 Commonwealth Avenue", 42.35004,-71.10478,0);
				String[] o_hours7 = {"0","0","0","0","0","0","0"};
				String[] c_hours7 = {"2359","2359","2359","2359","2359","2359","2359"};
				b7.setHours(o_hours7,c_hours7);
				places[iterator] = b7;
				iterator++;
				
				Spots b8 = new Spots("StuVi 2", "33 Harry Agganis Way", 42.35324,-71.11812,0);
				String[] o_hours8 = {"0","0","0","0","0","0","0"};
				String[] c_hours8 = {"2359","2359","2359","2359","2359","2359","2359"};
				b8.setHours(o_hours8,c_hours8);
				places[iterator] = b8;
				iterator++;
				
				Spots b9 = new Spots("Shaws Supermarket (Fenway)", "33 Kilarnock Street", 42.3436,-71.09985,0);
				String[] o_hours9 = {"0","0","0","0","0","0","0"};
				String[] c_hours9 = {"2359","2359","2359","2359","2359","2359","2359"};
				b9.setHours(o_hours9,c_hours9);
				places[iterator] = b9;
				iterator++;
				
				Spots b10 = new Spots("Mount Auburn Hospital", "330 Mount Auburn Street", 42.37441,-71.13378,0);
				String[] o_hours10 = {"0","0","0","0","0","0","0"};
				String[] c_hours10 = {"2359","2359","2359","2359","2359","2359","2359"};
				b10.setHours(o_hours10,c_hours10);
				places[iterator] = b10;
				iterator++;
				
				Spots b11 = new Spots("Quincy Market", "4 South Market Street", 42.35995,-71.05524,0);
				String[] o_hours11 = {"10","10","10","10","10","10","11"};
				String[] c_hours11 = {"21","21","21","21","21","21","18"};
				b11.setHours(o_hours11,c_hours11);
				places[iterator] = b11;
				iterator++;
				
				Spots b12 = new Spots("Stop & Shop", "60 Everett Street", 42.356403,-71.13936,0);
				String[] o_hours12 = {"7","7","7","7","7","7","7"};
				String[] c_hours12 = {"23","23","23","23","23","23","23"};
				b12.setHours(o_hours12,c_hours12);
				places[iterator] = b12;
				iterator++;
				
				Spots b13 = new Spots("Boston Common Visitor Center", "148 Tremont Street", 42.355077,-71.063362,0);
				String[] o_hours13 = {"9","9","9","9","9","9","9"};
				String[] c_hours13 = {"17","17","17","17","17","17","17"};
				b13.setHours(o_hours13,c_hours13);
				places[iterator] = b13;
				iterator++;
				
				Spots b14 = new Spots("Boston Public Library: Honan-Allston Branch", "300 North Harvard Street", 42.360114,-71.128094,0);
				String[] o_hours14 = {"12","10","12","10","9","9","0"};
				String[] c_hours14 = {"20","18","20","18","17","17","0"};
				b14.setHours(o_hours14,c_hours14);
				places[iterator] = b14;
				iterator++;


				Spots b15 = new Spots("Alewife Station", "Alewife Brook Parkway", 42.395034,-71.142483,0);
				String[] o_hours15 = {"530","530","530","530","530","530","530"};
				String[] c_hours15 = {"0","0","0","0","0","0","0"};
				b15.setHours(o_hours15,c_hours15);
				places[iterator] = b15;
				iterator++;
				
				Spots b16 = new Spots("Harvard COOP", "1400 Massachusetts Avenue", 42.373714,-71.119662,0);
				String[] o_hours16 = {"9","9","9","9","9","9","10"};
				String[] c_hours16 = {"22","22","22","22","22","22","21"};
				b16.setHours(o_hours16,c_hours16);
				places[iterator] = b16;
				iterator++;

				Spots b17 = new Spots("Au Bon Pain", "1100 Massachusetts Avenue", 42.327292,-71.063755,0);
				String[] o_hours17 = {"6","6","6","6","6","7","7"};
				String[] c_hours17 = {"20","20","20","20","20","20","19"};
				b17.setHours(o_hours17,c_hours17);
				places[iterator] = b17;
				iterator++;

				Spots b18 = new Spots("Boston Marriott Cambridge", "2 Cambridge Center", 42.362544,-71.084761,0);
				String[] o_hours18 = {"0","0","0","0","0","0","0"};
				String[] c_hours18 = {"2359","2359","2359","2359","2359","2359","2359"};
				b18.setHours(o_hours18,c_hours18);
				places[iterator] = b18;
				iterator++;

				Spots b19 = new Spots("Mapparium", "200 Massachusetts Avenue", 42.345164,-71.086727,0);
				String[] o_hours19 = {"0","10","10","10","10","10","10"};
				String[] c_hours19 = {"0","16","16","16","16","16","16"};
				b19.setHours(o_hours19,c_hours19);
				places[iterator] = b19;
				iterator++;
				
				Spots b20 = new Spots("Lenox Hotel", "61 Exeter Street", 42.349218,-71.079376,0);
				String[] o_hours20 = {"0","0","0","0","0","0","0"};
				String[] c_hours20 = {"2359","2359","2359","2359","2359","2359","2359"};
				b20.setHours(o_hours20,c_hours20);
				places[iterator] = b20;
				iterator++;

				Spots b21 = new Spots("Jurys Hotel", "350 Stuart Street", 42.349158,-71.072440,0);
				String[] o_hours21 = {"0","0","0","0","0","0","0"};
				String[] c_hours21 = {"2359","2359","2359","2359","2359","2359","2359"};
				b21.setHours(o_hours21,c_hours21);
				places[iterator] = b21;
				iterator++;			
				
				Spots b22 = new Spots("Liberty Hotel", "215 Charles Street", 42.361942,-71.070815,0);
				String[] o_hours22 = {"0","0","0","0","0","0","0"};
				String[] c_hours22 = {"2359","2359","2359","2359","2359","2359","2359"};
				b22.setHours(o_hours22,c_hours22);
				places[iterator] = b22;
				iterator++;
				
				Spots b23 = new Spots("Public Toilet", "1 City Hall Square", 42.360353,-71.058320,0);
				String[] o_hours23 = {"0","0","0","0","0","0","0"};
				String[] c_hours23 = {"2359","2359","2359","2359","2359","2359","2359"};
				b23.setHours(o_hours23,c_hours23);
				places[iterator] = b23;
				iterator++;
				
				Spots b24 = new Spots("Public Toilet", "1 1st Avenue/Charlestown Navy Yard", 42.375159,-71.054528,0);
				String[] o_hours24 = {"0","0","0","0","0","0","0"};
				String[] c_hours24 = {"2359","2359","2359","2359","2359","2359","2359"};
				b24.setHours(o_hours24,c_hours24);
				places[iterator] = b24;
				iterator++;
				
				Spots b25 = new Spots("South Station","700 Atlantic Avenue", 42.352140,-71.055043,0);
				String[] o_hours25 = {"5","5","5","5","5","5","5"};
				String[] c_hours25 = {"230","230","230","230","230","230","230"};
				b25.setHours(o_hours25,c_hours25);
				places[iterator] = b25;
				iterator++;
				
				Spots b26 = new Spots("Boston Public Library: Brighton Branch", "40 Academy Hill Road", 42.347808,-71.153348,0);
				String[] o_hours26 = {"12","10","10","12","9","9","0"};
				String[] c_hours26 = {"20","18","18","20","17","17","0"};
				b26.setHours(o_hours26,c_hours26);
				places[iterator] = b26;
				iterator++;

				Spots b27 = new Spots("Boston Public Library: Charlestown Branch", "179 Main Street", 42.375715,-71.064407,0);
				String[] o_hours27 = {"12","10","10","12","9","9","0"};
				String[] c_hours27 = {"20","18","18","20","17","14","0"};
				b27.setHours(o_hours27,c_hours27);
				places[iterator] = b27;
				iterator++;
				
				Spots b28 = new Spots("Boston Public Library: East Boston Branch", "276 Meridian Street", 42.376495,-71.039141,0);
				String[] o_hours28 = {"12","10","10","10","9","9","0"};
				String[] c_hours28 = {"20","18","18","18","17","14","0"};
				b28.setHours(o_hours28,c_hours28);
				places[iterator] = b28;
				iterator++;
				
				Spots b29 = new Spots("Boston Public Library: Faneuil Branch", "419 Faneuil Street", 42.351352,-71.167885,0);
				String[] o_hours29 = {"10","12","10","10","9","9","0"};
				String[] c_hours29 = {"18","20","18","18","17","14","0"};
				b29.setHours(o_hours29,c_hours29);
				places[iterator] = b29;
				iterator++;
				
				Spots b30 = new Spots("Boston Public Library: North End Branch", "25 Parmenter Street", 42.364026,-71.055002,0);
				String[] o_hours30 = {"10","10","12","10","9","10","0"};
				String[] c_hours30 = {"18","18","20","18","17","15","0"};
				b30.setHours(o_hours30,c_hours30);
				places[iterator] = b30;
				iterator++;
				
				Spots b31 = new Spots("Roche Bros Supermarket", "1800 Centre Street", 42.287432,-71.152481,0);
				String[] o_hours31 = {"7","7","7","7","7","7","8"};
				String[] c_hours31 = {"23","23","23","23","23","23","21"};
				b31.setHours(o_hours31,c_hours31);
				places[iterator] = b31;
				iterator++;			
				
				Spots b32 = new Spots("Shaws Supermarket (Packards Corner)", "1065 Commonwealth Avenue", 42.352677,-71.123333,0);
				String[] o_hours32 = {"0","0","0","0","0","0","0"};
				String[] c_hours32 = {"2359","2359","2359","2359","2359","2359","2359"};
				b32.setHours(o_hours32,c_hours32);
				places[iterator] = b32;
				iterator++;
				
				Spots b33 = new Spots("Shaws Supermarket (MIT)", "20 Sidney Street", 42.362349,-71.100211,0);
				String[] o_hours33 = {"7","7","7","7","7","7","7"};
				String[] c_hours33 = {"2359","2359","2359","2359","2359","2359","2359"};
				b33.setHours(o_hours33,c_hours33);
				places[iterator] = b33;
				iterator++;
				
				Spots b34 = new Spots("Boston Public Library: Connolly Branch", "433 Centre Street", 42.294923,-71.057203,0);
				String[] o_hours34 = {"12","10","10","10","9","9","0"};
				String[] c_hours34 = {"20","18","18","18","17","14","0"};
				b34.setHours(o_hours34,c_hours34);
				places[iterator] = b34;
				iterator++;
				
				Spots b35 = new Spots("Boston Public Library: Jamaica Plain Branch", "12 Sedgwick Street", 42.308591,-71.114920,0);
				String[] o_hours35 = {"10","10","10","12","9","9","0"};
				String[] c_hours35 = {"18","18","18","20","17","14","0"};
				b35.setHours(o_hours35,c_hours35);
				places[iterator] = b35;
				iterator++;

				Spots b36 = new Spots("Northeastern University Snell Library", "360 Huntington Avenue", 42.339761,-71.088202,0);
				String[] o_hours36 = {"745","745","745","745","745","9","10"};
				String[] c_hours36 = {"2359","2359","2359","2359","21","22","2359"};
				b36.setHours(o_hours36,c_hours36);
				places[iterator] = b36;
				iterator++;
				
				Spots b37 = new Spots("Starbucks", "468 Broadway", 42.373979,-71.113073,0);
				String[] o_hours37 = {"530","530","530","530","530","7","7"};
				String[] c_hours37 = {"2030","2030","2030","2030","2030","2030","2030"};
				b37.setHours(o_hours37,c_hours37);
				places[iterator] = b37;
				iterator++;
				
				Spots b38 = new Spots("Starbucks", "1380 Massachusetts Avenue", 42.373373,-71.119168,0);
				String[] o_hours38 = {"5","5","5","5","5","530","530"};
				String[] c_hours38 = {"1","1","1","1","1","1","1"};
				b38.setHours(o_hours38,c_hours38);
				places[iterator] = b38;
				iterator++;
				
				Spots b39 = new Spots("Starbucks", "655 Massachusetts Avenue", 42.356621,-71.103785,0);
				String[] o_hours39 = {"530","530","530","530","530","6","6"};
				String[] c_hours39 = {"21","21","21","21","22","21","21"};
				b39.setHours(o_hours39,c_hours39);
				places[iterator] = b39;
				iterator++;
				
				Spots b40 = new Spots("Starbucks", "750 Memorial Drive", 42.357984,-71.115139,0);
				String[] o_hours40 = {"530","530","530","530","530","6","6"};
				String[] c_hours40 = {"21","21","21","21","21","21","21"};
				b40.setHours(o_hours40,c_hours40);
				places[iterator] = b40;
				iterator++;
				
				Spots b41 = new Spots("Starbucks", "84 State Street", 42.359147,-71.055627,0);
				String[] o_hours41 = {"530","530","530","530","530","6","6"};
				String[] c_hours41 = {"21","21","21","21","21","21","21"};
				b41.setHours(o_hours41,c_hours41);
				places[iterator] = b41;
				iterator++;			
				
				Spots b42 = new Spots("Starbucks", "240 Washington Street", 42.357938,-71.057886,0);
				String[] o_hours42 = {"530","530","530","530","530","6","6"};
				String[] c_hours42 = {"21","21","21","21","21","21","21"};
				b42.setHours(o_hours42,c_hours42);
				places[iterator] = b42;
				iterator++;
				
				Spots b43 = new Spots("Starbucks", "165 Newbury Street", 42.350745,-71.078834,0);
				String[] o_hours43 = {"530","530","530","530","530","6","630"};
				String[] c_hours43 = {"21","21","21","21","21","22","21"};
				b43.setHours(o_hours43,c_hours43);
				places[iterator] = b43;
				iterator++;
				
				Spots b44 = new Spots("Starbucks", "273 Huntington Avenue", 42.342279,-71.085577,0);
				String[] o_hours44 = {"530","530","530","530","530","6","6"};
				String[] c_hours44 = {"22","22","22","22","22","22","22"};
				b44.setHours(o_hours44,c_hours44);
				places[iterator] = b44;
				iterator++;
				
				Spots b45 = new Spots("Starbucks", "147 Massachusetts Avenue", 42.346646,-71.087574,0);
				String[] o_hours45 = {"530","530","530","530","530","6","6"};
				String[] c_hours45 = {"2230","2230","2230","2230","2230","2230","2230"};
				b45.setHours(o_hours45,c_hours45);
				places[iterator] = b45;
				iterator++;
				
				Spots b46 = new Spots("Boston University George Sherman Union", "775 Commonwealth Avenue", 42.350686,-71.108994,0);
				String[] o_hours46 = {"7","7","7","7","7","7","9"};
				String[] c_hours46 = {"2359","2359","2359","2359","2","2","2359"};
				b46.setHours(o_hours46,c_hours46);
				places[iterator] = b46;
				iterator++;
				
				Spots b47 = new Spots("Boston Public Library: South Boston Branch", "646 East Broadway", 42.335790,-71.038499,0);
				String[] o_hours47 = {"12","10","10","12","9","9","0"};
				String[] c_hours47 = {"20","18","18","20","17","17","0"};
				b47.setHours(o_hours47,c_hours47);
				places[iterator] = b47;
				iterator++;
				
				Spots b48 = new Spots("Brookline Public Library: Main Branch", "361 Washington Street", 42.334303,-71.121776,0);
				String[] o_hours48 = {"10","10","10","10","10","10","1"};
				String[] c_hours48 = {"21","21","21","21","17","17","17"};
				b48.setHours(o_hours48,c_hours48);
				places[iterator] = b48;
				iterator++;
				
				
				//Check to see which places close within 30 minutes, and which ones are open
				//I used the current date/time to check the status. If this was an android,
				//we would call another method
				//So we'd use the results of that in these variables

				//Once the locations have been placed in the array, it gets easier:
				//we just have to iterate through the and make markers that way!
				//Make a new array for each of the LatLng and Marker objects
				LatLng[] positions = new LatLng[places.length];
				Marker[] marks = new Marker[places.length];
				
				for (int i=0; i<places.length; i++) {
				//Get the latitude and longitude of each place
				String placeName = places[i].getBuildingName();
				positions[i] = new LatLng(places[i].getLatitude(),places[i].getLongitude());  //Add
				
				//Check to see which places close within 30 minutes, and which ones are open
				//I used the current date/time to check the status. If this was an android,
				//e would call another method
				//So we'd use the results of that in these variables
					if (places[i].closeSoon(current_day, current_hour, current_minute)) {
						marks[i] = mMap.addMarker(new MarkerOptions().position(positions[i])
								.title(placeName)
								.snippet(places[i].getAddress() + "\n (Closing soon)")
								.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
						//Set the marker ID into the Spots class
						String temp = marks[i].getId();
						places[i].setMapID(temp);
					} else if (places[i].isOpen(current_day, current_hour, current_minute)) {
						marks[i] = mMap.addMarker(new MarkerOptions().position(positions[i])
								.title(placeName)
								.snippet(places[i].getAddress() + "\n (Open)")
								.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
						String temp = marks[i].getId();
						places[i].setMapID(temp);
					} else {
						marks[i] = mMap.addMarker(new MarkerOptions().position(positions[i])
								.title(placeName)
								.snippet(places[i].getAddress() + "\n (Closed)")
								.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
						String temp = marks[i].getId();
						places[i].setMapID(temp);
					}
			}
				//auto-zooms to Boston on app startup
				final LatLng BOSTON = new LatLng(42.35322,-71.08841);
				mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BOSTON,11));
				
				//enables user locator button
				mMap.setMyLocationEnabled(true);
				
		}
	}
}
