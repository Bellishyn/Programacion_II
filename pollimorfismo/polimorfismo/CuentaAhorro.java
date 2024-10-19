package polimorfismo;

public class CuentaAhorro extends Cuenta {
    private double interes;

    public CuentaAhorro(int numero, double interes){
        super(numero);
        this.interes = interes;  
    }

    public void agregarIntereses(){
       balance += balance * interes / 100; 
    }


    @Override
    public String toString(){
        return super.toString() + "\nInteres: " + interes + "%";     
    }
}
