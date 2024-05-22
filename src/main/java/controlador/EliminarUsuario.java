package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Supervisor;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

/**
 * Servlet implementation class EliminarUsuario
 */
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Map<String, String[]> parameters = request.getParameterMap();
		    for(String parameter : parameters.keySet()) {
		        System.out.println("Parameter name: " + parameter);
		        System.out.println("Parameter value: " + Arrays.toString(parameters.get(parameter)));
		    }
		    
		
		
	    int idUsuario = Integer.parseInt(request.getParameter("id"));

	    Usuario us = new Usuario();
	    us.setIdUsuario(idUsuario);

	    try {
	        us.eliminar();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error al eliminar usuario");
	    }

	    // Configura la respuesta para devolver JSON
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");

	    // Crea un objeto JSON
	    String json = "{ \"mensaje\": \"Usuario eliminado\" }";

	    // Escribe el JSON en la respuesta
	    PrintWriter out = response.getWriter();
	    out.print(json);
	    out.flush();
	}
	
	

}
