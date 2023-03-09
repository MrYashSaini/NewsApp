package com.example.ysnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CountryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String countryNames = "in";
    Spinner spinner;
    String[] country = {"India","Japan","New Zealand","Russia","USA"};
    String[] countrySymbol = {"in","jp","nz","ru","us"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        spinner = findViewById(R.id.spinner);
        Button button = findViewById(R.id.btnStart);

        spinner.setOnItemSelectedListener(CountryActivity.this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CountryActivity.this,MainActivity.class));
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        countryNames = countrySymbol[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    public String getCNames(){
        return countryNames;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}