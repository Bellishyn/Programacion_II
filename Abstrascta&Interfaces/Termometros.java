import java.util.Scanner;

public class Termometros {
    static Scanner input = new Scanner(System.in);

    static void printSeleccionTermometro(){
        System.out.println("Seleccione el tipo de termometro");
        System.out.println("1)\tCelsius");
        System.out.println("2)\tFahrenheit");
    }

    static void seleccionarTermometro() {
        int opt;
        double g;
        printSeleccionTermometro();
        opt = input.nextInt();
        switch (opt) {
            case 1:
                System.out.println("Proporcione los grados: ");
                g = input.nextDouble();
                Termometro t1 = new TermometroCelcius(g);
                opcionesTermometro(t1, opt);
                break;
            case 2:
                System.out.println("Proporcione los grados: ");
                g = input.nextDouble();
                Termometro t2 = new TermometroFahrenheit(g);
                opcionesTermometro(t2, opt);   
                break;
            default:
                break;
        }
    }

    static void printMenu(){
        System.out.println("Menú:");
        System.out.println("1)\tLeer temperatura.");
        System.out.println("2)\tConversion de grados.");
        System.out.println("3)\tDeterminar temperatura.");
        System.out.println("4)\tAlmacenar temperatura.");
        System.out.println("5)\tMostrar temperatura menor.");
        System.out.println("6)\tMostrar temperatura mayor.");
        System.out.println("7)\tResetear memoria.");
        System.out.println("8)\tSalir.");
    }

    static void opcionesTermometro(Termometro t, int v){
        do{
            printMenu();
            int opt = input.nextInt();
            input.nextLine();
            switch (opt){
                case 1:{
                    t.setGrados(input.nextDouble());
                    break;
                }
                case 2:{
                    conversion(t, v);
                    break;
                }
                case 3:{
                    System.out.println(t.determinarTemperatura());
                    break;
                }
                case 4:{
                    t.guardarEnMemoria();
                    System.out.println(t.imprimirMemoria());
                    break;
                }
                case 5:{
                    System.out.println(t.minimo());
                    break;
                }
                case 6:{
                    System.out.println(t.maximo());
                    break;
                }
                case 7:{
                    t.resetarMemoria();
                    break;
                }
                case 8:{
                    return;
                }
                default:{
                    System.out.println("Opcion no valida, intente de nuevo");
                    break;
                }
            }
        }while(true);
    }

    static void conversion(Termometro t, int v){
        if(v == 1){
            Termometro tmp = new TermometroFahrenheit(t.convertir());
            System.out.println("Conversion\n" + tmp);
        }else if(v == 2){
            Termometro tmp = new TermometroCelcius(t.convertir());
            System.out.println("Conversion\n" + tmp);
        }
    }

    public static void main(String[] args) {
        seleccionarTermometro();
    }
}