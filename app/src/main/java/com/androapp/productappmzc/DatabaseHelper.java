package com.androapp.productappmzc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String DbName="Product.db";
    static String TableName="Ptable";
    static String Col1="id";
    static String Col2="Pcod";
    static String Col3="Pname";
    static String Col4="Pprice";
    public DatabaseHelper(Context context) {
        super(context, DbName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="Create table "+TableName+"("+Col1+" integer primary key autoincrement," +
                Col2+" text," +
                Col3+" text," +
                Col4+" text )";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insertData(String Pcod,String Pname,String Pprice)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues c=new ContentValues();
        c.put(Col2,Pcod);
        c.put(Col3,Pname);
        c.put(Col4,Pprice);
        long status=db.insert(TableName,null,c);
        if(status==-1)
        {
            return  false;
        }
        else {
            return true;
        }

    }
    public Cursor searchData(String Pcod)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+TableName+
                " where " +Col2+ "='"+Pcod+"'";
        Cursor c=db.rawQuery(query,null);
        return c;
    }

}
