package controlador;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

/**
 * Servlet implementation class DatosPerfil
 */

public class DatosPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatosPerfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 /*
		  // Imprime todos los parámetros del formulario
	    Map<String, String[]> parameters = request.getParameterMap();
	    for(String parameter : parameters.keySet()) {
	        System.out.println("Parameter name: " + parameter);
	        System.out.println("Parameter value: " + Arrays.toString(parameters.get(parameter)));
	     */
	        
		 System.out.println("DatosPerfil doGet llamado");
	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            Usuario usuario = (Usuario) session.getAttribute("usuario");
	            if (usuario != null) {
	                System.out.println("Usuario encontrado en la sesión: " + usuario.getNombre());
	                response.setContentType("application/json");
	                response.setCharacterEncoding("UTF-8");
	                String json = "{"
	                        + "\"dni\":\"" + usuario.getDni() + "\","
	                        + "\"puesto\":\"" + usuario.getPuesto() + "\","
	                        + "\"nombre\":\"" + usuario.getNombre() + "\","
	                        + "\"apellido1\":\"" + usuario.getApellido1() + "\","
	                        + "\"apellido2\":\"" + usuario.getApellido2() + "\","
	                        + "\"correo\":\"" + usuario.getCorreo() + "\","
	                        + "\"telefono\":\"" + usuario.getTelefono() + "\""
	                        + "}";
	                response.getWriter().write(json);
	                response.getWriter().flush();
	            } else {
	                System.out.println("Usuario no encontrado en la sesión");
	                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	                response.getWriter().write("Usuario no encontrado en la sesión.");
	                response.getWriter().flush();
	            }
	        } else {
	            System.out.println("Sesión no encontrada");
	            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	            response.getWriter().write("Sesión no encontrada.");
	            response.getWriter().flush();
	        }
	    
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
