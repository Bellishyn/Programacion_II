package excepcionescuentabancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcepcionesCuentaBancaria {
    static Scanner sc = new Scanner(System.in);
    private static int obtenerOpcionUsuario(){
        int opcion;
        do {
            opcion = -1;
            System.out.println("Opciones Menú:");
            System.out.println("0) Salir");
            System.out.println("1) Crear nueva cuenta");
            System.out.println("2) Depositar cuenta actual");
            System.out.println("3) Retirar cuenta actual");
            System.out.println("4) Buscar cuenta");
            System.out.println("5) Imprimir todas las cuentas");

            System.out.print("Digita tu opción(0 - 5): ");
            try{
                opcion = sc.nextInt();
                if (opcion < 0 || opcion > 5)
                    System.out.println("Opción inválida");
            }catch(InputMismatchException e1){
                System.out.println("\nEl tipo de dato ingresado no es el correcto\n");
                sc.nextLine();
            }
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }
    
    private static double obtenerCantidad() {
        double cantidad;
        sc.nextLine();
        while(true){
            try {
                System.out.print("Balance Inicical: ");
                cantidad = sc.nextDouble();
                break;
            } catch(InputMismatchException e1){
            System.out.println("\nEl tipo de dato ingresado no es el corecto, proporcione de nuevo el balance.");
                sc.nextLine();
            }
        }
        return cantidad;
    }
   
    private static int obtenerNoCuenta() {
        int noCuenta;
        sc.nextLine();
        while(true){
            try{
                System.out.print("Número de cuenta: ");
                noCuenta = sc.nextInt();
                break;
            }
            catch(InputMismatchException e1){
                System.out.println("\nEl tipo de dato ingresado no es el corecto, el numero de cuenta deben ser solo numero enteros.");
                sc.nextLine();
            }
        }
        return noCuenta;
    }

    public static void main(String[] args) {
        Banco banco = new Banco(10);
        CuentaBancaria cuenta = null;
        double cantidad;
        int noCuenta, opcion;
        
        do {
            opcion = obtenerOpcionUsuario();
            
            switch (opcion) {
            case 1:                
                cantidad = obtenerCantidad();
                noCuenta = obtenerNoCuenta();
                try{
                    cuenta = new CuentaBancaria(cantidad, noCuenta);
                    banco.agregarCuenta(cuenta);
                    System.out.println("\nInformación cuenta: " + cuenta + "\n");
                }catch(IllegalArgumentException e1){
                    System.out.println("\nERROR " + e1.getMessage() + "\n");
                }
                break;
            case 2:
                cantidad = obtenerCantidad();
                cuenta.depositar(cantidad);
                System.out.println("\nInformación de la cuenta: " + cuenta + "\n");
                break;
            case 3:
                cantidad = obtenerCantidad();
                cuenta.retirar(cantidad);
                System.out.println("\nInformación de la cuenta: " + cuenta + "\n");
                break;                
            case 4:
                noCuenta = obtenerNoCuenta();
                CuentaBancaria b = banco.buscarCuenta(noCuenta);
                if (b != null) {
                    cuenta = b;
                    System.out.println("\nInformación cuenta: " + cuenta + "\n");
                } 
                else {
                    System.out.println("\n*****ERROR*****: Cuenta bancaria " + noCuenta + " no encontrada!\n");
                }
                break;
                
            case 5:
                System.out.print("\n\nLas cuentas: \n" + banco + "\n\n");
                break;
            }
         } while (opcion != 0);
        System.out.println("\n\nHasta luego!");
    }
}
  