package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 * Servlet implementation class InsertarUsuario
 */
@MultipartConfig
public class InsertarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarUsuario() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String dni = request.getParameter("dni");
		String puesto = request.getParameter("puesto");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		String permiso = request.getParameter("permiso");
		
		
		Usuario us1 = new Usuario (dni, puesto, nombre, apellido1, apellido2, correo, telefono, permiso);
		
		try {
			us1.insertar();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
			System.out.println("Error al añadir.");
		}
		
		response.sendRedirect("http://localhost:8080/My_Time/ListaUsuario.html");
		
	}

}
