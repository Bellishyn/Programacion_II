package fecha;

public class Fecha {
    private int day;
    private int month;
    private int year;

    public Fecha(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString(){
        return day + "/" + month + "/" + year;
    }
}
