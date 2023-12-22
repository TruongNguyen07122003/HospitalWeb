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
@WebServlet(name = "DeleteAccountServlet", urlPatterns = {"/DeleteAccountServlet"})
public class DeleteAccountServlet extends HttpServlet {

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
        String username = request.getParameter("pk");
        String searchValue = request.getParameter("lastSearchValue");
        String url = ERROR_PAGE;
//        String preButton = (String) getServletContext().getAttribute("preButton");
        
        
        try {
            /* TODO output your page here. You may use following sample code. */
            //2.call DAO
            //2.1 new DAO
            String preButton = (String) getServletContext().getAttribute("preButton");
            NurseDAO dao = new NurseDAO();
            //2.2 call method of DAO
            boolean result = dao.deleteAccount(username);
            //3.process result
            if (result) {
                
                // Lấy giá trị của preButton từ ServletContext
            

            if ("Display All Nurse".equals(preButton)) {
                // Nếu preButton là Display All Nurse, sử dụng URL với btAction là Display All Nurse
                url = "DispatchServlet?btAction=Display All Nurse";
            }
             else {
                    // Nếu btAction không phải là Display All Nurse, sử dụng URL với btAction là Search và thêm txtSearchValue
                    url = "DispatchServlet?btAction=Search&txtSearchValue=" + searchValue;
                }
            }

    

        }catch(NamingException ex){
            ex.printStackTrace();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace(); 
        }finally{
            //khi res.dis thi se tra ve 2 btAction cua searchdis va
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
