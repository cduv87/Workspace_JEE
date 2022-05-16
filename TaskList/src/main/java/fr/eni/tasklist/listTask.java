package fr.eni.tasklist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class listTask
 */
@WebServlet("")
public class listTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String toModify = null;
	ArrayList<String> list = new ArrayList<String>( );

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("liste", list);
		request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("tache")!=null) {
		this.list.add(request.getParameter("tache"));
		request.setAttribute("liste", list);
		response.sendRedirect("./");
		}
		if (request.getParameter("delete")!=null) {
//		String toDelete = null;
//		request.setAttribute("delete", toDelete);
		this.list.remove(request.getParameter("delete"));
		request.setAttribute("liste", list);
		response.sendRedirect("./");
		}
		if (request.getParameter("modifier")!=null)  {
			this.toModify = request.getParameter("modifier");
			request.setAttribute("Amodifier", this.toModify);
			request.setAttribute("liste", list);
			request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
		}
		if (request.getParameter("modified")!=null)  {
			String modified = request.getParameter("modified");
			int index = list.indexOf(this.toModify);
		    list.set(index, modified);
			request.setAttribute("liste", list);
			response.sendRedirect("./");
		}
		
//		request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);

	}
}


