package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    CardView cardview1, cardview2, cardview3, cardview4, cardview5, cardview6, cardview7,cardview8, cardview9, cardview10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(Color.BLACK);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cardview1 = findViewById(R.id.cardview1);
        cardview2 = findViewById(R.id.cardview2);
        cardview3 = findViewById(R.id.cardview3);
        cardview4 = findViewById(R.id.cardview4);
        cardview5 = findViewById(R.id.cardview5);
        cardview6 = findViewById(R.id.cardview6);
        cardview7 = findViewById(R.id.cardview7);
        cardview8 = findViewById(R.id.cardview8);
        cardview9 = findViewById(R.id.cardview9);
        cardview10 = findViewById(R.id.cardview10);

        cardview1.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), GeneralKnowledge.class)));
        cardview2.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), History.class)));
        cardview3.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Geography.class)));
        cardview4.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Science.class)));
        cardview5.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Mathematics.class)));
        cardview6.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Literature.class)));
        cardview7.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Technology.class)));
        cardview8.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Sports.class)));
        cardview9.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Music.class)));
        cardview10.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), BusinessEconomics.class)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.closeapp) {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Alert!");
            builder.setMessage("Do you want to exit?");
            builder.setCancelable(false);
            builder.setPositiveButton("YES",(dialog, which) -> finish());
            builder.setNegativeButton("NO",(dialog, which) -> dialog.cancel());
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert!");
        builder.setMessage("Do you want to exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("YES",(dialog, which) -> finish());
        builder.setNegativeButton("NO",(dialog, which) -> dialog.cancel());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}