package com.pedapp.pedapp.pedapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pedapp.pedapp.pedapp.Utilities.Utilities;

public class ChallengesRegistrationActivity extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View inflator = inflater.inflate(R.layout.fragment_new_challenge, null);

        final EditText edit = (EditText) inflator.findViewById(R.id.newChallenge);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflator)
                // Add action buttons
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {


                        String result = edit.getText().toString();
                        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(getContext(), "db_pedapp", null, 1);

                        SQLiteDatabase db = conn.getWritableDatabase();

                        ContentValues values = new ContentValues();

                        values.put(Utilities.FIELD_CATEGORY,0);
                        values.put(Utilities.FIELD_CHALLENGE,result);
                        values.put(Utilities.FIELD_RESPOND,"TU LO PEDISTE.... TOMAS!");
                        values.put(Utilities.FIELD_FROMUSER,1);
                        Long res = db.insert(Utilities.TABLE_CHALLENGE, Utilities.FIELD_CHALLENGE, values);

                        Log.d( "Registry ID: " , String.valueOf(res));
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}