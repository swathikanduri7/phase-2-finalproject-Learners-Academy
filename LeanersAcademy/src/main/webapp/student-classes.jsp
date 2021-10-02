<%@page import="com.swaraj.model.Student"%>
<%@page import="com.swaraj.model.Classes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Student to a Class</title>
</head>
<body>
<a href="home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
<div align="center">
    <h2>Assign Student to a Class</h2>
    <form action="assignStudentToAClass" method="post">
        Select a Student:&nbsp;
       
      <select name="student"  style="width: 100px;"> 
    <%
    List<Student> subList=(ArrayList<Student>)request.getAttribute("listStudent");
    for(int i=0;i<subList.size();i++){
    	%>
    	<option  value="<%=subList.get(i).getStudentId()%>"  ><%=subList.get(i).getStudentName()%></option>
    <%} %>
		  <%-- <c:forEach var="subject1" items="${listSubject}">		   
		        <option  value="${subject1.id}"  ><c:out value="${subject1.subjectName}"/></option>
		   </c:forEach> --%> 
     </select>
     


       Select a Class:&nbsp;
       <select name="classes"  style="width: 100px;">

   <%
    List<Classes> classesList=(ArrayList<Classes>)request.getAttribute("listClass");
    for(int i=0;i<classesList.size();i++){
    	%>
    	<option  value="<%=classesList.get(i).getClassId()%>"  ><%=classesList.get(i).getClassName()%></option>
    <%} %>
		  
       </select>
        <br/><br/>
        <input type="submit" value="Submit" />
    </form>
</div>




</body>
</html>