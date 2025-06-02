package main.java.com.indra.eventossostenibles.models;

public class Inscripciones {
    private int idUsuario;
    private int idEvento;

    public Inscripciones(int idEvento, int idUsuario) {
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
    }
    //Getters and Setters
    public int getIdEvento() {
        return idEvento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

}
