package String;

import java.util.Scanner; 

public class Programa3 {
    static Scanner leer = new Scanner(System.in);

    public static void parteInferior(String cadena){
        int i, j, n = cadena.length(); 
        
        for(i = n-2; i >= 0; i--){
            for(j = n-1; j > i; j--){
                System.out.print(" ");
            }
            for(j = 0; j <= i; j++){
                System.out.print(cadena.charAt(j));
            }
            for(j = i-1; j >= 0; j--){
                System.out.print(cadena.charAt(j));
            }
            System.out.println();
        }
    }

    public static void parteSuperior(String cadena){
        int i, j, n = cadena.length(); 

        for(i = 0; i < n; i++){
            for(j = n-1; j > i; j--){
                System.out.print(" ");
            }
            for(j = 0; j <= i; j++){
                System.out.print(cadena.charAt(j));
            }
            for(j = i-1; j >= 0; j--){
                System.out.print(cadena.charAt(j));
            }
        System.out.println();
        }
    }

    public static void main(String[] args) {
        String cadena = new String(); 

        System.out.println("Favor de escribir una cadena: ");
        cadena = leer.nextLine(); 

        if(cadena.length() > 10){
            cadena = cadena.substring(0, 10); 
        }

        parteSuperior(cadena);
        parteInferior(cadena);
    }
}
