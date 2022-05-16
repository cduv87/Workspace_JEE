package fr.eni.jee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestInitServlet
 */
@WebServlet("/init")
public class TestInitServlet extends HttpServlet {
	private int nbreAppel = 0;
	private int nbreInitialisation = 0;
       
   
	/**
	 * doGet : va être appelé à chaque requête HTTP de type GET sur /init
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nbreAppel ++; // j'incrémente la variable : nbreAppel
		
		// out correspond au flux de données de la réponse HTTP
		// on peut s'en servir comme du System.out (flux de données de la console Java)
		PrintWriter out = response.getWriter();
		
		out.println("********** APPEL DE LA SERVLET *********");
		// j'affiche à l'écran le nombre d'appels + nombre Init
		out.println("nbreInitialisation : " + nbreInitialisation);
		out.println("nbreAppel : " + nbreAppel);
		
	}


	/**
	 * On surcharge la méthode "init()" : cela nous permet d'executer du code supplémentaire à l'instantiation du servlet
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("****** INIT *****");
		nbreInitialisation ++; // j'incrémente la variable : nbreInitialisation
	}
}
