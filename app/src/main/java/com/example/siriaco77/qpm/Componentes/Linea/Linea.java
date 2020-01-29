package com.example.siriaco77.qpm.Componentes.Linea;

public class Linea {

    String Id;
    String Activa;

    public Linea(String id, String activa) {
        Id = id;
        Activa = activa;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getActiva() {
        return Activa;
    }

    public void setActiva(String activa) {
        Activa = activa;
    }



}
