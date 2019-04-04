package com.example.ejerciciolistas;

class Sitio {
    private String sitio;

    public Sitio(String sitio) {
        this.sitio = sitio;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    @Override
    public String toString() {
        return "Sitio{" +
                "sitio='" + sitio + '\'' +
                '}';
    }
}
