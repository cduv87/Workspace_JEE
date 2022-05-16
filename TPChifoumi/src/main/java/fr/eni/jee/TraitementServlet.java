package fr.eni.jee;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sert à traiter le choix envoyer par l'utilisateur (en le compoarant au choix machine) et à retourner le résultat du jeux
 */
@WebServlet("/traitement")
public class TraitementServlet extends HttpServlet {

	/**
	 * doPost : est appelée lorsqu'on clique sur un des boutons de notre page jeux.jsp et qu'on valide le formulaire
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1 - recupérer le choix utilisateur
		String choixUtilisateur = request.getParameter("choix");
		
		// 2 - génerer un choix machine (aléatoire entre Pierre/Feuille/Ciseau)
		String choixMachine = genererChoixMachine();
		
		// 3 - déterminer le resultat du jeux (PERDU/GAGNE/EGALITE) en fonction des choix utilisateur/machine
		String resultat = determinerResultat(choixUtilisateur, choixMachine);
		
		// 4 - déléguer l'affichage de la reponse à une JSP resultat en mettant les bons attributs dans la requête (choixUtilisateur/choixMachine/resultat)
		request.setAttribute("choixUtilisateur", choixUtilisateur);
		request.setAttribute("choixMachine", choixMachine);
		request.setAttribute("resultat", resultat);
		
		request.getRequestDispatcher("/WEB-INF/resultat.jsp").forward(request, response);
	}

	/**
	 * méthode utilitaire qui retourne un resultat "Gagné"/"Perdu"/"Egalité" en fonction du choix utilisateur/machine
	 */
	private String determinerResultat(String choixUtilisateur, String choixMachine) {
		
		// 1 - Si jamais les 2 choix sont identiques : Egalité
		if (choixUtilisateur.equals(choixMachine)) {
			return "Egalité";
		}
		// 2 - Sinon, si jamais le choix utilisateur l'emporte sur le choix machine
		else if (
				(choixUtilisateur.equals("Pierre") && choixMachine.equals("Ciseau")) ||
				(choixUtilisateur.equals("Feuille") && choixMachine.equals("Pierre")) ||
				(choixUtilisateur.equals("Ciseau") && choixMachine.equals("Feuille"))
				) {
			return "Gagné!";
		}
		// 3 - Sinon.....j'ai perdu
		else {
			return "Perdu :(";
		}
	}


	/**
	 * méthode utilitaire qui retourn eun choix au hasard parmis "Pierre"/"Feuille"/"Ciseau"
	 */
	private String genererChoixMachine() {
		String[] listeChoix = {"Pierre", "Feuille", "Ciseau"};
		int indexAleatoire = new Random().nextInt(3); // je génère un nombre aléatoire entre 0 et 2
		return listeChoix[indexAleatoire]; // je retourne l'élément de ma liste qui correspond à l'index aléatoire 
	}

}
