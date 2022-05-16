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
//@WebServlet("/TestServlet") : Cette classe est une servlet qui va écouter les requêtes effectuées à l'adresse : <<url_serveur>>:<<port_serveur>>/<<nom_appli>>/TestServlet = http://localhost:8080/DemoServlets/TestServlet
@WebServlet("/TestServlet")  
public class TestServlet extends HttpServlet {
	
	

	/**
	 * doGet() : code executé lorsqu'on effectue une requête HTTP de type GET sur l'url définie par l'annotation@WebServlet(http://localhost:8080/DemoServlets/TestServlet) 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * code à executer : c'est ici qu'on fait appel aux autres couches (BLL notamment) de notre application
		 */
		response.getWriter().append("DO GET Served at: ").append(request.getContextPath());
	}

	/**
	 * doPost() : code executé lorsqu'on effectue une requête HTTP de type POST sur l'url définie par l'annotation@WebServlet(http://localhost:8080/DemoServlets/TestServlet) 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("DO POST Served at: ").append(request.getContextPath());
	}

}
