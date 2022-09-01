package logica.datatypes;

import java.time.LocalDate;
import java.time.LocalTime;


public class DtClase {
    
    private final String nombreClase;
    private final LocalDate fecha;
    private final LocalTime horaIni;
    private final int cantMin;
    private final int cantMax;
    private final String claseURL;
    private final LocalDate fechaRegistro;
    //atributos calculados:
    private final LocalTime horaFin;
    private final int cantSocios;

    //El constructor no calcula ninguno de los atributos calculados tho
    public DtClase(String nombreClase, LocalDate fecha, LocalTime horaIni, int cantMin, int cantMax, String claseURL, LocalDate fechaRegistro, LocalTime horaFin, int cantSocios) {
        this.nombreClase = nombreClase;
        this.fecha = fecha;
        this.horaIni = horaIni;
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.claseURL = claseURL;
        this.fechaRegistro = fechaRegistro;
        this.horaFin = horaFin;
        this.cantSocios = cantSocios;
    }
    
    
}
