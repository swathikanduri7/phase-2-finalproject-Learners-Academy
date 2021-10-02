/*package com.swaraj.servlets;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swaraj.dao.ClassesDao;
//import com.swaraj.dao.ClassesDao;
import com.swaraj.model.Classes;
//import com.swaraj.model.Classes;

;

*//**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the classes.
 * @email Ramesh Fadatare
 *//*

@WebServlet("/classes")
public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassesDao classesDao;
	
	public void init() {
		classesDao = new ClassesDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewClassesForm(request, response);
				break;
			case "/insert":
				insertClasses(request, response);
				break;
			case "/delete":
				deleteClasses(request, response);
				break;
			case "/edit":
				showClassesEditForm(request, response);
				break;
			case "/update":
				updateClasses(request, response);
				break;
		
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listClasses(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Classes> listClasses = classesDao.getAllClasses();
		request.setAttribute("listClass", listClasses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewClassesForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showClassesEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Classes existingClasses = classesDao.getClasses(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-form.jsp");
		request.setAttribute("classes", existingClasses);
		dispatcher.forward(request, response);

	}

	private void insertClasses(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String section = request.getParameter("section");
		
        //String password = "adminClasses1";
		
		//String name, String password, String email, String country
		Classes newClasses = new Classes(name, section);
		classesDao.saveClasses(newClasses);
		response.sendRedirect("list");
	}

	private void updateClasses(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String section = request.getParameter("section");
		
	    // String password = "adminClasses1";
			
			//String name, String password, String email, String country
			Classes classes = new Classes(id,name, section);
		
		classesDao.updateClasses(classes);
		response.sendRedirect("list");
	}

	private void deleteClasses(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		classesDao.deleteClasses(id);
		response.sendRedirect("classes");
	}
}
*/