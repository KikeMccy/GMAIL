package com.example.gmail.modelo;

public class ModelWinzip {
    private String carpeta;
    private String detalle;

    public ModelWinzip(String carpeta, String detalle) {
        this.carpeta = carpeta;
        this.detalle = detalle;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
