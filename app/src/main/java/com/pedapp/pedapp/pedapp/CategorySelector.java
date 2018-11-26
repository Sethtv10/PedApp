package com.pedapp.pedapp.pedapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CategorySelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_selector);


    }

    public void leve(View view) {

        Intent i = new Intent(getBaseContext(), Challenges.class);
        i.putExtra("Category", "Leve");
        startActivity(i);

    }

    public void precopa(View view) {

        Intent i = new Intent(getBaseContext(), Challenges.class);
        i.putExtra("Category", "Precopa");
        startActivity(i);

    }

    public void sinaloense(View view) {

        Intent i = new Intent(getBaseContext(), Challenges.class);
        i.putExtra("Category", "Sinaloense");
        startActivity(i);

    }

    public void astral(View view) {

        Intent i = new Intent(getBaseContext(), Challenges.class);
        i.putExtra("Category", "Astral");
        startActivity(i);

    }

    public void hot(View view) {

        Intent i = new Intent(getBaseContext(), Challenges.class);
        i.putExtra("Category", "Hot");
        startActivity(i);

    }

}
