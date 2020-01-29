package com.example.siriaco77.qpm.Componentes.Colmenar;

import com.example.siriaco77.qpm.Componentes.Campo.Campo;

public class Colmenar {
    String Id;
    String Nombre;
    String Ubicacion;
    String IdCampo;
    Campo campo;

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }




    public Colmenar(String id, String nombre, String ubicacion, String idCampo) {
        Id = id;
        Nombre = nombre;
        Ubicacion = ubicacion;
        IdCampo = idCampo;
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

    public String getIdCampo() {
        return IdCampo;
    }

    public void setIdCampo(String idCampo) {
        IdCampo = idCampo;
    }


}
