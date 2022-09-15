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

import logica.clase.Clase;
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
        this.actividades = new ArrayList<>();
    }
    
    public Institucion(Institucion insti){
        this.nombreInst = insti.getNombreInst();
        this.descripcion = insti.getDescripcion();
        this.instURL = insti.getInstURL();
        this.actividades = new ArrayList<>();
    }

      public Institucion() {
          this.actividades = new ArrayList<>();
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
    
    public void darAltaActividadDeportiva(String nombreActividad, String nombreInsti, String desc, float dura, float costo, LocalDateTime fechaAlta,String IMG_URL, EntityManager em,EntityTransaction tran){    
    	//System.out.println("Antes de buscar la actidepo");
        //System.out.print("nombreActi");
        System.out.println(nombreActividad);
    	ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActividad);
        
    	System.out.println("Despues de buscar la actidepo");
//    	EntityTransaction tranza = em.getTransaction();
        //em.flush();

        
        if(acti == null){
        	System.out.println("antes de crear la actidepo");
            acti = new ActividadDeportiva(nombreActividad, desc, dura, costo, fechaAlta,IMG_URL, this);
//            System.out.println("MITIMITI PORTEZUELO");
//            //this.actividades.add(acti);
           System.out.println("despues de crear la actidepo");
//            
//            System.out.println(tran.isActive());
//            //arranco la transaccion
//            
//            //em.flush();
//            
//            
////            tranza.commit();
//            System.out.println("entre el primer y 2ndo tran");
            //NO ENTIENDO NADA VIEJAAAAAAAA
            //posible flush needed
            
            
            //em.flush();
//            tran.begin();
////            tranza.begin();
//            
////            tranza.commit();
//            tran.commit();
           // em.flush();
            
            try{
                em.persist(acti);  
            	this.agregarActi(acti,em,tran);
                
            }catch(Exception e) {
            	System.out.println(e.getMessage());
            	throw new IllegalArgumentException(e);
            }
            
            
            
            
        }else{//acti existe
            //tirar una excepcion, obviamente detallando que la actividad deportiva ya existe
            throw new IllegalArgumentException("La actividad: " + nombreActividad + " ya existe");
        }
    }
    
    private void agregarActi(ActividadDeportiva acti,EntityManager em, EntityTransaction tran){
        try{
                tran.begin();
                em.flush();
                boolean existsInsti = em.contains(this);
                boolean existsActi = em.contains(acti);
                this.actividades.add(acti);
                tran.commit();
            }catch(Exception e) {
            	tran.rollback();
            	System.out.println(e.getMessage());
            	throw new IllegalArgumentException(e);
            }
    }
    
    
    public void darAltaClaseInsti(String nombreActiDepo,Clase claseDictada, EntityManager em, EntityTransaction tran){
        System.out.println("Antes de crear la acti depo");
        ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActiDepo);
        System.out.println("Despues de crear la acti depo");
        
        try {
        	acti.darAltaClaseActi(claseDictada, em, tran);
        }catch(Exception e) {
        	throw new IllegalArgumentException("no se pudo encontrar la Actividad Deportiva asociada");
        }
        
        
    }
    
    
    
}
