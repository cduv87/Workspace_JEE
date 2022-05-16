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
@WebServlet("/inscriptionAvecRedirect")
public class ServletInscriptionAvecRedirect extends HttpServlet {
	
	/**
	 * doPost : On effectue le traitement de l'inscription , pusi on redirige sur une page de confirmation d'insciption
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
		 * C'est ici qu'on peut effectuer le traitement de l'inscription
		 * ajout de l'utilisateur en base de donnée etc...
		 */
		
		
		// à la fin, je redirige sur ma page de confimration
		response.sendRedirect("./confirmation.html");
	}
}
