<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Student Management Application</title>
</head>
<body>

 <a href="../home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
	<center>
		<h1>Student Management</h1>
        <h2>
        	<a href="new">Add New Student</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Students</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${student != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${student == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${student!= null}">
            			Edit Student
            		</c:if>
            		<c:if test="${student == null}">
            			Add New Student
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${student!= null}">
        			<input type="hidden" name="id" value="<c:out value='${student.studentId}' />" />
        		</c:if>            
            <tr>
                <th>Student Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${student.studentName}' />"
                		/>
                </td>
            </tr>
            
            <tr>
                <th>Student Mobile: </th>
                <td>
                	<input type="text" name="mobile" size="15"
                			value="<c:out value='${student.mobileNumber}' />"
                	/>
                </td>
            </tr>
            
            <tr>
                <th>Student Email: </th>
                <td>
                	<input type="text" name="email" size="45"
                			value="<c:out value='${student.studentEmail}' />"
                	/>
                </td>
            </tr>
                         
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
