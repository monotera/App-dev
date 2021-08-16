package com.example.taller01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FibonacciActivity extends ListActivity {
    private ArrayList<String> fiboList = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_fibonacci);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        fiboList = fibonacci(Integer.valueOf(message));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fiboList);
        setListAdapter(adapter);
    }
    public static ArrayList<String> fibonacci (Integer max) {
        ArrayList<String> fiboAux = new ArrayList<String>();
        int n0=0;
        int n1=1;
        int n2=1;

        if(max == 0) return fiboAux;

        if(max == 1) {
            fiboAux.add(Integer.toString(n0));
            return fiboAux;
        }

        fiboAux.add(Integer.toString(n0));
        fiboAux.add(Integer.toString(n1));

        for (int i = 0; i < max -2; ++i){
            fiboAux.add(Integer.toString(n2));
            n0=n1;
            n1=n2;
            n2 = n1 + n0;
        }
        return fiboAux;
    }
}