package logica;
import logica.ActividadDeportiva;
import logica.datatypes.DtCuponera;
import java.time.LocalDate;

/**
 *
 * @author elinzar (Kevin Viera)
 */
public class Cuponera {
//Private Variables-------------------------------------------------------------
    private String nombreCup;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private float descuento;
    private LocalDate fechaAlta;
    private int cantClases;
    
//Getters and Setters-----------------------------------------------------------
    public String getNombreCup() {
        return nombreCup;
    }

    public void setNombreCup(String nombreCup) {
        this.nombreCup = nombreCup;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getCantClases() {
        return cantClases;
    }

    public void setCantClases(int cantClases) {
        this.cantClases = cantClases;
    }
    
//Constructors------------------------------------------------------------------
    //empty constructor
    public Cuponera() {
    }
    //Full Constructor
    public Cuponera(String nombreCup, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, float descuento, LocalDate fechaAlta, int cantClases) {
        this.nombreCup = nombreCup;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descuento = descuento;
        this.fechaAlta = fechaAlta;
        this.cantClases = cantClases;
    }
    
//Methods-----------------------------------------------------------------------
    public String[] removeActividadesDeCuponera(String [] perteneAcup){ 
        
        String[] output = null; //placeholder
        return output; //placeholder
    }
    public void aniadirAD(ActividadDeportiva ad,int cantClases){
        
    }
    public DtCuponera getData(){ 
        DtCuponera output = new DtCuponera(this.nombreCup,this.descripcion,this.fechaInicio,this.fechaFin,this.descuento,this.fechaAlta,this.cantClases);
        return output;
    }
    
//EOF---------------------------------------------------------------------------
}
