package logica.controlador;

import java.time.LocalDate;


public class Controlador extends IControlador {
	public void altaUsuario(
			String nick, String nombre,String apellido,String email,LocalDate fechaNac) {
	}
	public void altaUsuario(
			String nick, String nombre,String apellido,String email,LocalDate fechaNac,
			String institucion, String descripcion, String biografia, String sitioWeb) {
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
