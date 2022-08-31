/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.datatypes;
import java.time.LocalDate;

/**
 *
 * @author elinzar
 */
public class DtCuponera {
    private String nombreCup;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private float descuento;
    private LocalDate fechaAlta;
    private int cantClases;

    public DtCuponera(String nombreCup, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, float descuento, LocalDate fechaAlta, int cantClases) {
        this.nombreCup = nombreCup;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descuento = descuento;
        this.fechaAlta = fechaAlta;
        this.cantClases = cantClases;
    }
   
}
