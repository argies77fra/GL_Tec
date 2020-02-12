package com.example.siriaco77.qpm.Componentes.Campo;

public class Campo {


    String Id;
    String Nombre;
    String Ubicacion;

    public Campo(String id, String nombre, String ubicacion) {
        Id = id;
        Nombre = nombre;
        Ubicacion = ubicacion;
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

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

}
