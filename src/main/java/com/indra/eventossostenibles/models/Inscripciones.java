package main.java.com.indra.eventossostenibles.models;

public class Inscripciones {
    private String nombreUsuario;
    private String nombreEvento;

    public Inscripciones(String nombreEvento, String nombreUsuario) {
        this.nombreEvento = nombreEvento;
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
