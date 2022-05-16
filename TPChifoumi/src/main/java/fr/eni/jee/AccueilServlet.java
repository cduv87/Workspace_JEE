package fr.eni.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * AccueilServlet : nous sert de point d'entrée à l'application
 */
@WebServlet("")
public class AccueilServlet extends HttpServlet {
	
	/**
	 * doGet : redirige le traitement à ma JSP d'accueil
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// je délègue le traitement de l'affichage des requêtes GET vers l'url de base à ma JSP située à ce chemin : /WEB-INF/jeux.jsp
		request.getRequestDispatcher("/WEB-INF/jeux.jsp").forward(request, response);
	}

}
