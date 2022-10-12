package logica.datatypes;

import java.io.File;
import java.time.LocalDate;

public class DtSocio extends DtUsuario{

	public DtSocio(String nickname, String email, String nombre, String apellido, LocalDate fechaNac, File img) {
		super(nickname, email, nombre, apellido, fechaNac, img);
	}
}
