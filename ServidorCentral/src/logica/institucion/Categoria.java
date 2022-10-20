package logica.institucion;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Categoria implements Serializable {
    @Id
    private String nombreCat;

    @ManyToMany(mappedBy = "categoriasAsociadas", cascade = CascadeType.ALL)
    private Collection<ActividadDeportiva> actisAsociadas;

    public Categoria(String nomCategoria) {
        this.nombreCat = nomCategoria;
    }

    public Categoria() {

    }

    public String getNombreCategoria() {
        return this.nombreCat;
    }
}
