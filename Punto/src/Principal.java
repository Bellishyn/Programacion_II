import java.util.Scanner;

public class Principal {
    static PuntoR2 p1 = new PuntoR2();
    static PuntoR2 p2 = new PuntoR2();
    static int opt;
    static Scanner leer = new Scanner(System.in);
    
    public static void subMenu(PuntoR2 p1, PuntoR2 p2) {
        do{
            System.out.println("Submenu\n");
            System.out.println("1) Punto 1.");
            System.out.println("2) Punto 2.");
            System.out.println("3) Regresar.");
            opt = leer.nextInt();
            
            switch (opt){
                case 1:{
                    System.out.print("\nIngrese x: ");
                    p1.setX(leer.nextDouble());
                    System.out.print("\nIngrese y: ");
                    p1.setY(leer.nextDouble());
                    break;
                }
                case 2:{
                    System.out.print("\nIngrese x: ");
                    p2.setX(leer.nextDouble());
                    System.out.print("\nIngrese y: ");
                    p2.setY(leer.nextDouble());
                    break;
                }
                case 3:{
                    System.out.println("Regresando...");
                    return;
                }
                default:{
                    System.out.println("Opcion no valida.");
                    break;
                }
            }
        }while (true);
    }
    
    public static void main(String args[]) {
        System.out.println("El punto 1 se hace creado en: " + p1);
        
        System.out.println("El punto 2 se hace creado en: " + p2);
        
        do {
            System.out.println("Menu\n");
            System.out.println("1) Modificar puntos.");
            System.out.println("2) Distancia.");
            System.out.println("3) Punto Medio.");
            System.out.println("4) Imprimir puntos.");
            System.out.println("5) Salir.");
            opt = leer.nextInt();
            leer.nextLine();
            
            switch (opt){
                case 1:{
                    subMenu(p1, p2);
                    break;
                }
                case 2:{
                    System.out.println("La distacia es: " + p1.distancia(p2) + "u");
                    break;
                }
                case 3:{
                    System.out.println("El punto medio es: " + p1.puntoMedio(p2));
                    break;
                }
                case 4:{
                    System.out.println("Punto 1: " + p1);
                    System.out.println("Punto 2: " + p2);
                    break;
                }
                default:{
                    break;
                }
            }
        }while (opt != 5);
    }
}
