package com.example.taller01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FactorialActivity extends AppCompatActivity {
    private String ecuacion = "";
    private long res = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        Intent intent = getIntent();
        String n = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        factorial(Integer.valueOf(n));
        TextView ecuacion_TV = (TextView)findViewById(R.id.fact_ecua);
        TextView res_TV = (TextView)findViewById(R.id.fact_res);
        ecuacion_TV.setText(ecuacion);
        res_TV.setText(Long.toString(res));
    }
    public void factorial(int n) {
        for (int i = 1; i <= n; i++){
            this.ecuacion = this.ecuacion + Integer.toString(i) + "x";
            this.res = this.res * i;
        }
        this.ecuacion = this.ecuacion.substring(0,this.ecuacion.length()-1);
        this.ecuacion = this.ecuacion + "=";
    }
}