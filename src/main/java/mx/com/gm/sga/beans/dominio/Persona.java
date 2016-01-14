package mx.com.gm.sga.beans.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQuery(name = "Persona.findAll", query="SELECT u FROM Persona u")
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSONA")
	private Integer idPersona;
	@Column(name = "NOMBRE", nullable = false, length = 45)
	private String nombre;
	@Column(name = "APELLIDO_PATERNO", nullable = false, length = 45)
	private String apePaterno;
	@Column(name = "APELLIDO_MATERNO", length = 45)
	private String apeMaterno;
	@Column(name = "EMAIL", nullable = false, length = 45)
	private String email;
	@Column(name = "TELEFONO", length = 45)
	private String telefono;
	
	@XmlTransient
	@OneToMany(mappedBy = "persona")
	private List<Usuario> usuarios;
	
	public Persona() {
	}

	public Persona(int idPersona) {
		this.idPersona = idPersona;
	}

	public Persona(int idPersona, String nombre, String apePaterno, String apeMaterno, String email, String telefono) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.email = email;
		this.telefono = telefono;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
		if (usuario.getPersona() != this) {
			usuario.setPersona(this);
		}
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apePaterno=" + apePaterno + ", apeMaterno="
				+ apeMaterno + ", email=" + email + ", telefono=" + telefono + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apeMaterno == null) ? 0 : apeMaterno.hashCode());
		result = prime * result + ((apePaterno == null) ? 0 : apePaterno.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Persona other = (Persona) obj;
		if (apeMaterno == null) {
			if (other.apeMaterno != null)
				return false;
		} else if (!apeMaterno.equals(other.apeMaterno))
			return false;
		if (apePaterno == null) {
			if (other.apePaterno != null)
				return false;
		} else if (!apePaterno.equals(other.apePaterno))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
}