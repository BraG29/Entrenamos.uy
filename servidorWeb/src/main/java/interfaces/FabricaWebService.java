package interfaces;
import java.util.Set;

import logica.datatypes.DtActividadDeportiva;
import logica.datatypes.DtClase;
import logica.datatypes.DtCuponera;
import logica.datatypes.DtUsuario;

public class FabricaWebService {
	private static FabricaWebService instancia = null;

	public static FabricaWebService getInstance() {
		if (instancia == null) instancia = new FabricaWebService();
		return instancia;
	}

	public class UsuarioController implements IUsuarioController {
		
		@Override
		public Set<String> obtenerInstituciones() {}
		
		@Override
		public Set<String> obtenerUsuarios() {}
		
		@Override
		public int ingresarDatosUsuario(DtUsuario datoUser) {}
	}

	public class ActividadDeportivaController implements IActividadDeportivaController {
		@Override
		public Set<String> obtenerInstituciones() {}

		@Override
		public Boolean ingresarDatosActividadDeportiva(String nombreInsti, DtActividadDeportiva datosAD) {}

		@Override
		public Set<String> obtenerActividades(String ins) {}
	}

	public class DictadoClaseController implements IDictadoClaseController {
		@Override
		public Set<String> obtenerUsuarios() {}
		
		@Override
		public Set<String> obtenerInstituciones() {}

		@Override
		public String obtenerInstitucionActDep(String actDep) {}

		@Override
		public Set<String> obtenerActividades(String ins) {}
	}

	public class CuponeraController implements ICuponeraController {
		@Override
		public Set<String> getNombreCuponeras() {}

		@Override
		public DtCuponera seleccionarCuponera(String nombre) {}

		@Override
		public Set<String> getNombreCuponerasSinRecibos() {}
	}

	public IActividadDeportivaController getIActDeportivaController() {
		IActividadDeportivaController iActividad = new ActividadDeportivaController();
		return iActividad;
	}

	public IUsuarioController getIUsuarioController() {
		IUsuarioController iUsuario = new UsuarioController();
		return iUsuario;
	}

	public IDictadoClaseController getIDictadoClaseController() {
		IDictadoClaseController iDictado = new DictadoClaseController();
		return iDictado;
	}

	public ICuponeraController getICuponeraController() {
		ICuponeraController iCuponera = new CuponeraController();
		return iCuponera;
	}
}
