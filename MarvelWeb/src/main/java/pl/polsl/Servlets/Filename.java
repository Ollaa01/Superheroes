/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.Servlets;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.polsl.Model.Model;

/**
 * Servlet using for taking file name from user and next creating Model.
 * @author  Aleksandra Rusek
 * @version 1.0
 */
@WebServlet("/getFromFile")
public class Filename extends HttpServlet {
    /**
     * Field containg string containing message throwing with exception.
     */
    String exc;
    /**
     * Field containing fileName.
     */
    String fileName;
    /**
     * Field containing Model from MVC.
     */
    Model model = new Model();
    /**
     * Field containing value of unseccesfull path.
     */
    int badTry = 0;
    
    /**
     * Process request for GET and POST method. Taking file name from user, throwing an exeption when not properly. Using cookies to count number of unsuccesfull try. Redirecting to jsp file to show results.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        fileName = request.getParameter("dataFile");
        ServletContext application = getServletConfig().getServletContext();
        String filePath = application.getRealPath(fileName);
        if(!fileExists(filePath)) {
           badTry ++;
           exc = "Bad Path. File doesn't exist! ";
           Cookie cookie = new Cookie("unsuccesfullTry", String.valueOf(badTry));
           response.addCookie(cookie);
           request.setAttribute("badTry", badTry);
           request.setAttribute("mess", exc);
           RequestDispatcher rd=request.getRequestDispatcher("exception.jsp"); 
           rd.forward(request, response);  
        } else {
         try {
        Reader in = new FileReader(filePath);
        this.getServletContext().setAttribute("model", model);
        response.sendRedirect("checkpath.jsp");
        model.readData(in);
          } catch (IOException e ) {
           badTry ++;
           exc = "Bad Path. Remember value can't be empty and file must exist! ";
           Cookie cookie = new Cookie("unsuccesfullTry", String.valueOf(badTry));
           response.addCookie(cookie);
           request.setAttribute("badTry", badTry);
           request.setAttribute("mess", exc);
           RequestDispatcher rd=request.getRequestDispatcher("exception.jsp"); 
           rd.forward(request, response);   
    }   
    }
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
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /**
     * Function checking if filePath exist.
     * @param filePath
     * @return value if file exist.
     */
      private boolean fileExists(String filePath) {
        return filePath != null 
                && Files.exists(Path.of(filePath)) 
                && !Files.isDirectory(Path.of(filePath));
    }
}


