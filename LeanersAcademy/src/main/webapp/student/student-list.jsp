<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import = "java.util.logging.Logger" %>
<html>
<head>
	<title>Student Management Application</title>
</head>
<body>
 <a href="../home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
 <% Logger logger = Logger.getLogger(this.getClass().getName());%>
	<center>
		<h1>Student Management</h1>
        <h2>
        	<a href="new">Add New Student</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Students</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>MobileNumber</th>
                <th>Email</th>
                
                <th>Actions</th>
            </tr>
          
            <c:forEach var="student" items="${listStudent}">
            
                    <tr>
                    <td><c:out value="${student.studentId}" /></td>
                    <td><c:out value="${student.studentName}" /></td>
                     <td><c:out value="${student.mobileNumber}" /></td>
                    <td><c:out value="${student.studentEmail}" /></td>
                    
                    <td>
                    	<a href="edit?id=<c:out value='${student.studentId}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${student.studentId}' />">Delete</a>                    	
                    </td>
                </tr>
                
                </br>
         
            </c:forEach>
        </table>
    </div>	
</body>
</html>
