package main.java.com.indra.eventossostenibles.models;

public class Categoria {
    private String nombre_Categoria;

    public Categoria(String nombre_Categoria) {
        this.nombre_Categoria = nombre_Categoria;
    }

    
    // Getter y Setter
    public String getNombre_Categoria() {
        return nombre_Categoria;
    }
    public void setNombre_Categoria(String nombre_Categoria) {
        this.nombre_Categoria = nombre_Categoria;
    }
}