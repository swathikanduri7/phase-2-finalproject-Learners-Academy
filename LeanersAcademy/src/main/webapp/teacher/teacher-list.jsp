<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import = "java.util.logging.Logger" %>
<html>
<head>
	<title>Teacher Management</title>
</head>
<body>

 <a href="../home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
 <% Logger logger = Logger.getLogger(this.getClass().getName());%>
	<center>
		<h1>Teacher Management</h1>
        <h2>
        	<a href="new">Add New Teacher</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Teachers</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Teachers</h2></caption>
            <tr>
                <th>ID</th>
                <th>Teacher Name</th>
                <th>Qualification</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
          
            <c:forEach var="teacher" items="${listTeacher}">
            
                     <tr>
                    <td><c:out value="${teacher.id}" /></td>
                    <td><c:out value="${teacher.teacherName}" /></td>
                    <td><c:out value="${teacher.qualification}" /></td>
                    <td><c:out value="${teacher.teacherEmail}" /></td>
                  
                    <td>
                    	<a href="edit?id=<c:out value='${teacher.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${teacher.id}' />">Delete</a>                    	
                    </td>
                </tr>
                
             </c:forEach>
        </table>
    </div>	
</body>
</html>
