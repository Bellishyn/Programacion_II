package cafetera;

import java.util.Scanner; 

public class Principal {
    static Scanner leer = new Scanner(System.in); 
    static Cafetera c1 = new Cafetera();
    static int opc,cantidad; 
    
    static void imprimir_menu(){
        System.out.println("\nOpciones del menu: ");
        System.out.println("1. LLenar cafetera.");
        System.out.println("2. Servir taza.");
        System.out.println("3. Agregar cafe.");
        System.out.println("4. Vaciar cafetera.");
        System.out.println("5. Salir");
        System.out.print("\nFavor de seleccionar una opcion: ");
    }

    static void acciones(Cafetera c1){
        do{
            imprimir_menu();
            opc = leer.nextInt(); 
            switch(opc){
                case 1 ->{
                    c1.llenarCafetera();
                    System.out.println(c1);
                    break; 
                }
                case 2 ->{
                    System.out.print("Proporcione la canidad a llenar: ");
                    cantidad = leer.nextInt();
                    System.out.println("Llenando taza, espere...");
                    c1.servirTaza(cantidad);
                    System.out.println("Cantidad actual de la cafetera: "+c1.getCapAct());
                    break; 
                }
                case 3 ->{
                    System.out.print("Indicar la cantidad a rellenar de la cafetera: ");
                    cantidad = leer.nextInt();
                    if((c1.getCapAct()+cantidad) > c1.getCapMax()){
                        c1.llenarCafetera();
                        System.out.println("Cantidad actual de la cafetera: "+c1.getCapAct());
                    } else {
                        c1.agregarCafe(cantidad);    
                        System.out.println("Cantidad actual de la cafetera: "+c1.getCapAct());
                    }
                    break;
                }
                case 4 ->{
                    c1.vaciarCafetera();
                    System.out.println(c1);
                    break;
                }
                case 5 ->{
                    System.out.println("Saliendo...");
                    return; 
                }
                default ->{
                    System.out.println("La opcion indicada no existe.");
                    break; 
                }
            }
        }while(true);   
    }
    
    public static void main(String[] args) {
        System.out.println("Cantidad maxima: "+c1.getCapMax());
        System.out.println("Capacidad Actual: "+c1.getCapAct());
        acciones(c1);
    }
}