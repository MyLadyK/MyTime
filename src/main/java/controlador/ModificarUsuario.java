package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Supervisor;

/**
 * Servlet implementation class ModificarUsuario
 */
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
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
		
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    // Leer el cuerpo de la solicitud y analizarlo como objeto JSON
	    StringBuilder sb = new StringBuilder();
	    String line;

	    try {
	        BufferedReader reader = request.getReader();
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    Gson gson = new Gson();
	    Supervisor sup = gson.fromJson(sb.toString(), Supervisor.class);

	    // Sup es un objeto Supervisor con los datos de la solicitud.
	    

	    try {
	        sup.modificar();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("T/C modficar doPut");
	    }

	    // Configura la respuesta para devolver JSON
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");

	    // Crea un objeto JSON
	    String json = "{ \"mensaje\": \"Usuario actualizado\" }";

	    // Escribe el JSON en la respuesta
	    PrintWriter out = response.getWriter();
	    out.print(json);
	    out.flush();
	}

}
