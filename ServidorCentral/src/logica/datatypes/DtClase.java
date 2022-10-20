package logica.datatypes;

import java.time.LocalDate;
import java.time.LocalTime;

public class DtClase {

    public final String nombreClase;
    public final LocalDate fecha;
    public final LocalTime horaIni;
    public final int cantMin;
    public final int cantMax;
    public final String claseURL;
    public final LocalDate fechaRegistro;
    // atributos calculados:
    public final LocalTime horaFin;
    public final int cantSocios;

    // El constructor no calcula ninguno de los atributos calculados tho
    public DtClase(String nombreClase, LocalDate fecha, LocalTime horaIni, int cantMini, int cantMaxi, String claseURL,
            LocalDate fechaRegistro, LocalTime horaFin, int cantSocios) {
        this.nombreClase = nombreClase;
        this.fecha = fecha;
        this.horaIni = horaIni;
        this.cantMin = cantMini;
        this.cantMax = cantMaxi;
        this.claseURL = claseURL;
        this.fechaRegistro = fechaRegistro;
        this.horaFin = horaFin;
        this.cantSocios = cantSocios;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraIni() {
        return horaIni;
    }

    public int getCantMin() {
        return cantMin;
    }

    public int getCantMax() {
        return cantMax;
    }

    public String getClaseURL() {
        return claseURL;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public int getCantSocios() {
        return cantSocios;
    }

}
