package com.example.siriaco77.qpm.Componentes.Empleado;

public class Empleado {

    String Id;
    String Nombre;
    String Apellido;
    String Dni;
    String User;
    String Pass;
    String Email;
    String Telefono;
    String IdEstablecimiento;
    String Activo;
    String NotificationId;
    String Direccion;
    String Observaciones;
    String FechaAlta;
    String FechaNacimiento;
    String HorasLaborales;
    String Legajo;
    String establecimiento;

    public static String nombreUsuarioActual;
    public static String idEstablecimientoActual;
    public static String idUsuarioActual;

    public static String getIdUsuarioActual() {
        return idUsuarioActual;
    }

    public static void setIdUsuarioActual(String idUsuarioActual) {
        Empleado.idUsuarioActual = idUsuarioActual;
    }

    public static String getNombreUsuarioActual() {
        return nombreUsuarioActual;
    }

    public static void setNombreUsuarioActual(String nombreUsuarioActual) {
        Empleado.nombreUsuarioActual = nombreUsuarioActual;
    }

    public static String getIdEstablecimientoActual() {
        return idEstablecimientoActual;
    }

    public static void setIdEstablecimientoActual(String idEstablecimientoActual) {
        Empleado.idEstablecimientoActual = idEstablecimientoActual;
    }



    public Empleado(String id, String nombre, String apellido, String dni, String user, String pass, String email, String telefono, String idEstablecimiento, String activo, String notificationId, String direccion, String observaciones, String fechaAlta, String fechaNacimiento, String horasLaborales, String legajo, String establecimiento) {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
        Dni = dni;
        User = user;
        Pass = pass;
        Email = email;
        Telefono = telefono;
        IdEstablecimiento = idEstablecimiento;
        Activo = activo;
        NotificationId = notificationId;
        Direccion = direccion;
        Observaciones = observaciones;
        FechaAlta = fechaAlta;
        FechaNacimiento = fechaNacimiento;
        HorasLaborales = horasLaborales;
        Legajo = legajo;
        this.establecimiento = establecimiento;
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

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getIdEstablecimiento() {
        return IdEstablecimiento;
    }

    public void setIdEstablecimiento(String idEstablecimiento) {
        IdEstablecimiento = idEstablecimiento;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String activo) {
        Activo = activo;
    }

    public String getNotificationId() {
        return NotificationId;
    }

    public void setNotificationId(String notificationId) {
        NotificationId = notificationId;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        FechaAlta = fechaAlta;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getHorasLaborales() {
        return HorasLaborales;
    }

    public void setHorasLaborales(String horasLaborales) {
        HorasLaborales = horasLaborales;
    }

    public String getLegajo() {
        return Legajo;
    }

    public void setLegajo(String legajo) {
        Legajo = legajo;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }




}
