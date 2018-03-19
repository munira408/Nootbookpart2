package com.example.munira.notebooklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Munira on 24-Feb-18.
 */
/*step:1 create SQLiteHelper*/
public class DatabaseHelper extends SQLiteOpenHelper {


    /*step:2 declare object And Create Database*/
    final static String DATABASE_NOTEDB = "NotebookListDB";
    /*step:3 SQL statement to create DATABASE Income table */
    final static String TABLE_NAME = "item_table";
    /*step:3 SQL statement to create DATABASE Argent table */
    final static String TABLE_NAME2 = "item_table2";
    /*step:3 SQL statement to create DATABASE Possible table */
    final static String TABLE_NAME3 = "item_table3";
    /*step:3 SQL statement to create DATABASE Yearly table */
    final static String TABLE_NAME4 = "item_table4";

    /*step:2 declare object Income*/
    final static String INCOME_ID = "id";
    final static String INCOME_TITLE = "title";
    final static String INCOME_AMOUNT = "amount";
    final static String INCOME_DATE = "date";


    /*step:2 declare object argent*/
    final static String ARGENT_ID = "id";
    final static String ARGENT_TITLE = "title";
    final static String ARGENT_AMOUNT = "amount";
    final static String ARGENT_DATE = "date";

    /*step:2 declare object possible*/
    final static String POSSIBLE_ID = "id";
    final static String POSSIBLE_TITLE = "title";
    final static String POSSIBLE_AMOUNT = "amount";
    final static String POSSIBLE_DATE = "date";

    /*step:2 declare object yearly*/
    final static String YEARLY_ID = "id";
    final static String YEARLY_TITLE = "title";
    final static String YEARLY_AMOUNT = "amount";
    final static String YEARLY_DATE = "date";


    /*next time use for create context*/
    Context context;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NOTEDB, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //db=this.getWritableDatabase();
        /*create income table for database*/
        String CREATE_DATABASE_QUERY = "create table " + TABLE_NAME + "(" +
                INCOME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                INCOME_TITLE + " TEXT, " +
                INCOME_AMOUNT + " TEXT, " +
                INCOME_DATE + " INTEGER  )";


        /*create argent table for database*/
        String CREATE_DATABASE_QUERY2 = "create table " + TABLE_NAME2 + "(" +
                ARGENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ARGENT_TITLE + " TEXT, " +
                ARGENT_AMOUNT + " TEXT, " +
                ARGENT_DATE + " INTEGER  )";

         /*create possible table for database*/
        String CREATE_DATABASE_QUERY3 = "create table " + TABLE_NAME3 + "(" +
                POSSIBLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                POSSIBLE_TITLE + " TEXT, " +
                POSSIBLE_AMOUNT + " TEXT, " +
                POSSIBLE_DATE + " INTEGER  )";

         /*create yearly table for database*/
        String CREATE_DATABASE_QUERY4 = "create table " + TABLE_NAME4 + "(" +
                YEARLY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                YEARLY_TITLE + " TEXT, " +
                YEARLY_AMOUNT + " TEXT, " +
                YEARLY_DATE + " INTEGER  )";


        db.execSQL(CREATE_DATABASE_QUERY); /*create income table run*/

        db.execSQL(CREATE_DATABASE_QUERY2); /*create argent table run*/

        db.execSQL(CREATE_DATABASE_QUERY3); /*create possible table run*/

        db.execSQL(CREATE_DATABASE_QUERY4);/*create yearly table run*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /*step:4 SQL statement to Drop DATABASE table income,argent,possible,yearly*/
        String ON_UPGRADE_QUERY = "DROP TABLE" + DATABASE_NOTEDB;
        String ON_UPGRADE_QUERY2 = "DROP TABLE2" + DATABASE_NOTEDB;
        String ON_UPGRADE_QUERY3 = "DROP TABLE3" + DATABASE_NOTEDB;
        String ON_UPGRADE_QUERY4 = "DROP TABLE4" + DATABASE_NOTEDB;

          /*DROP INCOME  TABLE RUN*/
        db.execSQL(ON_UPGRADE_QUERY);

        /*DROP ARGENT  TABLE RUN*/
        db.execSQL(ON_UPGRADE_QUERY2);


        /*DROP POSSIBLE  TABLE RUN*/
        db.execSQL(ON_UPGRADE_QUERY3);

          /*DROP YEARLY  TABLE RUN*/
        db.execSQL(ON_UPGRADE_QUERY4);

