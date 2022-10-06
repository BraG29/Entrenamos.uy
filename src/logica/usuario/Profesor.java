package logica.usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.property.access.internal.PropertyAccessMapImpl.GetterImpl;

import com.mysql.cj.Query;
import java.util.ArrayList;

import logica.clase.Clase;
import logica.datatypes.DtProfesor;
import logica.datatypes.DtUsuario;
import logica.institucion.ActividadDeportiva;
import logica.institucion.Institucion;

/**
 *
 * @author elinzar
 */
@Entity
public class Profesor extends Usuario{
//Variables---------------------------------------------------------------------
    public String biografia;
    public String descripcion;
    
    @Column(name="sitio_web")
    public String sitioWeb;
    
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private Collection<Clase> claseDictada;//taba mal escrito "Dicatada", aviso por si rompe algo lmao
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="institucion")
    private Institucion institucion;
    
    public Profesor() {
    	claseDictada = new ArrayList<>();
    }
    public Profesor(
    		String nickname, String apellido, String email, String nombre, LocalDate fechaNac, 
    		String biografia, String descripcion, String sitioWeb, Institucion institucion) {
    	super( nickname,  apellido,  email,  nombre, fechaNac);
    	this.biografia = biografia;
    	this.descripcion = descripcion;
    	this.sitioWeb = sitioWeb;
    	this.institucion = institucion;
        claseDictada = new ArrayList<>();
    }
    
    
    

//Getters and Setters-----------------------------------------------------------    
    

	public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    } 

    public Collection<Clase> getClaseDictada() {
        return claseDictada;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
    
    
        
    
//Methods-----------------------------------------------------------------------    
    @Override//child class implementation
    public DtUsuario getDatosCompletos(){
        //DtUsuario output = new DtProfesor(this.nickname, this.email, this.nombre, this.apellido, this.fechaNac, this.institucion, this.biografia, this.descripcion,this.sitioWeb);
        //return output;
    	return null;
    }
    
    public DtUsuario getDatosProfe(){ 
    	DtUsuario dtP = new DtProfesor(
        		this.nickname, this.email, this.nombre, this.apellido, 
        		this.fechaNac, this.institucion.getNombreInst(), this.biografia, this.descripcion, this.sitioWeb);
    	return dtP;

    }
    
    public Clase darAltaClaseProfe(String nombreInsti,String nombreActiDepo,String nombreClase,LocalDateTime fechaInicio ,int sociosMin,int sociosMax,String URL,LocalDate fechaAlta, ActividadDeportiva actiDepo) {
    	
    	LocalTime horaIni = fechaInicio.toLocalTime();
        Clase claseADictar = new Clase(nombreClase, fechaInicio.toLocalDate(), horaIni, sociosMin, sociosMax, URL, fechaAlta ,this, actiDepo); //por alguna razón tengo que pasarle un objeto profesor a una clase, cuidado con la visibildad
        this.claseDictada.add(claseADictar);
    	return claseADictar;
    }
    
}
