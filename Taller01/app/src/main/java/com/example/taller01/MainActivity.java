package com.example.taller01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int fibonacci_counter = 0;
    private int fact_counter = 0;
    private int countries_counter = 0;
    private int selected = -1;
    public static final String EXTRA_MESSAGE = "com.example.taller01.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        editText.setText("1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss", Locale.getDefault());
        String currentDateandTime = sdf.format(new Date());
        switch (this.selected){
            case 0:
                Button fiboBtn = (Button) findViewById(R.id.fiboBtn);
                fibonacci_counter++;
                fiboBtn.setText("FIBONACCI: " + Integer.toString(fibonacci_counter));
                TextView lastConnectionFibo = (TextView) findViewById(R.id.last_fibo);
                lastConnectionFibo.setText("Ultima conexion: " + currentDateandTime);
                break;
            case 1:
                Button factBtn = (Button) findViewById(R.id.button3);
                fact_counter++;
                factBtn.setText("FACTORIAL: " + Integer.toString(fact_counter));
                TextView lastConnectionFact = (TextView) findViewById(R.id.last_fact);
                lastConnectionFact.setText("Ultima conexion: " + currentDateandTime);
                break;
            case 2:
                Button countriesBtn = (Button) findViewById(R.id.button4);
                countries_counter++;
                countriesBtn.setText("COUNTRIES: " + Integer.toString(countries_counter));
                TextView lastConnectionCountries = (TextView) findViewById(R.id.last_countries);
                lastConnectionCountries.setText("Ultima conexion: " + currentDateandTime);
                break;
            default:
                break;
        }
    }

    public void onFiboBtnClick(View view){
        this.selected = 0;
        Intent intent = new Intent(this, FibonacciActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
    public void onFactBtnClick(View view){
        this.selected = 1;
        Intent intent = new Intent(this, FactorialActivity.class);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String message = mySpinner.getSelectedItem().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
    public void onCountriesBtnClick(View view){
        this.selected = 2;
        Intent intent = new Intent(this, CountriesActivity.class);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String message = mySpinner.getSelectedItem().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

}