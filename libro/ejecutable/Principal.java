package libro.ejecutable;

import autores.Autor;
import fecha.Fecha;
import libro.clase.Libro;

public class Principal {
    public static Libro l1 = new Libro("Calculo Vol. 1", "OpenStax", 783);
    /*Autores del libro Calculo Vol. 1*/    
    public static Autor a1 = new Autor("Gilber Strang", "Estadounidense", new Fecha(24, 03, 2022));
    public static Autor a2 = new Autor("Edwin \"Jed\" Herman", "Estadounidense", new Fecha(24, 03, 2022));
    
    public static void main(String[] args){
        l1.asignarAutor(a1);
        l1.asignarAutor(a2);
        a1.asignarLibro(l1);
        a2.asignarLibro(l1);
        System.out.println(l1);
    }
}