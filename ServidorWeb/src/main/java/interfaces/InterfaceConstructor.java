package interfaces;

public class InterfaceConstructor {
	private static InterfaceConstructor instancia;
	private static IActividadDeportivaController iActividad;
	private static IUsuarioController iUsuario;
	private static ICuponeraController iCuponera;
	private static IDictadoClaseController iDictado;
	
	public static InterfaceConstructor getInstance() {
		if (instancia == null) instancia = new InterfaceConstructor();
		return instancia;
	}
	
	private InterfaceConstructor() {
		FabricaWebService fabricaSistema = FabricaWebService.getInstance();
		iActividad = fabricaSistema.getIActDeportivaController();
		iUsuario = fabricaSistema.getIUsuarioController();
		iCuponera = fabricaSistema.getICuponeraController();
		iDictado = fabricaSistema.getIDictadoClaseController();
	}

    public static IActividadDeportivaController getIActividad() {
    	return iActividad;
    }
    public static IUsuarioController getIUsuario() {
    	return iUsuario;
    }
    public static ICuponeraController getICuponera() {
    	return iCuponera;
    }
    public static IDictadoClaseController getIDictado() {
    	return iDictado;
    }
}