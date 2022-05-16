package fr.eni.jee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestInitServlet
 */
@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
	private int nbreAppel = 0;
	private int nbreInitialisation = 0;
       
   
	/**
	 * doGet : va recupérer le paramètre "prenom" de la requête HTTP pour l'utiliser dans notre message de bienvenue
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String prenom = request.getParameter("prenom"); //request.getParameter("prenom") : recupère la valeur du paramètre "prenom" de ma reqiuête HTTP (que ce soit un paramètre contenu dans l'url ou dans le corps de la requête)		
		
		
		// out correspond au flux de données de la réponse HTTP
		// on peut s'en servir comme du System.out (flux de données de la console Java)
		PrintWriter out = response.getWriter();
		
		out.println("Bonjour " + prenom + " !!!");
		if (request.getParameter("age") != null) {
			int age = Integer.parseInt(request.getParameter("age")); //request.getParameter() renvoie toujours une valeur de type String => il faut caster dans le bon type au besoin
			out.println("Votre age : " + age);
		}
		out.println("Vous êtes inscrit");
	}


	/**
	 * Je precise juste que lorsque mon doPost est appelé, je veux executer le même code que dans mon doGet()
	*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
