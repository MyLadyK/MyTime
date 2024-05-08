package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Supervisor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

import dao.DaoSupervisor;

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
		/*
		//Método Antonio tutoría
		int idSupervisor= Integer.parseInt(request.getParameter("idSupervisor"));
		
		Supervisor sup = new DaoSupervisor();
		sup.modificar(idSupervisor);
	
		*/
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Cosecha propia
		
		 Map<String, String[]> parameters = request.getParameterMap();
		    for(String parameter : parameters.keySet()) {
		        System.out.println("Parameter name: " + parameter);
		        System.out.println("Parameter value: " + Arrays.toString(parameters.get(parameter)));
		    }
		
		
		
		String dni = request.getParameter("dni");
        String puesto = request.getParameter("puesto");
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String permiso = request.getParameter("permiso");

        Supervisor sup = new Supervisor(dni, puesto, nombre, apellido1, apellido2, correo, telefono, permiso);

        
            try {
				DaoSupervisor.getInstance().modificar(sup);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("T/C doPost modificar");
			}
        
        

        response.sendRedirect("ListaUsuario.html");
    }
		
	 

}
