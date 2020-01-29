package com.example.siriaco77.qpm.Componentes.Data;

import android.text.TextUtils;

import java.util.ArrayList;

public class Usuario {
    String id;
    String nombre;
    String apellido;
    String dni;
    String user;
    String email;
    String telefono;
    String idEstablecimiento;
    String idParentesco;
    String dni_hijo;
    String otroEstablecimiento;
    String idOrigen ="1";
    String idUsuarioPadre;
    int idPerfil;
    String direccion;

    String montoCuota;
    String fechaNacimiento;


    public static String usuario;
    public static String password;
    public static String nombreUsuarioActual;
    public static String idUsuarioActual;
    public static String idPerfilPermisos; //agregado
    public static String idEstablecimientoActual;
    public static String completo;//indica
    public static String versionAppV1="3";
    public static String versionAppV2="2";
    public static String versionAppV3="2";
    static String notificationId;//token firebase

    String notificationID;  //token para activacion de cuenta con disparo de notificacion

    public String getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
    }

    public static boolean permisoResponderMensaje;
    public static boolean permisoParteDiario;
    public static boolean permisoAutorizacion;
    public static boolean permisoCalendario;
    public static boolean permisoEnviarMensajeApp;
    public static boolean permisoCrearHijo;

    public static boolean getPermisoComunicacion() {
        return permisoComunicacion;
    }

    public static void setPermisoComunicacion(boolean permisoComunicacion) {
        Usuario.permisoComunicacion = permisoComunicacion;
    }

    /***************************permisos profe/director****************/
    public static boolean permisoComunicacion;
    public static boolean permisoRegistrarInforme;
    public static boolean permisoTomarAsistencia;
    public static boolean permisoEventos;
    public static boolean permisoAutorizaciones;
    public static boolean permisoCertificadosMedicos;
    public static boolean permisoServicio;
    public static boolean permisoInstitucional;
    public static boolean permisoAdministracion;

    public static boolean permisoAdministracionPagos;

    public static boolean permisoRealizarPagos;


    public static boolean getPermisoRealizarPagos() {
        return permisoRealizarPagos;
    }

    public static void setPermisoRealizarPagos(boolean permisoRealizarPagos) {
        Usuario.permisoRealizarPagos = permisoRealizarPagos;
    }

    public static boolean getPermisoAdministracionPagos() {
        return permisoAdministracionPagos;
    }

    public static void setPermisoAdministracionPagos(boolean permisoAdministracionPagos) {
        Usuario.permisoAdministracionPagos = permisoAdministracionPagos;
    }

    public static boolean getPermisoRegistrarInforme() {
        return permisoRegistrarInforme;
    }

    public static void setPermisoRegistrarInforme(boolean permisoRegistrarInforme) {
        Usuario.permisoRegistrarInforme = permisoRegistrarInforme;
    }

    public static boolean getPermisoTomarAsistencia() {
        return permisoTomarAsistencia;
    }

    public static void setPermisoTomarAsistencia(boolean permisoTomarAsistencia) {
        Usuario.permisoTomarAsistencia = permisoTomarAsistencia;
    }


    public static boolean getPermisoEventos() {
        return permisoEventos;
    }

    public static void setPermisoEventos(boolean permisoEventos) {
        Usuario.permisoEventos = permisoEventos;
    }


    public static boolean getPermisoAutorizaciones() {
        return permisoAutorizaciones;
    }

    public static void setPermisoAutorizaciones(boolean permisoAutorizaciones) {
        Usuario.permisoAutorizaciones = permisoAutorizaciones;
    }


    public static boolean getPermisoCertificadosMedicos() {
        return permisoCertificadosMedicos;
    }

    public static void setPermisoCertificadosMedicos(boolean permisoCertificadosMedicos) {
        Usuario.permisoCertificadosMedicos = permisoCertificadosMedicos;
    }


    public static boolean getPermisoServicio() {
        return permisoServicio;
    }

    public static void setPermisoServicio(boolean permisoServicio) {
        Usuario.permisoServicio = permisoServicio;
    }


    public static boolean getPermisoInstitucional() {
        return permisoInstitucional;
    }

    public static void setPermisoInstitucional(boolean permisoInstitucional) {
        Usuario.permisoInstitucional = permisoInstitucional;
    }


    public static boolean getPermisoAdministracion() {
        return permisoAdministracion;
    }

    public static void setPermisoAdministracion(boolean permisoAdministracion) {
        Usuario.permisoAdministracion = permisoAdministracion;
    }

    /******/

    ArrayList idsgrupos;

    public ArrayList getIdshijos() {
        return idshijos;
    }

    public void setIdshijos(ArrayList idshijos) {
        this.idshijos = idshijos;
    }

    ArrayList idshijos;

    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String dni, String user, String email, String telefono, int idPerfil, String idEstablecimiento, String dni_hijo,String idParentesco,String otroEstablecimiento,String notificationId,String notificationID, String direccion,String montoCuota){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.user = user;
        this.email = email;
        this.telefono = telefono;
        this.idPerfil = idPerfil;
        this.idEstablecimiento = idEstablecimiento;//no es static
        this.notificationId = notificationId;
        this.dni_hijo =dni_hijo;
        this.idParentesco =idParentesco;
        this.otroEstablecimiento=otroEstablecimiento;
        this.notificationID=notificationID;
        this.direccion=direccion;
        this.montoCuota=montoCuota;
    }

    public String getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(String montoCuota) {
        this.montoCuota = montoCuota;
    }


    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(String idOrigen) {
        this.idOrigen = idOrigen;
    }

    public String getOtroEstablecimiento() {
        return otroEstablecimiento;
    }

    public void setOtroEstablecimiento(String otroEstablecimiento) {
        this.otroEstablecimiento = otroEstablecimiento;
    }

    public String getIdUsuarioPadre() {
        return idUsuarioPadre;
    }

    public void setIdUsuarioPadre(String idUsuarioPadre) {
        this.idUsuarioPadre = idUsuarioPadre;
    }

    public String getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(String idParentesco) {
        this.idParentesco = idParentesco;
    }

    public String getDni_hijo() {
        return dni_hijo;
    }

    public void setDni_hijo(String dni_hijo) {
        this.dni_hijo = dni_hijo;
    }

    public static boolean getPermisoCalendario() {
        return permisoCalendario;
    }

    public static void setPermisoCalendario(boolean permisoCalendario) {
        Usuario.permisoCalendario = permisoCalendario;
    }

    public static boolean getPermisoAutorizacion() {
        return permisoAutorizacion;
    }

    public static void setPermisoAutorizacion(boolean permisoAutorizacion) {
        Usuario.permisoAutorizacion = permisoAutorizacion;
    }

    public static  boolean getPermisoParteDiario() {
        return permisoParteDiario;
    }

    public static void setPermisoParteDiario(boolean permisoParteDiario) {
        Usuario.permisoParteDiario = permisoParteDiario;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Usuario.usuario = usuario;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Usuario.password = password;
    }

    public static boolean getPermisoEnviarMensajeApp() {
        return permisoEnviarMensajeApp;
    }

    public static void setPermisoEnviarMensajeApp(boolean permisoEnviarMensajeApp) {
        Usuario.permisoEnviarMensajeApp = permisoEnviarMensajeApp;
    }

    public static String getCompleto() {
        return completo;
    }

    public static void setCompleto(String completo) {
        Usuario.completo = completo;
    }

    public static String getVersionAppV1() {
        return versionAppV1;
    }

    public static void setVersionAppV1(String versionApp) {
        Usuario.versionAppV1 = versionApp;
    }

    public static String getVersionAppV2() {
        return versionAppV2;
    }

    public static void setVersionAppV2(String versionAppV2) {
        Usuario.versionAppV2 = versionAppV2;
    }

    public static String getVersionAppV3() {
        return versionAppV3;
    }

    public static void setVersionAppV3(String versionAppV3) {
        Usuario.versionAppV3 = versionAppV3;
    }

    public static boolean getPermisoResponderMensaje() {
        return permisoResponderMensaje;
    }

    public static void setPermisoResponderMensaje(boolean permisoResponderMensaje) {
        Usuario.permisoResponderMensaje = permisoResponderMensaje;
    }

    public static boolean getPermisoCrearHijo() {
        return permisoCrearHijo;
    }

    public static void setPermisoCrearHijo(boolean permisoCrearHijo) {
        Usuario.permisoCrearHijo = permisoCrearHijo;
    }

    public static String getIdPerfilPermisos() {
        return idPerfilPermisos;
    }

    public static void setIdPerfilPermisos(String idPerfilPermisos) {
        Usuario.idPerfilPermisos = idPerfilPermisos;
    }

    public ArrayList getIdsgrupos() {
        return idsgrupos;
    }

    public void setIdsgrupos(ArrayList idsgrupos) {
        this.idsgrupos = idsgrupos;
    }



    public static String getIdEstablecimientoActual() {
        return idEstablecimientoActual;
    }

    public static void setIdEstablecimientoActual(String idEstablecimientoActual) {
        Usuario.idEstablecimientoActual = idEstablecimientoActual;
    }

    public static String getNotificationId() {
        return notificationId;
    }

    public static void setNotificationId(String notificationId) {
        Usuario.notificationId = notificationId;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public static String getNombreUsuarioActual() {
        return nombreUsuarioActual;
    }

    public static void setNombreUsuarioActual(String nombreUsuarioActual) {
        Usuario.nombreUsuarioActual = nombreUsuarioActual;
    }

    public static String getIdUsuarioActual() {
        return idUsuarioActual;
    }

    public static void setIdUsuarioActual(String idUsuarioActual) {
        Usuario.idUsuarioActual = idUsuarioActual;
    }

    public  void setIdEstablecimiento(String idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public  String getIdEstablecimiento() {//se cambio a static
        return idEstablecimiento;
    }

    public static boolean sesionActiva(){

        return !TextUtils.isEmpty(getIdUsuarioActual());
    }





}
