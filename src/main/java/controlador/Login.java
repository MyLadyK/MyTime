package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		String nombreUsuario = (String) sesion.getAttribute("nombre");
		System.out.println(nombreUsuario);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contraseña");

        // Aquí debes verificar las credenciales con la base de datos
        boolean isValidUser = DBUtil.checkUser(correo, contrasena);

        if (isValidUser) {
            // Inicio de sesión exitoso
            response.sendRedirect("home.html");
        } else {
            // Inicio de sesión fallido
            response.sendRedirect("Inicio.html");
        }
    }
	
	*/
	}


}
