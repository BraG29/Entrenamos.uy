package logica.clase;
import java.time.LocalDate;

/**
 *
 * @author elinzar
 */
public class Registro {
//Variables---------------------------------------------------------------------
    private int id;
    private LocalDate fecha;
    private float cost;
    private Clase claseAsociada;
//Getters and Setters-----------------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
//Constructors------------------------------------------------------------------   
    //Empty Constructor
    public Registro() {
    }
    //Full Constructor
    public Registro(int id, LocalDate fecha, float cost) {
        this.id = id;
        this.fecha = fecha;
        this.cost = cost;
    }
    
    public Clase esRegistroDe(){//needs implementation
        Clase output = null; 
        return output;
    }
    
}
