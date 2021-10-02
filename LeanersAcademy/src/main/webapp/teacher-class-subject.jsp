<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.swaraj.model.Subject"%>
<%@page import="com.swaraj.model.Classes"%>
<%@page import="com.swaraj.model.Teacher"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign teacher to a class for the subject</title>
</head>
<body>
<a href="home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
<div align="center">
    <h2>Assign teacher to a class for the subject</h2>
    <form action="assignTeacherToAClass" method="post">
        Select a Teacher:&nbsp;
<select name="teacher"  style="width: 100px;">
   <%
    List<Teacher> teachersList=(ArrayList<Teacher>)request.getAttribute("listTeacher");
    for(int i=0;i<teachersList.size();i++){
    	%>
    	<option  value="<%=teachersList.get(i).getId()%>"  ><%=teachersList.get(i).getTeacherName()%></option>
    <%} %>
		  
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

 Select a Subject:&nbsp;
        <select name="subject"  style="width: 100px;"> 
    <%
    List<Subject> subList=(ArrayList<Subject>)request.getAttribute("listSubject");
    for(int i=0;i<subList.size();i++){
    	%>
    	<option  value="<%=subList.get(i).getId()%>"  ><%=subList.get(i).getSubjectName()%></option>
    <%} %>
		 
     </select>
        <br/><br/>
        <input type="submit" value="Submit" />
    </form>
</div>




</body>
</html>