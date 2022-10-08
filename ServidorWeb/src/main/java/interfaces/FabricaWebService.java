package interfaces;
import java.util.Set;

import logica.datatypes.DtActividadDeportiva;
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
		public Set<String> obtenerInstituciones() {
			return null;
		}
		
		@Override
		public Set<String> obtenerUsuarios() {
			return null;
		}
		
		@Override
		public int ingresarDatosUsuario(DtUsuario datoUser) {
			return 0;
		}
	}

	public class ActividadDeportivaController implements IActividadDeportivaController {
		@Override
		public Set<String> obtenerInstituciones() {
			return null;
		}

		@Override
		public Boolean ingresarDatosActividadDeportiva(String nombreInsti, DtActividadDeportiva datosAD) {
			return null;
		}

		@Override
		public Set<String> obtenerActividades(String ins) {
			return null;
		}
	}

	public class DictadoClaseController implements IDictadoClaseController {
		@Override
		public Set<String> obtenerUsuarios() {
			return null;
		}
		
		@Override
		public Set<String> obtenerInstituciones() {
			return null;
		}

		@Override
		public String obtenerInstitucionActDep(String actDep) {
			return null;
		}

		@Override
		public Set<String> obtenerActividades(String ins) {
			return null;
		}
	}

	public class CuponeraController implements ICuponeraController {
		@Override
		public Set<String> getNombreCuponeras() {
			return null;
		}

		@Override
		public DtCuponera seleccionarCuponera(String nombre) {
			return null;
		}

		@Override
		public Set<String> getNombreCuponerasSinRecibos() {
			return null;
		}
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
