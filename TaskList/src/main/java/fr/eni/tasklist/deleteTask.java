package fr.eni.tasklist;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteTask
 */
@WebServlet("/deleteTask")
public class deleteTask extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toDelete = null;
		request.setAttribute("delete", toDelete);
		
		request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
	}

}
