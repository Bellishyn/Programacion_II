package Cadenas;

import java.util.Scanner; 

public class Programa1 {
    static String cadena, pal1, pal2; 
    static Scanner leer = new Scanner(System.in); 

    public static void main(String[] args) {
        //Colocar la cadena (oracion) a ocupar
        System.out.print("Favor de ingresar una oracion: ");
        cadena = leer.nextLine().toLowerCase().trim();

        //Solicitar la subcadena a cambiar 
        System.out.println("\nIndicar la palabra u letra a remplazar: ");
        pal1 = leer.nextLine().toLowerCase().trim();
        
        //Solicitar la nueva subcadena
        System.out.println("\nIndicar la nueva palabra u letra a colocar: "); 
        pal2 = leer.nextLine().toLowerCase().trim(); 

        //Remplazar la subcadena anterior con la nueva
        cadena = cadena.replace(pal1, pal2);

        //Convertir la primera letra de la oracion en mayuscula y mostrar en pantalla la nueva cadena
        cadena = cadena.substring(0, 1).toUpperCase() + cadena.substring(1); 
        System.out.println("\nLa nueva cadena es: " + cadena);
    } 
}
