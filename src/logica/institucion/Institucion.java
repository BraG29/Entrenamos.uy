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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;


import logica.datatypes.DtInstitucion;

import java.io.Serializable;
import java.time.LocalDate;
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
    
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name="Institucion_Actividad",
//	joinColumns = @JoinColumn(name="nom_institucion"),
//	inverseJoinColumns = @JoinColumn(name="nom_actividad"))
//    private Collection<ActividadDeportiva> actividades;

    
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
            acti = new ActividadDeportiva(nombreActividad, desc, dura, costo, fechaAlta, this);
            
//            this.actividades.add(acti);
           
            
            //arranco la transaccion
            EntityTransaction transaccion = em.getTransaction();
            
            transaccion.begin();
            em.persist(acti);
            transaccion.commit();
            
//            transaccion.begin();
//            
//            
//            
////        
//////            
//                       em.persist(this.actividades);
//          transaccion.commit();
////            
////            
  //          transaccion.begin();
//       
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaUpdate<Institucion> cum = cb.createCriteriaUpdate(Institucion.class);
//            
//            Root<Institucion> rootInsti = cum.from(Institucion.class);
//            cum.set(rootInsti.get("nombreInst"),this.nombreInst);
//            cum.set(rootInsti.get("descripcion"),this.descripcion);
//            cum.set(rootInsti.get("instURL"),this.instURL);
//            
//            cum.set(rootInsti.get(Path<actividades>),acti);
//            //cum.s
//            cum.where(cb.equal(rootInsti.get("nombreInsti"), this.getNombreInst()));
//            em.createQuery(cum).executeUpdate();
            
//            em.flush();
//            transaccion.commit();
//            
            em.close();
            //TIRAR ROLLBACK L8ER
            //emf.close();
            //termina la transaccion
            
        }else{//acti existe
            //tirar una excepcion, obviamente detallando que la actividad deportiva ya existe
            throw new IllegalArgumentException("La actividad: " + nombreActividad + " ya existe");
        }
    }
    
    
    public void darAltaClaseInsti(String nombreInsti,String nombreClase,LocalDateTime fechaInicio,String nombreProfe ,int sociosMin,int sociosMax,String URL,LocalDate fechaAlta, EntityManagerFactory emf){
        EntityManager em = emf.createEntityManager();
        ActividadDeportiva acti = em.find(ActividadDeportiva.class,nombreClase);
        
        acti.darAltaClaseActi(nombreInsti, nombreClase, fechaInicio, nombreProfe , sociosMin, sociosMax, URL,fechaAlta, emf);
    }
    
    
    
}
