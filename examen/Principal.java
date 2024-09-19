package examen;

import java.util.Scanner;

public class Principal {
    static Conductor c1 = new Conductor(202321544, "Irvin");
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args){
        Viaje v = new Viaje();
        String fecha;
        float distancia, tarifa;

        for(int i = 0; i < 3; i++){
            System.out.printf("Viaje %d\n", i + 1);
            System.out.print("Proporcione la fecha del viaje: ");
            fecha = leer.nextLine();
            System.out.print("Distacia del recorrido: ");
            distancia = leer.nextFloat();
            System.out.print("Tarifa por Km: ");
            tarifa = leer.nextFloat();
            leer.nextLine();
            v = new Viaje(fecha, distancia, tarifa);
            c1.agregarViaje(v);
        }
        System.out.println(c1);
        for(int i = 0; i < 3; i++){
            System.out.println(c1.devolverGanancias(c1.getFecha(i)));
        }
    }
}
