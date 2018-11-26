package com.pedapp.pedapp.pedapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pedapp.pedapp.pedapp.Utilities.Utilities;


public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    // final String CREATE_TABLE_PLAYERS = "CREATE TABLE Players (id INTEGER, nombre TEXT, genero TEXT)";

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilities.CREATE_TABLE_PLAYERS);
        db.execSQL(Utilities.CREATE_TABLE_CHALLENGE);
        db.execSQL("INSERT INTO " + Utilities.TABLE_CHALLENGE + "(" + Utilities.FIELD_CATEGORY + "," + Utilities.FIELD_CHALLENGE + "," + Utilities.FIELD_RESPOND + "," + Utilities.FIELD_FROMUSER + ") VALUES (1, 'CUENTA UNA HISTORIA','MUCHA PENA?',0)");
        db.execSQL("INSERT INTO " + Utilities.TABLE_CHALLENGE + "(" + Utilities.FIELD_CATEGORY + "," + Utilities.FIELD_CHALLENGE + "," + Utilities.FIELD_RESPOND + "," + Utilities.FIELD_FROMUSER + ") VALUES (1, 'DI QUIEN FUE TU PRIMER AMOR','¿TAN FEO ESTABA?', 0)");
        db.execSQL("INSERT INTO " + Utilities.TABLE_CHALLENGE + "(" + Utilities.FIELD_CATEGORY + "," + Utilities.FIELD_CHALLENGE + "," + Utilities.FIELD_RESPOND + "," + Utilities.FIELD_FROMUSER + ") VALUES (2, 'CUENTA TU ULTIMO BESO','¿ENSERIO?', 0)");
        db.execSQL("INSERT INTO " + Utilities.TABLE_CHALLENGE + "(" + Utilities.FIELD_CATEGORY + "," + Utilities.FIELD_CHALLENGE + "," + Utilities.FIELD_RESPOND + "," + Utilities.FIELD_FROMUSER + ") VALUES (2, 'INVITA LA RONDA','BUENA ELECCION', 0)");
        db.execSQL("INSERT INTO " + Utilities.TABLE_CHALLENGE + "(" + Utilities.FIELD_CATEGORY + "," + Utilities.FIELD_CHALLENGE + "," + Utilities.FIELD_RESPOND + "," + Utilities.FIELD_FROMUSER + ") VALUES (3, 'BAILA UNA CANCION DE DURANGUENZE','PERO SI BAILAS BIEN' , 0)");
        db.execSQL("INSERT INTO " + Utilities.TABLE_CHALLENGE + "(" + Utilities.FIELD_CATEGORY + "," + Utilities.FIELD_CHALLENGE + "," + Utilities.FIELD_RESPOND + "," + Utilities.FIELD_FROMUSER + ") VALUES (3, 'SUBE UN HISTORIA LLORANDO (ETIQUETA A LA APP)','DAAA!, TODOS SABRAN QUE ESTAS JUAGANDO' , 0)");
        db.execSQL("INSERT INTO " + Utilities.TABLE_CHALLENGE + "(" + Utilities.FIELD_CATEGORY + "," + Utilities.FIELD_CHALLENGE + "," + Utilities.FIELD_RESPOND + "," + Utilities.FIELD_FROMUSER + ") VALUES (4, 'GRITA LO MAS FUERTE POSIBLE','PERDISTE UN GRITO LIBERADOR', 0)");
        db.execSQL("INSERT INTO " + Utilities.TABLE_CHALLENGE + "(" + Utilities.FIELD_CATEGORY + "," + Utilities.FIELD_CHALLENGE + "," + Utilities.FIELD_RESPOND + "," + Utilities.FIELD_FROMUSER + ") VALUES (4, 'QUITATE LOS ZAPATOS','PERO ES COMODO' , 0)");
        db.execSQL("INSERT INTO " + Utilities.TABLE_CHALLENGE + "(" + Utilities.FIELD_CATEGORY + "," + Utilities.FIELD_CHALLENGE + "," + Utilities.FIELD_RESPOND + "," + Utilities.FIELD_FROMUSER + ") VALUES (5, 'PRENDA FUERA','¿NI UN CALCETIN?', 0)");
        db.execSQL("INSERT INTO " + Utilities.TABLE_CHALLENGE + "(" + Utilities.FIELD_CATEGORY + "," + Utilities.FIELD_CHALLENGE + "," + Utilities.FIELD_RESPOND + "," + Utilities.FIELD_FROMUSER + ") VALUES (5, 'BESO EN EL CUELLO ','¿TANTO ASCO DA?' , 0)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Players");
        onCreate(db);
    }
}
