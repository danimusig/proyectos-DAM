package boletinRepasoJava1_Ej5;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class Cliente {
    int codigoCliente;
    Date fecharegistro;
    Set<Libro> librosComprados = Collections.emptySet();

    public Cliente(int codigoCliente, Date fecharegistro, Set<Libro> librosComprados) {
        this.codigoCliente = codigoCliente;
        this.fecharegistro = ;
        this.librosComprados = librosComprados;
    }
}
