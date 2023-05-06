<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
 <h1>MENU: </h1>
 <form action="showAllS" >
            <input type="submit" value="Show All heroes" />
        </form>
  <form action="showMost" >
            <input type="submit" value="Show superheroes with the most superpowers" />
        </form> 
        <form action="showSorted" >
            <input type="submit" value="Show superheroes sorted by superpowers" />
        </form> 
        <form action="showNUS" >
            <input type="submit" value="Show superheroes name and universe" />
        </form> 
        <form action="searchU" >
            <p>Type Universes:<input type=text size=20 name=dataFile6 ></p>
            <input type="submit" value="Search for superheroes with insert universes" />
        </form> 
        <form action="searchT">
            <p>Type Types:<input type=text size=20 name=dataFile8 ></p>
            <input type="submit" value="Search for superheroes with insert type" />
        </form> 
</body>
</html>
