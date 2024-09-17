package fechas.fechas;

import java.util.Scanner; 

public class Principal {
    static Scanner leer = new Scanner(System.in); 

    static Fecha f1; 

    static int dd,mm,yy,opc,nd;

    static public void iniciar(){
        System.out.print("Indicar el dia: ");
        dd = leer.nextInt();
        System.out.print("Indicar el mes: ");
        mm = leer.nextInt();
        System.out.print("Indicar el año: ");
        yy = leer.nextInt(); 

        f1 = new Fecha(dd, mm, yy);
    }

    static public void menu(Fecha f1){
        do{
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("Fecha actual: " + f1.getDay() + "-" + f1.getMonth() + "-" + f1.getYear()); 
            System.out.println("\nMenu:  ");
            System.out.println("1. Dias del mes.     | 2. Fecha en formato corto. | 3. Fecha en formato largo. | 4. Dias transcurridos.");
            System.out.println("5. Dia de la semana. | 6. FechaTras.              | 7. Siguiente dia.          | 8. Anterior dia.");
            System.out.println("9.Salir.");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.print("Favor de seleccionar una opcion: ");
            opc = leer.nextInt(); 

            switch(opc){
                case 1: 
                    System.out.println("Los dias correspondientes al mes " + f1.getMonth() + " son " + f1.diasMes());
                    break; 
                case 2: 
                    f1.corta();
                    break; 
                case 3: 
                    f1.larga();
                    break; 
                case 4: 
                    System.out.println("El numero de dias transcurridos entre el 1-1-1900 hasta el " + f1.getDay() + "-" + f1.getMonth() + "-" + 
                        f1.getYear() + " es: " + f1.diasTranscurridos() + " dias.");
                    break;
                case 5:
                    System.out.println("Nota: 0 corresponde a domingo, ..., 6 corresponde a sabado.");
                    System.out.println("El dia de la semana es: " + f1.diaSemana());
                    break; 
                case 6: 
                    System.out.println("Indicar el numero de dias a avanzar en la fecha: ");
                    nd = leer.nextInt(); 
                    f1.fechaTras(nd);
                    f1.larga(); 
                    break; 
                case 7: 
                    System.out.println("Aumentando un dia a la fecha...");
                    f1.siguiente();
                    break; 
                case 8: 
                    System.out.println("Retrocediendo un dia a la fecha...");
                    f1.anterior();
                    break; 
                case 9: 
                    System.out.println("Saliendo...");
                    return; 
                default: 
                    System.out.println("Accion no valida.");
                    break; 
            }
        }while(true); 
    }

    public static void main(String[] args){
        iniciar(); 
        menu(f1); 
    }
}
