package interfaces;
import java.util.Set;
import datatypes.DtUsuario;

public interface IUsuarioController {
	public Set<String> obtenerInstituciones();
	public Set<String> obtenerUsuarios();
	public int ingresarDatosUsuario(DtUsuario datoUser);
}
