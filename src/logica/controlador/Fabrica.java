package logica.controlador;

public class Fabrica {
	
	public IControlador getInterface() {
		return Controlador.getInstance();
			
		}
}
