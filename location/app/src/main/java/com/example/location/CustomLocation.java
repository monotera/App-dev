package com.example.location;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class CustomLocation {
    private double latitud;
    private double longitud;
    private Date fecha;

    public JSONObject toJSON () {
        JSONObject obj = new JSONObject();
        try {
            obj.put("latitud", getLatitud());
            obj.put("longitud", getLongitud());
            obj.put("date", getFecha());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date date) {
        this.fecha = date;
    }
}
