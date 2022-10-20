
package logica.datatypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author elinzar
 */
public class DtCuponera {
    public final String nombreCup;
    public final String descripcion;
    public final LocalDate fechaInicio;
    public final LocalDate fechaFin;
    public final float descuento;
    public final LocalDate fechaAlta;
    public final int cantClases;
    public final Collection<String> actividades;// se podra pasar de collection a ArrayList<String> plz?

    public DtCuponera(String nombreCup, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, float descuento,
            LocalDate fechaAlta, int cantClases, Collection<String> actis) {
        this.nombreCup = nombreCup;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descuento = descuento;
        this.fechaAlta = fechaAlta;
        this.cantClases = cantClases;
        this.actividades = actis;
    }

    public String getNombreCup() {
        return nombreCup;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public float getDescuento() {
        return descuento;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public int getCantClases() {
        return cantClases;
    }

    public Collection<String> getActividades() {
        return actividades;
    }

}
