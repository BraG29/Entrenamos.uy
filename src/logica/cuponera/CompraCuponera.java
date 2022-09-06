package logica.cuponera;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 *
 * @author elinzar
 */

@Entity
public class CompraCuponera {
//Variables---------------------------------------------------------------------  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private LocalDate fecha;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="nom_cuponera")
    private Cuponera cuponeraAsociada;
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
