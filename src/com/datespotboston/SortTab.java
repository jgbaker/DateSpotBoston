package com.datespotboston;

//SettingsTab.java


import com.google.android.gms.common.GooglePlayServicesUtil;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SortTab extends Fragment	{
	SettingsSelectedListener mCallBack;

	
	//Activity must implement this
	public interface SettingsSelectedListener	{
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState)	{
		return inflater.inflate(R.layout.sort_layout, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState)	{
		super.onActivityCreated(savedInstanceState);
		
		
				//bar & pub button
				final Button button1 = (Button) getView().findViewById(R.id.bar_pub);
				button1.setOnClickListener(new View.OnClickListener() {
			
					@Override
					public void onClick(View v) {
						String info = ("Tavern In The Square (TITS)\n(617)-878-9865\nwww.taverninthesquare.com\n\n");
						AlertDialog.Builder infoDialog = new AlertDialog.Builder(getActivity());
						infoDialog.setTitle("Bars and Pubs");
						infoDialog.setMessage(info);
						infoDialog.show();				
					}
				});
		
				// cafe button
				final Button button2 = (Button) getView().findViewById(R.id.cafe);
				button2.setOnClickListener(new View.OnClickListener() {
			
					@Override
					public void onClick(View v) {
						
						
					}
				});
		
			   // dessert button
				final Button button3 = (Button) getView().findViewById(R.id.dessert);
				button3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						String info = GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(getActivity());
						AlertDialog.Builder infoDialog = new AlertDialog.Builder(getActivity());
						infoDialog.setTitle("Dessert");
						infoDialog.setMessage(info);
						infoDialog.show();				
					}
				});	
				
				// entertainment button
				final Button button4 = (Button) getView().findViewById(R.id.entertainment);
				button4.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						String info = GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(getActivity());
						AlertDialog.Builder infoDialog = new AlertDialog.Builder(getActivity());
						infoDialog.setTitle("Entertainment");
						infoDialog.setMessage(info);
						infoDialog.show();				
					}
				});	
				
				// night life button
				final Button button5 = (Button) getView().findViewById(R.id.nightlife);
				button5.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						String info = GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(getActivity());
						AlertDialog.Builder infoDialog = new AlertDialog.Builder(getActivity());
						infoDialog.setTitle("Nightlife");
						infoDialog.setMessage(info);
						infoDialog.show();				
					}
				});	
				
				// recreation button
				final Button button6 = (Button) getView().findViewById(R.id.recreation);
				button6.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						String info = GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(getActivity());
						AlertDialog.Builder infoDialog = new AlertDialog.Builder(getActivity());
						infoDialog.setTitle("Recreation");
						infoDialog.setMessage(info);
						infoDialog.show();				
					}
				});
		
				// restaurants button
				final Button button7 = (Button) getView().findViewById(R.id.restaurants);
				button7.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						String info = GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(getActivity());
						AlertDialog.Builder infoDialog = new AlertDialog.Builder(getActivity());
						infoDialog.setTitle("Restaurants");
						infoDialog.setMessage(info);
						infoDialog.show();				
					}
				});
				
				// shopping button
				final Button button8 = (Button) getView().findViewById(R.id.shopping);
				button8.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						String info = GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(getActivity());
						AlertDialog.Builder infoDialog = new AlertDialog.Builder(getActivity());
						infoDialog.setTitle("Shopping");
						infoDialog.setMessage(info);
						infoDialog.show();				
					}
				});
	}	
}