package main.java.com.indra.eventossostenibles.models;

import java.util.ArrayList;
import java.sql.Date;

public class Model {
    private ArrayList <Organizador> organizador;
    private ArrayList <Evento> evento;
    private ArrayList <Inscripciones> inscripciones;
    private ArrayList <Usuario> usuarios;

    public Model() {
        evento = new ArrayList <> ();
        organizador = new ArrayList <> ();
        inscripciones = new ArrayList <> ();
        usuarios = new ArrayList <> ();
    }
    // Método para crear un usuario
    public void crearUsuario(String nombre, String email){
        this.usuarios.add(new Usuario(nombre, email));
    }
    // Método para crear una inscripción
    public void crearInscripcion(int idUsuario, int idEvento){
        this.inscripciones.add(new Inscripciones(idEvento, idUsuario));
    }
    // Método para crear un evento
    public void crearEvento(String nombre, Date fecha, int duracion, String estado){
        this.evento.add(new Evento(nombre, fecha, duracion, estado));
    }

    // Método para crear un organizador
    public void crearOrganizador(String nombre, String email, String telefono){
        this.organizador.add(new Organizador(nombre, email, telefono));
    }

    // Getters y Setters
    public ArrayList <Organizador> getOrganizadores() {
        return organizador;
    }
    public void setOrganizadores(ArrayList<Organizador> organizador) {
        this.organizador = organizador;
    }
    public ArrayList <Evento> getEventos() {
        return evento;
    }
    public void setEventos(ArrayList<Evento> evento) {
        this.evento = evento;
    }
}
