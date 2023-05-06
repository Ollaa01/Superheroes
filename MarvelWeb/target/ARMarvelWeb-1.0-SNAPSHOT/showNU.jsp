<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="pl.polsl.Model.*"%>
<%   String str; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Superhero:</title>
</head>
<body>
<%
  out.print("Return to main page:");
%>
<button type="button" name="Go back" onclick="history.back()">back</button>
<%
  out.print("<br>"); 
%>
  <h1>Superheroes:</h1>
<%
  Model model=(Model)request.getAttribute("NameUni");
  ArrayList<Superhero> sp;
  sp = model.getSuperheroes();
  for(int i = 0; i < sp.size(); i++) {
  str = "Name: " + sp.get(i).getName() + " Universe(s): "+ sp.get(i).getUniverse();
  out.print(str);
  out.print("<br>");
    }
  %>
</body>
</html>