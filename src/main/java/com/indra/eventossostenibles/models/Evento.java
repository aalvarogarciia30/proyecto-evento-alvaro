package main.java.com.indra.eventossostenibles.models;

import java.sql.Date;

public class Evento {
    private String nombre;
    private Date fecha;
    private int duracion;
    private String estado;

    public Evento(String nombre, Date fecha, int duracion, String estado) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = duracion;
        this.estado = estado;
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
    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", duracion=" + duracion +
                ", estado='" + estado + '\'' +
                '}';
    }
}
