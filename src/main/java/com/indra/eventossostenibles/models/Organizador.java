package main.java.com.indra.eventossostenibles.models;

public class Organizador {
    
    private String nombre;
    private String email;
    private int telefono;

    public Organizador(String nombre, String email, int telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    @Override
    public String toString() {
        return "Organizador: " +
                 nombre + " "+ email +" " + telefono ;
    }
}
