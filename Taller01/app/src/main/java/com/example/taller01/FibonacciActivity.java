package com.example.taller01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FibonacciActivity extends Activity{
    private ArrayList<String> fiboList = new ArrayList<String>();
    ListView lv;
    ImageView iv;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_fibonacci);
        Intent intent = getIntent();
        lv = (ListView)findViewById(R.id.fibo_list);
        iv = (ImageView)findViewById(R.id.imageView);
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        fiboList = fibonacci(Integer.valueOf(message));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fiboList);
        lv.setAdapter(adapter);
        iv.setImageResource(R.drawable.fibonacci2);
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