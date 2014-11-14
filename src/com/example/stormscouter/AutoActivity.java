package com.example.stormscouter;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.os.Build;
import android.widget.*;
import com.example.stormscouter.*;

public class AutoActivity extends ActionBarActivity {

	public void gotonewactivity()
	{
		Intent inte = new Intent(this, TeleEndActivity.class);
		startActivity(inte);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto);

        Intent i = this.getIntent();
        this.setTitle("Autonomous");
		final CheckBox ramp = (CheckBox) this.findViewById(R.id.check_ramp),
				kick = (CheckBox) this.findViewById(R.id.check_kick),
		        centerauto = (CheckBox) this.findViewById(R.id.check_center);
		
		final Button autor = (Button) this.findViewById(R.id.autor),
			   rollpz = (Button) this.findViewById(R.id.rollpz),
			   changes = (Button) this.findViewById(R.id.change);
		
		autor.setText("Rolling Goal scored: " +DataHandler.getautorollingscore());
		rollpz.setText("Rolling Goal to parkzone: " +DataHandler.getrgtopz());
		
		
		autor.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DataHandler.addautorollingscore();
				autor.setText("Rolling Goal scored: " +DataHandler.getautorollingscore());
				
			}
			
		});
		rollpz.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			    DataHandler.addrgtopz();
			    rollpz.setText("Rolling goal to parkzone: " +DataHandler.getrgtopz());
			}
			
		});
		changes.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DataHandler.isramptofloor = ramp.isChecked();
				DataHandler.isknocked = kick.isChecked();
				DataHandler.centergoalisscored = centerauto.isChecked();
				gotonewactivity();
			}
			
		});
		        		
	}

}
