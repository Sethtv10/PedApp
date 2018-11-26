package com.pedapp.pedapp.pedapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pedapp.pedapp.pedapp.Utilities.Utilities;

public class Challenges extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenges);
        String[] args = new String[] {"0"};

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_pedapp", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

       // Cursor c = db.rawQuery(" SELECT * FROM "+Utilities.TABLE_CHALLENGE+"  WHERE  "+Utilities.FIELD_CHALLENGE+"=? ORDER BY RANDOM() LIMIT 1", args);
        Cursor c = db.rawQuery(" SELECT * FROM "+Utilities.TABLE_CHALLENGE+" WHERE "+Utilities.FIELD_CATEGORY+"=?  ORDER BY RANDOM() LIMIT 1", args);
        //Nos aseguramos de que existe al menos un registro
                if (c.moveToFirst()) {
                    //Recorremos el cursor hasta que no haya más registros
                    do {
                        String category= c.getString(0);
                        String challenge = c.getString(1);
                        String respond = c.getString(2);
                        String fromuser = c.getString(3);

                        TextView textView = (TextView)findViewById(R.id.challenge_text);
                        textView.setText(challenge);

                    } while(c.moveToNext());
                }



    }

    public void newChallengeButton(View view) {
        ChallengesRegistrationActivity challenge = new ChallengesRegistrationActivity();
        challenge.show(getSupportFragmentManager(), "NoticeDialogFragment");


    }

}

