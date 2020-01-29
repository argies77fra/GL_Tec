package com.example.siriaco77.qpm.Componentes.Historial_Estado_Sanidad;

public class HistorialEstadoSanidad {

    String IdEstadoSanidad;
    String IdColmena;
    String IdEnfermedad;
    String Observaciones;

    public HistorialEstadoSanidad(String idEstadoSanidad, String idColmena, String idEnfermedad, String observaciones) {
        IdEstadoSanidad = idEstadoSanidad;
        IdColmena = idColmena;
        IdEnfermedad = idEnfermedad;
        Observaciones = observaciones;
    }

    public HistorialEstadoSanidad(){

    }

    public String getIdEstadoSanidad() {
        return IdEstadoSanidad;
    }

    public void setIdEstadoSanidad(String idEstadoSanidad) {
        IdEstadoSanidad = idEstadoSanidad;
    }

    public String getIdColmena() {
        return IdColmena;
    }

    public void setIdColmena(String idColmena) {
        IdColmena = idColmena;
    }

    public String getIdEnfermedad() {
        return IdEnfermedad;
    }

    public void setIdEnfermedad(String idEnfermedad) {
        IdEnfermedad = idEnfermedad;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }






}
