package com.example.location;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void goToLocationSingleUse(View view){
        Intent intent = new Intent(this, LocationSingleUseActivity.class);
        startActivity(intent);
    }

    public void goToLocationAware(View view){
        Intent intent = new Intent(this, LocationAware.class);
        startActivity(intent);
    }
}