package excepcionescuentabancaria;

public class CuentaBancaria {
    private double balance;
    private int noCuenta;

    public CuentaBancaria(double balanceInicial, int noCuenta) {
        if(balanceInicial < 0.0){
            throw new IllegalArgumentException("El balance dado debe ser mayor a 0.");
        }
        if(String.valueOf(noCuenta).length() != 5){
            throw new IllegalArgumentException("El número de cuenta debe contener 5 digitos");
        }else if(noCuenta < 0){
            throw new IllegalArgumentException("El número de cuenta de debe ser positivo.");
        }
        this.balance = balanceInicial;
        this.noCuenta = noCuenta;
    }
    
    public double getBalance() {
        return balance;
    }

    public int getNoCuenta() {
        return noCuenta;
    }
    
    public void depositar(double cantidad) {
        if(cantidad < 0){
            throw new IllegalArgumentException("¡Cantidad negativa,no es posible depositar! Proporcione un valor positivo");
        }
        balance = balance + cantidad;
    }

    public void retirar(double cantidad) throws Sobregiro{
        if(cantidad < 0){
            throw new IllegalArgumentException("¡Cantidad negativa, no es posible retirar! Proporcione un valor positivo");
        }
        if(balance < cantidad){
            throw new Sobregiro();
        }
        balance = balance - cantidad;
    }
    
    @Override
    public String toString () {
        return "" + noCuenta + " $" + balance;
    }
}
