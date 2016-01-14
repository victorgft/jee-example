package test;

import static org.junit.Assert.assertTrue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import mx.com.gm.sga.beans.dominio.Persona;

@Ignore
public class TestEntidadPersona {
	static EntityManager em = null;
	static EntityTransaction tx = null;
	static EntityManagerFactory emf = null;
	Logger log = Logger.getLogger("TestEntidadPersona");

	@BeforeClass
	public static void init() throws Exception {
		emf = Persistence.createEntityManagerFactory("PersonaPU");
	}

	@Before public void setup() { 
		try {
			em = emf.createEntityManager();
		} catch (Exception ex) {
				ex.printStackTrace(); 
		}
	}
	
	@Test public void testPersonaEntity() { 
		System.out.println("Iniciando test Persona Entity con JPA"); 
		assertTrue(em != null); 
		EntityTransaction tx = em.getTransaction(); 
		tx.begin(); 
		//No se debe especificar el ID, ya que se genera en automático 
		Persona persona1 = new Persona(3, "Angelica2", "Lara2", "Gomez2", "alara2@mail.com3", "1314145518"); 
		log.debug("Objeto a persistir:" + persona1); 
		em.persist(persona1); 
		assertTrue(persona1.getIdPersona() != null); 
		tx.commit(); log.debug("Objeto persistido:" + persona1); 
		System.out.println("Fin test Persona Entity con JPA"); 
	} 
	
	@After public void tearDown() throws Exception { 
		if (em != null) { 
			em.close(); 
		} 
	} 
}