package com.example.memopad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MemoDBHelper extends SQLiteOpenHelper
{
	static final String name = "memos.db";
	static final int version = 1;
	static final CursorFactory factory = null;

	public MemoDBHelper(Context context)
	{
		super(context, name, factory, version);
		
	}
	// onCreate() translate to SQL-statement and  make a table of SQLite 
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		String sql = "CREATE TABLE memoDB("
				+ android.provider.BaseColumns._ID
				+" INTEGER PRIMARY KEY AUTOINCREMENT, title Text, memo Text); " ;
		db.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO Auto-generated method stub

	}

}
