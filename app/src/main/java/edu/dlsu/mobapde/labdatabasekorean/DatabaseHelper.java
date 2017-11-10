package edu.dlsu.mobapde.labdatabasekorean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by G301 on 11/7/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String SCHEMA = "asian";
    public static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, SCHEMA, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // ROLE: create the tables for the schema
        // It will only be called once by the system
        // -- when the schema with given name doesn't exist yet

        /*
        * CREATE TABLE korean (
        *   _id INTEGER PRIMARY KEY AUTOINCREMENT,
        *   name TEXT ,
        *   age INTEGER,
        *   kpopgroup TEXT
        * );
        * */

        String sql = "CREATE TABLE " + Korean.TABLE_NAME + " ("
                + Korean.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Korean.COLUMN_NAME + " TEXT,"
                + Korean.COLUMN_AGE + " INTEGER,"
                + Korean.COLUMN_KPOPGROUP + " TEXT"
                + ");";
        sqLiteDatabase.execSQL(sql);

        addKorean(new Korean("Kim Jong Un", 10, "Fran"), sqLiteDatabase);
        addKorean(new Korean("Kim Chi", 10, "Fran"), sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int i, int i1) {
        // ROLE: update the current schema
        // Will be called when version number is newer/higher

        // migration
        // drop current tables
        String sql = "DROP TABLE IF EXISTS " + Korean.TABLE_NAME + ";";
        sqLiteDatabase.execSQL(sql);
        // call onCreate
        onCreate(sqLiteDatabase);
    }

    // addKorean
    public long addKorean(Korean korean){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Korean.COLUMN_NAME, korean.getName());
        contentValues.put(Korean.COLUMN_AGE, korean.getAge());
        contentValues.put(Korean.COLUMN_KPOPGROUP, korean.getKpopGroup());

        long id = db.insert(Korean.TABLE_NAME,
                null,
                contentValues);
        db.close();
        return id;
    }

    // addKorean
    public long addKorean(Korean korean, SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(Korean.COLUMN_NAME, korean.getName());
        contentValues.put(Korean.COLUMN_AGE, korean.getAge());
        contentValues.put(Korean.COLUMN_KPOPGROUP, korean.getKpopGroup());

        long id = db.insert(Korean.TABLE_NAME,
                null,
                contentValues);
        db.close();
        return id;
    }

    // editKorean
    public boolean editKorean(Korean newKoreanDetails, int currentId){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Korean.COLUMN_NAME, newKoreanDetails.getName());
        contentValues.put(Korean.COLUMN_AGE, newKoreanDetails.getAge());
        contentValues.put(Korean.COLUMN_KPOPGROUP, newKoreanDetails.getKpopGroup());

        int rowsAffected = db.update(Korean.TABLE_NAME,
                contentValues,
                Korean.COLUMN_ID + "=?",
                new String[]{newKoreanDetails.getId()+""});
        db.close();

        return rowsAffected >0;
    }

    // deleteKorean
    public boolean deleteKorean(long id){
        SQLiteDatabase db = getWritableDatabase();
        int rowsAffected = db.delete(Korean.TABLE_NAME,
                Korean.COLUMN_ID + "=?",
                new String[]{id+""} );
        db.close();
        return rowsAffected >0;
    }

    // getKorean
    public Korean getKorean(long id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(Korean.TABLE_NAME,
                null,
                Korean.COLUMN_ID + "=?",
                new String[]{ id+"" },
                null,
                null,
                null);
        Korean k = null;
        if(c.moveToFirst()){
            k = new Korean();
            k.setName(c.getString(c.getColumnIndex(Korean.COLUMN_NAME)));
            k.setAge(c.getInt(c.getColumnIndex(Korean.COLUMN_AGE)));
            k.setKpopGroup(c.getString(c.getColumnIndex(Korean.COLUMN_KPOPGROUP)));
            k.setId(id);
        }

        c.close();
        db.close();

        return k;
    }

    // getAllKoreans
    public Cursor getAllKoreansCursor(){
        return getReadableDatabase().query(Korean.TABLE_NAME, null,null,null,null,null,null);
    }
}






