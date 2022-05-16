package fr.eni.tprecherchenombre;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRandom
 */
@WebServlet("/ServletRandom")
public class ServletRandom extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	// attributs
	Random rd = new Random();
	int nbreAuHAsardENtre0ET9;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRandom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer tentative = Integer.parseInt(request.getParameter("tentative"));
		
//		PrintWriter out = response.getWriter();
//		out.println("Votre essai : " + tentative );
		if (tentative == nbreAuHAsardENtre0ET9) {
			init();
			response.sendRedirect("./victoire.html");
		}
		else {
			response.sendRedirect("./echec.html");
		}
	}
	
	public void init() throws ServletException {
		System.out.println("****** INIT *****");
		nbreAuHAsardENtre0ET9 = rd.nextInt(10);
		System.out.println(nbreAuHAsardENtre0ET9);
	}


}
