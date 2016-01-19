package mx.com.gm.sga.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.gm.sga.beans.dominio.Persona;
import mx.com.gm.sga.servicio.PersonaService;

@WebServlet("/ListarPersonas")
public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PersonaService personaService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Persona> personas = personaService.listarPersonas();
		request.setAttribute("personas", personas);
		request.getRequestDispatcher("listarPersonas.jsp").forward(request, response);
	}
}
