package complejos;

public class Complejo {
    private double parteReal;
    private double parteImaginaria;
    
    public Complejo() {
        parteReal = 0;
        parteImaginaria = 0;
    }
    
    public Complejo(double r, double i) {
        parteReal = r;
        parteImaginaria = i;
    }
    
    public double getReal() {
        return parteReal;
    }
    
    public double getImaginaria() {
        return parteImaginaria;
    }
    
    public void setReal(double r) {
        parteReal = r;
    }
    
    public void setImaginaria(double i) {
        parteImaginaria = i;
    }
    
    public Complejo sumaComplejos(Complejo c) {
        double pr, pi;
        pr = parteReal + c.getReal();
        pi = parteImaginaria + c.getImaginaria();
        return new Complejo(pr, pi);
    }
    
    public Complejo restaComplejos(Complejo c) {
        double pr, pi;
        pr = parteReal - c.getReal();
        pi = parteImaginaria - c.getImaginaria();
        return new Complejo(pr, pi);
    }
    
    public Complejo multiplicacionComplejos(Complejo c) {
        double pr, pi;
        pr = (parteReal * c.getReal()) - (parteImaginaria * c.getImaginaria());
        pi = (parteReal * c.getImaginaria()) + (parteImaginaria * c.getReal());
        return new Complejo(pr, pi);
    }
    
    public Complejo conjugadoComplejos() {
        return new Complejo(parteReal, (-1) * parteImaginaria);
    }
    
    public double moduloComplejos() {
        return Math.sqrt(Math.pow(parteReal, 2) + Math.pow(parteImaginaria, 2));
    }
    
    public double anguloComplejos() {
        double a = parteImaginaria / parteReal;
        if((parteImaginaria < 0) && (parteReal > 0)) {
            return ((Math.atan(a) * 180) / Math.PI) + 360;
        }else if((parteImaginaria < 0) || (parteReal < 0)){
            return ((Math.atan(a) * 180) / Math.PI) + 180;
        }
        return (Math.atan(a) * 180) / Math.PI;
    }
    
    @Override
    public String toString(){
        return parteReal + ((parteImaginaria < 0) ? " - " + -1 * parteImaginaria :
                " + " + parteImaginaria) + "i";
    }
}
