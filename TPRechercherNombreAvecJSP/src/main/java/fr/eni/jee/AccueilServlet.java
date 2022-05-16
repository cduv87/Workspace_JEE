package fr.eni.jee;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Je définit le servlet qui va servir de point d'entrée pour mon application : @WebServlet("") = url de démarrage
 * Servlet = CONTROLLEUR
 */
@WebServlet("") // "" : 
public class AccueilServlet extends HttpServlet {

	/**
	 * Quand je fais une requête GET (= quand j'accède à la page), je redirige sur la jsp accueil.jsp
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// je redirige le traitement à ma JSP d'acceuil
		// JSP = VUE/AFFICHAGE
		request.setAttribute("erreurNombre", ""); // j'initialise l'attribut "erreurNombre" pour éviter
		request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		
	}
	
		

}
