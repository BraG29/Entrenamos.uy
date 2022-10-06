package interfaces;
import java.util.Set;
// TODO Ver que otras cosas importamos,
// se puede poner que estas interfaces tiren excepciones

public interface IDictadoClaseController {
	public Set<String> obtenerUsuarios();
	public Set<String> obtenerInstituciones();	
	public String obtenerInstitucionActDep(String actDep);	
	public Set<String> obtenerActividades(String ins);
}
