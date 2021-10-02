package com.swaraj.servlets;



import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swaraj.dao.ClassesDao;
import com.swaraj.dao.StudentDao;
import com.swaraj.dao.SubjectDao;
import com.swaraj.dao.TeacherDao;
import com.swaraj.dao.UserDao;
import com.swaraj.model.Classes;
import com.swaraj.model.Student;
import com.swaraj.model.Subject;
import com.swaraj.model.Teacher;
import com.swaraj.model.User;

;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private SubjectDao subjectDao;
	private TeacherDao teacherDao;
	private ClassesDao classesDao;
	private StudentDao studentDao;
	
	
	public void init() {
		userDao = new UserDao();
		subjectDao = new SubjectDao();
		teacherDao = new TeacherDao();
		classesDao = new ClassesDao();
		studentDao = new StudentDao();
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
			case "/assignTeacherToAClass":
				assignTeacherToAClass(request, response);
				break;
			
			case "/assignSubjectToAClass":
				assignSubjectToAClass(request, response);
				break;
			case "/assignStudentToAClass":
				assignStudentToAClass(request, response);
				break;
				
			case "/loginprocess":
				doLoginValidate(request, response);
				break;
			case "/user/new":
				showNewForm(request, response);
				break;
			case "/user/insert":
				insertUser(request, response);
				break;
			case "/user/delete":
				deleteUser(request, response);
				break;
			case "/user/edit":
				showEditForm(request, response);
				break;
			case "/user/update":
				updateUser(request, response);
				break;
			case "/user/list":
				listUser(request, response);
				break;
			case "/subject/new":
				showNewSubjectForm(request, response);
				break;
			case "/subject/insert":
				insertSubject(request, response);
				break;
			case "/subject/delete":
				deleteSubject(request, response);
				break;
			case "/subject/edit":
				showSubjectEditForm(request, response);
				break;
			case "/subject/update":
				updateSubject(request, response);
				break;
			case "/subject/list":
				listSubject(request, response);
				break;
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
			case "/classes/new":
				showNewClassesForm(request, response);
				break;
			case "/classes/insert":
				insertClasses(request, response);
				break;
			case "/classes/delete":
				deleteClasses(request, response);
				break;
			case "/classes/edit":
				showClassesEditForm(request, response);
				break;
			case "/classes/update":
				updateClasses(request, response);
				break;
			case "/classes/list":
				listClasses(request, response);
				break;
			case "/classes/report":
				classReport(request, response);
				break;
			case "/student/new":
				showNewStudentForm(request, response);
				break;
			case "/student/insert":
				insertStudent(request, response);
				break;
			case "/student/delete":
				deleteStudent(request, response);
				break;
			case "/student/edit":
				showEditStudentForm(request, response);
				break;
			case "/student/update":
				updateStudent(request, response);
				break;
			case "/student/list":
				listStudent(request, response);
				break;
			case "/home":
				displayMenu(request, response);
				break;
			case "/assignsub":
				assignsub(request, response);
				break;
			case "/assignteacher":
				assignteacher(request, response);
				break;
			case "/assignstudent":
				assignstudent(request, response);
				break;
			default:
			    displayLogin(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void classReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//int id = Integer.parseInt(request.getParameter("id"));
		int classId = Integer.parseInt(request.getParameter("id"));
		Classes existingClasses = classesDao.getClasses(classId);
		 Set<Student> students = new HashSet<Student>();
		 students= existingClasses.getStudents();
		 
		request.setAttribute("listStudent", students);
		
		Set<Teacher> teachers = new HashSet<Teacher>();
		teachers=existingClasses.getTeachers();
		
		request.setAttribute("listTeacher", teachers);
		
		request.setAttribute("classes", existingClasses);
		
		response.sendRedirect("class-report.jsp");
		
	}

	private void assignstudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher("student-classes.jsp");
			List<Student> listStudent = studentDao.getAllStudent();
			request.setAttribute("listStudent", listStudent);
			
			List<Classes> listClasses = classesDao.getAllClasses();
			request.setAttribute("listClass", listClasses);
			
			dispatcher.forward(request, response);
		
	}

	private void assignStudentToAClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("student");
		String classesId = request.getParameter("classes");
		
		int id = Integer.parseInt(studentId);
		Student existingStudent = studentDao.getStudent(id);
		
		int classId = Integer.parseInt(classesId);
		Classes existingClasses = classesDao.getClasses(classId);
		 Set<Student> students = new HashSet<Student>();
		 students= existingClasses.getStudents();
		 students.add(existingStudent);
		 existingClasses.setStudents(students);
		 classesDao.updateClasses(existingClasses);
		 
		 existingStudent.setGrade(existingClasses);
		 studentDao.updateStudent(existingStudent);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("student-classes.jsp");
			List<Student> listStudent = studentDao.getAllStudent();
			request.setAttribute("listStudent", listStudent);
			
			List<Classes> listClasses = classesDao.getAllClasses();
			request.setAttribute("listClass", listClasses);
			
			dispatcher.forward(request, response);
		
	}

	private void assignTeacherToAClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectId = request.getParameter("subject");
		String classesId = request.getParameter("classes");
		String teacher_Id = request.getParameter("teacher");
		
		int id = Integer.parseInt(subjectId);
		Subject existingSubject = subjectDao.getSubject(id);
		
		int classId = Integer.parseInt(classesId);
		Classes existingClasses = classesDao.getClasses(classId);
		
		int teacherId = Integer.parseInt(teacher_Id);
		Teacher teacherObj = teacherDao.getTeacher(teacherId);
		
		 Set<Subject> subjects = new HashSet<>();
		 subjects= teacherObj.getSubjects();
		 subjects.add(existingSubject);
		 teacherObj.setSubjects(subjects);
		 
		 Set<Classes> classes = new HashSet<>();
		 classes= teacherObj.getClasses();
		 classes.add(existingClasses);
		 teacherObj.setClasses(classes);
		 
		 teacherDao.updateTeacher(teacherObj);		 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-class-subject.jsp");
		List<Subject> listSubject = subjectDao.getAllSubject();
		request.setAttribute("listSubject", listSubject);
		
		List<Classes> listClasses = classesDao.getAllClasses();
		request.setAttribute("listClass", listClasses);
		
		List<Teacher> listTeacher = teacherDao.getAllTeacher();
		request.setAttribute("listTeacher", listTeacher);
		
		dispatcher.forward(request, response);
		
	}

	private void assignteacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-class-subject.jsp");
		List<Subject> listSubject = subjectDao.getAllSubject();
		request.setAttribute("listSubject", listSubject);
		
		List<Classes> listClasses = classesDao.getAllClasses();
		request.setAttribute("listClass", listClasses);
		
		List<Teacher> listTeacher = teacherDao.getAllTeacher();
		request.setAttribute("listTeacher", listTeacher);
		
		dispatcher.forward(request, response);
		
	}

	private void assignsub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("assign-subject-class.jsp");
		List<Subject> listSubject = subjectDao.getAllSubject();
		request.setAttribute("listSubject", listSubject);
		
		List<Classes> listClasses = classesDao.getAllClasses();
		request.setAttribute("listClass", listClasses);
		
		dispatcher.forward(request, response);
		
	}

	private void assignSubjectToAClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectId = request.getParameter("subject");
		String classesId = request.getParameter("classes");
		
		int id = Integer.parseInt(subjectId);
		Subject existingSubject = subjectDao.getSubject(id);
		
		int classId = Integer.parseInt(classesId);
		Classes existingClasses = classesDao.getClasses(classId);
		 Set<Subject> subjects = new HashSet<Subject>();
		 subjects= existingClasses.getSubjects();
		 subjects.add(existingSubject);
		 existingClasses.setSubjects(subjects);
		 classesDao.updateClasses(existingClasses);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("assign-subject-class.jsp");
			List<Subject> listSubject = subjectDao.getAllSubject();
			request.setAttribute("listSubject", listSubject);
			
			List<Classes> listClasses = classesDao.getAllClasses();
			request.setAttribute("listClass", listClasses);
			
			dispatcher.forward(request, response);
		
	}

	private void doLoginValidate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		Boolean existingUser = userDao.getUserByUserNameAndPassword(userName,password);
		if(existingUser){
			RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		//	request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

	private void displayLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		
	}

	private void displayMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
		dispatcher.forward(request, response);
		
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDao.getAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDao.getUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
        String password = "adminUser1";
		
		//String name, String password, String email, String country
		User newUser = new User(name, password,email, country);
		userDao.saveUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
	     String password = "adminUser1";
			
			//String name, String password, String email, String country
			User user = new User(id,name, password,email, country);
		
		userDao.updateUser(user);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
	}
	
	private void listSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Subject> listSubject = subjectDao.getAllSubject();
		request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewSubjectForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showSubjectEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Subject existingSubject = subjectDao.getSubject(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject-form.jsp");
		request.setAttribute("subject", existingSubject);
		dispatcher.forward(request, response);

	}

	private void insertSubject(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
				
		Subject newSubject = new Subject(name);
		subjectDao.saveSubject(newSubject);
		response.sendRedirect("list");
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		
			
			//String name, String password, String email, String country
			Subject subject = new Subject(id,name);
		
		subjectDao.updateSubject(subject);
		response.sendRedirect("list");
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		subjectDao.deleteSubject(id);
		response.sendRedirect("list");
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
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Student> listStudent = studentDao.getAllStudent();
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent = studentDao.getStudent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
        //String password = "adminStudent1";
		
		//String name, String password, String email, String country
		
		Student newStudent = new Student(name, mobile,email);
		studentDao.saveStudent(newStudent);
		response.sendRedirect("list");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
	     
		//String password = "adminStudent1";
			
			//String name, String password, String email, String country
			Student student = new Student(id,name,mobile, email);
		
		studentDao.updateStudent(student);
		response.sendRedirect("list");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDao.deleteStudent(id);
		response.sendRedirect("list");
	}
}
