/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.time.LocalDate;
/**
 *
 * @author elinzar
 */
public class CompraCuponera {
//Variables---------------------------------------------------------------------   
    private LocalDate fecha;
//Getters and Setters-----------------------------------------------------------
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
//Constructors------------------------------------------------------------------ 
    //Empty 
    public CompraCuponera() {
    }
    //Full
    public CompraCuponera(LocalDate fecha) {
        this.fecha = fecha;
    }
}
