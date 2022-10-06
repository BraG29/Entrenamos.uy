package logica.clase;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author elinzar
 */
@Entity
public class Registro implements Serializable {
//Variables---------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate fecha;
    private float cost;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="nom_clase")
    private Clase claseAsociada;
//Getters and Setters-----------------------------------------------------------
    public int getId() {
        return id;
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

    public Clase getClaseAsociada() {
        return claseAsociada;
    }
    
    
//Constructors------------------------------------------------------------------   
    //Empty Constructor
    public Registro() {
    }
    //Full Constructor
    public Registro(LocalDate fecha, float cost, Clase c) {
        this.fecha = fecha;
        this.cost = cost;
        this.claseAsociada = c;
    }

    public boolean esRegistroDe(Clase c){//needs implementation
    	if(claseAsociada == c) {
    		return true;
    	}
    	return false;
    }
    

    
}
