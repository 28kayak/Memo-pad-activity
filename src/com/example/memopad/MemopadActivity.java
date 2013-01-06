package com.example.memopad;
//initial memo app which can save written data on the memo-pad apps
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
//import statement for onStop()
import android.content.SharedPreferences;//interface
import android.text.Selection;
import android.widget.EditText;
//imports for saveMemo()
import java.text.DateFormat;
import java.util.Date;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;

//testing branch git

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
	
	void saveMemo()
	{
		EditText et = (EditText) this.findViewById(R.id.editText);
		String title;
		String memo = et.getText().toString();
		
		if(memo.trim().length() > 0)
		{
			if(memo.indexOf("\n")==-1)
			{
				title = memo.substring(0, Math.min(memo.length(), 20));
				
			}
			else
			{
				title = memo.substring(0, Math.min(memo.indexOf("\n"), 20));
			}
		
		String ts = DateFormat.getDateTimeInstance().format(new Date());
		MemoDBHelper memos = new MemoDBHelper(this);
		SQLiteDatabase db = memos.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("title", title + "\n" + ts);
		values.put("memo", memo);
		
		
		
		}//if
		
		
	}//saveMemo()
}
