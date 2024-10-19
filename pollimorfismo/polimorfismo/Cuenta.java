package polimorfismo; 

public class Cuenta
{
    protected double balance;
    private int noCuenta;
       
    public Cuenta(int a){    
		balance = 0.0;
		noCuenta = a;
    }
    
    public void depositar(double suma){
	if (suma>0)
	    balance += suma;    
	else
	    System.err.println("No es posible depositar cantidad negativa.");    
    }
    
    public void retirar(double suma){
	if (suma > 0)
	    balance -= suma;    
	else
	    System.err.println("No es posible retirar cantidad negativa.");    
    }
    
    public double getBalance(){
		return balance;
    }
    
    public int getNoCuenta(){
		return noCuenta;
    }
    
    public String toString(){
		return "No. Cuenta: " + noCuenta + " - " + "Balance = " + balance;    
    }
}

