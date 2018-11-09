package com.pedapp.pedapp.pedapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pedapp.pedapp.pedapp.Utilities.Utilities;


public class ConexionSQLiteHelper extends SQLiteOpenHelper{



    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Utilities.CREATE_TABLE_CHALLENGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
    db.execSQL("DROP TABLE IF EXISTS Challenge");
    onCreate(db);
    }
}
