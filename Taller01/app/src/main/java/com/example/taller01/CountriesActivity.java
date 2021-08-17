package com.example.taller01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CountriesActivity extends Activity {
    private static final String COUNTRIES_FILE = "countries.json";
    private ListView lv;
    JSONArray countries;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_countries);
        lv = (ListView)findViewById(R.id.countriesList);
        try {
            JSONObject jsonFile = loadCountriesByJson();
            countries = jsonFile.getJSONArray("Countries");
            ArrayList<String> aux = new ArrayList<String>();
            for (int i = 0; i < countries.length(); i++) {
                aux.add(countries.getJSONObject(i).getString("Name"));
            }
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aux);
            lv.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    public String loadJSONFromAsset(String assetName) {
        String json = null;
        try {
            InputStream is = this.getAssets().open(assetName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    public JSONObject loadCountriesByJson() throws JSONException {
        return new JSONObject(loadJSONFromAsset(COUNTRIES_FILE));
    }

}