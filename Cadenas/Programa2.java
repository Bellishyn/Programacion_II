package Cadenas;

import java.util.Scanner; 

public class Programa2 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) { 
        String cadena, invertida="";     
        int i; 
        
        //Solicitar cadena
        System.out.println("Favor de introducir una cadena: ");
        cadena = in.nextLine().trim(); 
        
        //Ciclo para invertir
        for(i=cadena.length()-1; i>=0; i--){
            invertida += cadena.charAt(i); 
        }

        //Impresion en pantalla
        System.out.println("\nCadena original: " + cadena);
        System.out.println("Cadena invertida: " + invertida);
    }
}
