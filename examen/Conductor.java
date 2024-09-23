package examen;

public class Conductor{
    private int id;
    private String nombre;
    private Viaje[] viajes;
    private int cantViajes;

    public Conductor(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
        viajes = new Viaje[3];
        cantViajes = 0;
    }

    public String getNombre(){
        return nombre;
    }

    public String getFecha(int i){
        return viajes[i].getFecha();
    }

    public int getID(){
        return id;
    }

    public void agregarViaje(Viaje viaje){
        viajes[cantViajes++] = viaje;
    }

    public String devolverGanancias(String fecha, int n){
        while((n < cantViajes) && (viajes[n].getFecha().equals(fecha))){
            n++;
        }

        return "Ganancia en " + viajes[n].getFecha() + " : " + (viajes[n].getTarifa() * viajes[n].getDistancia());
    }

    @Override
    public String toString(){
        String cad = "";
        for(int i = 0; i < cantViajes; i++){
            cad += viajes[i] + "\n";
        }
        return nombre + ":\n" + cad;
    }
}