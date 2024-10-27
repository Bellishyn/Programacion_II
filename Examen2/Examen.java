import java.util.Scanner;

interface Zoologico{
    public String recibirFelino();
}

abstract class Felino implements Zoologico{
    private String nombre;

    public Felino(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public abstract String alimentar();

    public abstract String cazar();

    @Override
    public String recibirFelino(){
        return "Felino recibido con carinio";
    }

    @Override
    public String toString(){
        return "Soy " +  nombre;
    }
}

class Gato extends Felino{
    private int vidas;

    public Gato(String nombre){
        super(nombre);
        this.vidas = 7;
    }

    public int getVidas(){
        return vidas;
    }

    public void setVidas(int vidas){
        this.vidas = vidas;
    }

    @Override
    public String alimentar(){
        return "Alimentado";
    }

    @Override
    public String cazar(){
        return "El gato ha cazado un raton";
    }

    public String ronronear(){
        return "Gato ronroneado :D";
    }

    @Override
    public String toString(){
        return super.toString() + ", un gato" + " y tengo " + vidas + " vidas";
    }
}

class Leon extends Felino{
    public Leon(String nombre){
        super(nombre);
    }

    @Override
    public String alimentar(){
        return "Alimentado";
    }

    @Override
    public String cazar(){
        return "El leon ha cazado un cebra :O";
    }

    public String rugir(){
        return "El leon ha rugido >:D";
    }

    @Override
    public String toString(){
        return super.toString() + ",un leon";
    }
}

public class Examen{
    static Scanner input = new Scanner(System.in);
    static Felino[] f = new Felino[5];

    static void menu(){
        do{
            int opt;
            System.out.println("Menu:");
            System.out.println("1. Alimentar");
            System.out.println("2. Cazar");
            System.out.println("3. Expresar");
            System.out.println("4. Salir");
            
            opt = input.nextInt();
            switch (opt) {
                case 1:
                    alimentarFelinos();
                    break;
                case 2:
                    felinosCazando();
                    break;
                case 3:
                    expresar();
                    break;
                case 4:
                    return;
                default:
                System.out.println("Opcion erronea");
                    break;
            }
        }while(true);
    }

    static void alimentarFelinos(){
        for(int i = 0; i < 5; i++){
            System.out.println(f[i].alimentar());
        }
    }


    static void felinosCazando(){
        for(int i = 0; i < 5; i++){
            System.out.println(f[i].cazar());
        }
    }

    static void expresar(){
        for(int i = 0; i < 5; i++){
            if(i < 3){
                if(f[i] instanceof Gato){
                    System.out.println(((Gato)f[i]).ronronear()); 
                } 
            }else{
                System.out.println(((Leon)f[i]).rugir());
            }
        }
    }
    public static void main(String[] args){
        Felino g1 = new Gato("Rotoplas");
        Felino g2 = new Gato("Chumuske");
        Felino g3 = new Gato("Minerva");
        Felino l1 = new Leon("Rugin");
        Felino l2 = new Leon("Samsom");
        f[0] = g1;
        f[1] = g2;
        f[2] = g3;
        f[3] = l1;
        f[4] = l2;
        menu();
    }
}