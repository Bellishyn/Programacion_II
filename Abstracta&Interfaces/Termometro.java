public abstract class Termometro implements Temperatura, Estadistica {
    private double grados;
    private double[] memoria;
    private int n; 

    public Termometro(double n){
            grados = n;
            memoria = new double[5]; 
            n = 0;
    }

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }

    public abstract double convertir();

    public void guardarEnMemoria() {
        if (n < 5) {
            memoria[n++] = grados;
        } else {
            n = 0;
            memoria[n++] = grados;
        }
    }

    public void resetarMemoria() {
        for(int i = 0; i < 5; i++){
            memoria[i] = 0;
        }
    }

    public String imprimirMemoria() {
        String cad = "";
        for(int i = 0; i < 5; i++){
            cad += (i + 1) + ".  " + memoria[i] + "°\n";
        }
        return cad;
    }

    @Override
    public double minimo() {
        double min = memoria[0];
        for(double grad : memoria) {
            if(grad < min){
                min = grad;
            }
        }
        return min;
    }

    @Override
    public double maximo() {
        double max = memoria[0];
        for(double grad : memoria) {
            if(grad > max){
                max = grad;
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return "Temperatura actual: " + grados + "°";
    }
}