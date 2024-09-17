package paralelepipedo.src.paralelepipedo.p;

import vector.Vector;

public class Paralelepipedo {
    private Vector u;
    private Vector v;
    private Vector w;
    
    public Paralelepipedo(Vector u, Vector v, Vector w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    
    public Vector getU() {
        return u;
    }
    
    public Vector getV() {
        return v;
    }
    
    public Vector getW() {
        return w;
    }
    
    public void setU(Vector u) {
        this.u = u;
    }
    
    public void setV(Vector v){
        this.v = v;
    }
    
    public void setW(Vector w){
        this.w = w;
    }
    
    public int volumen() {
        return Math.abs(w.productoPunto(u.productoCruz(v)));
    }
    
    @Override
    public String toString() {
        return "Vectores:\n" + u + "\n" + v + "\n" + w;
    }
}
