package DAM1.DanielMS_pe05_PenyaBetica;

/**
 * Clase Fecha: Almacena y modifica datos sobre una fecha.
 * @author DanielMS
 * @version 1.0
 * @see String
 * @see Integer
 */
public class Fecha {
    
    /**
     * El dia de la fecha.
     */
    private Integer dia;
    
    /**
     * El mes de la fecha.
     */
    private Integer mes;
    
    /**
     * El anyo de la fecha.
     */
    private Integer any;
    
    /**
     * Constructor Principal
     * @param dia El dia de la fecha en días.
     * @param mes El mes de la fecha en meses.
     * @param any El año de la fecha en anyos.
     */
    public Fecha(Integer dia, Integer mes, Integer any) {
        //Control de errores para el dia
        if (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
            System.out.println("AVISO: Este mes tiene 30 dias, se establecera 30 como dia");
            this.dia = 30;
        } else if (dia > 31 && (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)) {
            System.out.println("AVISO: Este mes tiene 31 dias, se establecera 31 como dia");
            this.dia = 31;
        } else if ((mes == 2 && dia > 29) && ((any % 4 == 0 && any % 100 == 0) || any % 400 == 0)) {
            System.out.println("AVISO: Febrero tiene 29 dias ya que este anyo es bisiesto, se establecera 29 como dia");
            this.dia = 29;
        } else if ((mes == 2 && dia > 28) && ((any % 4 != 0 && any % 100 != 0) || any % 400 != 0)) {
            System.out.println("AVISO: Febrero tiene 28 dias ya que este anyo no es bisiesto, se establecera 28 como dia");
            this.dia = 28;
        } else if (dia < 1) {
            System.out.println("AVISO: El dia esta fuera de rango, reintroduzca el parametro");
        } else {
            this.dia = dia;
        }
        
        //Control de errores para el mes
        if (mes > 12 && mes < 0) {
            System.out.print("AVISO: El mes esta fuera de rango, reintroduzca el parametro");
        } else {
            this.mes = mes;
        }    
        
        this.any = any;
    }

    /**
     * Obtiene el dia de la fecha.
     * @return El dia de la fecha en un Integer.
     */
    public Integer getDia() {
        return this.dia;
    }
    
    /**
     * Modifica el dia de la fecha.
     * @param nuevoDia El nuevo dia de la fecha en un Integer.
     */
    public void setDia(Integer nuevoDia) {
        //Control de errores para el dia
        if (nuevoDia > 30 && mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            System.out.println("AVISO: Este mes tiene 30 dias, se establecera 30 como dia");
            this.dia = 30;
        } else if (nuevoDia > 31 && mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            System.out.println("AVISO: Este mes tiene 31 dias, se establecera 31 como dia");
            this.dia = 31;
        } else if ((mes == 2 && nuevoDia > 29) && ((any % 4 == 0 && any % 100 == 0) || any % 400 == 0)) {
            System.out.println("AVISO: Febrero tiene 29 dias ya que este anyo es bisiesto, se establecera 29 como dia");
            this.dia = 29;
        } else if ((mes == 2 && nuevoDia > 28) && ((any % 4 != 0 && any % 100 != 0) || any % 400 != 0)) {
            System.out.println("AVISO: Febrero tiene 28 dias ya que este anyo no es bisiesto, se establecera 28 como dia");
            this.dia = 28;
        } else if (dia < 1) {
            System.out.println("AVISO: El dia esta fuera de rango, reintroduzca el parametro");
        } else {
            this.dia = nuevoDia;
        }
    }    
    
    /**
     * Obtiene el mes de la fecha.
     * @return El mes de la fecha en un Integer.
     */
    public Integer getMes() {
        return mes;
    }

    /**
     * Modifica el mes de la fecha.
     * @param nuevoMes El nuevo mes de la fecha en un Integer.
     */
    public void setMes(Integer nuevoMes) {
        //Control de errores para el mes
        if (mes > 12 && mes < 0) {
            System.out.print("AVISO: El mes esta fuera de rango, reintroduzca el parametro");
        } else {
            this.mes = nuevoMes;
        }    
    }

    /**
     * Obtiene el anyo de la fecha.
     * @return El anyo de la fecha en un Integer.
     */
    public Integer getAny() {
        return any;
    }

    /**
     * Modifica el anyo de la fecha.
     * @param any El anyo de la fecha en un Integer.
     */
    public void setAny(Integer any) {
        this.any = any;
    }
    
    /**
     * Obtiene informacion sobre la fecha.
     * @return Informacion sobre la fecha en una cadena de caracteres.
     */
    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.any;
    }
    
}
