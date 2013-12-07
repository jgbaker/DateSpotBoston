package com.datespotboston;

//import java.lang.*;

public class Spots {
	
	/*List of functions:
	 * void setHours()
	 * void setRating()
	 * 
	 * String getBuildingName()
	 * String getAddress()
	 * double getLatitude()
	 * double getLongitude()
	 * boolean isOpen()
	 * boolean closeSoon()
	 */
	
	private String buildingName;
	private String address;
	private double latitude;
	private double longitude;
	private String[] open;
	private String[] close;
	private int rating;
	private String mapID;

	//Constructor
	//Default constructor
	public Spots() {
		this.buildingName = "";
		this.address = "";
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.rating = 0;
		this.mapID = "";
		this.open = new String[7];
		this.close = new String[7];
	}
	
	//Constructor with input
	public Spots(String name, String address, double latitude, double longitude, int rating) {
		this.buildingName = name;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.rating = rating;
		this.mapID = "";
		this.open = new String[7];
		this.close = new String[7];
	}
	
	//function that sets when the place is open - takes two arrays as inputs
	public void setHours(String[] o_hours, String[] c_hours) {
		String newohours = "";
		String newchours = "";
		for (int i=0; i<7; i++) {
			if (o_hours[i].length() < 3) {
				newohours += o_hours[i]+"00";
			} else {
				newohours += o_hours[i];
			}
			if (c_hours[i].length() < 4 && Integer.valueOf(c_hours[i]) > 12) {
				newchours += c_hours[i]+"00";
			} else {
				newchours += c_hours[i];
			}
				
			this.open[i] = newohours;
			this.close[i] = newchours;
			
			newohours = "";
			newchours = "";
		}
	}
	
	//function that returns the building's name
	public String getBuildingName() {
		return this.buildingName;
	}
	
	//function that returns the address
	public String getAddress() {
		return this.address;
	}
	
	//function that returns the latitude
	public double getLatitude() {
		return this.latitude;
	}
	
	//function that returns the longitude
	public double getLongitude() {
		return this.longitude;
	}
	
	//function that checks the hours to determine if the location is open
	public boolean isOpen(int day, String hour, String minute) {
		int int_close = 0;
		int int_open = 0;
		
		String str_close = close[day];
		String str_open = open[day];
		//check to make sure that minute doesnt need a leading 0
		if (minute.length() == 1) {
			minute = "0" + minute;
		}
		
		if (Integer.valueOf(str_open) < 3) {
			str_open = str_open + "00";
		}
		
		if (Integer.valueOf(str_close) < 3) {
			str_close = str_close + "00";
		}
		
		int_close = Integer.valueOf(str_close);
		int_open = Integer.valueOf(str_open);
		int currentTime = Integer.valueOf(hour+minute);

		System.out.println(currentTime);
		System.out.println(int_close);
		System.out.println(int_open);
		
		//For post-midnight rollover
		if (int_close < 1200) {
			int_close = int_close + 2400;
		}
		
		if ((currentTime-int_open) < 0) {
			return false;
		}
		if ((currentTime-int_close) > 0) {
			return false;
		}
		return true;
	}
	
	//function that checks the hours to see if it closes within a half hour
		public boolean closeSoon(int day, String hour, String minute) {
			int int_close = 0;
			String str_close = close[day];
			int cl_hour = 0;
			int cl_minute = 0;
			
			//check to make sure that minute doesnt need a leading 0
			if (minute.length() == 1) {
				minute = "0" + minute;
			}
			
			if (Integer.valueOf(str_close) < 3) {
				cl_hour = Integer.valueOf(cl_hour);
				cl_minute = 0;
			} else {
			}
			
			int_close = Integer.valueOf(str_close);		

			//For post-midnight rollover
			if (int_close < 1200) {
				int_close = int_close + 2400;
			}
			int currentTime = Integer.valueOf(hour+""+minute);

			System.out.println(int_close - currentTime);
			System.out.println(int_close);
			System.out.println(int_close/100);
			System.out.println(int_close%100);
			
			int close_h = 0;
			int close_min = 0;
			int curr_h = 0;
			int curr_min = 0;
			
			close_h = int_close/100;
			close_min = int_close%100;
			curr_h = Integer.valueOf(hour);
			return false;
		}

		public void setMapID(String temp) {
			// TODO Auto-generated method stub
			
		}
}
		