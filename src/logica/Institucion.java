package logica;

/**
 *
 * @author progappvm
 */
public class Institucion {
    private String nombreInst;
    private String descripcion;
    private String instURL;

    //Setters
    public void setNombreInst(String nombreInst) {
        this.nombreInst = nombreInst;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setInstURL(String instURL) {
        this.instURL = instURL;
    }

    //Getters
    public String getNombreInst() {
        return nombreInst;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getInstURL() {
        return instURL;
    }
    
    public String[] getActividadesDeportivas(){//placeholder
        String[] ActiDepo = {"uwu"};
        return ActiDepo;
    }
    
    
    
}
