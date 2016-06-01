package com.filadelfia.lucas.igrejafiladelfia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lucas on 27/05/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "Config.db";

    private static final String TABLE_CONFIG = "config";
    private static final String TABLE_SETS = "sets";
    //private static final String COLUMN_DESCRIPTION = "description";
    //private static final String COLUMN_STATUS = "status";
    private static final String TABLE_CREATE_CONFIG = "create table config (id integer primary key not null , " +
            " logo text not null, background text not null, line text not null, " +
            " appointmentsbook text not null, warning text not null, site text not null,  " +
            " message text not null, facebook text not null, ministry text not null, youth text not null, " +
            " leadership text not null, contact text not null );";

    private static final String TABLE_CREATE_SETS = "create table sets (id integer primary key not null , " +
            " number text not null );";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LOGO = "logo";
    public static final String COLUMN_BACkGROUND = "background";
    public static final String COLUMN_LINE = "line";
    public static final String COLUMN_APPOINTMENTSBOOK = "appointmentsbook";
    public static final String COLUMN_WARNING = "warning";
    public static final String COLUMN_SITE = "site";
    public static final String COLUMN_MESSAGE = "message";
    public static final String COLUMN_FACEBOOK = "facebook";
    public static final String COLUMN_MINISTRY = "ministry";
    public static final String COLUMN_YOUTH = "youth";
    public static final String COLUMN_LEADERSHIP = "leadership";
    public static final String COLUMN_CONTACT = "contact";

    public static final String COLUMN_NUMBER = "number";

    //private static final String TABLE_CREATE2 = "create table audiosconectguitar (id integer primary key not null , " +
    //        " student_id integer not null, stage integer not null, lesson integer not null, filename text not null, original_filename text not null);";

    SQLiteDatabase db;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_CONFIG);
        db.execSQL(TABLE_CREATE_SETS);

        db.execSQL("insert into config (logo, background, line, appointmentsbook, warning, site, message, facebook, ministry, youth, leadership, contact) VALUES ('filadelfia', '#000000', 'line', 'appointmentsbook', 'warning', 'site', 'message', 'facebook', 'ministry', 'youth', 'leadership', 'contact') " );
        db.execSQL("insert into config (logo, background, line, appointmentsbook, warning, site, message, facebook, ministry, youth, leadership, contact) VALUES ('filadelfiai', '#FFFFFF', 'linei', 'appointmentsbooki', 'warningi', 'sitei', 'messagei', 'facebooki', 'ministryi', 'youthi', 'leadershipi', 'contacti') " );
        db.execSQL("insert into sets (number) VALUES ('1') " );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String query = "DROP TABLE IF EXISTS " + TABLE_SETS;
        String query2 = "DROP TABLE IF EXISTS " + TABLE_CONFIG;
        db.execSQL(query);
        db.execSQL(query2);
        this.onCreate(db);

    }

    /*public String[] getConfig(int number){

        db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_CONFIG + " WHERE id = " + number;
        Cursor cursor = db.rawQuery(selectQuery, null);
        int a;
        String b;

        b = "not found";

        if (cursor.moveToFirst())
        {
            do{
                a = cursor.getInt(0);

                if(a==number)
                {
                    b = cursor.getString(1);
                    break;
                }

            }
            while(cursor.moveToNext());
        }

        return new String[]{b};

    }*/

    //public Cursor getConfig(int number){

        //public Cursor getData(int id){
            /*SQLiteDatabase db = this.getReadableDatabase();
            Cursor res =  db.rawQuery( "select * from sets where id=" + number + "", null );
            return res;*/
        //}

        /*SQLiteOpenHelper sqliteHelper = null;

        // 1. get reference to SQLiteDatabase
        db = this.getReadableDatabase();*/

        // 2. select using rawQuery() method
        // Assume we have a table called "TABLE_NAME" with columns "COLUMNS_1 and COLUMNS_2"

        /*String query = "SELECT * FROM sets WHERE id = " + number;
        String b = "";
        //Cursor cursor = db.rawQuery(query, new String[] {"number"});
        Cursor cursor = db.query("config", // a. table
                //new String[] {"id", "number"}, // b. column names to return
                new String[] {"logo", "background", "line", "appointmentsbook", "warning", "site", "message", "facebook", "ministry", "youth", "leadership", "contact"},
                "id = ?", // c. selections "where clause"
                new String[] {"number"}, // d. selections args "where values"
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit*/

        /*if (cursor.moveToFirst())
        {
            /*do{
                a = cursor.getInt(0);

                if(a==1)
                {*/
           /* b = cursor.getString(1);
            //break;
                /*}

            }
            while(cursor.moveToNext());*/
        //}

        //return new String[]{};


        // 3. go over results
        /*cursor.moveToFirst()
        do{
            //get values
        }while(cursor.moveToNext())*/
    //}


    public String getSets(){
        SQLiteOpenHelper sqliteHelper = null;

        // 1. get reference to SQLiteDatabase
        db = this.getReadableDatabase();

        // 2. select using rawQuery() method
        // Assume we have a table called "TABLE_NAME" with columns "COLUMNS_1 and COLUMNS_2"

        String query = "SELECT id, number FROM sets WHERE id = 1";
        String b = "";
        //Cursor cursor = db.rawQuery(query, new String[] {"number"});
        Cursor cursor = db.query("sets", // a. table
                new String[] {"id", "number"}, // b. column names to return
                "id = ?", // c. selections "where clause"
                new String[] {"1"}, // d. selections args "where values"
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor.moveToFirst())
        {
            /*do{
                a = cursor.getInt(0);

                if(a==1)
                {*/
                    b = cursor.getString(1);
                    //break;
                /*}

            }
            while(cursor.moveToNext());*/
        }

        return b;


        // 3. go over results
        /*cursor.moveToFirst()
        do{
            //get values
        }while(cursor.moveToNext())*/
    }


    /*public String getSets(){

        db = this.getReadableDatabase();
        //String selectQuery = "SELECT id, number FROM " + TABLE_SET;
        String selectQuery = "SELECT id, number FROM sets";
        Cursor cursor = db.rawQuery(selectQuery, null);
        int a;
        String b;

        //b = cursor.getString(1);

        b = "not found";

        if (cursor.moveToFirst())
        {
            do{
                a = cursor.getInt(0);

                if(a==1)
                {
                    b = cursor.getString(1);
                    break;
                }

            }
            while(cursor.moveToNext());
        }

        return b;

    }*/

    //public void insertSet(String logo, String background, String line, String appointmentsbook, String warning, String site, String message, String facebook, String ministry, String youth, String leadership, String contact){
    public void insertSet(String number){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //String query = "select * from set";
        String query = "SELECT id, number FROM " + TABLE_SETS;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_NUMBER, Integer.parseInt(number));


        db.insert(TABLE_SETS , null , values);

    }


}
