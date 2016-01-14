package mx.com.gm.sga.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mx.com.gm.sga.beans.dominio.Persona;
import mx.com.gm.sga.beans.dominio.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {
	
	@PersistenceContext(unitName = "PersonaPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllUsuarios() {
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	@Override
	public Usuario findUsuarioByUsername(Usuario usuario) {
		Query query = em.createQuery("from Usuario u where u.username = :username");
		query.setParameter("username", usuario.getUsername());
		return (Usuario) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findUsuariosByPersona(Persona persona) {
		Query query = em.createQuery("from Usuario u where u.persoan = :persona");
		query.setParameter("persona", persona);
		return query.getResultList();
	}

	@Override
	public Usuario findUsuariosById(Usuario usuario) {
		return em.find(Usuario.class, usuario.getIdUsuario());
	}

	@Override
	public void insertUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		em.merge(usuario);
	}

	@Override
	public void deleteUsuario(Usuario usuario) {
		usuario = em.find(Usuario.class, usuario.getIdUsuario());
		em.remove(usuario);
	}

}
