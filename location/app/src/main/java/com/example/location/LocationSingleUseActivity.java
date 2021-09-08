package com.example.location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.logging.Logger;

public class LocationSingleUseActivity extends AppCompatActivity {
    // Setup del logger para esta clase
    private static final String TAG = LocationSingleUseActivity.class.getName();
    private Logger logger = Logger.getLogger(TAG);
    //Variables de permisos
    private final int LOCATION_PERMISSION_ID = 103;
    String locationPerm = Manifest.permission.ACCESS_FINE_LOCATION;
    //Variables de localizacion
    private FusedLocationProviderClient mFusedLocationClient;
    //Variables de UI
    TextView latitud, longitud, elevacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_single_use);
        latitud = findViewById(R.id.latitudeLabel);
        longitud = findViewById(R.id.longitudeLabel);
        elevacion = findViewById(R.id.elevationLAble);

        //Inicializar el FusedLocationProviderClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        requestPermission(this, locationPerm, "Permiso para utilizar la localizacion", LOCATION_PERMISSION_ID);
        initView();
    }

    private void requestPermission(Activity context, String permission, String justification, int id){
        // Verificar si no hay permisos
        if (ContextCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_DENIED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(context, permission)) {
                Toast.makeText(context, justification, Toast.LENGTH_SHORT).show();
            }
            // request the permission.
            ActivityCompat.requestPermissions(context, new String[]{permission}, id);
        }
    }

    private void initView() {
        if (ContextCompat.checkSelfPermission(this, locationPerm)
                != PackageManager.PERMISSION_GRANTED) {
            logger.warning("Failed to getting the location permission :(");
        } else {
            logger.info("Success getting the location permission :)");
            mFusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
                Log.i("LOCATION", "onSuccess location");
                if (location != null) {
                    Log.i(" LOCATION ", "Longitud: " + location.getLongitude());
                    Log.i(" LOCATION ", "Latitud: " + location.getLatitude());
                    latitud.setText(String.format("%s", location.getLatitude()));
                    longitud.setText(String.format("%s", location.getLongitude()));
                    elevacion.setText(String.format("%s", location.getAltitude()));
                }
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == LOCATION_PERMISSION_ID){
            initView();
        }
    }

    public void refresh(View view){
        initView();
    }
}