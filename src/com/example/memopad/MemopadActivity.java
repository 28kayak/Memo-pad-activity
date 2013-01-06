package com.example.memopad;
//initial memo app which can temporally write data on the memo-pad apps
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

//import statement for onStop()
import android.content.SharedPreferences;//interface
import android.text.Selection;
import android.widget.EditText;

public class MemopadActivity extends Activity
{



	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_memopad);
		
		EditText et = (EditText) findViewById(R.id.editText);
		SharedPreferences pref = this.getSharedPreferences("MemoPref", MODE_PRIVATE);
		et.setText(pref.getString("memo", ""));
		et.setSelection(pref.getInt("",0));
	}
	
	//onStop method is called before app shuts down, 
	//so it contains the function which saves written info
	@Override
	protected void onStop()
	{
		EditText et = (EditText) findViewById(R.id.editText);
		//use method findViewById and contain an object of EditText into the variable et 
		SharedPreferences pref = getSharedPreferences("MemoPref", MODE_PRIVATE);
		//create an object of SharedPreferences using getSharedPreferences
		SharedPreferences.Editor  editor = pref.edit();
		//SharedPreferences.Editor used to write SharedPreferences gets from edit().
		editor.putString("memo", et.getText().toString());
		//canNOT save Editable type,so change to String type by toString() 
		editor.putInt("cursor", Selection.getSelectionStart(et.getText()));
		//contain putString() gets String and putText()gets int
		editor.commit();
		//save data and done
		
		super.onStop();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_memopad, menu);
		return true;
	}
}
