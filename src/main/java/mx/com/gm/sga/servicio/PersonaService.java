package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;

import mx.com.gm.sga.beans.dominio.Persona;

@Local
public interface PersonaService {
	public List<Persona> listarPersonas();

	public Persona encontrarPersonaPorId(Persona persona);

	public Persona econtrarPersonaPorEmail(Persona persona);

	public void registrarPersona(Persona persona);

	public void modificarPersona(Persona persona);

	public void eliminarPersona(Persona persona);
}