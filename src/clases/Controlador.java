package clases;

import java.time.LocalDate;


public class Controlador extends IControlador {
	public boolean altaUsuario(
			String nick, String nombre,String apellido,String email,LocalDate fechaNac) {
		return true;
	}
	public boolean altaUsuario(
			String nick, String nombre,String apellido,String email,LocalDate fechaNac,
			String institucion, String descripcion, String biografia, String sitioWeb) {
		return true;
	}
	public static Controlador getInstance() {
		if(instance == null)
			instance = new Controlador();
		return instance;
	}
	
	private static Controlador instance;
	private void Controlador(){
	}
}
