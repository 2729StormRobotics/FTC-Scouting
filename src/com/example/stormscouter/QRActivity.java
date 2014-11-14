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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.os.Build;

import com.example.stormscouter.*;

public class QRActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        Intent finalintent = this.getIntent();
        DrawQRCode draw = new DrawQRCode(this, "@stormscouting" + DataHandler.getQRdata());
        setContentView(R.layout.activity_qr);
        addContentView(draw, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
	}}