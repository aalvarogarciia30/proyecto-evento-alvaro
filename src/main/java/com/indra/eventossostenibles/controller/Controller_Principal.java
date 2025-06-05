package main.java.com.indra.eventossostenibles.controller;

import java.util.Scanner;

import main.java.com.indra.eventossostenibles.models.Organizador;
import main.java.com.indra.eventossostenibles.view.ViMenuPrincipal;
import main.java.com.indra.eventossostenibles.models.Usuario;
import main.java.com.indra.eventossostenibles.models.Evento;
import main.java.com.indra.eventossostenibles.models.Model;

/**
 * Controlador principal de la aplicación de eventos sostenibles.
 * Gestiona la interacción entre el modelo, la vista y el usuario.
 */
public class Controller_Principal {

    private Model model;
    private ViMenuPrincipal view;

    /**
     * Constructor. Inicializa el modelo y la vista, y muestra el menú principal.
     */
    public Controller_Principal() {
        model = new Model();
        view = new ViMenuPrincipal();
        
        mostrarMenu();
    }
    Scanner scanner = new Scanner(System.in);

    /**
     * Muestra el menú principal y gestiona la selección de opciones por parte del usuario.
     */
    public void mostrarMenu(){
        boolean bucle = true;
        while(bucle){
            view.mostrarMenuPrincipal();
            String opcion = scanner.nextLine();
            switch(opcion){
                case "1":
                    // Crear Organizador
                    crearOrganizador();
                    break;
                case "2":
                    // Crear Evento
                    crearEvento();
                    
                    break;
                case "3":
                    // Registrar Usuario
                    registrarUsuario();
                    break;
                case "4":
                    // Inscribir usuario a Evento
                    inscribirUsuarioEvento();
                    break;
                case "5":
                    // Mostrar Eventos de organizador
                    mostrarEventosOrganizador();
                    break;
                case "6":
                    // Salir
                    bucle = false;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }

    /**
     * Permite crear un nuevo evento, solicitando los datos necesarios y validando la entrada.
     * Controla errores de entrada y existencia de organizadores.
     */
    public void crearEvento() {
        if (model.getOrganizadores().isEmpty()) {
            System.out.println("No hay organizadores disponibles. Por favor, cree un organizador primero.");
        } else {
            System.out.println("¿Qué organizador desea crear el evento?:");
            for (Organizador organizador : model.getOrganizadores()) {
                System.out.println(organizador);
            }
            System.out.println("Ingrese el nombre del organizador del evento:");
            String nombreOrganizador = scanner.nextLine();
            boolean existeOrganizador = false;
            for (Organizador organizador : model.getOrganizadores()) {
                if (organizador.getNombre().equalsIgnoreCase(nombreOrganizador)) {
                    existeOrganizador = true;
                    break;
                }
            }
            if (!existeOrganizador) {
                System.out.println("El organizador no existe. Volviendo al menú principal.");
                return;
            }
            System.out.println("Ingrese el nombre del evento:");
            String nombreEvento = scanner.nextLine();
            if (nombreEvento == null || nombreEvento.isEmpty()) {
                System.out.println("El nombre del evento no puede estar vacío. Volviendo al menú principal.");
                return;
            }
            System.out.println("Ingrese la ubicación del evento:");
            String ubicacionEvento = scanner.nextLine();
            if (ubicacionEvento == null || ubicacionEvento.isEmpty()) {
                System.out.println("La ubicación no puede estar vacía. Volviendo al menú principal.");
                return;
            }
            System.out.println("Ingrese la categoría del evento:");
            String categoriaEvento = scanner.nextLine();
            if (categoriaEvento == null || categoriaEvento.isEmpty()) {
                System.out.println("La categoría no puede estar vacía. Volviendo al menú principal.");
                return;
            }
            System.out.println("Ingrese la fecha del evento (YYYY-MM-DD):");
            String fechaEvento = scanner.nextLine();
            try {
                java.sql.Date.valueOf(fechaEvento);
            } catch (IllegalArgumentException e) {
                System.out.println("La fecha ingresada no es válida. Volviendo al menú principal.");
                return;
            }
            System.out.println("Ingrese la duración del evento (en horas):");
            int duracionEvento=scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            
            if (duracionEvento <= 0) {
                System.out.println("La duración debe ser un número positivo. Volviendo al menú principal.");
                return;
            }
            System.out.println("Ingrese el estado del evento (Activo/Inactivo):");
            String estadoEvento = scanner.nextLine();
            if (!estadoEvento.equalsIgnoreCase("Activo") && !estadoEvento.equalsIgnoreCase("Inactivo")) {
                System.out.println("El estado debe ser 'Activo' o 'Inactivo'. Volviendo al menú principal.");
                return;
            }
            // Crea el evento con los datos ingresados            
            model.crearEvento(nombreEvento, java.sql.Date.valueOf(fechaEvento), duracionEvento, estadoEvento, nombreOrganizador, ubicacionEvento, categoriaEvento);
            System.out.println("Evento creado exitosamente.");
        }
    }

    /**
     * Permite crear un nuevo organizador, solicitando los datos necesarios y validando la entrada.
     */
    public void crearOrganizador() {
        System.out.println("Ingrese el nombre del organizador:");
        String nombre = scanner.nextLine();
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("El nombre del organizador no puede estar vacío. Volviendo al menú principal.");
            return;
        }
        System.out.println("Ingrese el email del organizador:");
        String email = scanner.nextLine();
        if (email == null || email.isEmpty()) {
            System.out.println("El email del organizador no puede estar vacío. Volviendo al menú principal.");
            return;
        }
        System.out.println("Ingrese el teléfono del organizador:");
        int telefono = scanner.nextInt();
        if (telefono <= 0) {
            System.out.println("El teléfono del organizador no puede estar vacío. Volviendo al menú principal.");
            return;
        }
        model.crearOrganizador(nombre, email, telefono);
        System.out.println("Organizador creado exitosamente.");
    }

    /**
     * Permite registrar un nuevo usuario, solicitando los datos necesarios y validando la entrada.
     */
    public void registrarUsuario() {
        System.out.println("Ingrese el nombre del usuario:");
        String nombreUsuario = scanner.nextLine();
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            System.out.println("El nombre del usuario no puede estar vacío. Volviendo al menú principal.");
            return;
        }
        System.out.println("Ingrese el email del usuario:");
        String emailUsuario = scanner.nextLine();
        if (emailUsuario == null || emailUsuario.isEmpty()) {
            System.out.println("El email del usuario no puede estar vacío. Volviendo al menú principal.");
            return;
        }
        model.crearUsuario(nombreUsuario, emailUsuario);
        System.out.println("Usuario registrado exitosamente.");
    }

