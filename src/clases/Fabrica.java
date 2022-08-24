package clases;

public class Fabrica {
	
	IControlador getInterface() {
		return Controlador.getInstance();
			
		}
}
