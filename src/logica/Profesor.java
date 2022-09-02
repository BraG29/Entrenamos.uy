package logica;
import logica.Usuario;
import logica.Institucion;
import logica.datatypes.DtProfesor;
import logica.datatypes.DtUsuario;

/**
 *
 * @author elinzar
 */
public class Profesor extends Usuario{
//Variables---------------------------------------------------------------------
    public String institucion;
    public String biografia;
    public String descripcion;
    public String sitioWeb;
    
//Getters and Setters-----------------------------------------------------------    
    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

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
        DtUsuario output = new DtProfesor(this.nickname, this.email, this.nombre, this.apellido, this.fechaNac, this.institucion, this.biografia, this.descripcion,this.sitioWeb);
        return output;
    }
    
}
