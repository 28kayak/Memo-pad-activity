package com.example.memopad;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
//initial memo app which can temporally write data on the memopad apps
public class MemopadActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_memopad);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_memopad, menu);
		return true;
	}
}
