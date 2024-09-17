package punto;
public class PuntoR2 {
    private double x;
    private double y;
    
    public PuntoR2(){
        x = 0.0;
        y = 0.0;
    }
    
    public PuntoR2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public double distancia(PuntoR2 p) {
        return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
    }
    
    public PuntoR2 puntoMedio(PuntoR2 p) {
        double xm, ym;
        
        xm = (x + p.getX())/2;
        ym = (y + p.getY())/2;
        return new PuntoR2(xm, ym);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}