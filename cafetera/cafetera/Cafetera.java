package cafetera.cafetera;

public class Cafetera {
    private int capacidadMaxima; 
    private int cantidadActual; 

    public Cafetera(){
        capacidadMaxima = 1000; 
        cantidadActual = 0; 
    }

    public Cafetera(int capacidadMaxima){
        cantidadActual = this.capacidadMaxima = capacidadMaxima; 
    }

    public Cafetera(int cm, int ca){
        capacidadMaxima = cm; 
        cantidadActual = Math.min(cm, ca); 
    }

    public int getCapMax(){
        return capacidadMaxima; 
    }

    public int getCapAct(){
        return cantidadActual; 
    }

    public void setCapMax(int t){
        capacidadMaxima = t; 
    }

    public void setCapAct(int t){
        cantidadActual = t; 
    }

    public void llenarCafetera(){
        cantidadActual = capacidadMaxima; 
    }

    public void servirTaza(int s){
        if(s > cantidadActual){
             System.out.println("No hay suficiente cafe. Se servira lo que queda: " + cantidadActual + " ml.");
             cantidadActual = 0;
        } else {
            cantidadActual -= s; 
        }
    }

    public void agregarCafe(int j){
        setCapAct(getCapAct() + j); 
    }

    public void vaciarCafetera(){
        cantidadActual = 0; 
    }

    @Override 
    public String toString(){
        return "Capacidad maxima: "+capacidadMaxima+"\nCantidad Actual: "+
        cantidadActual; 
    }
}