<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details in the table</title>
</head>
<body>
<%List<Student> s=(List<Student>)request.getAttribute("list"); %>
<table border="1">
<tr><th>Sno</th><th>Sname</th><th>Semail</th><th>Sphono</th><th>Edit operation</th><th>Delete Operation</th></tr>
<%for(Student ss:s){ %>
<tr><td><%=ss.getSid() %></td><td><%=ss.getName() %></td><td><%=ss.getEmail() %></td><td><%=ss.getPhoneno() %></td><td><a href="./edit.jsp">edit</a></td><td><a href="./delete.jsp">delete</a></td></tr>
<%} %>
</table>
</body>
</html>

