package controlador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Sesion
 */
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession sesion;		//Se pone aquí (en la configuración del servlet inicializando el objeto
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		sesion = request.getSession();
		
		String nombre = "Jabber";		//request.getParameter
		
		sesion.setAttribute("nombre", nombre);
		sesion.setAttribute("edad", 8);
		//se pueden poner todos los sesion.setAttribute que se necesiten	DaoUsuario.dameNombre
		
		String respuesta = (String) sesion.getAttribute("nombre");
		int respuesta2 = (int) sesion.getAttribute("edad");
		
		System.out.println(respuesta + respuesta2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
