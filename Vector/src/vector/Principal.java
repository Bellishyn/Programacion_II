package vector;

import java.util.Scanner;

public class Principal {
    static Vector v = new Vector();
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Deme un vector: ");
        v.setX(leer.nextInt());
        v.setY(leer.nextInt());
        v.setZ(leer.nextInt());        
        
        System.out.printf("\nMagnitud: %.3f", v.magnitud());
        System.out.println("\nVector Unitario: " + v.vectorUnitario());
        System.out.println("Multiplicacion Escalar: " + v.multiEscalar(8));
        System.out.println("Suma de vectores: " + v.sumaVectores(new Vector(7, 8, 9)));
        System.out.println("Producto Punto: " + v.productoPunto(new Vector(8, 11, 2)));
        System.out.println("Producto Cruz: " + v.productoCruz(new Vector(9, 3, 54)));
        System.out.println(v);
    }
}