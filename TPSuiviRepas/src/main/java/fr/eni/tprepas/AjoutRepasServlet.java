package fr.eni.tprepas;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.tprepas.utils.StringConvert;

import fr.eni.tprepas.bll.RepasManager;
import fr.eni.tprepas.bo.Repas;

@WebServlet("/AjoutRepas")
public class AjoutRepasServlet extends HttpServlet {
	LocalDate date;
	LocalTime time;
	List<String> ingredients = new ArrayList<String>();
	private RepasManager repasManager = new RepasManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/AjoutRepas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		date = LocalDate.parse(request.getParameter("date"));
		time = LocalTime.parse(request.getParameter("heure"));
		// List<String> list = new ArrayList<String>(Arrays.asList(str.split(", ")));
		// ingredients =
		// Arrays.asList((request.getParameter("ingredients")).split(","));
		StringConvert c = new StringConvert();
		ingredients = c.StringToList(request.getParameter("ingredients"));
		Repas repas = new Repas(date, time, ingredients);

		try {
			this.repasManager.add(repas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * SI j'arrive ici sans plantage, c'est que l'insertion en base de donnée s'est
		 * bien passée
		 **/

		request.setAttribute("messageConfirmation", "Avis ajouté : " + repas);

		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

}
