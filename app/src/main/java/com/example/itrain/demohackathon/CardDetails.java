package com.example.itrain.demohackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CardDetails extends AppCompatActivity {

    private Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);

        addItemsOnSpinner2();

        Button btnsub = (Button)findViewById(R.id.btn_login);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
                Intent intmain = new Intent(CardDetails.this,MainActivity.class);
                startActivity(intmain);
            }
        });

    }

    public void addItemsOnSpinner2() {

        spin = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("RHB");
        list.add("CIMB");
        list.add("MAYBANK");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapter);
    }
}
