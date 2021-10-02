<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import = "java.util.logging.Logger" %>
<html>
<head>
	<title>Manage Subjects</title>
</head>
<body>

 <a href="../home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
 <% Logger logger = Logger.getLogger(this.getClass().getName());%>
	<center>
		<h1>Manage Subjects</h1>
        <h2>
        	<a href="new">Add New Subjcet</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Subjects</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Subjects</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
          
            <c:forEach var="subject" items="${listSubject}">
        
                <tr>
                    <td><c:out value="${subject.id}" /></td>
                    <td><c:out value="${subject.subjectName}" /></td>
                 
                    <td>
                    	<a href="edit?id=<c:out value='${subject.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${subject.id}' />">Delete</a>                    	
                    </td>
                </tr>
                
                </br>
        
            </c:forEach>
        </table>
    </div>	
</body>
</html>
