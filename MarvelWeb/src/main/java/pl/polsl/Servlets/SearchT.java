/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.Model.Model;
import pl.polsl.Model.OwnException;


/**
 * Servlet using to show superheroes with insterted by user types.
 * @author Aleksandra Rusek
 * @version 1.0
 */
@WebServlet("/searchT")
public class SearchT extends HttpServlet {
    /**
     * List containing inserted by user types of superheroes.
     */
    ArrayList<String> sTypes;
    /**
     * String containing inserted by user type of superhero.
     */
    String types;
     /**
     * Process request for GET and POST method. Getting inserted by user data and searching superheroes with that type. Using session to show which types where searched in that session. Redirecting to jsp file to show results.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Model model = (Model) this.getServletContext().getAttribute("model");
         HttpSession session = request.getSession(true);
         types = request.getParameter("dataFile8");
         try {
         model.checkString(types);
         } catch(OwnException e) {
           String exc = e.getMessage() + " ";
           request.setAttribute("mess", exc);
           RequestDispatcher rd=request.getRequestDispatcher("exceptionEmpty.jsp"); 
           rd.forward(request, response);
         }
         if(sTypes == null || sTypes.isEmpty() == true) {
         sTypes = new ArrayList();
         }
         else {sTypes = (ArrayList<String>)session.getAttribute("listT"); 
             if(sTypes == null || sTypes.isEmpty() == true) {
         sTypes = new ArrayList();
         } 
         }
         sTypes.add(types);
         session.setAttribute("listT", sTypes);
         model.searchSuperheroByType(types);
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
