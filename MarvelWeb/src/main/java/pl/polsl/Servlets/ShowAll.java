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

/**
 * Servlet using for showing all superheroes.
 * @author  Aleksandra Rusek
 * @version 1.0
 */
@WebServlet("/showAllS")
public class ShowAll extends HttpServlet {
     /**
     * Process request for GET and POST method. Using for showing all superheroes. Redirecting to jsp file to show results.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Model model = (Model) this.getServletContext().getAttribute("model");
         request.setAttribute("modelA",model);
         RequestDispatcher rd=request.getRequestDispatcher("showAll.jsp"); 
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
