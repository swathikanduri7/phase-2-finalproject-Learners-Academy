<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Login</title>
	
	</head>
<body background="image1.jpg">

	<center>
		<h1>Login</h1>
       
	</center>
    <div align="center">
	<form action="loginprocess" method="post">  
        <table border="1" cellpadding="5">
                    
            <tr>
                <th>User Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${user.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>User Password: </th>
                <td>
                	<input type="password" name="password" size="45"
                			value="<c:out value='${user.password}' />"
                	/>
                </td>
            </tr>
           
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Login" />
            		&nbsp;&nbsp<a href="user/new">Register User</a>
            	</td>
            	
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
