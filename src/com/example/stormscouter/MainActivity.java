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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	public void changer()
	{
		Intent intent = new Intent(this, AutoActivity.class);
		startActivity(intent);
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText team = (EditText) this.findViewById(R.id.txt_team),
        	           match = (EditText) this.findViewById(R.id.txt_match);
        final RadioButton red = (RadioButton) this.findViewById(R.id.red),
        		    blue = (RadioButton) this.findViewById(R.id.blue);
        Button btn_start = (Button) this.findViewById(R.id.begin);
        btn_start.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DataHandler.team = team.getText().toString();
				DataHandler.match = match.getText().toString();
				DataHandler.isRed = red.isChecked();
				changer();
			}
        	
        });
        
    }

}
