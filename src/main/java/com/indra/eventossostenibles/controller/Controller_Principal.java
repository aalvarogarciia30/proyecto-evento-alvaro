package main.java.com.indra.eventossostenibles.controller;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.com.indra.eventossostenibles.models.Organizador;
import main.java.com.indra.eventossostenibles.models.Usuario;
import main.java.com.indra.eventossostenibles.view.ViMenuPrincipal;
import main.java.com.indra.eventossostenibles.models.Evento;
import main.java.com.indra.eventossostenibles.models.Model;

public class Controller_Principal {

    private Model model;
    private ViMenuPrincipal view;

    public Controller_Principal() {
        model = new Model();
        view = new ViMenuPrincipal();
        
        mostrarMenu();
    }
    Scanner scanner = new Scanner(System.in);
    ArrayList <Organizador> organizadores = new ArrayList<>();
    ArrayList <Usuario> usuarios = new ArrayList<>();

    public void mostrarMenu(){
        boolean bucle = true;
        while(bucle){
            view.mostrarMenuPrincipal();
            int opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                    // Crear Organizador
                    crearOrganizador();
                    break;
                case 2:
                    // Crear Evento
                    crearEvento();
                    
                    break;
                case 3:
                    // Registrar Usuario
                    registrarUsuario();
                    break;
                case 4:
                    // Inscribir usuario a Evento
                    inscribirUsuarioEvento();
                    break;
                case 5:
                    // Mostrar Eventos de organizador
                    mostrarEventosOrganizador();
                    break;
                case 6:
                    // Salir
                    bucle = false;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }
    public void crearEvento(){
        System.out.println("Ingrese el nombre del evento:");
        String nombreEvento = scanner.next();
        System.out.println("Ingrese la fecha del evento (YYYY-MM-DD):");
        String fechaEvento = scanner.next();
        System.out.println("Ingrese la duración del evento (en horas):");
        int duracionEvento = scanner.nextInt();
        System.out.println("Ingrese el estado del evento (Activo/Inactivo):");
        String estadoEvento = scanner.next();
        model.crearEvento(nombreEvento, java.sql.Date.valueOf(fechaEvento), duracionEvento, estadoEvento);
        System.out.println("Evento creado exitosamente.");
    }
    public void crearOrganizador() {
        System.out.println("Ingrese el nombre del organizador:");
        String nombre = scanner.next();
        System.out.println("Ingrese el email del organizador:");
        String email = scanner.next();
        System.out.println("Ingrese el teléfono del organizador:");
        String telefono = scanner.next();
        model.crearOrganizador(nombre, email, telefono);
        System.out.println("Organizador creado exitosamente.");
    }
    public void registrarUsuario() {
        System.out.println("Ingrese el nombre del usuario:");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese el email del usuario:");
        String emailUsuario = scanner.nextLine();
        model.crearUsuario(nombreUsuario, emailUsuario);
        System.out.println("Usuario registrado exitosamente.");
    }
    public void inscribirUsuarioEvento() {
        System.out.println("Ingrese el ID del usuario a inscribir:");
        int idUsuario = scanner.nextInt();
        System.out.println("Ingrese el ID del evento al que desea inscribir al usuario:");
        int idEvento = scanner.nextInt();
        model.crearInscripcion(idUsuario, idEvento);
        System.out.println("Usuario inscrito al evento exitosamente.");
    }
    public void mostrarEventosOrganizador() {
        for(Organizador organizador : model.getOrganizadores()) {
            System.out.println(organizador);
        }
        String nombreOrganizador=scanner.next();
        boolean encontrado = false;
        for (Organizador organizador : model.getOrganizadores()) {
            if (organizador.getNombre().equals(nombreOrganizador)) {
                System.out.println("Eventos del organizador " + organizador.getNombre() + ":");
                for (Evento evento : model.getEventos()) {
                    if (evento.getOrganizador().equals(organizador)) {
                        System.out.println(evento);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("No hay eventos registrados para este organizador.");
                }
                break;
            }
        }
    }
}
