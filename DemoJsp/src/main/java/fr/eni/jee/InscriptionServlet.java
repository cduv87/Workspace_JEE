package fr.eni.jee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {	
    

	/**
	 * doPost : est appelé sur validation du formulaire
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// on recupère le prenom 
		String prenom = request.getParameter("prenom"); //request.getParameter("prenom") : recupère la valeur du paramètre "prenom" de ma reqiuête HTTP (que ce soit un paramètre contenu dans l'url ou dans le corps de la requête)
		
		
		// on recupère l'age 
		if (request.getParameter("age") == null || request.getParameter("age").isEmpty()) {
			
			
			// je redirige vers l'index si il y a des erreurs
			
			// je définit un ATTRIBUT de requête qui sera accessible dans ma JSP
			request.setAttribute("erreurAge", "l'age doit être rempli");
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			int age = Integer.parseInt(request.getParameter("age")); //request.getParameter() renvoie toujours une valeur de type String => il faut caster dans le bon type au besoin
		
		// à la fin, je redirige sur ma page de confimration
		// on ne fait pas un redirect response.sendRedirect("./confirmation.jsp"); car ca provoque 2 allez-retour : 
		
		// request.getRequestDispatcher("confirmation.jsp").forward(request, response) : je délègue le traitement de ma requête HTTP à une JSP
		// on a mis la jsp dans le dossier /WEB-INF car cela permet de la cacher et d'y accéder directement
			
		String categorie;
		
		if (age > 18) {
			categorie = "adulte";
		}
		else {
			categorie = "enfant";
		}
		
		// je définit un ATTRIBUT de requête qui sera accessible dans ma JSP
		request.setAttribute("categorie", categorie);
		
		request.getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);
		}
		
	}

}
