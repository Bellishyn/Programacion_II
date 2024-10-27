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
        try{
            Object c = new CuentaBancaria(cantidad, this.noCuenta);
            balance = balance + cantidad;
        }
        catch(IllegalArgumentException e1){
            System.out.println("¡Cantidad negativa, no es posible depositar! Proporcione un valor positivo.");
        }
        catch(Exception e2){
            System.out.println("Ocurrio un error");
        }
        finally{

        }
    }

    public void retirar(double cantidad) {
        try{
            Object c = new CuentaBancaria(cantidad, this.noCuenta);
            if(balance < cantidad){
                try {
                    throw new IllegalArgumentException();
                } catch (Exception e1) {
                    System.out.println("¡No hay fondos suficientes!");
                }
            }else{balance = balance - cantidad;}
        }
        catch(IllegalArgumentException e2){
            System.out.println("¡Cantidad negativa, no es posible retirar! Proporcione un valor positivo.");
        }
        catch(Exception e3){
            System.out.println("Ocurrio un error");
        }
        finally{

        }
    }
    
    @Override
    public String toString () {
        return "" + noCuenta + " $" + balance;
    }
}
