package mx.com.gm.sga.beans.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Integer idUsuario;
	@Column(name = "USERNAME", nullable = false, length = 45)
	private String username;
	@Column(name = "PASSWORD", nullable = false, length = 45)
	private String password;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PERSONA")
	private Persona persona;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
		if(!persona.getUsuarios().contains(this)) {
			persona.addUsuario(this);
		}
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario(int idUsuario, String password, String username, Persona persona) {
		this.idUsuario = idUsuario;
		this.password = password;
		this.username = username;
		this.persona = persona;
	}

	public Usuario(String username, String password, Persona persona) {
		this.username = username;
		this.password = password;
		this.persona = persona;
	}

	public Usuario(String username, String password) { 
		this.username = username;
	}
	
	public Usuario() { 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", password=" + password + ", persona="
				+ persona + "]";
	}
	
}
