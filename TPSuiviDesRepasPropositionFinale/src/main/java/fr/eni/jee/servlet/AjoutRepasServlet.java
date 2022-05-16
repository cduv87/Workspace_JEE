package fr.eni.jee.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

import fr.eni.jee.bll.BusinessException;
import fr.eni.jee.bll.RepasManager;
import fr.eni.jee.bo.Repas;

/**
 * Servlet associé à la fonctionnalité "AjoutRepas"
 * 2 actions à gérer :
 *  - doGet : accès à la page d'ajout : on affiche le formulaire
 *  - doPost : traitement du formulaire : on xrée un objet Repas qui va être ajouté à la base de donnée via les couches BLL/DAL
 */
@WebServlet("/ajoutRepas")
public class AjoutRepasServlet extends HttpServlet {
	
	// attribut qui contient la référence vers notre couche BLL (traitement métier)
	private RepasManager repasManager = new RepasManager();
	
	/**
	 * doGet : accès à la page d'ajout : on affiche le formulaire
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// on délègue la génération de la réponse HTML à la JSP
		request.getRequestDispatcher("/WEB-INF/ajoutRepas.jsp").forward(request, response);
	}

	/**
	 * doPost : traitement du formulaire : on xrée un objet Repas qui va être ajouté à la base de donnée via les couches BLL/DAL
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// traitement préalable : à ajouter pour éviter les problèmes d'accents mal gerés dans les tâches
		request.setCharacterEncoding("UTF-8");
				
		// 1 - recupère les paramètres date, heure, repas au format String
		String dateFormatString = request.getParameter("date"); // recupère la valeur du champs avec name="date" 
		String heureFormatString = request.getParameter("heure"); // recupère la valeur du champs avec name="heure"
		String repasFormatString = request.getParameter("repas"); // recupère la valeur du champs avec name="repas"
		
		// 2 - je convertis les paramètres afin qu'ils soient dans le même type que les attributs de ma classe Repas (LocalDate, LocalTime, List<String>)
		LocalDate date = LocalDate.parse(dateFormatString);
		LocalTime heure = LocalTime.parse(heureFormatString);		
		// pour la liste d'ingredients ("aliments"), je vais devoir utiliser la fonction split() pour convertir mon paragraphe en tableau
		String[] tableauAliments = repasFormatString.split(","); //méthode split() : https://codegym.cc/fr/groups/posts/la-methode-string-split-en-java
		
		
		// 3 - je crée un objet de la classe Repas
		Repas repas = new Repas(date, heure);
		
		// pour chaque élément de mon tableau d'aliments, j'ajoute l'aliment correspondant à mon repas
		for (String aliment : tableauAliments) {
			repas.addAliment(aliment);
		}
		
		System.out.println("Repas qui va être créé : " + repas);
		
		// 4 - appeller la couche BLL (RepasManager) pour effectuer la création de repas
		try {
			this.repasManager.add(repas);
			// après création Ok, rediriger sur historique (ou accueil si la page d'historique n'a pas été codée)
			response.sendRedirect("./visualiserRepas");
		} 
		// si j'ai une exception personalisée (liée à la validation)
		catch (BusinessException e) {
			// j'ajoute un attribut à la requête avec le contenu du message d'erreur afin de pouvoir l'afficher
			request.setAttribute("messageErreur", e.getMessage());
			// je redirige sur le formulaire
			this.doGet(request, response);
		}
	}
}
