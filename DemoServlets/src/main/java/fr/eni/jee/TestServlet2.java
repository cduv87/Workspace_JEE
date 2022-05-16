package fr.eni.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
//@WebServlet : ATTENTION : il faut mettre une url différente de TestServlet car 2 Servlets ne peuvent pas écouter la même url
// urlPatterns : permet de definir une suite d'url qui va pointer sur ce servlet (attention, toujours commencer les url par / SAUF l'url "" qui correspond à la racine de l'application
@WebServlet(urlPatterns = {"/TestServlet2", "/TestServlet2UrlAlternative", "/Servlet2/*"})  
public class TestServlet2 extends HttpServlet {
	
	

	/**
	 * doGet() : code executé lorsqu'on effectue une requête HTTP de type GET sur l'url définie par l'annotation@WebServlet(http://localhost:8080/DemoServlets/TestServlet2) 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * code à executer : c'est ici qu'on fait appel aux autres couches (BLL notamment) de notre application
		 */
		response.getWriter().append("DO GET TestServlet2 Served at: ").append(request.getContextPath());
	}

	/**
	 * doPost() : code executé lorsqu'on effectue une requête HTTP de type POST sur l'url définie par l'annotation@WebServlet(http://localhost:8080/DemoServlets/TestServlet2) 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("DO POST TestServlet2 Served at: ").append(request.getContextPath());
	}

}
