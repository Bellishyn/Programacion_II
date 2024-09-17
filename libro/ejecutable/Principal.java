package libro.ejecutable;

import autores.Autor;
import fecha.Fecha;
import libro.clase.Libro;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    static Autor at = new Autor("", "", new Fecha(01, 01, 1900));
    static Libro lt = new Libro("", "", 0);
    static ArrayList<Autor> a = new ArrayList<>();
    static ArrayList<Libro> l = new ArrayList<>();
    static int opt, pag = 0, dd , mm, yy;
    static String nombre, nacionalidad, editorial;
    static Scanner leer = new Scanner(System.in);

    //Metodo para agregar a un autor
    static void agregarAutor(){
        System.out.println("Proporcione la fecha en el formato dd_mm_yy, tenga en cuenta que el guion bajo es un espacio");
        System.out.print("Nombre: ");
        nombre = leer.nextLine();
        System.out.print("Nacionalidad: ");
        nacionalidad = leer.nextLine();
        System.out.print("Fecha: ");
        dd = leer.nextInt();
        mm = leer.nextInt();
        yy = leer.nextInt();
        leer.nextLine();

        at = new Autor(nombre, nacionalidad, new Fecha(dd, mm, yy));
        at.asignarLibro(lt);
        lt.asignarAutor(at);
        a.add(at);
         
    }

    //Metodo para imprimir una lista de autores
    static void listaAutores(){
        if(a.isEmpty()){
            System.out.println("Lista vacia.");
            return;
        }
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
        System.out.print("\n");
        return;
    }

    //Metodo Sub-Menu
    static void subMenu(){
        //Lectura de datos del Libro nuevo
        System.out.print("Titulo: ");
        nombre = leer.nextLine();
        System.out.print("Editorial: ");
        editorial = leer.nextLine();
        System.out.print("Numero de paginas: ");
        pag = leer.nextInt();
        leer.nextLine();

        //Se crea un nuevo libro
        lt = new Libro(nombre, editorial, pag);
        do{
            //Sub-Meno
            System.out.println("\n\nSub-Menu-.\n1.-\tAgregar Autor.");
            System.out.println("2.-\tMostra Autor.");
            System.out.print("3.-\tRegresar al Menu anterior\nSelecione una opcion\n>> ");
            opt = leer.nextInt();
            leer.nextLine();
            switch (opt) {
                case 1:{
                    //Llamado a la funcion de la linea 18
                    agregarAutor();
                    break;
                }
                case 2:{
                    //Llamado a la funcion de la linea 34
                    System.out.println("Lista de autores:");
                    listaAutores();
                    break;
                }
                case 3:{
                    l.add(lt);
                    System.out.println("Regresando al menu anterior...");
                    return;
                }
                default:{
                    System.out.println("\nOpcion no valida...\n");
                }
            }
        }while(true);

    }

    //Metodo de lista de Libros
    static void listaLibros(){
        if(l.isEmpty()){
            System.out.println("Lista vacia.");
            return;
        }
        for(int i = 0; i < a.size(); i++){
            System.out.print(l.get(i));
        }
        System.out.print("\n");
        return;
    }

    //Menu principal
    static void menu(){
        do{
            System.out.println("Menu-.\n1.-\tNuevo Libro.");
            System.out.println("2.-\tMostrar Libros.");
            System.out.print("3.-\tSalir\nSelecione una opcion\n>> ");
            opt = leer.nextInt();
            leer.nextLine();
            switch (opt) {
                case 1:{
                    //Lamada al metodo de la linea 41
                    subMenu();
                    break;
                }
                case 2:{
                    //Lamada al metodo de la linea 84
                    listaLibros();
                    break;
                }
                case 3:{
                    System.out.println("Saliendo...");
                    return;
                }
                default:{
                    System.out.println("\nOpcion no valida...\n");
                }
            }
        }while(true);
    }
    
    public static void main(String[] args){
        menu();
    }
}