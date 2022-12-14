package logica.institucion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import logica.clase.Clase;
import logica.datatypes.DtActividadDeportiva;
import logica.datatypes.DtClase;
import logica.datatypes.DtInstitucion;

@Entity
public class Institucion implements Serializable {
    @Id
    @Column(name = "nombre")
    private String nombreInst;
    private String descripcion;
    @Column(name = "institucion_URL")
    private String instURL;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name="Institucion_Actividad",
//	joinColumns = @JoinColumn(name="nom_institucion"),
//	inverseJoinColumns = @JoinColumn(name="nom_actividad"))
//    private Collection<ActividadDeportiva> actividades;

    @OneToMany(mappedBy = "insti", cascade = CascadeType.ALL)
    private Collection<ActividadDeportiva> actividades;

    // Constructor por parametro
    public Institucion(String nombreInst, String descripcion, String instURL) {
        this.nombreInst = nombreInst;
        this.descripcion = descripcion;
        this.instURL = instURL;
        this.actividades = new ArrayList<>();
    }

    public Institucion(Institucion insti) {
        this.nombreInst = insti.getNombreInst();
        this.descripcion = insti.getDescripcion();
        this.instURL = insti.getInstURL();
        this.actividades = new ArrayList<>();
    }

    public Institucion() {
        this.actividades = new ArrayList<>();
    }

    // Setters-----------------------------------------------------------------
    public void setNombreInst(String nombreInst) {
        this.nombreInst = nombreInst;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setInstURL(String instURL) {
        this.instURL = instURL;
    }

    // Getters-----------------------------------------------------------------
    public String getNombreInst() {
        return nombreInst;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getInstURL() {
        return instURL;
    }

    public ArrayList<String> getActividadesDeportivas() {
        ArrayList<String> ActividadesNom = new ArrayList<String>();

        for (ActividadDeportiva a : this.actividades) {
            ActividadesNom.add(a.getNombreAct());
        }

        return ActividadesNom;
    }

    public ArrayList<String> getClases(String nomAC) {
        ArrayList<String> nombreClases = new ArrayList<String>();

        // ActividadDeportiva ActiDepo = actividades.get(nomAC);
        // nombreClases.addAll(ActiDepo.getNombreClases());

        return nombreClases;
    }

    public DtInstitucion getDTInstitucion() {
        ArrayList<DtActividadDeportiva> listDt = new ArrayList<>();
        for (ActividadDeportiva ac : actividades) {
            DtActividadDeportiva dtAct = ac.getDTActividadDeportiva();
            listDt.add(dtAct);
        }

        DtInstitucion DtInsti = new DtInstitucion(this.nombreInst, this.descripcion, this.instURL, listDt);
        return DtInsti;
    }

    public ActividadDeportiva darAltaActividadDeportiva(String nombreActividad, String nombreInsti, String desc,
            float dura, float costo, LocalDateTime fechaAlta, ArrayList<Categoria> arrCat) {
        ActividadDeportiva acti = new ActividadDeportiva(nombreActividad, desc, dura, costo, fechaAlta, this, arrCat);
        this.agregarActi(acti);
        return acti;

    }

    private void agregarActi(ActividadDeportiva acti) {
        this.actividades.add(acti);
    }

    public void darAltaClaseInsti(ActividadDeportiva actiDepo, Clase claseDictada) {
        actiDepo.darAltaClaseActi(claseDictada);
    }

    public DtClase getDtClaseXActiDepo(String nombreActi, String nombreClase, EntityManager em) {
        System.out.println("Antes de buscar la ActiDepo para la Clase");
        ActividadDeportiva acti = em.find(ActividadDeportiva.class, nombreActi);
        System.out.println("Despues de buscar la ActiDepo para la Clase");

        DtClase claseADevolver = acti.getDtClaseXActiDepo(nombreClase, em);
        return claseADevolver;
    }

}
