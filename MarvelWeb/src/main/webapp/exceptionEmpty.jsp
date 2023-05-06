<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<h1>Exception:</h1>
</head>
<body>
  <%
     String exc = (String)request.getAttribute("mess");
     out.print(exc);
 %>
  Enter to go back: 
  <button type="button" name="Go back" onclick="history.back()">back</button>
</body>
</html>
