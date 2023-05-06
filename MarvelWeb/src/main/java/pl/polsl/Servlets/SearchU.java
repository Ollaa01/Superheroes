/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.polsl.Model.Model;
import pl.polsl.Model.OwnException;

/**
 * Servlet using for searching for superhero with universes inserted by user.
 * @author  Aleksandra Rusek
 * @version 1.0
 */
@WebServlet("/searchU")
public class SearchU extends HttpServlet {
    /**
     * String containing inserted by user universes.
     */
    String universes;
     /**
     * Process request for GET and POST method. Getting inserted by user data and searching superheroes with that universes. Redirecting to jsp file to show results.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = (Model) this.getServletContext().getAttribute("model");
        universes = request.getParameter("dataFile6");
        String[] parts =universes.split(",");
         try {
         model.checkString(universes);
         } catch(OwnException e) {
           String exc = e.getMessage() + " ";
           request.setAttribute("mess", exc);
           RequestDispatcher rd=request.getRequestDispatcher("exceptionEmpty.jsp"); 
           rd.forward(request, response);
         }
         model.searchSuperheroByUni(parts);
         request.setAttribute("showF",model);
         RequestDispatcher rd=request.getRequestDispatcher("showFilter.jsp"); 
         rd.forward(request, response);
    }
     /**
     * Handles the GET method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    processRequest(request, response); 
    }
    /**
     * Handles the POST method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    processRequest(request, response); 
    }
    
}

