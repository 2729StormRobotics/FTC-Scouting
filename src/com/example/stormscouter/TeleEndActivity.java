package com.example.stormscouter;

import com.example.stormscouter.R.id;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;
import android.view.View.OnClickListener;
import com.example.stormscouter.*;

public class TeleEndActivity extends ActionBarActivity {
public static String extramessage = "@stormscouting";
	public void intentqr()
	{
		Intent qrintent = new Intent(this, QRActivity.class);
		startActivity(qrintent);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tele_end);

		Intent secondintent = this.getIntent();
		this.setTitle("Tele-op/End Game");
		
		final Button tmade = (Button) this.findViewById(R.id.tmade),
			   tmiss = (Button) this.findViewById(R.id.tmiss),
			   tmadesub = (Button) this.findViewById(R.id.tmadesub),
			   tmisssub = (Button) this.findViewById(R.id.tmisssub),
			   
			   smade = (Button) this.findViewById(R.id.smade),
			   smiss = (Button) this.findViewById(R.id.smiss),
			   smadesub = (Button) this.findViewById(R.id.smadesub),
			   smisssub = (Button) this.findViewById(R.id.smisssub),
			   
			   nmade = (Button) this.findViewById(R.id.nmade),
			   nmiss = (Button) this.findViewById(R.id.nmiss),
			   nmadesub = (Button) this.findViewById(R.id.nmadesub),
			   nmisssub = (Button) this.findViewById(R.id.nmisssub),
			   
			   movepz = (Button) this.findViewById(R.id.movepz),
			   movefloor = (Button) this.findViewById(R.id.movefloor),
			   centerend = (Button) this.findViewById(R.id.centergoalend),
			   qr = (Button) this.findViewById(R.id.QR);
		
		tmade.setText("Made: " +DataHandler.getthirty());
		tmiss.setText("Miss: " +DataHandler.getthirtymiss());
		smade.setText("Made: " +DataHandler.getsixty());
		smiss.setText("Miss: " +DataHandler.getsixtymiss());
		nmade.setText("Made: " +DataHandler.getninty());
		nmiss.setText("Miss: " +DataHandler.getnintymiss());
		movepz.setText("Bot or Rolling Goal to parkzone: " +DataHandler.getbotrolltopz());
		movefloor.setText("Bot or Rolling Goal off of floor: " +DataHandler.getbotrollofffloor());
		centerend.setText("Center goal scored: " +DataHandler.getcentergoalend());
		
		tmade.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    DataHandler.addthirty();
			    tmade.setText("Made: " +DataHandler.getthirty());
			}
			
		});
		tmiss.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    DataHandler.addthirtymiss();
			    tmiss.setText("Miss: " +DataHandler.getthirtymiss());
			}
			
		});
		tmadesub.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DataHandler.subthirty();
				tmade.setText("Made: " +DataHandler.getthirty());
			}
			
		});
		tmisssub.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DataHandler.subthirtymiss();
				tmiss.setText("Miss: " +DataHandler.getthirtymiss());
			}
			
		});
		smade.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DataHandler.addsixty();
				smade.setText("Made: " +DataHandler.getsixty());
			}
			
		});
		smiss.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    DataHandler.addsixtymiss();
			    smiss.setText("Miss: " +DataHandler.getsixtymiss());
			}
			
		});
		smadesub.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DataHandler.subsixty();
				smade.setText("Made: " +DataHandler.getsixty());
			}
			
		});
		smisssub.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    DataHandler.subsixtymiss();
			    smiss.setText("Miss: " +DataHandler.getsixtymiss());
			    
			}
			
		});
		nmade.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DataHandler.addninty();
				nmade.setText("Made: " +DataHandler.getninty());
			}
			
		});
		nmiss.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DataHandler.addnintymiss();
				nmiss.setText("Miss: " +DataHandler.getnintymiss());
				
			}
			
		});
		nmadesub.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    DataHandler.subninty();
			    nmade.setText("Made: " +DataHandler.getninty());
			}
			
		});
		nmisssub.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DataHandler.subnintymiss();
				nmiss.setText("Miss: " +DataHandler.getnintymiss());
			}
			
		});
		movepz.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DataHandler.addbotrolltopz();
				movepz.setText("Bot or Rolling goal to parkzone: " +DataHandler.getbotrolltopz());
			}
			
		});
		movefloor.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    DataHandler.addbotrollofffloor();
			    movefloor.setText("Bot or Rolling goal off of floor: " +DataHandler.getbotrollofffloor());
			}
			
		});
		centerend.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    DataHandler.addcentergoalend();
			    centerend.setText("Center goal scored: " +DataHandler.getcentergoalend());
			}
			
		});
		qr.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intentqr();
			}
			
		});

}}
