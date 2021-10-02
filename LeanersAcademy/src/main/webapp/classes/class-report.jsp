<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Class Report</title>
</head>
<body>

 <a href="../home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
	<center>
		<h1>Class Report</h1>       
	</center>
    <div align="center">		
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		Class Report
            	</h2>
            </caption>
        		<c:if test="${class != null}">
        			<input type="hidden" name="id" value="<c:out value='${class.classId}' />" />
        		</c:if>            
            <tr>
                <th>Class Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${class.className}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Class with Section </th>
                <td>
                	<input type="text" name="section" size="45"
                			value="<c:out value='${class.classSection}' />"
                	/>
                </td>
            </tr>          
        </table>
        &nbsp;&nbsp;&nbsp;
      <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>MobileNumber</th>
                <th>Email</th>
            </tr>          
            <c:forEach var="student" items="${listStudent}">            
                    <tr>
                    <td><c:out value="${student.studentId}" /></td>
                    <td><c:out value="${student.studentName}" /></td>
                     <td><c:out value="${student.mobileNumber}" /></td>
                    <td><c:out value="${student.studentEmail}" /></td>                    
                </tr>                
                </br>         
            </c:forEach>
        </table>
    </div>
    
     <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Teachers</h2></caption>
            <tr>
                <th>ID</th>
                <th>Teacher Name</th>
                <th>Qualification</th>
                <th>Email</th>
               
            </tr>
          
            <c:forEach var="teacher" items="${listTeacher}">            
                     <tr>
                    <td><c:out value="${teacher.id}" /></td>
                    <td><c:out value="${teacher.teacherName}" /></td>
                    <td><c:out value="${teacher.qualification}" /></td>
                    <td><c:out value="${teacher.teacherEmail}" /></td>                  
                </tr>                
             </c:forEach>
        </table>
    </div>		
        
    </div>	
</body>
</html>
