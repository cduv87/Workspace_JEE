package fr.eni.tprepas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tprepas.bll.RepasManager;
import fr.eni.tprepas.bo.Repas;

/**
 * Servlet implementation class AfficherRepasServlet
 */
@WebServlet("/AfficherRepas")
public class AfficherRepasServlet extends HttpServlet {
	private RepasManager repasManager = new RepasManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Repas> listeRepas = new ArrayList<Repas>();
		listeRepas = repasManager.GetRepas();
		request.setAttribute("listeRepas", listeRepas);
		if ((request.getParameter("detail")) != null) {
			Integer id = Integer.parseInt(request.getParameter("detail"));
			List<String> ingredients = repasManager.GetIngredientsFromIdRepas(id);
			request.setAttribute("ingredients", ingredients);
			}

		request.getRequestDispatcher("/WEB-INF/AfficherRepas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
