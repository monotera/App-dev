package com.example.taller01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Paises2 extends AppCompatActivity {
    private static final String COUNTRIES_FILE = "countries.json";
    JSONArray countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises2);
        Intent intent = getIntent();
        String info = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String img_url = intent.getStringExtra(CountriesActivity.EXTRA_MESSAGE2);
        TextView inf = (TextView) findViewById(R.id.text_info);
        ImageView iv = (ImageView)findViewById(R.id.imageCountry);
        Glide.with(this).load(img_url).into(iv);


        inf.setText(info);
    }

}