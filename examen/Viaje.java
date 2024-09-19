package examen;

public class Viaje {
    private String fecha;
    private float distancia;
    private float tarifa;

    public Viaje(){
        this.fecha = "";
        this.distancia = 0;
        this.tarifa = 0;
    }

    public Viaje(String fecha, float distancia, float tarifa){
        this.fecha = fecha;
        this.distancia = distancia;
        this.tarifa = tarifa;
    }

    public String getFecha(){
        return fecha;
    }

    public float getDistancia(){
        return distancia;
    }

    public float getTarifa(){
        return tarifa;
    }

    @Override
    public String toString() {
        return "Viajes realizado el: " + fecha + "\nDistancia recorrida: " + distancia;
    }
}
