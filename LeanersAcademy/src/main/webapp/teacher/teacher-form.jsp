<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Teacher Management</title>
</head>
<body>
 <a href="../home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
	<center>
		<h1>Teacher Management</h1>
        <h2>
        	<a href="new">Add New Teacher</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Teachers</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${teacher != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${teacher == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${teacher != null}">
            			Edit User
            		</c:if>
            		<c:if test="${teacher == null}">
            			Add New Teacher
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${teacher != null}">
        			<input type="hidden" name="id" value="<c:out value='${teacher.id}' />" />
        		</c:if>            
            <tr>
                <th>Teacher Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${teacher.teacherName}' />"
                		/>
                </td>
            </tr>
            
             <tr>
                <th>Teacher Qualification: </th>
                <td>
                	<input type="text" name="qualification" size="15"
                			value="<c:out value='${teacher.qualification}' />"
                	/>
                </td>
            </tr>
            
            
            <tr>
                <th>Teacher Email: </th>
                <td>
                	<input type="text" name="email" size="45"
                			value="<c:out value='${teacher.teacherEmail}' />"
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
