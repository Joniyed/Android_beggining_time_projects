package com.example.smartdeviceappdevelopementfall2019.db_access;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.smartdeviceappdevelopementfall2019.entity.RegistrationEntity;

public class DBConnection extends SQLiteOpenHelper {
    private final static int DATABASE_VERSION=1;
    private final static String DATABSE_NAME="smartdeviceappdevelopment.db";

    public DBConnection(@Nullable Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ RegistrationEntity.TABLE_NAME+"("+
                RegistrationEntity._ID+" INTEGER PRIMARY KEY,"+
                RegistrationEntity.FULL_NAME+" TEXT,"+
                RegistrationEntity.USER_NAME+" TEXT,"+
                RegistrationEntity.PASSWORD+" TEXT,"+
                RegistrationEntity.EMAIL_ADDRESS+" TEXT,"+
                RegistrationEntity.CONTACT_NUMBER+" TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(RegistrationEntity.TABLE_UPGRADE);
        onCreate(db);
    }

    public void addRegistrationData(String fullName, String userName, String password, String email, String contact){
        SQLiteDatabase database = getWritableDatabase();

        ContentValues registrationDataSave = new ContentValues();
        registrationDataSave.put(RegistrationEntity.FULL_NAME,fullName);
        registrationDataSave.put(RegistrationEntity.USER_NAME,userName);
        registrationDataSave.put(RegistrationEntity.PASSWORD,password);
        registrationDataSave.put(RegistrationEntity.EMAIL_ADDRESS,email);
        registrationDataSave.put(RegistrationEntity.CONTACT_NUMBER, contact);

        long resultOfRegistration = database.insert(RegistrationEntity.TABLE_NAME, null, registrationDataSave);
        if(resultOfRegistration>0){
            System.out.println("Data save successfully");
        }

    }

    public boolean checkLogin(String username, String password){
        try{
            SQLiteDatabase db = getReadableDatabase();
            String[] projection = {
                    RegistrationEntity._ID
            };
            String selection = RegistrationEntity.USER_NAME+"=? AND "+
                    RegistrationEntity.PASSWORD+"=?";
            String[] selectionArgs = {username,password};

            Cursor cursor = db.query(
                    RegistrationEntity.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null);
            if(cursor != null && cursor.getCount()>0){
                while (cursor.moveToNext()){
                    int id = cursor.getInt(
                            cursor.getColumnIndexOrThrow(
                                    RegistrationEntity._ID));

                    if(id > 0)
                        return Boolean.TRUE;
                }
            }

        }catch (Exception ex){
            Log.e("DBERROR",ex.getMessage());
        }
        return Boolean.FALSE;
    }

    public boolean updateData(String name, int id){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(RegistrationEntity.FULL_NAME,name);

        String selection = RegistrationEntity._ID+"=?";
        String[] selectionArgs = {String.valueOf(id)};

        int updateResult = db.update(RegistrationEntity.TABLE_NAME, contentValues, selection, selectionArgs);
        if(updateResult>0)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public boolean deleteData(int id){
        SQLiteDatabase db = getWritableDatabase();

        String selection = RegistrationEntity._ID+"=?";
        String[] selectionArgs = {String.valueOf(id)};

        int deleteResult = db.delete(RegistrationEntity.TABLE_NAME, selection, selectionArgs);
        if(deleteResult>0)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
