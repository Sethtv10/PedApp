package com.pedapp.pedapp.pedapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pedapp.pedapp.pedapp.Utilities.Utilities;

public class PlayersRegistrationActivity extends AppCompatActivity {

    EditText /*fieldID,*/ fieldCHALLENGE,fieldCATEGORY;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges_registration);

        //SE CAPTURA LA INFORMACION DE LOS CAMPOS DE FORMULARIO

        //fieldID = (EditText) findViewById(R.id.fieldID);
        fieldCHALLENGE = (EditText) findViewById(R.id.fieldCHALLENGE);
        fieldCATEGORY = (EditText) findViewById(R.id.fieldCATEGORY);


    }
    public void onClick(View view){
        //ALMACENA LOS RETOS EN LA BASE DE DATOS
        registerChallenges();
    }

    private void registerChallenges() {
        //ABRIMOS INICIALMENTE LA CONEXION PARA PODER ESCRIBIR
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_pedapp", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        //SIRVE COMO HAASH TABLE
        ContentValues values = new ContentValues();

        //values.put(Utilities.FIELD_ID, fieldID.getText().toString());
        values.put(Utilities.FIELD_CHALLENGE, fieldCHALLENGE.getText().toString());
        values.put(Utilities.FIELD_CATEGORY, fieldCATEGORY.getText().toString());

        //INSERTA LA INFORMACION EN LA BASE DE DATOS
        Long idResultante = db.insert(Utilities.TABLE_CHALLENGE, Utilities.FIELD_CHALLENGE, values);

        Toast.makeText(getApplicationContext(),"Registry ID: " +idResultante, Toast.LENGTH_SHORT).show();
    }
}
