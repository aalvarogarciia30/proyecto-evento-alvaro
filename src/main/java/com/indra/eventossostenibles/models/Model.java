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
    public void crearInscripcion(String nombreUsuario, String nombreEvento){
        this.inscripciones.add(new Inscripciones(nombreUsuario, nombreEvento));
    }
    // Método para crear un evento
    public void crearEvento(String nombre, Date fecha, int duracion, String estado,String nombreOrganizador, String ubicacion, String categoria){
        this.evento.add(new Evento(nombre, fecha, duracion, estado, nombreOrganizador, ubicacion, categoria));
    }

    // Método para crear un organizador
    public void crearOrganizador(String nombre, String email, int telefono){
        this.organizador.add(new Organizador(nombre, email, telefono));
    }

    // Getters y Setters
    public ArrayList <Organizador> getOrganizadores() {
        return organizador;
    }
    public ArrayList <Evento> getEventos() {
        return evento;
    }
    public ArrayList <Inscripciones> getInscripciones() {
        return inscripciones;
    }
    public ArrayList <Usuario> getUsuarios() {
        return usuarios;
    }
}