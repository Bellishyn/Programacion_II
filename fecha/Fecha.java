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

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return day;
    }

    public boolean equals(Fecha fecha){
        return (day == fecha.getDay()) && (month == fecha.getMonth()) && (year == fecha.getYear());
    }

    @Override
    public String toString(){
        return day + "/" + month + "/" + year;
    }
}
