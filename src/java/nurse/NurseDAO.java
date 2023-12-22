/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nurse;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import util.DBHelper;

/**
 *
 * @author GIGABYTE
 */
public class NurseDAO  implements Serializable{
   
        public NurseDTO checkLogin(String staffID, String password)
               throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
//        boolean result = false;
        NurseDTO result = null;

        try {
            //1.Create Connection
            con = DBHelper.createConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "SELECT name, isAdmin "
                        + "FROM Nurse "
                        + "WHERE staffID = ? "
                        + "AND password = ?";
//                String sql = " SELECT name FROM Nurse WHERE staffID = 'N000001' AND password = '12345';";
                //3.Create StatementObject
                stm = con.prepareStatement(sql);
                stm.setString(1, staffID);
                stm.setString(2, password);
                //4.Execute Querry
                rs = stm.executeQuery();
                //5.Process
                if (rs.next()) {
                     //mapping
                    //5.1 get data from result set
                    
                    String fullName = rs.getString("name");
                    boolean isAdmin = rs.getBoolean("isAdmin");
                    //5.2set data to DTO
                    
                    result = new NurseDTO(staffID, fullName, isAdmin);
                    //result = true;
                }//end username and password are existed
            }//end connection is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    private List<NurseDTO> accounts;

    public List<NurseDTO> getAccounts() {
        return accounts;
    }

    public void searchLastName(String searchValue)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1.Create Connection
            con = DBHelper.createConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "SELECT id, name, age, gender, address, phone, staffID, department, shift, salary "
                        + "FROM Nurse "
                        + "WHERE name Like ?";
                //3.Create StatementObject
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4.Execute Querry
                rs = stm.executeQuery();
                //5.Process
                while (rs.next()) {
                    //5.1 get data from rs
                    String username = rs.getString("name"); //lay tu cau lenh SQL o tren
                    int id = rs.getInt("id");
                    int age = rs.getInt("age");
                    String gender = rs.getString("gender");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    String staffID = rs.getString("staffID");
                    String department = rs.getString("staffID");
                    String shift = rs.getString("shift");
                    String password=rs.getString("password");
                    double salary = rs.getDouble("salary");
                    
                    
                    //5.2 set data into DTO
                    NurseDTO dto = new NurseDTO(id, username, age, gender, address, phone, staffID, department, shift,password, salary);
                    //5.3 add DTO into List
                    if (this.accounts == null) {
                        this.accounts = new ArrayList<>();
                    }//end accounts had NOT existed
                    this.accounts.add(dto);
                }
            }//end username and password are existed
        }//end connection is available
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    public void displayAll()
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1.Create Connection
            con = DBHelper.createConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "SELECT *"
                        + "FROM Nurse ";
                        
                //3.Create StatementObject
                stm = con.prepareStatement(sql);
               
                //4.Execute Querry
                rs = stm.executeQuery();
                //5.Process
                while (rs.next()) {
                    //5.1 get data from rs
                    String username = rs.getString("name"); //lay tu cau lenh SQL o tren
                    int id = rs.getInt("id");
                    int age = rs.getInt("age");
                    String gender = rs.getString("gender");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    String staffID = rs.getString("staffID");
                    String department = rs.getString("staffID");
                    String shift = rs.getString("shift");
                    String password = rs.getString("password");
                    double salary = rs.getDouble("salary");
                    
                    
                    //5.2 set data into DTO
                    NurseDTO dto = new NurseDTO(id, username, age, gender, address, phone, staffID, department, shift, password, salary);
                    //5.3 add DTO into List
                    if (this.accounts == null) {
                        this.accounts = new ArrayList<>();
                    }//end accounts had NOT existed
                    this.accounts.add(dto);
                }
            }//end username and password are existed
        }//end connection is available
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }


    public boolean deleteAccount(String username)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;

        try {
            //1.Create Connection
            con = DBHelper.createConnection();
            if (con != null) {
                //2.Create SQL String
                String sql = "DELETE FROM Nurse "
                        + "WHERE staffID = ?";
                //3.Create StatementObject
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                //4.Execute Querry
                int effectiveRows = stm.executeUpdate();
                //5.Process
                if (effectiveRows > 0) {
                    result = true;
                }
            }//end connection is available
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    

    public boolean updateAccount(String staffID, boolean isAdmin, int id, String name, int age, String gender, String address, String phone, String department, String shift, double salary, String password)
        throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Create Connection
            con = DBHelper.createConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "UPDATE Nurse "
                        + "SET id = ?, "
                        + "name = ?, "
                        + "age = ?, "
                        + "gender = ?, "
                        + "address = ?, "
                        + "phone = ?, "
                        + "isAdmin = ?, "
                        + "department = ?, "
                        + "shift = ?, "
                        + "salary = ?, "
                        + "password = ? "
                        + "WHERE staffID = ?";
                //3. Create StatementObject
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                stm.setString(2, name);
                stm.setInt(3, age);
                stm.setString(4, gender);
                stm.setString(5, address);
                stm.setString(6, phone);
                stm.setBoolean(7, isAdmin);
                stm.setString(8, department);
                stm.setString(9, shift);
                stm.setDouble(10, salary);
                stm.setString(11, password);
                stm.setString(12, staffID);

                //4. Execute Query
                int effectiveRows = stm.executeUpdate();
                //5. Process Result
                if (effectiveRows > 0) {
                    result = true;
                }
            }//end connection is available
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }


