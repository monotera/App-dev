package com.example.taller01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private int fibonacci_counter = 0;
    private int fact_counter = 0;
    public static final String EXTRA_MESSAGE = "com.example.taller01.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button fiboBtn = (Button) findViewById(R.id.fiboBtn);
    }
    public void onFiboBtnClick(View view){
        fibonacci_counter++;
        Intent intent = new Intent(this, FibonacciActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
    public void onFactBtnClick(View view){
        Intent intent = new Intent(this, FactorialActivity.class);
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String message = mySpinner.getSelectedItem().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

}