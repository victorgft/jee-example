package mx.com.gm.sga.eis;

import java.util.List;

import mx.com.gm.sga.beans.dominio.Persona;
import mx.com.gm.sga.beans.dominio.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> findAllUsuarios();

	public Usuario findUsuarioByUsername(Usuario usuario);

	public List<Usuario> findUsuariosByPersona(Persona persona);

	public Usuario findUsuariosById(Usuario usuario);

	public void insertUsuario(Usuario usuario);

	public void updateUsuario(Usuario usuario);

	public void deleteUsuario(Usuario usuario);

}
