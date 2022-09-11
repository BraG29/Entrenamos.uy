package logica.institucion;
import logica.cuponera.Cuponera;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import logica.clase.Clase;
import logica.cuponera.Cuponera;
import logica.datatypes.DtActividadDeportiva;
import java.util.ArrayList;
import java.util.Collection;

import logica.cuponera.Cuponera;
@Entity
public class ActividadDeportiva {
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
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Actividad_Clase",
		joinColumns = @JoinColumn(name="nom_actividad"),
		inverseJoinColumns = @JoinColumn(name="nom_clase"))
    private Collection<Clase> clases;

    
    
    public ActividadDeportiva(String nombreAct, String descripcion, float duracion, float costo, LocalDateTime fechaRegistro) {
        this.nombreAct = nombreAct;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaRegistro = fechaRegistro;
    }
    
     public ActividadDeportiva() {
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
    
    
    public DtActividadDeportiva getDTActividadDeportiva(){
        ArrayList<String> strClases = new ArrayList<String>();
        //strClases.addAll(clases.keySet());
        
        ArrayList<String> strCuponeras = new ArrayList<String>();
        //strCuponeras.addAll(cuponeras.keySet());
        
        DtActividadDeportiva DtActi = new DtActividadDeportiva(this.nombreAct, this.descripcion, this.duracion, this.costo, this.fechaRegistro, strClases, strCuponeras);
        return DtActi;
    }
    
    public ArrayList<String> getNombreClases(){
        ArrayList<String> nombreClases = new ArrayList<String>();
        //nombreClases.addAll(clases.keySet());
        
        return nombreClases;
    }
    
}
