package polimorfismo;

public class CuentaCorriente extends Cuenta{
    private double limiteSobregiro; 

    public CuentaCorriente(int numero, double limiteSobregiro){
        super(numero);
        this.limiteSobregiro = limiteSobregiro; 
    }

    @Override
    public void retirar(double c){
        if(c > 0 && (balance + limiteSobregiro) >= c){
            balance -= c; 
        } else {
            System.out.println("Cantidad no valida");
        }
    }

    @Override
    public String toString(){
        return super.toString() + "\nLimite de sobregiro: " + limiteSobregiro; 
    }
}