package com.example.ejerciciolistas;

import java.util.ArrayList;
import com.google.gson.Gson;

public class Sitios {

    private ArrayList<Sitio> sitiosList;

    public ArrayList<Sitio> getSitiosList() {
        return sitiosList;
    }

    public Sitios(){this.sitiosList = new ArrayList<>();}

    public Sitios(ArrayList<Sitio> sitiosList) {
        this.sitiosList = sitiosList;
    }

    public String toJSON(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public Sitios fromJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json,Sitios.class);
    }

    public void addSitio (Sitio sitio){
        sitiosList.add(sitio);
    }

    public void removeSitio(Sitio sitio){
        sitiosList.remove(sitio);
    }

    @Override
    public String toString() {
        return "Sitios{" +
                "sitiosList=" + sitiosList +
                '}';
    }
}
