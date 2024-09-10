package paralelepipedo.Principal;

import java.util.Scanner;
import paralelepipedo.p.Paralelepipedo;
import vector.Vector;

public class Principal {
    static Vector u = new Vector();
    static Vector v = new Vector();
    static Vector w = new Vector();
    static Paralelepipedo p = new Paralelepipedo(u, v, w);
    static Scanner leer = new Scanner(System.in);
    static int opt;
    
    static void asignacion(){
        System.out.println("Proporcione el primer vector: ");
        u.setX(leer.nextInt());
        u.setY(leer.nextInt());
        u.setZ(leer.nextInt());
        p.setU(u);
        System.out.println("Proporcione el segundo vector: ");
        v.setX(leer.nextInt());
        v.setY(leer.nextInt());
        v.setZ(leer.nextInt());
        p.setV(v);
        System.out.println("Proporcione el tercer vector: ");
        w.setX(leer.nextInt());
        w.setY(leer.nextInt());
        w.setZ(leer.nextInt());
        p.setW(w);
    }
    
    static void menu(){
        System.out.println("Menu\n1.\tLeer vectores.");
        System.out.println("2.\tCalcular volumen.");
        System.out.println("3.\tImprimir vectorese del paralelepipedo.");
        System.out.println("4.\tSalir");
        System.out.print("Seleccione una opcion...\n>>");
        opt = leer.nextInt();
        
        switch (opt) {
            case 1:{
                asignacion();
                break;
            }
            case 2:{
                if((u.magnitud() == 0) && (v.magnitud() == 0) && (w.magnitud() == 0)){
                    System.out.println("Uno o más vectores estan el origen, modifique los vectores...");
                }else
                    if(u.validacion(v) || v.validacion(w) || w.validacion(u)){
                        System.out.println("Uno o más vectores se repiten, modifique los vectores...");
                    }else{
                        System.out.println("El volmen es: " + p.volumen());
                    }
                break;
            }
            case 3:{
                System.out.println(p);
                break;
            }
            case 4:{
                System.out.println("Saliendo...");
                break;
            }
            default:{
                System.out.println("Opcion no valida...");
                break;
            }
        }
    }
    public static void main(String[] args) {
        
        do{
           menu();
        }while(true);
        
    }
}
