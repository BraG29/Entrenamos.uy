package logica;

import java.util.HashMap;
import logica.datatypes.DtInstitucion;
import java.util.ArrayList;

public class Institucion {
    private String nombreInst;
    private String descripcion;
    private String instURL;  
    private HashMap<String, ActividadDeportiva> actividades = new HashMap<>();

    
    //Constructor por parametrOwO
    public Institucion(String nombreInst, String descripcion, String instURL) {
        this.nombreInst = nombreInst;
        this.descripcion = descripcion;
        this.instURL = instURL;
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
    
    
    public String[] getActividadesDeportivas(){//placeholder
        String[] ActiDepo = {"uwu"};
        return ActiDepo;
    }
    
    public DtInstitucion getDTInstitucion(){
        ArrayList<String> ActividadesNom = new ArrayList<String>();
        ActividadesNom.addAll(this.actividades.keySet()); 
        
        DtInstitucion DtInsti = new DtInstitucion(this.nombreInst, this.descripcion, this.instURL, ActividadesNom);
        return DtInsti;
    }
    
    
    
}
