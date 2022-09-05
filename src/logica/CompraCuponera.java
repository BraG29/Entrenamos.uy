package logica;
import java.time.LocalDate;
/**
 *
 * @author elinzar
 */
public class CompraCuponera {
//Variables---------------------------------------------------------------------   
    private LocalDate fecha;
    private Cuponera cuponeraAsociada;
//Getters and Setters-----------------------------------------------------------
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
//Constructors------------------------------------------------------------------ 
    //Empty 
    public CompraCuponera() {
    }
    //Full
    public CompraCuponera(LocalDate fecha) {
        this.fecha = fecha;
    }
}
