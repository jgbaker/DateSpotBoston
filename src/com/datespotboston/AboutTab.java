package com.datespotboston;

// AboutTab.java

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.common.GooglePlayServicesUtil;

public class AboutTab extends Fragment	{
	
	@Override
	public void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState)	{
		return inflater.inflate(R.layout.about_layout, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)	{
		super.onActivityCreated(savedInstanceState);
		
		final Button button = (Button) getView().findViewById(R.id.legal_button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String licenseInfo = GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(getActivity());
				AlertDialog.Builder LicenseDialog = new AlertDialog.Builder(getActivity());
				LicenseDialog.setTitle("Legal Notice");
				LicenseDialog.setMessage(licenseInfo);
				LicenseDialog.show();				
			}
		});
	}	
}
