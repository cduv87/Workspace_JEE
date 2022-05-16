package fr.eni.jee.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bll.RepasManager;
import fr.eni.jee.bo.Repas;

/**
 * Servlet associé à la fonctionnalité "AjoutRepas"
 * 2 actions à gérer :
 *  - doGet : accès à la page d'ajout : on affiche le formulaire
 *  - doPost : traitement du formulaire : on xrée un objet Repas qui va être ajouté à la base de donnée via les couches BLL/DAL
 */
@WebServlet("/visualiserRepas")
public class VisualiserRepasServlet extends HttpServlet {
	
	// attribut qui contient la référence vers notre couche BLL (traitement métier)
	private RepasManager repasManager = new RepasManager();
	
	/**
	 * doGet : accès à la page d'ajout : on affiche le tableau des repas
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1 - on recupère les repas deouis la couche BLL
		List<Repas> repas = this.repasManager.getAll();
		
		// 1.bis - Si jamais on a l'attribut de requête "idRepas" qui est présent, alors on va chercher les aliments qui correspondent à ce repas
		if (request.getParameter("idRepas") != null) {
			int idRepas = Integer.valueOf(request.getParameter("idRepas"));
			List<String> ingredients = this.repasManager.getIngredients(idRepas);
			// dans ce cas, on ajoute un attribut de requête "listeIngredients" : on pourra utiliser ${listeIngredients} dans la JSP
			request.setAttribute("listeIngredients", ingredients);
			System.out.println("listeIngredients : " + Arrays.toString(ingredients.toArray()));
		}
		
		// 2 - on ajoute un attribut de requête "listeRepas" : on pourra utiliser ${listeRepas} dans la JSP
		request.setAttribute("listeRepas", repas);
		
		// 3 - on délègue la génération de la réponse HTML à la JSP
		request.getRequestDispatcher("/WEB-INF/visualisationRepas.jsp").forward(request, response);
	}
}
