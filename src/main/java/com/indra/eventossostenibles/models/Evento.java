package main.java.com.indra.eventossostenibles.models;

import java.sql.Date;

public class Evento {
    private String nombre;
    private Date fecha;
    private int duracion;
    private String estado;
    private String nombreOrganizador;
    private String ubicacion;
    private String categoria;

    public Evento(String nombre, Date fecha, int duracion, String estado, String nombreOrganizador,String ubicacion, String categoria) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = duracion;
        this.estado = estado;
        this.nombreOrganizador = nombreOrganizador;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
    }
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getNombreOrganizador() {
        return nombreOrganizador;
    }
    public void setNombreOrganizador(String nombreOrganizador) {
        this.nombreOrganizador = nombreOrganizador;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return "Evento: " + nombre + ", Fecha: " + fecha + ", Duración: " + duracion + " horas, Estado: " + estado +
               ", Organizador: " + nombreOrganizador + ", Ubicación: " + ubicacion + ", Categoría: " + categoria;
    }
}
