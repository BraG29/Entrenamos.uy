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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import logica.usuario.Socio;

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
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="nom_clase")
    private Clase claseAsociada;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Socio socio;
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
