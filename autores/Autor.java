package autores;

import libro.clase.Libro;
import fecha.Fecha;
import java.util.ArrayList;

public class Autor {
    private String nombre;
    private String nacionalidad;
    private Fecha fecha;
    private ArrayList<Libro> libros;

    public Autor(String nombre, String nacionalidad, Fecha fecha){
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fecha = fecha;
        libros = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public void asignarLibro(Libro libro){
        libros.add(libro);
    }

    @Override
    public String toString(){
        String cad = "";
        for(int i = 0; i < libros.size(); i++){
            cad += libros.get(i).getTitulo() + "\n";
        }
        return nombre + ", " + nacionalidad + ", " + fecha + "\nLibros: " + cad;
    }
}
