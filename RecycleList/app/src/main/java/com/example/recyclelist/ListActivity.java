package com.example.recyclelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ArrayList<Item> items;
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        items= new ArrayList<>();
        list = (RecyclerView) findViewById(R.id.rlist);
        list.setLayoutManager(new LinearLayoutManager(this));

       fillItems();

        AdapterList al = new AdapterList(items);
        list.setAdapter(al);
    }

    private void fillItems(){
        items.add(new Item("Nelson","Mosquera",R.drawable.estacionamiento_autos_rosario));
        items.add(new Item("Nelson2","Mosquera",R.drawable.estacionamiento_autos_rosario));
        items.add(new Item("Nelson3","Mosquera",R.drawable.estacionamiento_autos_rosario));
        items.add(new Item("Nelson4","Mosquera",R.drawable.estacionamiento_autos_rosario));
    }
}