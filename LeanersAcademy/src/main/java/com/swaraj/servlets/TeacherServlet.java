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

import com.swaraj.dao.TeacherDao;
import com.swaraj.model.Teacher;

*//**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the teacher.
 * @email Ramesh Fadatare
 *//*

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDao;
	
	public void init() {
		teacherDao = new TeacherDao();
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
			case "/teacher/new":
				showNewTeacherForm(request, response);
				break;
			case "/teacher/insert":
				insertTeacher(request, response);
				break;
			case "/teacher/delete":
				deleteTeacher(request, response);
				break;
			case "/teacher/edit":
				showEditTeacherForm(request, response);
				break;
			case "/teacher/update":
				updateTeacher(request, response);
				break;
			case "/teacher/list":
				listTeacher(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Teacher> listTeacher = teacherDao.getAllTeacher();
		request.setAttribute("listTeacher", listTeacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewTeacherForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditTeacherForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Teacher existingTeacher = teacherDao.getTeacher(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
		request.setAttribute("teacher", existingTeacher);
		dispatcher.forward(request, response);

	}

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String qualification = request.getParameter("qualification");
		String email = request.getParameter("email");
        
		
		//String name, String password, String email, String country
		Teacher newTeacher = new Teacher(name,qualification,email);
		teacherDao.saveTeacher(newTeacher);
		response.sendRedirect("list");
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String qualification = request.getParameter("qualification");
		String email = request.getParameter("email");
	    
			
			//String name, String password, String email, String country
			Teacher teacher = new Teacher(id,name,qualification,email);
		
		teacherDao.updateTeacher(teacher);
		response.sendRedirect("list");
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		teacherDao.deleteTeacher(id);
		response.sendRedirect("list");
	}
}
*/