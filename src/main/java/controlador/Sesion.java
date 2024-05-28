package controlador;

import java.io.IOException;
import java.sql.SQLException;

import dao.DaoUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

/**
 * Servlet implementation class Sesion
 */


public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sesion() {
		super();
		
	}

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String correo = request.getParameter("correo");
	        String contrasena = request.getParameter("contrasena");

	        DaoUsuario daoUs = null;

	        try {
	            daoUs = new DaoUsuario();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        if (daoUs != null) {
	            Usuario usuario = daoUs.loginUsuario(correo, contrasena);

	            if (usuario != null) {
	                HttpSession session = request.getSession();
	                session.setAttribute("usuario", usuario);
	                response.addHeader("permiso", usuario.getPermiso());
	                response.setStatus(HttpServletResponse.SC_OK);
	                System.out.println("Usuario almacenado en la sesión: " + usuario.getNombre()); 

	            } else {
	                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	            }
	        } else {
	            System.out.println("Error en el servlet de inicio de la sesión");
	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        }
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        HttpSession session = request.getSession(false); // Evita crear una nueva sesión si no existe
	        if (session != null) {
	            session.invalidate();
	        }
	        response.sendRedirect("Inicio.html");
	    }
	}
