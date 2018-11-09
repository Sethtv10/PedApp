package com.pedapp.pedapp.pedapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    public int players = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_pedapp", null, 1);

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


}
