package fr.eni.pfc;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServCombat
 */
@WebServlet("/ServCombat")
public class ServCombat extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1 - On recupère la valeur saisie par l'utilisateur dans le formulaire
					String propArme = request.getParameter("choix");
					String botArme = choixBot();
					request.setAttribute("ArmeHumain", propArme);
					request.setAttribute("ArmeBot", botArme);
					if (propArme.equals(botArme)) {
						request.setAttribute("resultat", "Même arme utilisée par l'adversaire : égalité");
						request.getRequestDispatcher("/WEB-INF/Combat.jsp").forward(request, response);				
					}
					else {
						switch(propArme){
						   
					       case "Pierre": 
						    	   switch(botArme){
								   
							       case "Feuille": 
							    	    request.setAttribute("resultat", "perdu");
							           break;
							   
							       case "Ciseaux":
							    	    request.setAttribute("resultat", "gagné");
							           break; 
							       }
					           break;
					   
					       case "Feuille":
						    	   switch(botArme){
								   
							       case "Pierre": 
							    	    request.setAttribute("resultat", "gagné");
							           break;
							   
							       case "Ciseaux":
							    	    request.setAttribute("resultat", "perdu");
							           break; 
							       }
					           break;
					   
					       case "Ciseaux":
						    	   switch(botArme){
								   
							       case "Pierre": 
							    	    request.setAttribute("resultat", "perdu");
							           break;
							   
							       case "Feuille":
							    	    request.setAttribute("resultat", "gagné");
							           break; 
							       }
					           break;
					   }//switch
					}//else
					request.getRequestDispatcher("/WEB-INF/Combat.jsp").forward(request, response);	
	}//post

	   protected String choixBot() {
	        String botArme = null;
	        int temp;
	        Random rd = new Random();
	        temp = rd.nextInt(3);
	            switch(temp){
	                case 0 : botArme = "Pierre"; break;
	                case 1 : botArme = "Feuille"; break;
	                case 2 : botArme = "Ciseaux"; break;
	            }
	        return botArme;
	    	
}
}
