package com.example.itrain.demohackathon;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class WhatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertAdd = new AlertDialog.Builder(WhatsActivity.this);
                alertAdd.setMessage("New Card Created")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // FIRE ZE MISSILES!
                            }
                        });
                alertAdd.show();
            }
        });

        FloatingActionButton del = (FloatingActionButton) findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertdel = new AlertDialog.Builder(WhatsActivity.this);
                alertdel.setMessage("Successfully Delete")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // FIRE ZE MISSILES!
                            }
                        });
                alertdel.show();
            }
        });


        ImageButton ib = (ImageButton)findViewById(R.id.btnedit);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentedit = new Intent(WhatsActivity.this, CardDetails.class);
                startActivity(intentedit);
            }
        });

        ImageButton ibb = (ImageButton)findViewById(R.id.btnedit1);
        ibb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentedit1 = new Intent(WhatsActivity.this, CardDetails.class);
                startActivity(intentedit1);
            }
        });
    }
}
