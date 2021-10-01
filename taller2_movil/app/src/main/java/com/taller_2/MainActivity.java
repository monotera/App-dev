package com.taller_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onContactClick(View view) {
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }

    public void onCameraClick(View view){
        Intent intent = new Intent(this,Camera.class);
        startActivity(intent);
    }

    public void onMapsCLick(View view){
        Intent intent = new Intent(this,MapsActivity.class);
        startActivity(intent);
    }
}