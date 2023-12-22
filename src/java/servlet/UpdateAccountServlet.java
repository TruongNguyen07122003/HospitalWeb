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
    private final String UPDATE_PAGE = "update.html";
    private final String ERROR_PAGE = "errors.html";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("updateID");
        String name = request.getParameter("updateName");
        int age = Integer.parseInt(request.getParameter("updateAge"));
        String gender = request.getParameter("updateGender");
        String address = request.getParameter("updateAddress");
        String department = request.getParameter("updateDepartment");
        String staffID = request.getParameter("updateStaffID");
        String shift = request.getParameter("updateShift");
        String salary = request.getParameter("updateSalary");
        String password = request.getParameter("updatePassword");
        
        boolean isAdmin = false;
        String searchValue = request.getParameter("lastSearchValue");
        if (request.getParameter("checkAdmin") != null) {
            isAdmin = true;
        }
      
        String url = ERROR_PAGE;
        try {
            // Lưu thông tin vào request để chuyển tới update.jsp
            request.setAttribute("updateID", id);
            request.setAttribute("updateName", name);
            request.setAttribute("updateAge", age);
            request.setAttribute("updateGender", gender);
            request.setAttribute("updateAddress", address);
            request.setAttribute("updateDepartment", department);
            request.setAttribute("updateStaffID", staffID);
            request.setAttribute("updateShift", shift);
            request.setAttribute("updateSalary", salary);
            request.setAttribute("updatePassword", password);

            // Chuyển hướng tới trang update.jsp
            request.getRequestDispatcher(UPDATE_PAGE).forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
//        }
//        try {
//            NurseDAO dao = new NurseDAO();
//            boolean result = dao.updateAccount(userName, password, isAdmin);
//            if (result) {
//                //refresh previous function (Search) --> using url rewriting
//                url = "DispatchServlet"
//                        + "?btAction=Search"
//                        + "&txtSearchValue=" + searchValue;
//            }//end update action
//        }catch(SQLException | ClassNotFoundException | NamingException ex){
//            ex.printStackTrace();
//        }finally{
//            response.sendRedirect(url);
//        }
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
