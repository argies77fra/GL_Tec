package com.example.siriaco77.qpm.Componentes.Nivel_Produccion;

public class Nivel_Produccion {

    String Id;
    String Nombre;

    public Nivel_Produccion(String id, String nombre) {
        Id = id;
        Nombre = nombre;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
