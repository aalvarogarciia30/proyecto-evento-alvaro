package test.java.com.indra.eventossostenibles;
import main.java.com.indra.eventossostenibles.models.Model;
import org.junit.Test;

public class TestProyecto {
    private Model model;
    public TestProyecto() {
        model = new Model();
    }

    @Test
    public void testOrganizador() {
        // Crear un organizador
        model.crearOrganizador("Organizador1","email@gmail.com", 123456789);
        
        // Verificar que el organizador se ha añadido a la lista
        assert model.getOrganizadores().size() == 1;
        // Verificar que el organizador se ha añadido correctamente
        assert model.getOrganizadores().get(0).getNombre().equals("Organizador1");
        assert model.getOrganizadores().get(0).getEmail().equals("email@gmail.com");
        assert model.getOrganizadores().get(0).getTelefono() == 123456789;
        // Verificar que el organizador se ha añadido correctamente al modelo
        assert model.getOrganizadores().contains(model.getOrganizadores().get(0));
        
    }
    @Test
    public void testEvento() {
        // Crear un evento
        model.crearEvento("Evento1", java.sql.Date.valueOf("2023-10-01"), 120, "Activo", "Organizador1", "Ubicacion1", "Categoria1");
        
        // Verificar que el evento se ha añadido a la lista
        assert model.getEventos().size() == 1;
        // Verificar que el evento se ha añadido correctamente
        assert model.getEventos().get(0).getNombre().equals("Evento1");
        assert model.getEventos().get(0).getFecha().toString().equals("2023-10-01");
        assert model.getEventos().get(0).getDuracion() == 120;
        assert model.getEventos().get(0).getEstado().equals("Activo");
        assert model.getEventos().get(0).getNombreOrganizador().equals("Organizador1");
        assert model.getEventos().get(0).getUbicacion().equals("Ubicacion1");
        assert model.getEventos().get(0).getCategoria().equals("Categoria1");
    }
    @Test
    public void testUsuario() {
        // Crear un usuario
        model.crearUsuario("Usuario1", "email@gmail.com");
        // Verificar que el usuario se ha añadido a la lista
        assert model.getUsuarios().size() == 1;
        // Verificar que el usuario se ha añadido correctamente
        assert model.getUsuarios().get(0).getNombre().equals("Usuario1");
        assert model.getUsuarios().get(0).getEmail().equals("email@gmail.com");
    }
    @Test
    public void testInscripcion() {
        // Crear una inscripción
        model.crearInscripcion("Usuario1", "Evento1");
        // Verificar que la inscripción se ha añadido a la lista
        assert model.getInscripciones().size() == 1;
        // Verificar que la inscripción se ha añadido correctamente
        assert model.getInscripciones().get(0).getNombreUsuario().equals("Usuario1");
        assert model.getInscripciones().get(0).getNombreEvento().equals("Evento1");
    }
}