package logica.institucion;

import java.io.Serializable;
import logica.cuponera.Cuponera;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.ManyToOne;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


import logica.clase.Clase;
import logica.cuponera.Cuponera;
import logica.datatypes.DtActividadDeportiva;
import logica.datatypes.DtClase;
import net.bytebuddy.description.type.RecordComponentDescription.ForLoadedRecordComponent;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityTransaction;


import logica.clase.Clase;


import logica.cuponera.Cuponera;

@Entity
public class ActividadDeportiva implements Serializable {
	@Id
	@Column(name="nombre")
    private String nombreAct;
    private String descripcion;
    private float duracion;//en minutos gente
    private float costo;
    @Column(name="fecha_registro")
    private LocalDateTime fechaRegistro;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Actividad_Cuponera",
    	joinColumns = @JoinColumn(name="nom_actividad"),
    	inverseJoinColumns = @JoinColumn(name="nom_cuponera"))
    private Collection<Cuponera> cuponeras;
    
    @OneToMany(mappedBy = "claseDe",cascade = CascadeType.ALL)
    private Collection<Clase> clases;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "institucion")
    private Institucion insti;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Actividad_Categorias",
    	joinColumns = @JoinColumn(name="nom_actividad"),
    	inverseJoinColumns = @JoinColumn(name="nom_categoria"))
    private Collection<Categoria> categoriasAsociadas;
   

    
    public ActividadDeportiva(String nombreAct, String descripcion, float duracion, float costo, LocalDateTime fechaRegistro, Institucion institu) {
        this.nombreAct = nombreAct;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
        this.insti = institu;
        this.clases = new ArrayList<>();
     //   this.cuponeras = new ArrayList<>();
    }
    
    public int getCantCupo() {
    	return this.cuponeras.size();
    }
    
    public ArrayList<String> getNombreCupo() {
//    	ArrayList<Cuponera> cupos = ((List<Cuponera>)this.cuponeras);
   	ArrayList<String> listaADevolver = new ArrayList<String>();
   	
//    	for(int i = 0;i < cupos.size();i++) {
//    		listaADevolver.add(cupos.get(i).getNombreCup());
//    	}
    	
    	for(Cuponera C : this.cuponeras) {
    		listaADevolver.add(C.getNombreCup());
    	}
    	
    	return listaADevolver;
    	
    }
    
    public ActividadDeportiva() {
        this.clases = new ArrayList<>();
        this.cuponeras = new ArrayList<>();
    }

    //Getters
    public String getNombreAct() {
        return nombreAct;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getDuracion() {
        return duracion;
    }

    public float getCosto() {
        return costo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public Collection<Cuponera> getCuponeras() {
        return cuponeras;
    }

    public Institucion getInsti() {
        return insti;
    }
    
    

    //Setters
    public void setNombreAct(String nombreAct) {
        this.nombreAct = nombreAct;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setCuponeras(Collection<Cuponera> cuponeras) {
        this.cuponeras = cuponeras;
    }

    public void setInsti(Institucion insti) {
        this.insti = insti;
    }
    
    
    
    public void agregarCup(Cuponera cup){
    	this.cuponeras.add(cup);
    }
    
    public DtActividadDeportiva getDTActividadDeportiva(){
        ArrayList<String> strClases = new ArrayList<String>();
        for(Clase c : this.clases){
            strClases.add(c.getNombreClase());
        }
        
        ArrayList<String> strCuponeras = new ArrayList<String>();
        for(Cuponera c : this.cuponeras){
            strCuponeras.add(c.getNombreCup());
        }
        
        DtActividadDeportiva DtActi = new DtActividadDeportiva(this.nombreAct, this.descripcion, this.duracion, this.costo, this.fechaRegistro, strClases, strCuponeras);
        return DtActi;
    }
    
    
    public ArrayList<String> getNombreClases(){
        ArrayList<String> nombreClases = new ArrayList<String>();
        
        for(Clase C : this.clases) {
    		nombreClases.add(C.getNombreClase());
    	}
    	
    	return nombreClases;
    }
    
    public void darAltaClaseActi(Clase claseDictada){
    		this.clases.add(claseDictada);
    }
    
    public DtClase getDtClaseXActiDepo(String nombreClase,EntityManager em) {
    	//this.clases
    	System.out.println("Antes de buscar la Clase");
    	Clase clase = em.find(Clase.class,nombreClase);
    	System.out.println("Despues de buscar la Clase");
    	
    	DtClase claseADevolver = clase.getData();
    	
    	return claseADevolver;
    }
    
    public Clase getClase(String nomClase) {
    	Clase c = null;
    	for(Clase cl : clases) {
    		if(cl.getNombreClase().equals(nomClase)) {
    			c = cl;
    			break;
    		}
    	}
    	return c;
    }
    
}
