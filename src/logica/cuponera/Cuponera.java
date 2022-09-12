package logica.cuponera;

import logica.datatypes.DtCuponera;
import logica.institucion.ActividadDeportiva;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Cuponera {
//Private Variables-------------------------------------------------------------

	@Id
	@Column(name = "nombre")
	private String nombreCup;
	private String descripcion;
	@Column(name = "fecha_inicio")
	private LocalDateTime fechaInicio;
	@Column(name = "fecha_fin")
	private LocalDateTime fechaFin;
	private float descuento;
	@Column(name = "fecha_alta")
	private LocalDateTime fechaAlta;
	@Column(name = "cant_clases")
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

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getCantClases() {
		return cantClases;
	}

	public void setCantClases(int cantClases) {
		this.cantClases = cantClases;
	}

//Constructors------------------------------------------------------------------
	// empty constructor
	public Cuponera() {
	}

	// Full Constructor
	public Cuponera(String nombreCup, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			float descuento, LocalDateTime fechaAlta, int cantClases) {
		this.nombreCup = nombreCup;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descuento = descuento;
		this.fechaAlta = fechaAlta;
		this.cantClases = cantClases;
	}

//Methods-----------------------------------------------------------------------
	public String[] removeActividadesDeCuponera(String[] perteneAcup) {

		String[] output = null; // placeholder
		return output; // placeholder
	}

	public void aniadirAD(ActividadDeportiva ad, int cantClases) {

	}

	public DtCuponera getData() {
		ArrayList<String> nomActis = new ArrayList<String>();
		// nomActis.addAll(this.actividades.keySet());

		DtCuponera output = new DtCuponera(this.nombreCup, this.descripcion, this.fechaInicio, this.fechaFin,
				this.descuento, this.fechaAlta, this.cantClases, nomActis);
		return output;
	}

	
	public DtCuponera getDatosConAC() {
		return null;
	}
	
//EOF---------------------------------------------------------------------------
}
