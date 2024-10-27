package excepcionescuentabancaria;

public class Sobregiro extends Exception {
    public Sobregiro(){
        super("¡No hay fondos suficientes!");
    }
}
