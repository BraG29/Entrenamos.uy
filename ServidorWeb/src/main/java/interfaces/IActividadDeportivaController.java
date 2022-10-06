package interfaces;
import java.util.Set;
import logica.datatypes.DtActividadDeportiva;

public interface IActividadDeportivaController {

	public Set<String> obtenerInstituciones();
	public Boolean ingresarDatosActividadDeportiva(String nombreInsti, DtActividadDeportiva datosAD);
	public Set<String> obtenerActividades(String ins);
}