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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nurse.RegistrationCreateErrors;
import nurse.NurseDAO;
import nurse.NurseDTO;

/**
 *
 * @author GIGABYTE
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String USER_LENGTH_ERROR = "Nurse ID is must be formed :Nxxxxxx";
    private final String PASSWORD_LENGTH_ERROR = "Password need to be from 5 to 30 charaters";
    private final String CONFRIM_ERRORS = "confirm not matched password";
    private final String FULLNAME_LENGTH_ERROR = "fullname errors";
    private final String CREATE_ERROR_PAGE = "createAccount.jsp";
    private final String USER_EXISTED_ERRORS = "Nurse ID is existed";
    private final String RESULT_SEARCH_PAGE = "search.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String updateIDParam = request.getParameter("id");
        int id = (updateIDParam != null && !updateIDParam.isEmpty()) ? Integer.parseInt(updateIDParam) : 0;

        String updateAgeParam = request.getParameter("age");
        int age = (updateAgeParam != null && !updateAgeParam.isEmpty()) ? Integer.parseInt(updateAgeParam) : 0;

        String updateSalaryParam = request.getParameter("salary");
        double salary = (updateSalaryParam != null && !updateSalaryParam.isEmpty()) ? Double.parseDouble(updateSalaryParam) : 0.0;
        
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirmPassword");
        String staffID = request.getParameter("staffID");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String department = request.getParameter("department");
        String shift = request.getParameter("shift");
        RegistrationCreateErrors err = new RegistrationCreateErrors();
        
        boolean foundErr = false;
        String url = CREATE_ERROR_PAGE;
        
        try {
            //2. verify all user's errors
            if (!staffID.matches("N\\d{6}")) {
                foundErr = true;
                err.setUserIDLengthErr(USER_LENGTH_ERROR);
            }
            if(password.trim().length() < 5 || password.trim().length() > 30){
                foundErr = true;
                err.setPasswordLengthErr(PASSWORD_LENGTH_ERROR);
            }else if (!confirm.trim().equals(password.trim())){
                foundErr = true;
                err.setConfirmLengthErr(CONFRIM_ERRORS);
            }if(username.trim().length() < 2 || username.trim().length() > 50){
                foundErr = true;
                err.setFullNameLengthErr(FULLNAME_LENGTH_ERROR);
            }
            if(foundErr){//error occur
                //cache to attribute then fw page to display
                request.setAttribute("CREATE_ERRORS", err);
            }else{
                //call DAO
                //3.1 new DAO
                NurseDAO dao = new NurseDAO();
              
               

                //3.2 call method of DAO
                NurseDTO dto = new NurseDTO(id, username,age, gender, address, phone, staffID, shift, department,password, salary); 
                System.out.println("DTO values: " + dto);
                System.out.println("da khoi tao dto de nhet vao dao");
                boolean result = dao.createAccount(dto);
                System.out.println("da add thanh cong vao dao");
                //4.process result
                if(result){
                    url = RESULT_SEARCH_PAGE;
                }
            }
            
        }catch (SQLException ex) {
            String errMsg = ex.getMessage();
            log("CreateAccountServlet _ SQL: " + errMsg);
            if(errMsg.contains("duplicate")) {
                err.setUserIDIsExisted(username + USER_EXISTED_ERRORS);
                request.setAttribute("CREATE_ERRORS", err);
            }
        } catch (NamingException ex) {
            log("CreateAccountServlet _ Naming: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("CreateAccountServlet _ ClassNotFound: " + ex.getMessage());
        } finally {
            //response tra ve co mat hay khong
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
