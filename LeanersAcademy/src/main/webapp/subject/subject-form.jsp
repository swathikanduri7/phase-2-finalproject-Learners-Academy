<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Manage Subjects</title>
</head>
<body>

 <a href="../home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
	<center>
		<h1>Manage Subjects</h1>
        <h2>
        	<a href="new">Add New Subject</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Subjects</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${subject != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${subject == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${subject != null}">
            			Edit Subject
            		</c:if>
            		<c:if test="${subject == null}">
            			Add New Subject
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${subject != null}">
        			<input type="hidden" name="id" value="<c:out value='${subject.id}' />" />
        		</c:if>            
            <tr>
                <th>Subject Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${subject.subjectName}' />"
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