    /**
     * Permite inscribir un usuario a un evento usando nombres, validando que ambos existan.
     */
    public void inscribirUsuarioEvento() {
        System.out.println("Para inscribir un usuario a un evento, primero debe existir un usuario y un evento.");
        if (model.getUsuarios().isEmpty()) {
            System.out.println("No hay usuarios registrados. Por favor, registre un usuario primero.");
            return;
        }
        if (model.getEventos().isEmpty()) {
            System.out.println("No hay eventos registrados. Por favor, cree un evento primero.");
            return;
        }
        //Muestra los usuarios disponibles
        for (Usuario usuarios : model.getUsuarios()) {
            System.out.println(usuarios);
        }
        System.out.println("Ingrese el nombre del usuario que se quiere inscribir al evento:");
        String nombreUsuario = scanner.nextLine();
        boolean existeUsuario = false;
        for (Usuario usuarios : model.getUsuarios()) {
            if (usuarios.getNombre().equalsIgnoreCase(nombreUsuario)) {
                existeUsuario = true;
                break;
            }
        }
        if (!existeUsuario) {
            System.out.println("El usuario no existe. Volviendo al menú principal.");
            return;
        }
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            System.out.println("El nombre del usuario no puede estar vacío. Volviendo al menú principal.");
            return;
        }

        //Muestra los eventos disponibles
        for (Evento evento : model.getEventos()) {
            System.out.println(evento);
        }
        System.out.println("Ingrese el nombre del evento al que desea inscribirse:");
        String nombreEvento = scanner.nextLine();
        boolean existeEvento = false;
        for (Evento evento : model.getEventos()) {
            if (evento.getNombre().equalsIgnoreCase(nombreEvento)) {
                existeEvento = true;
                break;
            }
        }
        if (!existeEvento) {
            System.out.println("El evento no existe. Volviendo al menú principal.");
            return;
        }
        // Crea la inscripción con los datos ingresados
        
        if (nombreEvento == null || nombreEvento.isEmpty()) {
            System.out.println("El nombre del evento no puede estar vacío. Volviendo al menú principal.");
            return;
        }
        model.crearInscripcion(nombreEvento, nombreUsuario);
        System.out.println("Usuario inscrito al evento exitosamente.");
    }

    /**
     * Muestra los eventos asociados a un organizador seleccionado por el usuario.
     * Controla que el nombre del organizador no esté vacío.
     */
    public void mostrarEventosOrganizador() {
        //Muestra los organizadores disponibles
        System.out.println("Organizadores disponibles:");
        for(Organizador organizador : model.getOrganizadores()) {
            System.out.println(organizador);
        }
        System.out.println("Ingrese el nombre del organizador para ver sus eventos:");
        String nombreOrganizador = scanner.nextLine();
        if (nombreOrganizador == null || nombreOrganizador.isEmpty()) {
            System.out.println("El nombre del organizador no puede estar vacío. Volviendo al menú principal.");
            return;
        }
        boolean encontrado = false;
        // Busca el organizador por nombre y muestra sus eventos
        // Si no se encuentra, muestra un mensaje indicando que no hay eventos registrados
        for (Organizador organizador : model.getOrganizadores()) {
            if (organizador.getNombre().equals(nombreOrganizador)) {
                System.out.println("Eventos del organizador " + organizador.getNombre() + ":");
                for (Evento evento : model.getEventos()) {
                    if (evento.getNombreOrganizador().equals(organizador.getNombre())) {
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
