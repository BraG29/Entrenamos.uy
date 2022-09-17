package logica.cuponera;

import java.io.Serializable;
import logica.datatypes.DtCuponera;
import logica.institucion.ActividadDeportiva;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityTransaction;

@Entity
public class Cuponera implements Serializable {
//Private Variables-------------------------------------------------------------
	
	
	@Id
	@Column(name = "nombre")
	private String nombreCup;
	private String descripcion;
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;
	@Column(name = "fecha_fin")
	private LocalDate fechaFin;
	private float descuento;
	@Column(name = "fecha_alta")
	private LocalDate fechaAlta;
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

    public Collection<ActividadDeportiva> getActividades() {
        return actividades;
    }

    public void setActividades(Collection<ActividadDeportiva> actividades) {
        this.actividades = actividades;
    }
        

//Constructors------------------------------------------------------------------
	// empty constructor
	public Cuponera() {
            this.actividades = new ArrayList<>();
	}

	// Full Constructor
	public Cuponera(String nombreCup, String descripcion, LocalDate fechaInicio, LocalDate fechaFin,
			float descuento, LocalDate fechaAlta, int cantClases) {
		this.nombreCup = nombreCup;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descuento = descuento;
		this.fechaAlta = fechaAlta;
		this.cantClases = cantClases;
        this.actividades = new ArrayList<>();
	}

//Methods-----------------------------------------------------------------------
	public String[] removeActividadesDeCuponera(String[] perteneAcup) {

		String[] output = null; // placeholder
		return output; // placeholder
	}

	public boolean aniadirAD(ActividadDeportiva acti, int cantidadClases,EntityManager em,EntityTransaction tran) {
            try{
                
                acti.agregarCup(this, em, tran);
                tran.begin();
                em.flush();
                this.actividades.add(acti);
                this.cantClases =+ cantidadClases;
                tran.commit();
                System.out.println("Should have worked...");
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
                tran.rollback();
                return false;
            }
            return true;
	}

	public DtCuponera getData() {
		ArrayList<String> nomActis = new ArrayList<String>();
		// nomActis.addAll(this.actividades.keySet());
		for(ActividadDeportiva ac : this.actividades) {
			nomActis.add(ac.getNombreAct());
		}
		DtCuponera output = new DtCuponera(this.nombreCup, this.descripcion, this.fechaInicio, this.fechaFin,
				this.descuento, this.fechaAlta, this.cantClases, nomActis);
		return output;
	}

	/*
	public ArrayList<String> getNombres() {
		EntityManager em = emf.createEntityManager();
		ArrayList<String> listaActividades = new ArrayList<String>();
		java.util.List consultaAct = null;
		try {
			em.getTransaction().begin();
			consultaAct = em.createQuery("SELECT nombreAct FROM Actividad_Cuponera").getResultList();//resultado = nombre
		}catch (Exception ex) {
			if (em != null) {
				em.getTransaction().rollback();
			}
		} finally {
			em.close();
		}
		for (int i = 0; i < consultaAct.size(); i++) {
			String nombreAct = (String)consultaAct.get(i); //nombre de la actividad en la q toy parado
			listaActividades.add(nombreAct); //agrego a lista	
		}
		return listaActividades; //retorno nombres de actividades de esa cuponera.
	}*/
	
//EOF---------------------------------------------------------------------------
}
