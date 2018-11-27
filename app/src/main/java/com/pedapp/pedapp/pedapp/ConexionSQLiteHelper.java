package com.pedapp.pedapp.pedapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.pedapp.pedapp.pedapp.Utilities.Utilities;


public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    // final String CREATE_TABLE_PLAYERS = "CREATE TABLE Players (id INTEGER, nombre TEXT, genero TEXT)";

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String[] arrChallenge;
        String[] arrRespond;
        Integer [] fromuser;
        Integer[] category;
        db.execSQL(Utilities.CREATE_TABLE_PLAYERS);
        db.execSQL(Utilities.CREATE_TABLE_CHALLENGE);

        //Insert de Retos de Categoria 1
        category = new Integer[]{1,1,2,2,3,3,4,4,5,5};
        arrChallenge = new String[] {"CUENTA UNA HISTORIA", "DI QUIEN FUE TU PRIMER AMOR","CUENTA TU ULTIMO BESO", "PERO SI BAILAS BIEN","BAILA UNA CANCION DE DURANGUENZE", "INVITA LA RONDA","GRITA LO MAS FUERTE POSIBLE", "SUBE UNA HISTORIA BAILANDO UN CUMBION","PRENDA FUERA", "BESO EN EL CUELLO A "};
        arrRespond = new String[] {"MUCHA PENA?", "¿TAN FEO ESTABA?","¿ENSERIO?", "BUENA ELECCION","PERO SI BAILAS BIEN", "BUENA ELECCION","PERDISTE UN GRITO LIBERADOR", "NO HAS DE TENER CELULAR!","¿NI UN CALCETIN?", "TANTO ASCO DA?"};
        fromuser = new Integer[]{0,0,0,0,0,0,0,0,0,1};
        insertArrayChallenges(db,category, arrChallenge,arrRespond, fromuser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Players");
        onCreate(db);
    }

    public void insertArrayChallenges(SQLiteDatabase db,Integer [] category, String [] arrChallenge, String [] arrRespond, Integer[] fromuser){

        for(int i = 0; i < arrChallenge.length;i++) {
            ContentValues values = new ContentValues();
            values.put(Utilities.FIELD_CATEGORY, category[i]);
            values.put(Utilities.FIELD_CHALLENGE, arrChallenge[i]);
            values.put(Utilities.FIELD_RESPOND, arrRespond[i]);
            values.put(Utilities.FIELD_FROMUSER, fromuser[i]);
            Long res = db.insert(Utilities.TABLE_CHALLENGE, Utilities.FIELD_CHALLENGE, values);
            Log.d("Registry ID: ", String.valueOf(res));
        }
    }
}
