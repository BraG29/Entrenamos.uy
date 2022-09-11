package logica.datatypes;

import java.time.LocalDate;

public class DtProfesor extends DtUsuario{
	
	public final String institucion;
	public final String biografia;
	public final String descripcion;
	public final String sitioWeb;
	public DtProfesor(
			String nickname, String email, String nombre, String apellido, LocalDate fechaNac, 
			String imagenURL, String institucion, String biografia, String descripcion, String sitioWeb) {
		super(nickname, email, nombre, apellido, fechaNac, imagenURL);
		this.institucion = institucion;
		this.biografia = biografia;
		this.descripcion = descripcion;
		this.sitioWeb = sitioWeb;
		// TODO Auto-generated constructor stub
	}




}