        /*again create table*/
        onCreate(db);

    }


    /*step:5 Insert data to income table */
    public boolean insertData(String title, String amount, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(INCOME_TITLE, title);
        contentValues.put(INCOME_AMOUNT, amount);
        contentValues.put(INCOME_DATE, date);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    /*step:5 Insert data to argent table */
    public boolean insertData2(String title, String amount, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ARGENT_TITLE, title);
        contentValues.put(ARGENT_AMOUNT, amount);
        contentValues.put(ARGENT_DATE, date);
        long result = db.insert(TABLE_NAME2, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }


    /*step:5 Insert data to possible table */
    public boolean insertData3(String title, String amount, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(POSSIBLE_TITLE, title);
        contentValues.put(POSSIBLE_AMOUNT, amount);
        contentValues.put(POSSIBLE_DATE, date);
        long result = db.insert(TABLE_NAME3, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }


    /*step:5 Insert data to yearly table */
    public boolean insertData4(String title, String amount, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(YEARLY_TITLE, title);
        contentValues.put(YEARLY_AMOUNT, amount);
        contentValues.put(YEARLY_DATE, date);
        long result = db.insert(TABLE_NAME4, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    /*step:6 Update data to income table */
    public boolean updateData(String id, String title, String amount, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(INCOME_TITLE, title);
        contentValues.put(INCOME_AMOUNT, amount);
        contentValues.put(INCOME_DATE, date);
        long result = db.update(DATABASE_NOTEDB, contentValues, "ID = ?", new String[]{id});

        return true;

    }

    /*step:6 Update data to argent table */
    public boolean updateData2(String id, String title, String amount, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ARGENT_TITLE, title);
        contentValues.put(ARGENT_AMOUNT, amount);
        contentValues.put(ARGENT_DATE, date);
        long result = db.update(DATABASE_NOTEDB, contentValues, "ID = ?", new String[]{id});

        return true;

    }


    /*step:6 Update data to possible table */
    public boolean updateData3(String id, String title, String amount, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(POSSIBLE_TITLE, title);
        contentValues.put(POSSIBLE_AMOUNT, amount);
        contentValues.put(POSSIBLE_DATE, date);
        long result = db.update(DATABASE_NOTEDB, contentValues, "ID = ?", new String[]{id});

        return true;

    }


    /*step:6 Update data to yearly table */
    public boolean updateData4(String id, String title, String amount, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(YEARLY_TITLE, title);
        contentValues.put(YEARLY_AMOUNT, amount);
        contentValues.put(YEARLY_DATE, date);
        long result = db.update(DATABASE_NOTEDB, contentValues, "ID = ?", new String[]{id});

        return true;

    }


    /* step:7 List to multi show income data*/
    public List<Item> getAllData() {
        List<Item> itemList = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {

            while (cursor.moveToNext()) {

                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String amount = cursor.getString(2);
                String date = cursor.getString(3);
                Item item = new Item();
                item.setWishId(id);
                item.setWishString(title);
                item.setAmountInteger(amount);
                item.setNoteDate(date);
                itemList.add(item);
            }

        }
        db.close();
        return itemList;
    }


    /* step:7 List to multi show argent data*/
    public List<Item> getAllData2() {
        List<Item> itemList2 = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME2;
        Cursor cursor = db.rawQuery(sql, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {

            while (cursor.moveToNext()) {

                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String amount = cursor.getString(2);
                String date = cursor.getString(3);
                Item item = new Item();
                item.setWishId(id);
                item.setWishString(title);
                item.setAmountInteger(amount);
                item.setNoteDate(date);
                itemList2.add(item);
            }

        }
        db.close();
        return itemList2;
    }

    /* step:7 List to multi show possible data*/
    public List<Item> getAllData3() {
        List<Item> itemList3 = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME3;
        Cursor cursor = db.rawQuery(sql, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {

            while (cursor.moveToNext()) {

                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String amount = cursor.getString(2);
                String date = cursor.getString(3);
                Item item = new Item();
                item.setWishId(id);
                item.setWishString(title);
                item.setAmountInteger(amount);
                item.setNoteDate(date);
                itemList3.add(item);
            }

        }
        db.close();
        return itemList3;
    }

    /* step:7 List to multi show data*/
    public List<Item> getAllData4() {
        List<Item> itemList4 = new ArrayList<Item>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME4;
        Cursor cursor = db.rawQuery(sql, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {

            while (cursor.moveToNext()) {

                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String amount = cursor.getString(2);
                String date = cursor.getString(3);
                Item item = new Item();
                item.setWishId(id);
                item.setWishString(title);
                item.setAmountInteger(amount);
                item.setNoteDate(date);
                itemList4.add(item);
            }

        }
        db.close();
        return itemList4;
    }


    /* step:7 List to show income data*/
    public Integer deleteData(int id) {
        String ids = "" + id;
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{ids});

    }

    /* step:7 List to show argent data*/
    public Integer deleteData2(int id) {
        String ids = "" + id;
        SQLiteDatabase db2 = this.getWritableDatabase();
        return db2.delete(TABLE_NAME2, "ID = ?", new String[]{ids});

    }

    /* step:7 List to show possible data*/
    public Integer deleteData3(int id) {
        String ids = "" + id;
        SQLiteDatabase db3 = this.getWritableDatabase();
        return db3.delete(TABLE_NAME3, "ID = ?", new String[]{ids});

    }

    /* step:7 List to show yearly data*/
    public Integer deleteData4(int id) {
        String ids = "" + id;
        SQLiteDatabase db4 = this.getWritableDatabase();
        return db4.delete(TABLE_NAME4, "ID = ?", new String[]{ids});

    }


}
