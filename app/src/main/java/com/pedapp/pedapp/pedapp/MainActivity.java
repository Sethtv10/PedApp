package com.pedapp.pedapp.pedapp;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.pedapp.pedapp.pedapp.Utilities.Utilities;

import java.io.Console;
import java.lang.reflect.Array;


public class MainActivity extends AppCompatActivity {
    public int players = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_pedapp", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.execSQL("DELETE FROM Players");
        db.close();

    }


    public void plusButton(View view) {
            LinearLayout ll = (LinearLayout) findViewById(R.id.playerslayout);
            EditText et = new EditText(this);
            et.setId(players);
            et.setHint("Nombre de Jugador");
            et.setPadding(10,40,10,30);
            ll.addView(et);
             players = players + 1;
             EditText numberPlayers = (EditText) findViewById(R.id.numberOfPlayers);
             numberPlayers.setText(String.valueOf(players));
             et.setGravity(Gravity.CENTER);


    }
    public void lessButton(View view) {
        if (players > 2) {

            players = players - 1;
            LinearLayout ll = (LinearLayout) findViewById(R.id.playerslayout);
            EditText editText = (EditText) findViewById(players);
            ll.removeView(editText);
            EditText numberPlayers = (EditText) findViewById(R.id.numberOfPlayers);
            numberPlayers.setText(String.valueOf(players));
        }

    }

    public void onClickFierro(View view) {
        String[] playersArray = new String[players];

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_pedapp", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();
        db.execSQL("DELETE FROM Players");

        ContentValues values = new ContentValues();

        EditText edit = (EditText)findViewById(R.id.one);
        String result = edit.getText().toString();
        if(result.equals("")){
            db.execSQL("DELETE FROM Players");
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

            alertDialog.setMessage("¡Llene todos los nombres Compa!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "¡Jalo!",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return;
        }
        playersArray[0] = result;

        values.put(Utilities.FIELD_ID,0);
        values.put(Utilities.FIELD_NAME,result);
        values.put(Utilities.FIELD_GENDER,"N");
        Long res = db.insert(Utilities.TABLE_PLAYERS, Utilities.FIELD_ID, values);

        Log.d( "Registry ID: " , String.valueOf(res));

        edit = (EditText)findViewById(R.id.two);
        result = edit.getText().toString();
        if(result.equals("")){
            db.execSQL("DELETE FROM Players");
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

            alertDialog.setMessage("¡Llene todos los nombres Compa!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "¡Jalo!",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            return;
        }
        playersArray[1] = result;


        values.put(Utilities.FIELD_ID,1);
        values.put(Utilities.FIELD_NAME,result);
        values.put(Utilities.FIELD_GENDER,"N");
        res = db.insert(Utilities.TABLE_PLAYERS, Utilities.FIELD_ID, values);

        Log.d( "Registry ID: " , String.valueOf(res));

        for (int i = 2; i < players ; i++){
            edit = (EditText)findViewById(i);
            result = edit.getText().toString();
            if(result.equals("")){
                db.execSQL("DELETE FROM Players");
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                alertDialog.setMessage("¡Llene todos los nombres Compa!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "¡Jalo!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                return;
            }
            playersArray[i] = result;
            values.put(Utilities.FIELD_ID,i);
            values.put(Utilities.FIELD_NAME,result);
            values.put(Utilities.FIELD_GENDER,"N");
            res = db.insert(Utilities.TABLE_PLAYERS, Utilities.FIELD_ID, values);


            Log.d( "Registry ID: " , String.valueOf(res));
        }

        db.close();

        Intent intent = new Intent(this ,CategorySelector.class);
        startActivity(intent);



    }
}
