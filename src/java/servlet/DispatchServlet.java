/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.MyApplicationConstants;

/**
 *
 * @author GIGABYTE
 */
public class DispatchServlet extends HttpServlet {
//    private final String LOGIN_PAGE = "login.html";
////    private final String LOGIN_CONTROLLER = "search.html";
//    private final String LOGIN_CONTROLLER = "LoginServlet";
//    private final String SEARCH_LASTNAME_CONTROLLER = "SearchLastNameServlet";
//    private final String DELETE_ACCOUNT_CONTROLLER = "DeleteAccountServlet";
//    private final String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountServlet"; 
//      public String preButton;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //0.get current context
        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties)context.getAttribute("SITEMAPS");
        
        String button = request.getParameter("btAction");
       
        
        String url = siteMaps.getProperty(
                MyApplicationConstants.DispatchFeature.LOGIN_PAGE);
        
            try {
                
              
            if (button.equals("Login")) {
                url = siteMaps.getProperty(MyApplicationConstants.DispatchFeature.LOGIN_CONTROLLER);
            }if(button.equals("Search")){
                getServletContext().setAttribute("preButton", button);
                url=siteMaps.getProperty(MyApplicationConstants.DispatchFeature.SEARCH_LASTNAME_CONTROLLER);
            }if(button.equals("Display All Nurse")){
                getServletContext().setAttribute("preButton", button);
                url=siteMaps.getProperty(MyApplicationConstants.DispatchFeature.DISPLAY_ALL_CONTROLLER);
            }if(button.equals("Delete")){
                url=siteMaps.getProperty(MyApplicationConstants.DispatchFeature.DELETE_NURSE_CONTROLLER);
            }if(button.equals("Create New Nurse Account")){
                url=siteMaps.getProperty(MyApplicationConstants.DispatchFeature.CREATE_ACCOUNT_PAGE);
            }if(button.equals("Update")){
                url=siteMaps.getProperty(MyApplicationConstants.DispatchFeature.UPDATE_ACCOUNT_CONTROLLER);
            }if(button.equals("Create Account")){
                url=siteMaps.getProperty(MyApplicationConstants.DispatchFeature.CREATE_ACCOUNT_CONTROLLER);
            } if (button.equals("Log Out")) {
                url = siteMaps.getProperty(MyApplicationConstants.DispatchFeature.LOGOUT_CONTROLLER);
            }if (button.equals("SearchPatient")) {
                url = siteMaps.getProperty(MyApplicationConstants.DispatchFeature.SEARCH_PATIENT_CONTROLLER);
            }if (button.equals("Display All Patient")) {
                url = siteMaps.getProperty(MyApplicationConstants.DispatchFeature.DISPLAY_ALL_PATIENT_CONTROLLER);
            }
        }finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
