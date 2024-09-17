package fechas.fechas;

/* Clase */
public class Fecha {
    
    /* Atributos */
    private int day; 
    private int month; 
    private int year; 

    /* Constructores */

    /* Por defecto sin parametros */
    public Fecha(){
        day = 1;
        month = 1; 
        year = 1900; 
    }

    /* Constructor con parametros */
    public Fecha(int dd, int mm, int yy){
        day = dd; 
        month = mm; 
        year = yy; 
        valida();
    }

    /* Metodos */

    public boolean bisiesto(){
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0); 
    }

    public int diasMes(){
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if(bisiesto()){
                    return 29; 
                } else {
                     return 28; 
                }
            default:
                return 31;
        }
    }

    private int diasMes(int mm){
        switch (mm) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if(bisiesto()){
                    return 29; 
                } else {
                     return 28; 
                }
            default:
                return 31;
        }
    }

    private void valida(){
        if(day<1 || day>diasMes(month)){
            day = 1; 
        }
        if(month<1 || month>12){
            month = 1;
        } 
        if(year<1900 || year>2050){ 
            year = 1900; 
        }
    }

    /* Getters */

    public int getDay(){
        return day; 
    }

    public int getMonth(){
        return month; 
    }

    public int getYear(){
        return year; 
    }

    /* Setters */

    public void setDay(int dd){
        day = dd; 
    }

    public void setMonth(int mm){
        month = mm; 
    }

    public void setYear(int yy){
        year = yy; 
    }

    public void corta(){
        System.out.println(day+"-"+month+"-"+year);
    }

    public int diasTranscurridos(){
        int db = 365; 
        if(bisiesto()){
            db = 366; 
        }
        return (day-1)+((month-1)*diasMes(month-1))+((year-1900)*db);
    }

    /* Congruencia de Zeller*/

    public int diaSemana(){
        int mm=month, yy=year, v1, v2; 

        //La congruencia denomina a Enero y Febrero como el mes 13 y 14 del año anterior
        if (mm <= 2) {
            mm += 12; 
            yy -= 1; 
        }

        //Calculando variables necesarias
        v1 = yy % 100; 
        v2 = yy / 100;

        // Aplicacion la congruencia de Zeller y ajustando para retornar 0-domingo ... 6-sabado
        return (((day + (13 * (mm + 1)) / 5 + v1 + v1 / 4 + v2 / 4 + 5 * v2) % 7) + 6) % 7;
    }

    public void larga(){
        String n1=null, n2=null;
        switch(diaSemana()){
            case 0: 
                n1 = "Domingo";
                break; 
            case 1: 
                n1 = "Lunes";
                break;
            case 2: 
                n1 = "Martes";
                break; 
            case 3: 
                n1 = "Miercoles";  
                break; 
            case 4:
                n1 = "Jueves"; 
                break; 
            case 5: 
                n1 = "Viernes";
                break; 
            case 6: 
                n1 = "Sabado"; 
                break;  
            default: 
                break;     
        }

        switch(month){
            case 1: 
                n2 = "enero"; 
                break; 
            case 2: 
                n2 = "febrero"; 
                break; 
            case 3: 
                n2 = "marzo"; 
                break; 
            case 4: 
                n2 = "abril"; 
                break; 
            case 5: 
                n2 = "mayo"; 
                break;
            case 6: 
                n2 = "junio"; 
                break;
            case 7: 
                n2 = "julio"; 
                break;   
            case 8: 
                n2 = "agosto"; 
                break; 
            case 9: 
                n2 = "septiembre"; 
                break; 
            case 10: 
                n2 = "octubre"; 
                break; 
            case 11: 
                n2 = "noviembre"; 
                break; 
            case 12: 
                n2 = "diciembre"; 
                break; 
            default: 
                break; 
        }

        System.out.println(n1 + " " + day + " de " + n2 + " de "+ year);
    }

    public void fechaTras(int n){ 
        for(int i=0; i<n; i++){
            day++; 
            if(day > diasMes(month)){
                month++;
                day = 1;
                if(month > 12){
                    year++; 
                    month = 1; 
                    day = 1; 
                }
            }
        }
    }

    public void siguiente(){
        day++; 
        if(day > diasMes(month)){
            month++;
            day = 1;
            if(month > 12){
                year++; 
                month = 1; 
                day = 1; 
            }
        }
    }

    public void anterior(){
        day--;
        if(day < 1){
            month--; 
            day = diasMes(month);
            if(month < 1){
                year--; 
                month = 12; 
                day = diasMes(12); 
            } 
        }
    }

    @Override
    public String toString() {
        return "Dia: "+day+"\nMes: "+month+"\nAño: "+year;
    }
}
