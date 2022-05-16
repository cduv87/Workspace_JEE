package fr.eni.jee;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TraitementServlet
 */
@WebServlet("/traitement")
public class TraitementServlet extends HttpServlet {
	
	private int nbreAleatoire; // attribut qui stocke le nombre aléatoire choisi par l'ordinateur (accessible dans toutes les méthodes de ma classe)

	/**
	 * doPost : est appelé lorsqu'on valide le formulaire
	 * compare la valeur du nombre envoyé par la requête HTTP avec celle du nombre generé au hasard par le servlet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// on rajoute un bloc try-catch pour pallier aux eventuelles mauvaises saisies (et donc plantage lors de la conversion texte -> nombre)
		try {
			// 1 - On recupère la valeur saisie par l'utilisateur dans le formulaire
			int nombreSaisi = Integer.parseInt(request.getParameter("nombre"));
			
			// 2 - On compare cette valeur avec le nombre generé par l'ordi
			if (nombreSaisi == this.nbreAleatoire) {
				// gagné 
				init(); // on reinitialise le nombre après une victoire 
				
				// on redirige vers la JSP de resultat (forward) en mettant l'attribut de requête "resultat" à : "Victoire"
				request.setAttribute("resultat", "victoire");
				request.getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);				
			}
			else {
				// perdu 
				// on redirige vers la JSP de resultat (forward) en mettant l'attribut de requête "resultat" à : "echec"
				request.setAttribute("resultat", "echec");
				request.getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);
			}
		}
		// Validation côté serveur (en plus de la validation HTML) : si jamais erreur de saisie (nulle ou texte à la place de nombre)
		catch(NumberFormatException exception) {
			// on redirige vers la JSP d'accueil (forward) en mettant l'attribut de requête "erreurNombre" à : "Veuillez saisir un nombre au format correct"
			request.setAttribute("erreurNombre", "Veuillez saisir un nombre au format correct");
			request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}
	}

	/**
	 * On genère notre nombre aléatoire dans le init() pour garder le même entre 2 tentatives de l'utilisateur
	 *  nb : on rappelera cette méthode init() seulement après une victoire pour reinitialiser le nombre
	 */
	@Override // @Override : indication non obligatoire pour le compilateur
	public void init() throws ServletException {
		Random rd = new Random();
		this.nbreAleatoire = rd.nextInt(10) + 1; // on rajoute + 1 car rd.nextInt(10) genère un nombre aléatoire entre 0 et 9
		System.out.println("Nombre choisi par l'ordinateur : " + this.nbreAleatoire);
	}

	
	

	
	

}
