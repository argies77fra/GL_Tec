package com.example.siriaco77.qpm.Componentes.Tarea;

import com.example.siriaco77.qpm.Componentes.Colmena.Colmena;
import com.example.siriaco77.qpm.Componentes.Empleado.Empleado;
import com.example.siriaco77.qpm.Componentes.Estado_Tarea.Estado_Tarea;
import com.example.siriaco77.qpm.Componentes.Etapa_Produccion.Etapa_Produccion;
import com.example.siriaco77.qpm.Componentes.Linea.Linea;

public class Tarea {

    String Id;
    String Fecha;
    String IdEtapaProduccion;
    String IdcolmenaOrigen;
    String IdcolmenaDestino;
    String CantidadCeldas;
    String Observaciones;
    String IdLinea;
    String IdEstadoTarea;
    private String MotivoCambio;
    String IdEmpleado;
    String _FechaF;
    String _FechaI;

    Etapa_Produccion etapa_produccion;
    Linea linea;
    Estado_Tarea estado_tarea;
    Empleado empleado;
    Colmena colmena_origen;
    Colmena colmena_destino;


    public Etapa_Produccion getEtapa_produccion() {
        return etapa_produccion;
    }

    public void setEtapa_produccion(Etapa_Produccion etapa_produccion) {
        this.etapa_produccion = etapa_produccion;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public Estado_Tarea getEstado_tarea() {
        return estado_tarea;
    }

    public void setEstado_tarea(Estado_Tarea estado_tarea) {
        this.estado_tarea = estado_tarea;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Colmena getColmena_origen() {
        return colmena_origen;
    }

    public void setColmena_origen(Colmena colmena_origen) {
        this.colmena_origen = colmena_origen;
    }

    public Colmena getColmena_destino() {
        return colmena_destino;
    }

    public void setColmena_destino(Colmena colmena_destino) {
        this.colmena_destino = colmena_destino;
    }




    public Tarea(String id, String fecha, String idEtapaProduccion, String idcolmenaOrigen, String idcolmenaDestino, String cantidadCeldas, String observaciones, String idLinea, String idEstadoTarea, String motivoCambio, String idEmpleado, String _FechaF, String _FechaI) {
        Id = id;
        Fecha = fecha;
        IdEtapaProduccion = idEtapaProduccion;
        IdcolmenaOrigen = idcolmenaOrigen;
        IdcolmenaDestino = idcolmenaDestino;
        CantidadCeldas = cantidadCeldas;
        Observaciones = observaciones;
        IdLinea = idLinea;
        IdEstadoTarea = idEstadoTarea;
        MotivoCambio = motivoCambio;
        IdEmpleado = idEmpleado;
        this._FechaF = _FechaF;
        this._FechaI = _FechaI;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getIdEtapaProduccion() {
        return IdEtapaProduccion;
    }

    public void setIdEtapaProduccion(String idEtapaProduccion) {
        IdEtapaProduccion = idEtapaProduccion;
    }

    public String getIdcolmenaOrigen() {
        return IdcolmenaOrigen;
    }

    public void setIdcolmenaOrigen(String idcolmenaOrigen) {
        IdcolmenaOrigen = idcolmenaOrigen;
    }

    public String getIdcolmenaDestino() {
        return IdcolmenaDestino;
    }

    public void setIdcolmenaDestino(String idcolmenaDestino) {
        IdcolmenaDestino = idcolmenaDestino;
    }

    public String getCantidadCeldas() {
        return CantidadCeldas;
    }

    public void setCantidadCeldas(String cantidadCeldas) {
        CantidadCeldas = cantidadCeldas;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public String getIdLinea() {
        return IdLinea;
    }

    public void setIdLinea(String idLinea) {
        IdLinea = idLinea;
    }

    public String getIdEstadoTarea() {
        return IdEstadoTarea;
    }

    public void setIdEstadoTarea(String idEstadoTarea) {
        IdEstadoTarea = idEstadoTarea;
    }

    public String getMotivoCambio() {
        return MotivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        MotivoCambio = motivoCambio;
    }

    public String getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        IdEmpleado = idEmpleado;
    }

    public String get_FechaF() {
        return _FechaF;
    }

    public void set_FechaF(String _FechaF) {
        this._FechaF = _FechaF;
    }

    public String get_FechaI() {
        return _FechaI;
    }

    public void set_FechaI(String _FechaI) {
        this._FechaI = _FechaI;
    }
}
