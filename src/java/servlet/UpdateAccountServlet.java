/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nurse.NurseDAO;

/**
 *
 * @author GIGABYTE
 */
@WebServlet(name = "UpdateAccountServlet", urlPatterns = {"/UpdateAccountServlet"})
public class UpdateAccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private final String ERROR_PAGE = "errors.html";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String updateIDParam = request.getParameter("updateID");
        int id = (updateIDParam != null && !updateIDParam.isEmpty()) ? Integer.parseInt(updateIDParam) : 0;

        String updateAgeParam = request.getParameter("updateAge");
        int age = (updateAgeParam != null && !updateAgeParam.isEmpty()) ? Integer.parseInt(updateAgeParam) : 0;

        String updateSalaryParam = request.getParameter("updateSalary");
        double salary = (updateSalaryParam != null && !updateSalaryParam.isEmpty()) ? Double.parseDouble(updateSalaryParam) : 0.0;

//        int id = Integer.parseInt(request.getParameter("updateID"));
        String name = request.getParameter("updateName");
//        int age = Integer.parseInt(request.getParameter("updateAge"));
        String gender = request.getParameter("updateGender");
        String address = request.getParameter("updateAddress");
        String phone = request.getParameter("updatePhone");
        String department = request.getParameter("updateDepartment");
        String staffID = request.getParameter("updateStaffID");
        String shift = request.getParameter("updateShift");
//        double salary =  Double.parseDouble(request.getParameter("updateSalary"));
        String password = request.getParameter("txtPassword");
        String searchValue = request.getParameter("lastSearchValue");
               
      
        String url = ERROR_PAGE;
        try {
            String preButton = (String) getServletContext().getAttribute("preButton");
            NurseDAO dao = new NurseDAO();
            boolean result = dao.updateAccount(id, age, salary, name, gender, address, phone, department, staffID, shift, password);
            
            if ("Display All Nurse".equals(preButton)) {
                // Nếu preButton là Display All Nurse, sử dụng URL với btAction là Display All Nurse
                if (result) {
                //refresh previous function (Search) --> using url rewriting
                url = "DispatchServlet"
                        + "?btAction=Display All Nurse";
                        
            }//end update action
            }
             else {
                    // Nếu btAction không phải là Display All Nurse, sử dụng URL với btAction là Search và thêm txtSearchValue
                    url = "DispatchServlet?btAction=Search&txtSearchValue=" + searchValue;
                }
        
        }catch(SQLException | ClassNotFoundException | NamingException ex){
            ex.printStackTrace();
        }finally{
            response.sendRedirect(url);
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
