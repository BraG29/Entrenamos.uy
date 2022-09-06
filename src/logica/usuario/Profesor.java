package logica.usuario;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import logica.clase.Clase;
import logica.datatypes.DtProfesor;
import logica.datatypes.DtUsuario;
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
    public String sitioWeb;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Clase> claseDicatada;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="institucion")
    private Institucion institucion;
    
    
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
    
//Methods-----------------------------------------------------------------------    
    @Override//child class implementation
    public DtUsuario getDatosCompletos(){
        //DtUsuario output = new DtProfesor(this.nickname, this.email, this.nombre, this.apellido, this.fechaNac, this.institucion, this.biografia, this.descripcion,this.sitioWeb);
        //return output;
    	return null;
    }
    
}
