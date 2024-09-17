package fraccion.fraccion;

public class Fraccion {
    private int numerador;
    private int denominador;
    
    public Fraccion() {
        numerador = 0;
        denominador = 0;
    }
    
    public Fraccion(int n, int d) {
        numerador = n;
        denominador = d;
    }
    
    public Fraccion(Fraccion f) {
        numerador = f.getNumerador();
        denominador = f.getDenominador();
    }
    
    public int getNumerador() {
        return numerador;
    }
    
    public int getDenominador() {
        return denominador;
    }
    
    public void setNumerador(int n) {
        numerador = n;
    }
    
    public void setDenominador(int d) {
        denominador = d;
    }
    
    private int calcularMCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calcularMCD(b, a % b);
    }
    
    public Fraccion suma(Fraccion f) {
        int ns, ds;
        if(denominador != f.getDenominador()){
            ns = (numerador * f.getDenominador()) + (f.getNumerador() * denominador);
            ds = denominador * f.getDenominador();
        }else{
            ns = numerador + f.getNumerador();
            ds = denominador;
        }
        return new Fraccion(ns, ds);
    }
    
    public Fraccion resta(Fraccion f) {
        int nr, dr;
        if(denominador != f.getDenominador()){
            nr = (numerador * f.getDenominador()) - (f.getNumerador() * denominador);
            dr = denominador * f.getDenominador();
        }else{
            nr = numerador - f.getNumerador();
            dr = denominador;
        }
        return new Fraccion(nr, dr);
    }
    
    public Fraccion multiplicacion(Fraccion f) {
        int nm, dm;
        nm = numerador * f.getNumerador();
        dm = denominador * f.getDenominador();
        return new Fraccion(nm, dm);
    }
    
    public Fraccion division(Fraccion f){
        int nd, dd;
        nd = numerador * f.getDenominador();
        dd = denominador * f.getNumerador();
        return new Fraccion(nd, dd);
    }
    
    public Fraccion simplificacion(){
        int numsimp = numerador, demsimp = denominador;
        int mcd = calcularMCD(numsimp, demsimp);
        numsimp /= mcd;
        demsimp /= mcd;
        
        return new Fraccion(numsimp, demsimp);
    }
    
    @Override
    public String toString(){
        if(denominador == 0){
            return "El resultado no es posible,\n\t  denominador igual a 0.";
        }
        double resultado = numerador / denominador;
        if(resultado >= 0){
            return Math.abs(numerador) + "/" + Math.abs(denominador);
        }
        return "- " + Math.abs(numerador) + "/" + Math.abs(denominador);
    }
}
