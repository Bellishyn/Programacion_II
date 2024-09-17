package recta.triangulo;

import recta.recta.Recta;
import punto.PuntoR2;

public class Triangulo {
    private PuntoR2 p1;
    private PuntoR2 p2;
    private PuntoR2 p3;
    
    public Triangulo(PuntoR2 p1, PuntoR2 p2, PuntoR2 p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    
    public void setP1(PuntoR2 p){
        this.p1 = p;
    }
    
    public void setP2(PuntoR2 p){
        this.p2 = p;
    }
    
    public void setP3(PuntoR2 p){
        this.p3 = p;
    }
    
    public boolean validacion(){
        if((p1.distancia(p2) + p1.distancia(p3)) > p2.distancia(p3)){
            if((p1.distancia(p3) + p2.distancia(p3)) > p1.distancia(p2)){
                if((p1.distancia(p2) + p2.distancia(p3)) > p1.distancia(p3)){
                    System.out.println("El triangulo existe");
                    return true;
                }
            }
        }
        
        System.out.println("El triangulo dado, no existe");
            return false;
    }
    
    public double area(){
        Recta r1 = new Recta(p2, p3);
        return (p2.distancia(p3) * r1.distancia(p1)) / 2;
    }
    
    public double perimetro(){
        return (p1.distancia(p2)) + (p2.distancia(p3)) + p3.distancia(p1);
    }
    
    @Override
    public String toString(){
        return "El triangulo esta en los puntos " + p1 + ", " + p2 + " y " + p3;
    }
}
