public class TermometroCelcius extends Termometro{
    public TermometroCelcius(double g){
        super(g);
    }
    
    @Override
    public String determinarTemperatura(){
        if(super.getGrados() > 38){
            return "Fiebre: " + super.getGrados() + "°C";
        } else{
            return "Temperatura normal: " + super.getGrados() + "°C";
        }
    }

    @Override
    public double convertir(){
        return (super.getGrados() * 9/5) + 32;
    }

    @Override
    public String toString(){
        return super.toString() + "C";
    }
}