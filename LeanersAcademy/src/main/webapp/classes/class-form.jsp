<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Class Management Application</title>
</head>
<body>

 <a href="../home">HOME PAGE</a>
        	&nbsp;&nbsp;&nbsp
	<center>
		<h1>Class Management</h1>
        <h2>
        	<a href="new">Add New Class</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Classes</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${class != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${class == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${class != null}">
            			Edit Class
            		</c:if>
            		<c:if test="${class == null}">
            			Add New Class
            		</c:if>
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
