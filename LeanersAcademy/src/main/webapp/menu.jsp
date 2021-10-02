<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import = "java.util.logging.Logger" %>
<html>
<head>
	<title>Menu</title>
</head>
<body>
 <% Logger logger = Logger.getLogger(this.getClass().getName());%>
 
 <a href="home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
	
		<h1><u>Menu</u></h1>
        <h2>
         <ul class="sidebar-menu" data-widget="tree">
         <li>
                        <a href="user/list">Users List</a>
         </li>
        
         <li>
                       <a href="teacher/list">Teachers List</a>
        	&nbsp;&nbsp;&nbsp;
         </li>
         <li>
                       <a href="student/list">Students List</a>
        	&nbsp;&nbsp;&nbsp;
         </li>
        	
        	<li>   	
        	
        	<a href="subject/list">Subjects List</a>
        	&nbsp;&nbsp;&nbsp;
        	</li>
        	<li>
        	<a href="classes/list">Classes List</a>
        	&nbsp;&nbsp;&nbsp;
        	</li>
        	<li>
        	<a href="assignsub">Assign Subject to a Class</a>
        	&nbsp;&nbsp;&nbsp;
        	</li>
        	<li>
        	<a href="assignteacher">Assign Teacher to a Class and Subject</a>
        	&nbsp;&nbsp;&nbsp;
        	</li>
        	<li>
        	<a href="assignstudent">Assign Student to a Class</a>
        	&nbsp;&nbsp;&nbsp;
        	</li>
        	</ul>
        </h2>
	
 	
</body>
</html>
