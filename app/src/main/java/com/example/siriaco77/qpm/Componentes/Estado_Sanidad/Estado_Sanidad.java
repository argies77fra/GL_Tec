package com.example.siriaco77.qpm.Componentes.Estado_Sanidad;

public class Estado_Sanidad {

    String Id;
    String Nombre;

    public Estado_Sanidad(String id, String nombre) {
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
