package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DaoTurno;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListarTurno
 */
public class ListarTurno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTurno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out = response.getWriter();
			DaoTurno dao = new DaoTurno();
			String resultado = dao.dameJson();
			
			System.out.println(resultado);	//Por consola
			out.print(resultado);		//En navegador
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("T/C listado-dameJson en Servlet ListarTurno");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
