<%@page import="java.util.List"%>
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
  ArrayList<String> listT = (ArrayList)session.getAttribute("listT");
  out.print("Searching types in this session: <br>");
  if(listT == null) {out.print("none");}
  else {
  for(int i = 0; i< listT.size(); i++) {
    if(listT.get(i).isBlank() || listT.get(i).isEmpty() || listT.get(i) == null) {}
    else {out.print(listT.get(i) + "<br>");}
    }
  }
  out.print("<br>"); 
%>
  <h1>Superheroes:</h1>
<%
  Model model=(Model)request.getAttribute("showF");
  List<Superhero> sp;
  sp = model.getFilteredSuperhero();
  for(int i = 0; i < sp.size(); i++) {
  str = sp.get(i).toString();
  out.print(str);
  out.print("<br>");
    }
 %>
</body>
</html>
