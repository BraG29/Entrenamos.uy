package interfaces;
import java.util.Set;
import logica.datatypes.DtCuponera;

public interface ICuponeraController {
	public Set<String> getNombreCuponeras();
	public DtCuponera seleccionarCuponera(String nombre);
	public Set<String> getNombreCuponerasSinRecibos();
}