//    
    public boolean createAccount(NurseDTO account)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. Create Connection
            con = DBHelper.createConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "INSERT Into Nurse("
                        +"id, name, age, gender, address, phone, staffID, department, shift, salary, password, isAdmin"
                        +") Values ("
                        +"?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
                        +")";
                //3. Create StatementObject
                stm = con.prepareStatement(sql);
                stm.setInt(1, account.getId());
                stm.setString(2, account.getName());
                stm.setInt(3, account.getAge());
                stm.setString(4, account.getGender());
                stm.setString(5, account.getAddress());
                stm.setString(6, account.getPhone());
                stm.setString(7, account.getStaffID());
                stm.setString(8, account.getDepartment());
                stm.setString(9, account.getShift());
                stm.setDouble(10, account.getSalary());
                stm.setString(11, account.getPassword());
                stm.setBoolean(12, account.getIsAdmin());
                
                
                
                //4. Execute Query
                int effectiveRows = stm.executeUpdate();
                //5. Process Result
                if (effectiveRows > 0) {
                    result = true;
                    System.out.println("no effect rows to create rows!");
                }
            }//end connection is available
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
//
//   //    public boolean createAccount(NurseDTO account)
//            throws SQLException, NamingException, ClassNotFoundException {
//        Connection con = null;
//        PreparedStatement stm = null;
//        boolean result = false;
//        try {
//            //1. Create Connection
//            con = DBHelper.createConnection();
//            if (con != null) {
//                //2. Create SQL String
//                String sql = "INSERT Into Registration("
//                        +"username, password, lastname, isAdmin"
//                        +") Values ("
//                        +"?, ?, ?, ?"
//                        +")";
//                //3. Create StatementObject
//                stm = con.prepareStatement(sql);
//                stm.setString(1, account.getUsername());
//                stm.setString(2, account.getPassword());
//                stm.setString(3, account.getFullName());
//                stm.setBoolean(4, account.isRole());
//                
//                
//                //4. Execute Query
//                int effectiveRows = stm.executeUpdate();
//                //5. Process Result
//                if (effectiveRows > 0) {
//                    result = true;
//                    System.out.println("no effect rows to create rows!");
//                }
//            }//end connection is available
//        } finally {
//            if (stm != null) {
//                stm.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//        return result;
//    }
//}
//
//
