package com.pedapp.pedapp.pedapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pedapp.pedapp.pedapp.Utilities.Utilities;

public class ChallengesNotComplete extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View inflator = inflater.inflate(R.layout.fragment_not_complete, null);

        final TextView respondTextView = (TextView) inflator.findViewById(R.id.respond);
        respondTextView.setText(Challenges.respondfor);

        final TextView punishTextView = (TextView) inflator.findViewById(R.id.punish);
        int drinks = (int) (Math.random() * 3) + 1;
        punishTextView.setText("Tomas "+drinks+" Tragos");

        builder.setView(inflator);
        return builder.create();


    }

}