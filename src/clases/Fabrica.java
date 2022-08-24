package clases;

public class Fabrica {
	
	public IControlador getInterface() {
		return Controlador.getInstance();
			
		}
}
