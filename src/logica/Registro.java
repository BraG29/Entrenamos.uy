/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.time.LocalDate;
import logica.Clase;

/**
 *
 * @author elinzar
 */
public class Registro {
//Variables---------------------------------------------------------------------
    private int id;
    private LocalDate fecha;
    private float cost;
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
