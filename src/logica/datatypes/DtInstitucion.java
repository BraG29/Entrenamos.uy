package logica.datatypes;

import java.util.ArrayList;

public class DtInstitucion {
    public final String nombreInst;
    public final String descripcion;
    public final String instURL;
    public final ArrayList<String> actividades;
    
    
    public DtInstitucion(String nomInst, String desc, String URL, ArrayList<String> acti){
        this.nombreInst = nomInst;
        this.descripcion = desc;
        this.instURL = URL;
        this.actividades = acti;
    }
}
