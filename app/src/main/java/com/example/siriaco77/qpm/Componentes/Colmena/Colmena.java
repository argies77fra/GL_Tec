package com.example.siriaco77.qpm.Componentes.Colmena;

import com.example.siriaco77.qpm.Componentes.Colmenar.Colmenar;
import com.example.siriaco77.qpm.Componentes.Estado_Colmena.Estado_Colmena;
import com.example.siriaco77.qpm.Componentes.Estado_Sanidad.Estado_Sanidad;
import com.example.siriaco77.qpm.Componentes.Nivel_Produccion.Nivel_Produccion;
import com.example.siriaco77.qpm.Componentes.Origen_Reina.Origen_Reina;
import com.example.siriaco77.qpm.Componentes.Tipo_Colmena.Tipo_Colmena;


public class Colmena{

    private String Id;
    private String CantidadCuadros;
    private String Tamano;
    private String Descripcion;
    private String FechaAlta;
    private String activa;
    private String IdColmenar;
    private String IdTipoColmena;
    private String IdEstadoSanidad;
    private String IdOrigenReina;
    private String IdEstadoColmena;
    private String IdNivelProduccion;

    private Colmenar colmenar;
    //Campo campo;
    private Tipo_Colmena tipo_colmena;
    private Estado_Sanidad estado_sanidad;
    private Origen_Reina origen_reina;
    private Estado_Colmena estado_colmena;

    private Nivel_Produccion nivel_produccion;


    public Estado_Colmena getEstado_colmena() {
        return estado_colmena;
    }

    public void setEstado_colmena(Estado_Colmena estado_colmena) {
        this.estado_colmena = estado_colmena;
    }

    public Origen_Reina getOrigen_reina() {
        return origen_reina;
    }

    public void setOrigen_reina(Origen_Reina origen_reina) {
        this.origen_reina = origen_reina;
    }

    public Estado_Sanidad getEstado_sanidad() {
        return estado_sanidad;
    }

    public void setEstado_sanidad(Estado_Sanidad estado_sanidad) {
        this.estado_sanidad = estado_sanidad;
    }

    public Tipo_Colmena getTipo_colmena() {
        return tipo_colmena;
    }

    public void setTipo_colmena(Tipo_Colmena tipo_colmena) {
        this.tipo_colmena = tipo_colmena;
    }

    public Colmenar getColmenar() {
        return colmenar;
    }

    public void setColmenar(Colmenar colmenar) {
        this.colmenar = colmenar;
    }

    public Nivel_Produccion getNivel_produccion() {
        return nivel_produccion;
    }

    public void setNivel_produccion(Nivel_Produccion nivel_produccion) {
        this.nivel_produccion = nivel_produccion;
    }


   public Colmena(String id, String cantidadCuadros, String tamano, String descripcion, String fechaAlta, String activa, String idColmenar, String idTipoColmena, String idEstadoSanidad, String idOrigenReina, String idEstadoColmena, String idNivelProduccion, String estado_colmena) {
        Id = id;
        CantidadCuadros = cantidadCuadros;
        Tamano = tamano;
        Descripcion = descripcion;
        FechaAlta = fechaAlta;
        this.activa = activa;
        IdColmenar = idColmenar;
        IdTipoColmena = idTipoColmena;
        IdEstadoSanidad = idEstadoSanidad;
        IdOrigenReina = idOrigenReina;
        IdEstadoColmena = idEstadoColmena;
        IdNivelProduccion = idNivelProduccion;
        estado_colmena =estado_colmena;

    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCantidadCuadros() {
        return CantidadCuadros;
    }

    public void setCantidadCuadros(String cantidadCuadros) {
        CantidadCuadros = cantidadCuadros;
    }

    public String getTamano() {
        return Tamano;
    }

    public void setTamano(String tamano) {
        Tamano = tamano;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        FechaAlta = fechaAlta;
    }

    public String getActiva() {
        return activa;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }

    public String getIdColmenar() {
        return IdColmenar;
    }

    public void setIdColmenar(String idColmenar) {
        IdColmenar = idColmenar;
    }

    public String getIdTipoColmena() {
        return IdTipoColmena;
    }

    public void setIdTipoColmena(String idTipoColmena) {
        IdTipoColmena = idTipoColmena;
    }

    public String getIdEstadoSanidad() {
        return IdEstadoSanidad;
    }

    public void setIdEstadoSanidad(String idEstadoSanidad) {
        IdEstadoSanidad = idEstadoSanidad;
    }

    public String getIdOrigenReina() {
        return IdOrigenReina;
    }

    public void setIdOrigenReina(String idOrigenReina) {
        IdOrigenReina = idOrigenReina;
    }

    public String getIdEstadoColmena() {
        return IdEstadoColmena;
    }

    public void setIdEstadoColmena(String idEstadoColmena) {
        IdEstadoColmena = idEstadoColmena;
    }

    public String getIdNivelProduccion() {
        return IdNivelProduccion;
    }

    public void setIdNivelProduccion(String idNivelProduccion) {
        IdNivelProduccion = idNivelProduccion;
    }




 }