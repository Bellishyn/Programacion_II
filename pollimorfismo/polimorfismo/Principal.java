package polimorfismo;

import java.util.Scanner;

public class Principal {  
    static int cantidadCuentas=0, opc; 
    static char ocp; 
    static Scanner leer = new Scanner(System.in); 
    static Cuenta [] C = new Cuenta[10];

    public static int verificar(){
        int numCuenta; 
        
        do {
            System.out.print("Favor de digitar el numero de cuenta: ");
            numCuenta = leer.nextInt(); 
            for(int i = 0; i < C.length; i++){
                if(C[i] != null && numCuenta == C[i].getNoCuenta()){
                    return i; 
                }
            }
        } while(true); 
    }

    public static void crearCuentaAhorro(){
        int numero;  
        double interes; 

        numero = (int)(Math.random()*1000000);
        interes = 5;
    
        C[cantidadCuentas] = new CuentaAhorro(numero, interes);
        System.out.println(C[cantidadCuentas]);
        System.out.println("Cuenta creada exitosamente...\n");
        cantidadCuentas++;  
    }

    public static void crearCuentaCorriente(){
        int numero; 
        double limiteSobregiro; 

        numero = (int)(Math.random()*1000000);
        limiteSobregiro = 500; 

        C[cantidadCuentas] = new CuentaCorriente(numero, limiteSobregiro); 
        System.out.println("\n" + C[cantidadCuentas]);
        System.out.println("Cuenta creada exitosamente...\n");
        cantidadCuentas++; 
    }

    public static void eliminarCuenta(){
        int i = verificar();
        
        for(int n = i; n <  C.length - 1; n++){
            C[n] = C[n+1]; 
        }

        C[C.length - 1] = null; 
        cantidadCuentas--; 
        System.out.println("La cuenta se ha eliminado exitosamente...\n");
    }

    public static void depositar(){
        double cantidad;
        int numero; 
        
        numero = verificar(); 
        System.out.print("Ingrese la cantidad a depositar: ");
        cantidad = leer.nextDouble();  
        
        C[numero].depositar(cantidad);
    }

    public static void retirar(){
        double cantidad; 
        int numero; 

        numero = verificar(); 
        System.out.print("Ingrese la cantidad a retirar: ");
        cantidad = leer.nextDouble(); 

        C[numero].retirar(cantidad);
    }

    public static void cuentas(){
        int i;

        if(cantidadCuentas == 0){
            System.out.println("No existen cuentas.\n");
        }

        for(i = 0; i < C.length; i++){
            if(C[i] != null){
                System.out.println("Cuenta " + (i+1) + ":");
                System.out.println(C[i] + "\n");
            }
        } 
    }

    public static void actualizar(){
        for(int i = 0; i < C.length -1; i++){
            if(C[i] != null && C[i] instanceof CuentaAhorro){
                ((CuentaAhorro)C[i]).agregarIntereses(); 
            } else if(C[i] != null && C[i] instanceof CuentaCorriente && C[i].getBalance() < 0) {
                System.out.println("La cuenta " + C[i].getNoCuenta() + "esta sobregirada\n");
            }
        }
    }

    public static void acciones(char ocp){
        switch(ocp){
            case 'a': 
                crearCuentaAhorro();
                break; 
            case 'b': 
                crearCuentaCorriente();
                break; 
            case 'c':  
                return; 
            default: 
                System.out.println("Opcion no valida.\n");
        }
    }

    public static void menu(){
        System.out.println("Bienvenido...");
        do{ 
            System.out.println("  1. Crear cuenta.");
            System.out.println("  2. Eliminar cuenta.");
            System.out.println("  3. Depositar.");
            System.out.println("  4. Retirar.");
            System.out.println("  5. Mostrar cuentas.");
            System.out.println("  6. Actualizar.");
            System.out.println("  7. Salir");
            System.out.print("\nSeleccionar una opcion: ");
            opc = leer.nextInt(); 
            switch(opc){
                case 1:
                    if(cantidadCuentas == 9){
                        System.out.println("El numero de cuentas posibles esta completo.");
                        break; 
                    } 
                    System.out.println("\n  a. Cuenta Ahorros.");
                    System.out.println("  b. Cuenta Corriente.");
                    System.out.println("  c. Regresar.");
                    leer.nextLine(); 
                    System.out.print("\nSeleccionar una opcion: ");
                    ocp = leer.nextLine().charAt(0);
                    acciones(ocp); 
                    break; 
                case 2: 
                    eliminarCuenta();
                    break; 
                case 3: 
                    depositar(); 
                    break; 
                case 4: 
                    retirar();
                    break; 
                case 5: 
                    cuentas(); 
                    break; 
                case 6: 
                    actualizar();
                    break; 
                case 7: 
                    System.out.println("Hasta pronto...");
                    return; 
                default: 
                    System.out.println("Opcion invalida.\n");
                    break; 
            }       
        } while(true); 
    }

    public static void main(String[] args) {
        menu(); 
    }
}
