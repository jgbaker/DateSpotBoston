package com.datespotboston;

//MapTab.java

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
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Calendar;
import com.datespotboston.MainActivity;

public class MapTab extends Fragment	{
	static GoogleMap mMap;
	SupportMapFragment mMapFragment;
	GoogleMapOptions mMapOptions;
	MapSelectedListener mCallback;
	static int num_locations = 128;

	static Spots[] places = new Spots[num_locations];
	public static Marker[] marks = new Marker[places.length];

	LatLng[] positions = new LatLng[places.length];
	
	char newState = MainActivity.getState();
    int startSpot;
	int endSpot;

	
	//FragmentActivity must implement this
	public interface MapSelectedListener	{
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
					mMapFragment).commit();}
		
	}
	
	public static void clearMap() {
		mMap.clear();
	}
	
	public static Marker[] returnMarkers(){
		return marks;
		
	}
	
	@Override
	public void onDestroyView()	{
		super.onDestroyView();
		/*Fragment fragment = (getFragmentManager().findFragmentById(R.id.map_container));
		FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
		ft.remove(fragment);
		ft.commit();*/
	}
	
	@Override
	public void onResume()	{
		super.onResume();
		if (mMap == null){
			mMap = mMapFragment.getMap();
			
			
				//Get the date and time from the android device via Calendar
				Calendar current_daytime = Calendar.getInstance();
				int current_day = current_daytime.get(Calendar.DAY_OF_WEEK);
				String current_hour = Integer.toString(current_daytime.get(Calendar.HOUR_OF_DAY));
				String current_minute = Integer.toString(current_daytime.get(Calendar.MINUTE));

				
				if (current_day == 1) {
					current_day = 6;
				} else {
					current_day -= 2;
				}
				
				//Hard Code the Date Spots
				
				int iterator = 0;


				//<!-- Cafe --!>//
				
				Spots g1 = new Spots("Crema Cafe", "27 Brattle Street", "\n617-876-2700",42.373700, -71.120701,0);
                String[] o_hours1 = {"7", "7", "7", "7", "7", "8", "8"};
                String[] c_hours1 = {"21", "21", "21", "21", "21", "21", "21"};
                g1.setHours(o_hours1, c_hours1);
                places[iterator] = g1;
                iterator++;
               
               Spots g2 = new Spots("Boston Common Coffee Co.", "97 Salem Street","\n617-725-0040" ,42.364030, -71.055386,0);
                String[] o_hours2 = {"6", "6", "6", "6", "6", "7", "7"};
                String[] c_hours2 = {"21", "21", "21", "21", "21", "21", "21"};
                g2.setHours(o_hours2, c_hours2);
                places[iterator] = g2;
                iterator++;
               
                Spots g3 = new Spots("Boston Common Coffee Co.", "515 Washington Street", "\n617-542-0595",42.354279, -71.062102,0);
                String[] o_hours3 = {"6", "6", "6", "6", "6", "7", "7"};
                String[] c_hours3 = {"21", "21", "21", "21", "21", "21", "21"};
                g3.setHours(o_hours3, c_hours3);
                places[iterator] = g3;
                iterator++;
               
                Spots g4 = new Spots("Boston Common Coffee Co.", "10 High Street", "\n617-695-9700", 42.35340, -71.056759,0);
                String[] o_hours4 = {"6", "6", "6", "6", "6", "0", "0"};
                String[] c_hours4 = {"18", "18", "18", "18", "18", "0", "0"};
                g4.setHours(o_hours4, c_hours4);
                places[iterator] = g4;
                iterator++;
               
                Spots g5 = new Spots("Zume's Coffee House", "221 Main Street", "\n617-242-0038",  42.376585, -71.065514,0);
                String[] o_hours5 = {"6", "6", "6", "6", "6", "7", "7"};
                String[] c_hours5 = {"18", "18", "18", "18", "18", "18", "18"};
                g5.setHours(o_hours5, c_hours5);
                places[iterator] = g5;
                iterator++;
               
                Spots g6 = new Spots("Equal Exchange Cafe", "226 Causeway Street", "\n617-372-8777",42.366709, -71.059442,0);
                String[] o_hours6 = {"7", "7", "7", "7", "7", "8", "9"};
                String[] c_hours6 = {"19", "19", "19", "19", "19", "17", "16"};
                g6.setHours(o_hours6, c_hours6);
                places[iterator] = g6;
                iterator++;
               
                Spots g7 = new Spots("Simon's Coffee Shop", "1736 Massachusetts Avenue", "\n617-497-7766", 42.384542, -71.119566,0);
                String[] o_hours7 = {"7", "7", "7", "7", "7", "8", "8"};
                String[] c_hours7 = {"20", "20", "20", "20", "20", "20", "20"};
                g7.setHours(o_hours7, c_hours7);
                places[iterator] = g7;
                iterator++;
               
                Spots g8 = new Spots("Wired Puppy", "250 Newbury Street", "\n857-366-4655", 42.349363, -71.082573, 0);
                String[] o_hours8 = {"630", "630", "630", "630", "630", "630", "630"};
                String[] c_hours8 = {"1930", "1930", "1930", "1930", "1930", "1930", "1930"};
                g8.setHours(o_hours8, c_hours8);
                places[iterator] = g8;
                iterator++;
               
                Spots g9 = new Spots("Cafenation", "380 Washington Street", "\n617-783-4514", 42.349156, -71.154156,0);
                String[] o_hours9 = {"7", "7", "7", "7", "7", "8", "8"};
                String[] c_hours9 = {"18", "18", "18", "18", "18", "18", "18"};
                g9.setHours(o_hours9, c_hours9);
                places[iterator] = g9;
                iterator++;
               
                Spots g10 = new Spots("Ula Cafe", "284 Armory Street", "\n617-524-7890",  42.314766, -71.104524,0);
                String[] o_hours10 = {"7", "7", "7", "7", "7", "8", "9"};
                String[] c_hours10 = {"19", "19", "19", "19", "19", "19", "16"};
                g10.setHours(o_hours10, c_hours10);
                places[iterator] = g10;
                iterator++;
               
                Spots g11 = new Spots("P.S. Gourmet Coffee", "106 Dorchester Street", "\n617-269-4020 ", 42.335342, -71.045773,0);
                String[] o_hours11 = {"6", "6", "6", "6", "6", "6", "6"};
                String[] c_hours11 = {"20", "20", "20", "20", "20", "20", "20"};
                g11.setHours(o_hours11, c_hours11);
                places[iterator] = g11;
                iterator++;
               
                Spots g12 = new Spots("1369 Coffee House", "1369 Cambridge Street", "\n617-576-1369", 42.373796, -71.100318,0);
                String[] o_hours12 = {"7", "7", "7", "7", "7", "8", "8"};
                String[] c_hours12 = {"22", "22", "22", "22", "23", "23", "22"};
                g12.setHours(o_hours12, c_hours12);
                places[iterator] = g12;
                iterator++;
               
                Spots g13 = new Spots("1369 Coffee House", "757 Massachusetts Avenue", "\n617-576-4600", 42.366598, -71.105297,0);
                String[] o_hours13 = {"7", "7", "7", "7", "7", "8", "8"};
                String[] c_hours13 = {"22", "22", "22", "22", "23", "23", "22"};
                g13.setHours(o_hours13, c_hours13);
                places[iterator] = g13;
                iterator++;

                Spots g14 = new Spots("Espresso Love", "33 Broad Street", "\n857-284-7462" ,42.358544, -71.054399, 0);
                String[] o_hours14 = {"630", "630", "630", "630", "630", "0", "0"};
                String[] c_hours14 = {"18", "18", "18", "18", "18", "0", "0"};
                g14.setHours(o_hours14, c_hours14);
                places[iterator] = g14;
                iterator++;
               
                Spots g15 = new Spots("Sip Cafe", "00 Post Office Square", "\n617-338-3080", 42.356736, -71.056437, 0);
                String[] o_hours15 = {"630", "630", "630", "630", "630", "0", "0"};
                String[] c_hours15 = {"17", "17", "17", "17", "17", "0", "0"};
                g15.setHours(o_hours15, c_hours15);
                places[iterator] = g15;
                iterator++;
               
                Spots g16 = new Spots("Kookoo Cafe", "7 Station Street", "\n617-730-5525", 42.332614, -71.117828,0);
                String[] o_hours16 = {"7", "7", "7", "7", "7", "8", "0"};
                String[] c_hours16 = {"18", "18", "18", "18", "18", "17", "0"};
                g16.setHours(o_hours16, c_hours16);
                places[iterator] = g16;
                iterator++;
				
				
				//<!-- Restaurants --!>//

                Spots g17 = new Spots("Beijing Cafe", "728 Commonwealth Ave", "617-859-3925", 42.349717, -71.106424,0);
                String[] o_hours17 = {"11", "11", "11", "11", "11", "12", "12"};
                String[] c_hours17 = {"2230", "2230", "2230", "2230", "23", "23", "2230"};
                g17.setHours(o_hours17,c_hours17);
                places[iterator] = g17;
                iterator++;

                Spots g18 = new Spots("The Elephant Walk", "900 Beacon St", "617-247-1500",42.346661,-71.105662,0);
                String[] o_hours18 = {"1130", "1130", "1130", "1130", "1130", "17", "1130"};
                String[] c_hours18 = {"22", "22", "22", "22", "23", "23", "22"};
                g18.setHours(o_hours18,c_hours18);
                places[iterator] = g18;
                iterator++;

                Spots g19 = new Spots("Audubon Circle Restaurant Bar", "838 Beacon St", "617-421-1910", 42.347325, -71.103044,0);
                String[] o_hours19 = {"1130", "1130", "1130", "1130", "1130", "11", "11"};
                String[] c_hours19 = {"1", "1", "1", "1", "1", "1", "1"};
                g19.setHours(o_hours19,c_hours19);
                places[iterator] = g19;
                iterator++;
               
                Spots g20 = new Spots("Sol Azteca", "914 Beacon St", "617-262-0909",  42.346520, -71.106193,0);
                String[] o_hours20 = {"17", "17", "17", "17", "17", "17", "17"};
                String[] c_hours20 = {"22", "22", "22", "22", "23", "23", "22"};
                g20.setHours(o_hours20,c_hours20);
                places[iterator] = g20;
                iterator++;

                Spots g21 = new Spots("Maluken and Sushi Express", "1038 Beacon St", "617-738-5658", 42.345884, -71.108690,0);
                String[] o_hours21 = {"1145", "1145", "1145", "1145", "1145", "1145", "1145"};
                String[] c_hours21 = {"2230", "2230", "2230", "2230", "23", "23", "2230"};
                g21.setHours(o_hours21,c_hours21);
                places[iterator] = g21;
                iterator++;           
               
                Spots g22 = new Spots("Bistro du Midi", "272 Boylston St", "617-426-7878", 42.352068, -71.069345,0);
                String[] o_hours22 = {"1130", "1130", "1130", "1130", "1130", "1130", "1130"};
                String[] c_hours22 = {"22", "22", "22", "22", "22", "22", "22"};
                g22.setHours(o_hours22,c_hours22);
                places[iterator] = g22;
                iterator++;
               
                Spots g23 = new Spots("jm Curley", "21 Temple Pl", "617-338-5333", 42.355262, -71.062315,0);
                String[] o_hours23 = {"1130", "1130", "1130", "1130", "1130", "17", "15"};
                String[] c_hours23 = {"2", "2", "2", "2", "2", "2", "22"};
                g23.setHours(o_hours23,c_hours23);
                places[iterator] = g23;
                iterator++;
               
                Spots g24 = new Spots("Marliave", "10 Bosworth St", "617-422-0004",42.356901, -71.060201,0);
                String[] o_hours24 = {"11", "11", "11", "11", "11", "11", "11"};
                String[] c_hours24 = {"22", "22", "22", "22", "22", "22", "22"};
                g24.setHours(o_hours24,c_hours24);
                places[iterator] = g24;
                iterator++;
               
                Spots g25 = new Spots("B Good", "272 Newbury St", "617-236-0440", 42.349248, -71.083491,0);
                String[] o_hours25 = {"11", "11", "11", "11", "11", "11", "11"};
                String[] c_hours25 = {"21", "21", "21", "21", "21", "22", "21"};
                g25.setHours(o_hours25,c_hours25);
                places[iterator] = g25;
                iterator++;
               
                Spots g26 = new Spots("Falafel King", "48 Winter St", "617-338-8355",  42.356013, -71.061821,0);
                String[] o_hours26 = {"11", "11", "11", "11", "11", "11", "0"};
                String[] c_hours26 = {"18", "18", "18", "18", "18", "1530", "0"};
                g26.setHours(o_hours26,c_hours26);
                places[iterator] = g26;
                iterator++;

                Spots g27 = new Spots("Hei La Moon", "88 Beach St", "617-338-8813", 42.351026, -71.058812,0);
                String[] o_hours27 = {"830", "830", "830", "830", "830", "830", "830"};
                String[] c_hours27 = {"23", "23", "23", "23", "23", "23", "23"};
                g27.setHours(o_hours27,c_hours27);
                places[iterator] = g27;
                iterator++;
               
                Spots g28 = new Spots("Alfredo's", "229 Brighton Ave", "617-562-8222", 42.353599, -71.135729,0);
                String[] o_hours28 = {"11", "11", "11", "11", "11", "11", "11"};
                String[] c_hours28 = {"22", "22", "22", "22", "22", "22", "22"};
                g28.setHours(o_hours28,c_hours28);
                places[iterator] = g28;
                iterator++;
               
                Spots g29 = new Spots("A@Time", "433 Cambridge St", "617-202-5840", 42.354935, -71.134383,0);
                String[] o_hours29 = {"15", "1130", "1130", "1130", "1130", "12", "12"};
                String[] c_hours29 = {"22", "22", "22", "22", "22", "22", "22"};
                g29.setHours(o_hours29,c_hours29);
                places[iterator] = g29;
                iterator++;
               
                Spots g30 = new Spots("Genki Ya Sushi", "398 Harvard St", "617-277-3100", 42.344974, -71.126664,0);
                String[] o_hours30 = {"1130", "1130", "1130", "1130", "1130", "1130", "1130"};
                String[] c_hours30 = {"2230", "2230", "2230", "2230", "23", "23", "22"};
                g30.setHours(o_hours30,c_hours30);
                places[iterator] = g30;
                iterator++;
               
                Spots g31 = new Spots("Bondir Restaurant", "279 Broadway", "617-661-0009",  42.368136, -71.097816,0);
                String[] o_hours31 = {"17", "0", "17", "17", "17", "17", "17"};
                String[] c_hours31 = {"22", "0", "22", "22", "22", "22", "22"};
                g31.setHours(o_hours31,c_hours31);
                places[iterator] = g31;
                iterator++;           
               
                Spots g32 = new Spots("Life Alive", "765 Massachusetts Ave", "617-354-5433", 42.366618, -71.105539,0);
                String[] o_hours32 = {"8", "8", "8", "8", "8", "8", "11"};
                String[] c_hours32 = {"22", "22", "22", "22", "22", "22", "19"};
                g32.setHours(o_hours32,c_hours32);
                places[iterator] = g32;
                iterator++;
               
                Spots g33 = new Spots("Cuchi Cuchi", "795 Main St", "617-864-2929", 42.363336, -71.097138,0);
                String[] o_hours33 = {"1730", "1730", "1730", "1730", "1730", "1730", "1730"};
                String[] c_hours33 = {"1", "1", "1", "1", "1", "1", "2359"};
                g33.setHours(o_hours33,c_hours33);
                places[iterator] = g33;
                iterator++;
               
                Spots g34 = new Spots("Felipe's Taqueria", "83 Mt Auburn St", "617-354-9944", 42.372531, -71.119776,0);
                String[] o_hours34 =  {"11", "11", "11", "11", "11", "11", "11"};
                String[] c_hours34 = {"2359", "2359", "2359", "2", "2", "2", "2359"};
                g34.setHours(o_hours34,c_hours34);
                places[iterator] = g34;
                iterator++;
               
                Spots g35 = new Spots("Veggie Galaxy", "450 Massachusetts Ave", "617-497-1513",  42.363562, -71.100974,0);
                String[] o_hours35 = {"7", "7", "7", "7", "7", "9", "9"};
                String[] c_hours35 = {"22", "22", "22", "22", "23", "23", "23"};
                g35.setHours(o_hours35,c_hours35);
                places[iterator] = g35;
                iterator++;

                Spots g36 = new Spots("Mamma Maria", "3 N Square", "617-523-0077", 42.364038, -71.053332,0);
                String[] o_hours36 = {"17", "17", "17", "17", "17", "17", "17"};
                String[] c_hours36 = {"22", "22", "22", "22", "23", "23", "22"};
                g36.setHours(o_hours36,c_hours36);
                places[iterator] = g36;
                iterator++;
               
                Spots g37 = new Spots("Giacomo's Restaurant", "355 Hannover St", "617-523-9026", 42.364605, -71.053501,0);
                String[] o_hours37 = {"1630", "1630", "1630", "1630", "17", "17", "16"};
                String[] c_hours37 = {"22", "22", "22", "22", "23", "23", "2130"};
                g37.setHours(o_hours37,c_hours37);
                places[iterator] = g37;
                iterator++;
               
                Spots g38 = new Spots("Goody Glover's", "50 Salem St", "617-367-6444", 42.363110, -71.056247,0);
                String[] o_hours38 = {"16", "16", "16", "11", "11", "11", "11"};
                String[] c_hours38 = {"1", "1", "1", "1", "1", "1", "1"};
                g38.setHours(o_hours38,c_hours38);
                places[iterator] = g38;
				iterator++;
				
		          
		           //Dessert
				

		           Spots g39 = new Spots("Angora Café", "1027 Commonwealth Ave","617-232-1757 ", 42.352169, -71.121669,0);
		           String[] o_hours39 =  {"8", "8", "8", "8", "8", "9", "9"}    ;
		           String[] c_hours39 =  {"2330", "2330", "2330", "2330", "2330", "2330", "2330"};
		           g39.setHours(o_hours39, c_hours39);
		           places[iterator] = g39;
		           iterator++;

		           Spots g40 = new Spots("Mixx Frozen Yogurt", "66 Brighton Ave",  "617-782-6499", 42.352867,-71.128578,0 );
		           String[] o_hours40 =  {"2", "2", "2", "2", "11", "11", "11"}    ;
		           String[] c_hours40 =  {"23", "23", "23", "23", "23", "23", "23"};
		           g40.setHours(o_hours40, c_hours40);
		           places[iterator] = g40;
		           iterator++;

		           Spots g41 = new Spots("Red Mango", "334 Massachusetts Ave", "857-366-4116", 42.342892,-71.084311,0);
		           String[] o_hours41 =  {"11", "11", "11", "11", "11", "11", "11"}    ;
		           String[] c_hours41 =  {"23", "23", "23", "23", "2359", "2359", "23"};
		           g41.setHours(o_hours41, c_hours41);
		           places[iterator] = g41;
		           iterator++;

		           Spots g42 = new Spots("Pinkberry", "288 Newbury St",  " 617-2362294 ",42.349394,-71.084526,0 );
		           String[] o_hours42 =  {"10", "10", "10", "10", "10", "10", "10"}    ;
		           String[] c_hours42 =  {"23", "23", "23", "23", "23", "23", "23"};
		           g42.setHours(o_hours42, c_hours42);
		           places[iterator] = g42;
		           iterator++;

		           Spots g43 = new Spots("Zinga", "508 Commonwealth Ave"," 857-263-8496 ",42.349141,-71.095448,0);
		           String[] o_hours43 =  {"11", "11", "11", "11", "11", "11", "11"}    ;
		           String[] c_hours43 =  {"22", "22", "22", "23", "23", "23", "22"};
		           g43.setHours(o_hours43, c_hours43);
		           places[iterator] = g43;
		           iterator++;

		           Spots g44 = new Spots("BerryLine", "1377 Boylston St", "617-236-0082 ",  42.344272,-71.100812,0 );
		           String[] o_hours44 =  {"11", "11", "11", "11", "11", "11", "11"};
		           String[] c_hours44 =  {"21", "21", "21", "21", "22", "22", "21"};
		           g44.setHours(o_hours44, c_hours44);
		           places[iterator] = g44;
		           iterator++;

		           Spots g45 = new Spots("J.P. Licks Homemade Ice Cream ", "659 Centre St, Jamaica Plain", "617-524-6740", 42.313259,-71.114244,0 );
		           String[] o_hours45 =  {"6", "6", "6", "6", "6", "6", "6"};
		           String[] c_hours45 =  {"2359", "2359", "2359", "2359", "2359", "2359", "2359"};
		           g45.setHours(o_hours45, c_hours45);
		           places[iterator] = g45;
		           iterator++;

		           Spots g46 = new Spots("Ben & Jerry's", "174 Newbury St",  "617-536-5456" ,42.350806,-71.079118,0 );
		           String[] o_hours46 =  {"11", "11", "11", "11", "11", "11", "11"}    ;
		           String[] c_hours46 =  {"22", "22", "22", "22", "22", "22", "22"};
		           g46.setHours(o_hours46, c_hours46);
		           places[iterator] = g46;
		           iterator++;

		           Spots g47 = new Spots("Tasti D-Lite", "205 Newbury St", "857-233-2180",42.350568,-71.080856 ,0  );
		           String[] o_hours47 =  {"12", "12", "12", "12", "12", "12", "12"}    ;
		           String[] c_hours47 =  {"20", "20", "20", "20", "20", "20", "20"};
		           g47.setHours(o_hours47, c_hours47);
		           places[iterator] = g47;
		           iterator++;

		           Spots g48 = new Spots("Cold Stone Creamery", "201 Brookline Ave","617-425-6360", 42.344875,-71.101863,0);
		           String[] o_hours48 =  {"12", "12", "12", "12", "12", "12", "12"}    ;
		           String[] c_hours48 =  {"21", "21", "21", "21", "22", "22", "21"};
		           g48.setHours(o_hours48, c_hours48);
		           places[iterator] = g48;
		           iterator++;

		           Spots g49 = new Spots("Andalus Pizza & Cafe", "153 Sutherland Rd", "617-277-5400" ,42.341449,-71.146924,0 );
		           String[] o_hours49 =  {"10", "10", "10", "10", "10", "10", "10"}    ;
		           String[] c_hours49 =  {"2359", "2359", "2359", "2359", "2359", "2359", "2359"};
		           g49.setHours(o_hours49, c_hours49);
		           places[iterator] = g49;
		           iterator++;

		           Spots g50 = new Spots("Café Podima", "168 Cambridge St", "617-227-4959 "  ,42.36162,-71.064999,0);
		           String[] o_hours50 =  {"1030", "1030", "1030", "1030", "1030", "1030", "1030"}    ;
		           String[] c_hours50=  {"2230", "2230", "2230", "2230", "2230", "2230", "2230"};
		           g50.setHours(o_hours50, c_hours50);
		           places[iterator] = g50;
		           iterator++;

		           Spots g51 = new Spots("Café 472", "472 Commonwealth Ave",  "617-236-4949 ",42.348966,-71.093602,0 );
		           String[] o_hours51 =  {"10", "10", "10", "10", "10", "10", "10"}    ;
		           String[] c_hours51 =  {"2359", "2359", "2359", "2359", "2359", "2359", "2359"};
		           g51.setHours(o_hours51, c_hours51);
		           places[iterator] = g51;
		           iterator++;

		           Spots g52 = new Spots("Emack & Bolio’s Ice Cream", "290 Newbury St","617-236-4949 " ,42.349585,-71.084418,0);
		           String[] o_hours52 =  {"11", "11", "11", "11", "11", "11", "11"}    ;
		           String[] c_hours52 =  {"22", "22", "22", "22", "22", "22", "22"};
		           g52.setHours(o_hours52, c_hours52);
		           places[iterator] = g52;
		           iterator++;

		           Spots g53 = new Spots("Pinkberry", "800 Boylston St", "617-536-7127 " ,42.347888, -71.081929 ,0 );
		           String[] o_hours53 =  {"9", "9", "9", "9", "9", "9", "9"};
		           String[] c_hours53 =  {"23", "23", "23", "23", "23", "23", "22"};
		           g53.setHours(o_hours53, c_hours53);
		           places[iterator] = g53;
		           iterator++;
		           
		           
		       	
					// Entertainment
					
					Spots g54 = new Spots("Wang Theater", "270 Tremont St", "617-482-9393",  42.350508, -71.065016,0);
	                String[] o_hours54 = {"12", "12", "12", "12", "12", "12", "0"};
	                String[] c_hours54 = {"18", "18", "18", "18", "18", "18", "0"};
	                g54.setHours(o_hours54,c_hours54);
	                places[iterator] = g54;
	                iterator++;
	               
	                Spots g55 = new Spots("Improv Asylum", "216 Hanover St", "617-263-6887",  42.362936, -71.055459,0);
	                String[] o_hours55 = {"0", "12", "12", "12", "12", "12", "12"};
	                String[] c_hours55 = {"0", "21", "21", "21", "23", "2359", "21"};
	                g55.setHours(o_hours55,c_hours55);
	                places[iterator] = g55;
	                iterator++;
	               
	                Spots g56 = new Spots("Boston Opera House", "539 Washington St", "617-259-3400",  42.353981, -71.062274,0);
	                String[] o_hours56 = {"10", "10", "10", "10", "10", "0", "0"};
	                String[] c_hours56 = {"17", "17", "17", "17", "17", "0", "0"};
	                g56.setHours(o_hours56,c_hours56);
	                places[iterator] = g56;
	                iterator++;
	               
	                Spots g57 = new Spots("Howl at the Moon Boston", "184 High St", "617-292-4695", 42.356530, -71.052726,0);
	                String[] o_hours57 = {"16", "16", "16", "16", "16", "17", "19"};
	                String[] c_hours57 = {"2", "2", "2", "2", "2", "2", "2"};
	                g57.setHours(o_hours57,c_hours57);
	                places[iterator] = g57;
	                iterator++;
	               
	                Spots g58 = new Spots("Regal Fenway Stadium 13 & RPX", "201 Brookline Avenue", "617-424-6111", 42.344339, -71.101614,0);
	                String[] o_hours58 = {"11", "11", "11", "11", "11", "11", "11"};
	                String[] c_hours58 = {"2330", "2330", "2330", "2330", "2330", "2330", "2330"};
	                g58.setHours(o_hours58,c_hours58);
	                places[iterator] = g58;
	                iterator++;
	               
	                Spots g59 = new Spots("Coolidge Corner Theater", "290 Harvard St", "617-734-2501", 42.342745, -71.122437,0);
	                String[] o_hours59 = {"0", "0", "0", "0", "0", "0", "0"};
	                String[] c_hours59 = {"2359", "2359", "2359", "2359", "2359", "2359", "2359"};
	                g59.setHours(o_hours59,c_hours59);
	                places[iterator] = g59;
	                iterator++;
	               
	                Spots g60 = new Spots("AMC Loews Boston Common 19", "175 Tremont St", "617-423-5801",  42.353200, -71.064174,0);
	                String[] o_hours60 = {"0", "0", "0", "0", "0", "0", "0"};
	                String[] c_hours60 = {"2359", "2359", "2359", "2359", "2359", "2359", "2359"};
	                g60.setHours(o_hours60,c_hours60);
	                places[iterator] = g60;
	                iterator++;
	               
	                Spots g61 = new Spots("Simons IMAX Theater", "1 Central Wharf", "617-973-5206",  42.358877, -71.050377,0);
	                String[] o_hours61 = {"9", "9", "9", "9", "9", "9", "9"};
	                String[] c_hours61 = {"19", "19", "19", "19", "19", "19", "19"};
	                g61.setHours(o_hours61,c_hours61);
	                places[iterator] = g61;
	                iterator++;
	               
	                Spots g62 = new Spots("Museum of Science", "1 Science Park", "617-723-2500",  42.367748, -71.070848,0);
	                String[] o_hours62 = {"9", "9", "9", "9", "9", "9", "0"};
	                String[] c_hours62 = {"17", "17", "17", "17", "21", "17", "0"};
	                g62.setHours(o_hours62,c_hours62);
	                places[iterator] = g62;
	                iterator++;
	               
	                Spots g63 = new Spots("Museum of Fine Arts, Boston", "465 Huntington Ave", "617-267-9300",42.339371, -71.093992,0);
	                String[] o_hours63 = {"10", "10", "10", "10", "10", "10", "10"};
	                String[] c_hours63 = {"1645", "1645", "2145", "2145", "2145", "1645", "1645"};
	                g63.setHours(o_hours63,c_hours63);
	                places[iterator] = g63;
	                iterator++;
					
					Spots g64 = new Spots("Paradise Rock Club", "967 Commonwealth Ave", "617-562-8800", 42.351805, -71.119591,0);
					String[] o_hours64 = {"12", "12", "12", "12", "12", "12", "0"};
					String[] c_hours64 ={"18", "18", "18", "18", "18", "18", "0"};
					g64.setHours(o_hours64,c_hours64);
					places[iterator] = g64;
					iterator++;
					
					Spots g65 = new Spots("Middle East Restaurant and Nightclub", "480 Massachusetts Ave", "617-864-3278",  42.363877, -71.101346,0);
					String[] o_hours65 = {"11", "11", "11", "11", "1", "11", "11"};
					String[] c_hours65 = {"11", "11", "11", "11", "11", "11", "11"};
					g65.setHours(o_hours65,c_hours65);
					places[iterator] = g65;
					iterator++;
					
					Spots g66 = new Spots("Brighton Music Hall", "158 Brighton Ave","617-779-0140",  42.352895, -71.132562,0);
					String[] o_hours66 = {"0", "0", "0", "0", "0", "0", "0"};
					String[] c_hours66 = {"2359", "2359", "2359", "2359", "2359", "2359", "2359"};
					g66.setHours(o_hours66,c_hours66);
					places[iterator] = g66;
					iterator++;
					
					Spots g67 = new Spots("Orpheum Theater", "1 Hamilton Pl","617-482-0106", 42.356257, -71.061016,0);
					String[] o_hours67 = {"10", "10", "10", "10", "10", "10", "0"};
					String[] c_hours67 = {"17", "17", "17", "17", "17", "17", "0"};
					g67.setHours(o_hours67,c_hours67);
					places[iterator] = g67;
					iterator++;
					
					Spots g68 = new Spots("Cafe 939", "939 Boylston St", "617-747-6038",  42.348157, -71.084956,0);
					String[] o_hours68 = {"730", "730", "730", "730", "730", "1030", "1030"};
					String[] c_hours68 = {"21", "21", "23", "23", "23", "23", "21"};
					g68.setHours(o_hours68,c_hours68);
					places[iterator] = g68;
					iterator++;
					
					Spots g69 = new Spots("The Comedy Studio", "1238 Massachusetts Ave", "617-661-6507",  42.372397, -71.115980,0);
					String[] o_hours69 = {"8", "8", "8", "8", "8", "8", "8"};
					String[] c_hours69 = {"22", "22", "22", "22", "22", "22", "22"};
					g69.setHours(o_hours69,c_hours69);
					places[iterator] = g69;
					iterator++;
					
					Spots g70 = new Spots("Brattle Theatre", "40 Brattle St","617-876-6837",  42.373587, -71.121286,0);
					String[] o_hours70 = {"16", "16", "16", "16", "16", "12", "12"};
					String[] c_hours70 ={"2359", "2359", "2359", "2359", "2359", "2359", "2359"};
					g70.setHours(o_hours70,c_hours70);
					places[iterator] = g70;
					iterator++;
					
					Spots g71 = new Spots("O'Brien's Pub", "3 Harvard Ave", "617-782-6245", 42.355270, -71.132822,0);
					String[] o_hours71 = {"0", "0", "0", "0", "0", "0", "0"};
					String[] c_hours71 = {"2359", "2359", "2359", "2359", "2359", "2359", "2359"};
					g71.setHours(o_hours71,c_hours71);
					places[iterator] = g71;
					iterator++;
					
					Spots g72 = new Spots("Copperfield's Bar", "98 Brookline Ave", "617-247-8605", 42.346159, -71.099506,0);
					String[] o_hours72 = {"0", "0", "0", "0", "0", "0", "0"};
					String[] c_hours72 = {"2359", "2359", "2359", "2359", "2359", "2359", "2359"};
					g72.setHours(o_hours72,c_hours72);
					places[iterator] = g72;
					iterator++;
					
					Spots g73 = new Spots("Boston Symphony Orchestra", "301 Massachusetts Ave", "617-266-1492",  42.342979, -71.085690,0);
					String[] o_hours73 = {"10", "10", "10", "10", "10", "12", "0"};
					String[] c_hours73 = {"18", "18", "18", "18", "18", "18", "0"};
					g73.setHours(o_hours73,c_hours73);
					places[iterator] = g73;
					iterator++;
		           
		           
				
				//<!-- Recreation --!>//
				
				Spots g74 = new Spots("Community Rowing, Inc.", "20 Nonantum Road", "617-779-8267", 42.366915,-71.165314,0);
				String[] o_hours74 = {"5","5","5","5","5","5","5"};
				String[] c_hours74 = {"21","21","21","21","21","16","16"};
				g74.setHours(o_hours74,c_hours74);
				places[iterator] = g74;
				iterator++;


				Spots g75 = new Spots("The Skating Club of Boston", "1240 Soldiers Field Road", "617-782-5900", 42.373257,-71.136875,0);
				String[] o_hours75 = {"0","940","0","0","0","1530","0"};
				String[] c_hours75 = {"2359","2230","2359","2359","2359","17","2359"};
				g75.setHours(o_hours75,c_hours75);
				places[iterator] = g75;
				iterator++;


				Spots g76 = new Spots("Lucky Strike Lanes", "145 Ipswich Street", "818-933-3752", 42.356514,-71.094589,0);
				String[] o_hours76 = {"11","11","11","11","11","11","12"};
				String[] c_hours76 = {"2","2","2","2","2","2","2"};
				g76.setHours(o_hours76,c_hours76);
				places[iterator] = g76;
				iterator++;	


				Spots g77 = new Spots("New England Aquarium", "1 Central Wharf", "617-973-5200", 42.367423,-71.049328,0);
				String[] o_hours77 = {"9","9","9","9","9","9","9"};
				String[] c_hours77 = {"17","17","17","17","17","18","18"};
				g77.setHours(o_hours77,c_hours77);
				places[iterator] = g77;
				iterator++;


				Spots g78 = new Spots("The Esplanade", "Go for a walk", "617-227-0365", 42.356134,-71.076422,0);
				String[] o_hours78 = {"0","0","0","0","0","0","0"};
				String[] c_hours78 = {"2359","2359","2359","2359","2359","2359","2359"};
				g78.setHours(o_hours78,c_hours78);
				places[iterator] = g78;
				iterator++;


				Spots g79 = new Spots("Starbucks", "273 Huntington Avenue", "617-536-6501", 42.342279,-71.085577,0);
				String[] o_hours79 = {"530","530","530","530","530","6","6"};
				String[] c_hours79 = {"22","22","22","22","22","22","22"};
				g79.setHours(o_hours79,c_hours79);
				places[iterator] = g79;
				iterator++;


				Spots g80 = new Spots("Back Bay Fens", "The Fens", " ",42.342559,-71.094246,0);
				String[] o_hours80 = {"0","0","0","0","0","0","0"};
				String[] c_hours80 = {"2359","2359","2359","2359","2359","2359","2359"};
				g80.setHours(o_hours80,c_hours80);
				places[iterator] = g80;
				iterator++;


				Spots g81 = new Spots("Jamaica Pond Park", "507 Jamaicaway", " ", 42.318828,-71.119652,0);
				String[] o_hours81 = {"0","0","0","0","0","0","0"};
				String[] c_hours81 = {"2359","2359","2359","2359","2359","2359","2359"};
				g81.setHours(o_hours81,c_hours81);
				places[iterator] = g81;
				iterator++;


				Spots g82 = new Spots("Fenway Park", "4 Yawkey Way", "877-733-7699", 42.350425,-71.097193,0);
				String[] o_hours82 = {"0","0","0","0","0","0","0"};
				String[] c_hours82 = {"2359","2359","2359","2359","2359","2359","2359"};
				g82.setHours(o_hours82,c_hours82);
				places[iterator] = g82;
				iterator++;


				Spots g83 = new Spots("TD Garden", "100 Legends Way", "617-624-1050", 42.366345,-71.061695,0);
				String[] o_hours83 = {"0","0","0","0","0","0","0"};
				String[] c_hours83 = {"2359","2359","2359","2359","2359","2359","2359"};
				g83.setHours(o_hours83,c_hours83);
				places[iterator] = g83;
				iterator++;


				Spots g84 = new Spots("Kings", "50 Dalton Street", "617-266-2695", 42.347793,-71.085362,0);
				String[] o_hours84 = {"12","12","12","12","12","12","12"};
				String[] c_hours84 = {"1","1","1","1","1","2","23"};
				g84.setHours(o_hours84,c_hours84);
				places[iterator] = g84;
				iterator++;


				Spots g85 = new Spots("Boston Duck Tours", "4 Copley Place #4155", "617-267-3825", 42.347999,-71.078753,0);
				String[] o_hours85 = {"0","0","0","0","0","0","0"};
				String[] c_hours85 = {"2359","2359","2359","2359","2359","2359","2359"};
				g85.setHours(o_hours85,c_hours85);
				places[iterator] = g85;
				iterator++;


				Spots g86 = new Spots("Boston Common Frog Pond", "Boston Common", "617-635-2120", 42.365393,-71.06678,0);
				String[] o_hours86 = {"0","0","0","0","0","0","0"};
				String[] c_hours86 = {"2359","2359","2359","2359","2359","2359","2359"};
				g86.setHours(o_hours86,c_hours86);
				places[iterator] = g86;
				iterator++;


				Spots g87 = new Spots("Copley Square", "560 Boylston Street", " ", 42.351694,-71.076221,0);
				String[] o_hours87 = {"0","0","0","0","0","0","0"};
				String[] c_hours87 = {"2359","2359","2359","2359","2359","2359","2359"};
				g87.setHours(o_hours87,c_hours87);
				places[iterator] = g87;
				iterator++;


				Spots g88 = new Spots("Charles River Canoe & Kayak", "1071 Soldiers Field Road", "617-462-2513",  42.371037,-71.130638,0);
				String[] o_hours88 = {"0","0","0","0","0","0","0"};
				String[] c_hours88 = {"2359","2359","2359","2359","2359","2359","2359"};
				g88.setHours(o_hours88,c_hours88);
				places[iterator] = g88;
				iterator++;
				
				
				
				//Shopping

				Spots g89 = new Spots("The Shops at Prudential Center", "800 Boylston St"," ",42.348934,-71.082573,0);
				String[] o_hours89 = {"10", "10", "10", "10", "10", "10","11"};
				String[] c_hours89 = {"21","21", "21", "21", "21", "21","18"};
				g89.setHours(o_hours89, c_hours89);
				places[iterator] = g89;
				iterator++;


				Spots g90 = new Spots("The Mall at Chestnut Hill", "199 Boylston St"," ", 42.321731,-71.176021,0);
				String[] o_hours90 = {"10", "10", "10", "10", "10", "10", "12"};
				String[] c_hours90 = {"21", "21", "21", "21", "21","20","18"};
				g90.setHours(o_hours90, c_hours90);
				places[iterator] = g90;
				iterator++;


				Spots g91 = new Spots("Newbury Street Shops", "Along Newbury St"," ", 42.348601,-71.087937,0);
				String[] o_hours91 = {"0", "0", "0", "0", "0", "0", "0"};
				String[] c_hours91 = {"2359", "2359", "2359", "2359", "2359", "2359", "2359"};
				g91.setHours(o_hours91, c_hours91);
				places[iterator] = g91;
				iterator++;


				Spots g92 = new Spots("Cambridge Galleria", "100 Cambridgeside Pl"," ", 42.367882,-71.076372,0);
				String[] o_hours92 = {"10", "10", "10", "10", "10", "10","10"};
				String[] c_hours92 = {"21","21","21","21","22","21","21"};
				g92.setHours(o_hours92, c_hours92);
				places[iterator] = g92;
				iterator++;
				
				
				
				
				// Night Life
				
				Spots g93 = new Spots("Royale", "279 Tremont St", "617-338-7699", 42.350552,-71.065772,0);
				String[] o_hours93 = {"0","0","0","0","22","22","0"};
				String[] c_hours93 = {"0","0","0","0","2","2","0"};
				g93.setHours(o_hours93,c_hours93);
				places[iterator] = g93;
				iterator++;


				Spots g94 = new Spots("Good Life", "28 Kingston St", "617-451-2622",  42.354072,-71.059191,0);
				String[] o_hours94 = {"1130","1130","1130","1130","1130","17","0"};
				String[] c_hours94 = {"2","2","2","2","2","2","0"};
				g94.setHours(o_hours94,c_hours94);
				places[iterator] = g94;
				iterator++;


				Spots g95 = new Spots("Liquor Store", "25 Boylston Pl", "617-357-6800",  42.353724,-71.066194,0);
				String[] o_hours95 = {"0","0","0","0","21","21","0"};
				String[] c_hours95 = {"0","0","0","0","2","2","0"};
				g95.setHours(o_hours95,c_hours95);
				places[iterator] = g95;
				iterator++;


				Spots g96 = new Spots("Rise", "306 Stuart St", "617-423-7473", 42.351947,-71.070728,0);
				String[] o_hours96 = {"0","0","0","0","1","1","1"};
				String[] c_hours96 = {"0","0","0","0","6","6","6"};
				g96.setHours(o_hours96,c_hours96);
				places[iterator] = g96;
				iterator++;


				Spots g97 = new Spots("The Estate", "1 Boylston Pl", "617-351-7000", 42.356134,-71.06595,0);
				String[] o_hours97 = {"0","0","0","22","22","22","0"};
				String[] c_hours97 = {"0","0","0","2","2","2","0"};
				g97.setHours(o_hours97,c_hours97);
				places[iterator] = g97;
				iterator++;


				Spots g98 = new Spots("Tequila Rain", "145 Ipswich St", "617-437-0300", 42.350679,-71.095104,0);
				String[] o_hours98 = {"1730","1730","1730","1730","1730","11","11"};
				String[] c_hours98 = {"2","2","2","2","2","2","2"};
				g98.setHours(o_hours98,c_hours98);
				places[iterator] = g98;
				iterator++;


				Spots g99 = new Spots("Game On!", "82 Lansdowne Street", "617-351-7001", 42.34903,-71.098465,0);
				String[] o_hours99 = {"1130","1130","1130","1130","1130","1130","1130"};
				String[] c_hours99 = {"1","1","1","2","2","2","1"};
				g99.setHours(o_hours99,c_hours99);
				places[iterator] = g99;
				iterator++;


				Spots g100 = new Spots("Middle East Restaurant and Nightclub", "472-480 Massachusetts Avenue", "617-864-3278",  42.363776,-71.101377,0);
				String[] o_hours100 = {"11","11","11","11","11","11","11"};
				String[] c_hours100 = {"1","1","1","2","2","2","1"};
				g100.setHours(o_hours100,c_hours100);
				places[iterator] = g100;
				iterator++;


				Spots g101 = new Spots("The Greatest Bar","262 Friend Street", "617-367-0544",  42.364696,-71.0613,0);
				String[] o_hours101 = {"16","16","16","16","16","1130","16"};
				String[] c_hours101 = {"2","2","2","2","2","2","2"};
				g101.setHours(o_hours101,c_hours101);
				places[iterator] = g101;
				iterator++;


				Spots g102 = new Spots("Storyville", "90 Exeter Street", "617-236-1134",  42.348268,-71.078803,0);
				String[] o_hours102 = {"0","0","12","20","19","19","0"};
				String[] c_hours102 = {"0","0","2","2","2","2359","0"};
				g102.setHours(o_hours102,c_hours102);
				places[iterator] = g102;
				iterator++;


				Spots g103 = new Spots("The Brahmin", "33 Stanhope Street", "617-723-3131",  42.348427,-71.07331,0);
				String[] o_hours103 = {"1630","1630","1630","1630","1630","1630","1630"};
				String[] c_hours103 = {"2","2","2","2","2","2","2"};
				g103.setHours(o_hours103,c_hours103);
				places[iterator] = g103;
				iterator++;


				Spots g104 = new Spots("Tavern In The Square", "161 Brighton Avenue", "(617) 782-8100",  42.353486,-71.132646,0);
				String[] o_hours104 = {"9","12","12","12","12","12","10"};
				String[] c_hours104 = {"17","2","2","2","2","2","2"};
				g104.setHours(o_hours104,c_hours104);
				places[iterator] = g104;
				iterator++;
				
				
				
				
				
				//Bars and Pubs
				
				
				Spots g105 = new Spots("Audubon Circle Restaurant Bar", "838 Beacon Street","617-421-1910", 42.34738,-71.102879,0);
				String[] o_hours105 = {"1130","1130","1130","1130","1130","11","11"};
				String[] c_hours105 = {"1","1","1","1","1","1","1"};
				g105.setHours(o_hours105, c_hours105);
				places[iterator] = g105;
				iterator++;
				
				Spots g106 = new Spots("Sunset Cantina", "916 Commonwealth Avenue","617-731-8646", 42.351218,-71.117163,0);
				String[] o_hours106 = {"11","11","11","11","11","11","11"};
				String[] c_hours106 = {"2","2","2","2","2","2","2"};
				g106.setHours(o_hours106, c_hours106);
				places[iterator] = g106;
				iterator++;
				
				Spots g107 = new Spots("White Horse Tavern", "116 Brighton Avenue", "617-254-6633",42.35366,-71.131153,0);
				String[] o_hours107 = {"10","10","10","10","10","10","10"};
				String[] c_hours107 = {"2","2","2","2","2","2","2"};
				g107.setHours(o_hours107, c_hours107);
				places[iterator] = g107;
				iterator++;
				
				Spots g108 = new Spots("Deep Ellum", "477 Cambridge Street", "617-787-2337", 42.356007, -71.136732,0);
				String[] o_hours108 = {"11","11","11","11","11","10","10"};
				String[] c_hours108 = {"2","2","2","2","2","2","2"};
				g108.setHours(o_hours108, c_hours108);
				places[iterator] = g108;
				iterator++;
				
				Spots g109 = new Spots("Draft Bar and Grille", "34 Harvard Avenue", "617-783-9400", 42.357212,-71.132798,0);
				String[] o_hours109 = {"11","11","11","11","11","11","11"};
				String[] c_hours109 = {"2","2","2","2","2","2","2"};
				g109.setHours(o_hours109, c_hours109);
				places[iterator] = g109;
				iterator++;
				
				Spots g110 = new Spots("Common Ground Bar and Grill", "85 Harvard Avenue","617-783-2701", 42.355499,-71.132369,0);
				String[] o_hours110 = {"10","10","10","10","10","10","10"};
				String[] c_hours110 = {"2","2","2","2","2","2","2"};
				g110.setHours(o_hours110, c_hours110);
				places[iterator] = g110;
				iterator++;
				
				
				Spots g111 = new Spots("Cornwall's", "654 Beacon Street", "617-262-3749",  42.349283,-71.095891,0);
				String[] o_hours111 = {"11","11","11","11","11","11","11"};
				String[] c_hours111 = {"2","2","2","2","2","2","2"};
				g111.setHours(o_hours111, c_hours111);
				places[iterator] = g111;
				iterator++;
				
				Spots g112 = new Spots("The Lower Depths Tap Room", "476 Commonwealth Avenue","617-266-6662",  42.348712,-71.093831,0);
				String[] o_hours112 = {"1130","1130","1130","1130","1130","1130","1130"};
				String[] c_hours112 = {"1","1","1","1","1","1","1"};
				g112.setHours(o_hours112, c_hours112);
				places[iterator] = g112;
				iterator++;
				
				Spots g113 = new Spots("The Corner Tavern", "421 Marlborough Street", "617-262-5555",  42.350045,-71.089625,0);
				String[] o_hours113 = {"1130","1130","1130","1130","1130","1130","1130"};
				String[] c_hours113 = {"2","2","2","2","2","2","2"};
				g113.setHours(o_hours113, c_hours113);
				places[iterator] = g113;
				iterator++;

				Spots g114 = new Spots("Dillons", "955 Boylston Street","617-421-1818",  42.347951,-71.086092,0);
				String[] o_hours114 = {"11","11","11","11","11","10","10"};
				String[] c_hours114 = {"2","2","2","2","2","2","2"};
				g114.setHours(o_hours114, c_hours114);
				places[iterator] = g114;
				iterator++;
				
				Spots g115 = new Spots("Mass Ave Tavern", "94 Massachusetts Avenue","617-927-4900", 42.348522,-71.087995,0);
		           String[] o_hours115 = {"1130","1130","1130","1130","1130","1130","1130"};
		           String[] c_hours115 = {"1","1","1","1","1","1","1"};
		           g115.setHours(o_hours115,c_hours115);
		           places[iterator] = g115;
		           iterator++;
		 
		           Spots g116 = new Spots("M Bar & Lounge", "776 Boylston Street","617-535-8800",  42.350806,-71.081715,0);
		           String[] o_hours116 = {"11","11","11","11","11","11","11"};
		           String[] c_hours116 = {"1","1","1","2","2","2","1"};
		           g116.setHours(o_hours116,c_hours116);
		           places[iterator] = g116;
		           iterator++;
		 
		           Spots g117 = new Spots("The Rattlesnake Bar", "384 Boylston Street", "617-859-7772", 42.351916,-71.072037,0);
		           String[] o_hours117 = {"1130","1130","1130","1130","1130","1130","1130"};
		           String[] c_hours117 = {"2","2","2","2","2","2","2"};
		           g117.setHours(o_hours117,c_hours117);
		           places[iterator] = g117;
		           iterator++;
		 
		           Spots g118 = new Spots("Daisy Buchanan's", "240 Newbury Street","617-247-8516", 42.349569,-71.082294,0);
		           String[] o_hours118 = {"1130","1130","1130","1130","1130","1130","1130"};
		           String[] c_hours118 = {"2","2","2","2","2","2","2"};
		           g118.setHours(o_hours118,c_hours118);
		           places[iterator] = g118;
		           iterator++;
		 
		           Spots g119 = new Spots("21st Amendment", "150 Bowdoin Street", "617-227-7100", 42.358813,-71.062574,0);
		           String[] o_hours119 = {"1130","1130","1130","1130","1130","1130","1130"};
		           String[] c_hours119 = {"2","2","2","2","2","2","2"};
		           g119.setHours(o_hours119,c_hours119);
		           places[iterator] = g119;
		           iterator++;
		 
		           Spots g120 = new Spots("Sidebar", "14 Bromfield Street", "617-357-1899", 42.357466,-71.059957,0);
		           String[] o_hours120 = {"11","11","11","11","11","17","0"};
		           String[] c_hours120 = {"2359","2359","2359","2359","2359","1","0"};
		           g120.setHours(o_hours120,c_hours120);
		           places[iterator] = g120;
		           iterator++;
		 
		           Spots g121 = new Spots("Stoddard's Fine Food & Ale", "48 Temple Place", "617-426-0048", 42.355848,-71.061766,0);
		           String[] o_hours121 = {"0","17","17","1130","1130","1130","1130"};
		           String[] c_hours121 = {"0","2245","2245","2245","2245","2245","2345"};
		           g121.setHours(o_hours121,c_hours121);
		           places[iterator] = g121;
		           iterator++;
		 
		           Spots g122 = new Spots("The Asgard Irish Pub and Restaurant", "350 Massachusetts Avenue", "617-577-9100", 42.363126,-71.09946,0);
		           String[] o_hours122 = {"11","11","11","11","11","10","10"};
		           String[] c_hours122 = {"1","1","1","2","2","2","1"};
		           g122.setHours(o_hours122,c_hours122);
		           places[iterator] = g122;
		           iterator++;
		 
		           Spots g123 = new Spots("All Asia", "334 Massachusetts Avenue", "617-497-1544",42.362841,-71.099056,0);
		           String[] o_hours123 = {"12","12","12","12","12","12","12"};
		           String[] c_hours123 = {"2","2","2","2","2","2","2"};
		           g123.setHours(o_hours123,c_hours123);
		           places[iterator] = g123;
		           iterator++;
		 
		           Spots g124 = new Spots("Brick & Mortar", "567 Massachusetts Avenue", "617-491-0016", 42.364759,-71.102486,0);
		           String[] o_hours124 = {"17","17","17","17","17","17","17"};
		           String[] c_hours124 = {"1","1","1","2","2","2","1"};
		           g124.setHours(o_hours124,c_hours124);
		           places[iterator] = g124;
		           iterator++;
		 
		           Spots g125 = new Spots("T's Pub", "973 Commonwealth Avenue", "617-254-0807",  42.351694,-71.119738,0);
		           String[] o_hours125 = {"11","11","11","11","11","11","11"};
		           String[] c_hours125 = {"2","2","2","2","2","2","2"};
		           g125.setHours(o_hours125,c_hours125);
		           places[iterator] = g125;
		           iterator++;
		 
		           Spots g126 = new Spots("Wonder Bar", "186 Harvard Avenue", "617-351-2665", 42.353343,-71.130724,0);
		           String[] o_hours126 = {"19","19","19","19","19","19","19"};
		           String[] c_hours126 = {"2","2","2","2","2","2","2"};
		           g126.setHours(o_hours126,c_hours126);
		           places[iterator] = g126;
		           iterator++;
		 
		           Spots g127 = new Spots("Hops N Scotch", "1306 Beacon Street", "617-232-8808", 42.342052,-71.119995,0);
		           String[] o_hours127 = {"17","17","17","17","17","10","10"};
		           String[] c_hours127 = {"2350","2359","1","1","2","15","15"};
		           g127.setHours(o_hours127,c_hours127);
		           places[iterator] = g127;
		           iterator++;
		           
					Spots g128 = new Spots("Whisky Saigon", "116 Boylston Street", "617-482-7799", 42.352542,-71.065612,0);
					String[] o_hours128 = {"0","0","0","18","20","20","0"};
					String[] c_hours128 = {"0","0","0","21","2","2","0"};
					g128.setHours(o_hours128,c_hours128);
					places[iterator] = g128;
					iterator++;


				


				
				//Use location arrays
				//Iterate through arrays to make markers
				//Make new array for each of the Latitude/Longitude and Marker objects
				
				//fun state
				if(newState=='1'){
					startSpot = 0;
					endSpot = 40;
				}
				
				//food state
				else if (newState=='2'){
					startSpot = 41;
					endSpot = 72;
				}
				
				//drink state
				else if (newState=='3'){
					startSpot = 73;
					endSpot = 82; 
				}
				
				//all state
				else {
					startSpot = 0;
					endSpot = 128;
				}

				
				for (int i=startSpot; i<endSpot; i++) {
					
				//Get the latitude and longitude of each place
				String placeName = places[i].getBuildingName();
				positions[i] = new LatLng(places[i].getLatitude(),places[i].getLongitude());  //Add
		
				//Check to see which places close within 30 minutes, and which ones are open
				//Use current date/time to check the status. 
					if (places[i].closeSoon(current_day, current_hour, current_minute)) {
						marks[i] = mMap.addMarker(new MarkerOptions().position(positions[i])
								.title(placeName)
								.snippet(places[i].getAddress() + "  (Closing Soon)  " + places[i].getPhone())
								.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
						//Set the marker ID into the Spots class
						String temp = marks[i].getId();
						places[i].setMapID(temp);
					} else if (places[i].isOpen(current_day, current_hour, current_minute)) {
						marks[i] = mMap.addMarker(new MarkerOptions().position(positions[i])
								.title(placeName)
								.snippet(places[i].getAddress() + "  (Open)  " + places[i].getPhone())
								.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
						String temp = marks[i].getId();
						places[i].setMapID(temp);
					} else {
						marks[i] = mMap.addMarker(new MarkerOptions().position(positions[i])
								.title(placeName)
								.snippet(places[i].getAddress() + "  (Closed)  " + places[i].getPhone())
								.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
						String temp = marks[i].getId();
						places[i].setMapID(temp);
					}
				}
			    
			}		
				//auto-zooms to Boston on startup
				final LatLng BOSTON = new LatLng(42.35322,-71.08841);
				mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BOSTON,12));
				
				//disables user locator button
				mMap.setMyLocationEnabled(false);
				
				
				
		}
	}

