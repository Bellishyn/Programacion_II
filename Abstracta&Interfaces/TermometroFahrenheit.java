public class TermometroFahrenheit extends Termometro {
    public TermometroFahrenheit(double g){
        super(g);
    }
    
    @Override
    public String determinarTemperatura(){
        if(super.getGrados() > 100.4){
            return "Fiebre: " + super.getGrados() + "°F";
        } else{
            return "Temperatura normal: " + super.getGrados() + "°F";
        }
    }

    @Override
    public double convertir(){
        return (super.getGrados() - 32) * 5/9;
    }

    @Override
    public String toString(){
        return super.toString() + "F";
    }
}