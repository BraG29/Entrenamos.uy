package logica.institucion;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import logica.datatypes.DtInstitucion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Institucion implements Serializable{
	@Id
	@Column(name="nombre")
    private String nombreInst;
    private String descripcion;
    @Column(name="institucion_URL")
    private String instURL;  
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Institucion_Actividad",
	joinColumns = @JoinColumn(name="nom_institucion"),
	inverseJoinColumns = @JoinColumn(name="nom_actividad"))
    private Collection<ActividadDeportiva> actividades;

    
    //Constructor por parametro
    public Institucion(String nombreInst, String descripcion, String instURL) {
        this.nombreInst = nombreInst;
        this.descripcion = descripcion;
        this.instURL = instURL;
    }
    
    public Institucion(Institucion insti){
        this.nombreInst = insti.getNombreInst();
        this.descripcion = insti.getDescripcion();
        this.instURL = insti.getInstURL();
    }

      public Institucion() {
    }
    
    //Setters-----------------------------------------------------------------
    public void setNombreInst(String nombreInst) {
        this.nombreInst = nombreInst;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setInstURL(String instURL) {
        this.instURL = instURL;
    }

    //Getters-----------------------------------------------------------------
    public String getNombreInst() {
        return nombreInst;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getInstURL() {
        return instURL;
    }
    
    
    public ArrayList<String> getActividadesDeportivas(){
        ArrayList<String> ActividadesNom = new ArrayList<String>();
        //ActividadesNom.addAll(this.actividades.keySet()); 
        return ActividadesNom;
    }
    
    public ArrayList<String> getClases(String nomAC){
        ArrayList<String> nombreClases = new ArrayList<String>();
        
        //ActividadDeportiva ActiDepo = actividades.get(nomAC);
        //nombreClases.addAll(ActiDepo.getNombreClases());
        
        return nombreClases;
    }
    
    public DtInstitucion getDTInstitucion(){
        ArrayList<String> ActividadesNom = new ArrayList<String>();
        //ActividadesNom.addAll(this.actividades.keySet()); 
        
        DtInstitucion DtInsti = new DtInstitucion(this.nombreInst, this.descripcion, this.instURL, ActividadesNom);
        return DtInsti;
    }
    
    public void darAltaActividadDeportiva(String nombreActividad, String nombreInsti, String desc, float dura, float costo, LocalDateTime fechaAlta, EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();
        ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActividad);
        
        if(acti == null){
            acti = new ActividadDeportiva(nombreActividad, desc, dura, costo, fechaAlta);
            
            //arranco la transaccion
            EntityTransaction transaccion = em.getTransaction();
            transaccion.begin();
            em.persist(acti);
            transaccion.commit(); 
            em.close();
            emf.close();
            //termina la transaccion
            
        }else{//acti existe
            //tirar una excepcion, obviamente detallando que la actividad deportiva ya existe
        }
    }
    
    
    
}
