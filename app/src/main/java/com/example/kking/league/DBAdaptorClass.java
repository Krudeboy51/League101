package com.example.kking.league;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kking on 11/18/2017.
 */

public class DBAdaptorClass {
    DBHelperClass dbHelperClass;

    public DBAdaptorClass(Context c){
        dbHelperClass = new DBHelperClass(c);
    }

    public long insertData(String tag, String data){
        SQLiteDatabase db = dbHelperClass.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DBHelperClass.COL_TAG, tag);
        cv.put(DBHelperClass.COL_DATA, data);
        long id = db.insert(Constants.DBTABLENAME, null, cv);
        return id;
    }

    public String getData(String tag){
        SQLiteDatabase db = dbHelperClass.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from "+Constants.DBTABLENAME, null);
        Log.i("LINK  - GET daTA", "Select * from "+Constants.DBTABLENAME+" where "+DBHelperClass.COL_TAG+" = '"+tag+"'");
        String data = null;
        if(c.moveToFirst()){
            do {
                data = c.getString(1);
            }while(c.moveToNext());
        } else {
            return null;
        }
        return data;
                //c.getString(c.getColumnIndex(tag));
    }

   static class DBHelperClass extends SQLiteOpenHelper {


       private static String COL_TAG = "tag";
       private static String COL_DATA = "data";
       private static final String CREATE_TABLE =
               "CREATE TABLE "+Constants.DBTABLENAME+
               " ("
                       +COL_TAG+" VARCHAR(255) ,"+
                       COL_DATA+" VARCHAR(225));";
       private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+Constants.DBTABLENAME;


       public DBHelperClass(Context context) {
           super(context, Constants.DBNAME, null, Constants.DBVERSION);
       }

       @Override
       public void onCreate(SQLiteDatabase db) {
           try {
               db.execSQL(CREATE_TABLE);
           } catch (Exception e) {
               Log.e("SQLITE ERROR", e.getMessage());
           }
       }

       @Override
       public void onUpgrade(SQLiteDatabase db, int i, int i1) {
           try {
               db.execSQL(DROP_TABLE);
               onCreate(db);
           } catch (Exception e) {
               Log.e("SQLITE ERROR", e.getMessage());
           }
       }
   }
}
