
package logica.datatypes;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author elinzar
 */
public class DtCuponera {
    public final String nombreCup;
    public final String descripcion;
    public final LocalDateTime fechaInicio;
    public final LocalDateTime fechaFin;
    public final float descuento;
    public final LocalDateTime fechaAlta;
    public final int cantClases;
    public final ArrayList<String> actividades;

    public DtCuponera(String nombreCup, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, float descuento, LocalDateTime fechaAlta, int cantClases, ArrayList<String> actis) {
        this.nombreCup = nombreCup;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descuento = descuento;
        this.fechaAlta = fechaAlta;
        this.cantClases = cantClases;
        this.actividades = actis;
    }
}
