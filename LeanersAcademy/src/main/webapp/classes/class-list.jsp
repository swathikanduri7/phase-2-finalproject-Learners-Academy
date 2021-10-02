<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import = "java.util.logging.Logger" %>
<html>
<head>
	<title>Class Management Applicationn</title>
</head>
<body>

 <a href="../home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
 <% Logger logger = Logger.getLogger(this.getClass().getName());%>
	<center>
		<h1>Class Management</h1>
        <h2>
        	<a href="new">Add New Class</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Classes</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Classes</h2></caption>
            <tr>
                <th>ID</th>
                <th>ClassName</th>
                <th>Section</th>
                <th>Actions</th>
            </tr>
          
            <c:forEach var="class" items="${listClass}">
            
                   <tr>
                    <td><c:out value="${class.classId}" /></td>
                    <td><c:out value="${class.className}" /></td>                    
                    <td><c:out value="${class.classSection}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${class.classId}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${class.classId}' />">Delete</a> 
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="report?id=<c:out value='${class.classId}' />">Class Report</a>                     	
                    </td>
                </tr>
                
                </br>
         
            </c:forEach>
        </table>
    </div>	
</body>
</html>
