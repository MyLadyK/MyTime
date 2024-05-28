package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import dao.DaoTurno;

/**
 * Servlet implementation class InsertarTurno
 */
public class InsertarTurno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertarTurno() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int anno = Integer.parseInt(request.getParameter("anno"));
		String mes = request.getParameter("mes");
		String diaInicio = request.getParameter("diaInicio");
		String diaFin = request.getParameter("diaFin");
		String horaInicio = request.getParameter("horaInicio");
		String horaFin = request.getParameter("horaFin");
		int numTrabajadores = Integer.parseInt(request.getParameter("numTrabajadores"));

		try {
			DaoTurno.getInstance().generarTurno(anno, mes, diaInicio, diaFin, horaInicio, horaFin, numTrabajadores);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
