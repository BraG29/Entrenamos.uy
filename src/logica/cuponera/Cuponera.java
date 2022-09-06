package logica.cuponera;
import logica.datatypes.DtCuponera;
import logica.institucion.ActividadDeportiva;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author elinzar (Kevin Viera)
 */

@Entity
public class Cuponera {
//Private Variables-------------------------------------------------------------
	
	@Id
	@Column(name="nombre")
    private String nombreCup;
    private String descripcion;
    @Column(name="fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name="fecha_fin")
    private LocalDate fechaFin;
    private float descuento;
    @Column(name="fecha_alta")
    private LocalDate fechaAlta;
    @Column(name="cant_clases")
    private int cantClases;
    
    @ManyToMany(mappedBy = "cuponeras")
    private Collection<ActividadDeportiva> actividades;
    
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
        ArrayList<String> nomActis = new ArrayList<String>(); 
        //nomActis.addAll(this.actividades.keySet());
        
        DtCuponera output = new DtCuponera(this.nombreCup,this.descripcion,this.fechaInicio,this.fechaFin,this.descuento,this.fechaAlta,this.cantClases,nomActis);
        return output;
    }
    
//EOF---------------------------------------------------------------------------
}
