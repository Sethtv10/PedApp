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
    public static String respond;
    public static String respondfor;
    public static String[] args;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenges);
        Bundle extras = getIntent().getExtras();
        args = new String[] { extras.getString("Category")};

        TextView textView = (TextView)findViewById(R.id.user_name);
        textView.setText("");

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
                        respond = c.getString(2);
                        String fromuser = c.getString(3);
                        if(Integer.parseInt(fromuser) == 1){
                            Cursor cur = db.rawQuery(" SELECT * FROM "+Utilities.TABLE_PLAYERS+"   ORDER BY RANDOM() LIMIT 1", null);
                            if (cur.moveToFirst()) {
                                do {
                                    String name = cur.getString(1);
                                    textView = (TextView)findViewById(R.id.user_name);
                                    textView.setText(name);
                                }while(cur.moveToNext());
                            }

                        }
                        textView = (TextView)findViewById(R.id.challenge_text);
                        textView.setText(challenge);

                    } while(c.moveToNext());
                }



    }

    public void newChallengeButton(View view) {
        ChallengesRegistrationActivity challenge = new ChallengesRegistrationActivity();
        challenge.show(getSupportFragmentManager(), "NoticeDialogFragment");


    }

    public void challengeComplete(View view) {
        String[] args;
        Bundle extras = getIntent().getExtras();
        args = new String[] { extras.getString("Category")};

        TextView textView = (TextView)findViewById(R.id.user_name);
        textView.setText("");

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_pedapp", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();


        Cursor c = db.rawQuery(" SELECT * FROM "+Utilities.TABLE_CHALLENGE+" WHERE "+Utilities.FIELD_CATEGORY+"=?  ORDER BY RANDOM() LIMIT 1", args);
        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                String category= c.getString(0);
                String challenge = c.getString(1);
                respond = c.getString(2);
                String fromuser = c.getString(3);
                if(Integer.parseInt(fromuser) == 1){
                    Cursor cur = db.rawQuery(" SELECT * FROM "+Utilities.TABLE_PLAYERS+"   ORDER BY RANDOM() LIMIT 1", null);
                    if (cur.moveToFirst()) {
                        do {
                            String name = cur.getString(1);
                            textView = (TextView)findViewById(R.id.user_name);
                            textView.setText(name);
                        }while(cur.moveToNext());
                    }

                }

                textView = (TextView)findViewById(R.id.challenge_text);
                textView.setText(challenge);

            } while(c.moveToNext());
        }
    }

    public void challengeNotComplete(View view) throws InterruptedException {
            respondfor = respond;
            ChallengesNotComplete challengenot = new ChallengesNotComplete();
            challengenot.show(getSupportFragmentManager(), "NoticeDialogFragment");
            challengeComplete(view);


    }

    public void back(View view){
        finish();
    }


}

