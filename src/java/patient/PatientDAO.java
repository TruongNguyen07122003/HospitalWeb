/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import patient.PatientDTO;
import util.DBHelper;
import java.sql.Timestamp;
/**
 *
 * @author GIGABYTE
 */
public class PatientDAO {
    private List<PatientDTO> accounts;

    public List<PatientDTO> getAccounts() {
        return accounts;
    }

   

// ...

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
            String sql = "SELECT id, name, age, gender, address, phone, diagnosis, admissionDate, dischargeDate "
                    + "FROM Patient "
                    + "WHERE name LIKE ?";
            //3.Create StatementObject
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchValue + "%");
            //4.Execute Query
            rs = stm.executeQuery();
            //5.Process
            while (rs.next()) {
                //5.1 Get data from rs
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String diagnosis = rs.getString("diagnosis");

                // Convert timestamp to Timestamp object
                Timestamp admissionDate = rs.getTimestamp("admissionDate");
                Timestamp dischargeDate = rs.getTimestamp("dischargeDate");

                //5.2 Set data into DTO
                PatientDTO dto = new PatientDTO(id, name, age, gender, address, phone, diagnosis, admissionDate, dischargeDate);

                //5.3 Add DTO into List (assuming accounts is a List<PatientDTO>)
                if (this.accounts == null) {
                    this.accounts = new ArrayList<>();
                }
                this.accounts.add(dto);
            }
        }
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
                        + "FROM Patient ";
                        
                //3.Create StatementObject
                stm = con.prepareStatement(sql);
               
                //4.Execute Querry
                rs = stm.executeQuery();
                //5.Process
                while (rs.next()) {
                    //5.1 get data from rs
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String gender = rs.getString("gender");
                    String address = rs.getString("address");
                    String phone = rs.getString("phone");
                    String diagnosis = rs.getString("diagnosis");

                    // Convert timestamp to Timestamp object
                    Timestamp admissionDate = rs.getTimestamp("admissionDate");
                    Timestamp dischargeDate = rs.getTimestamp("dischargeDate");

                //5.2 Set data into DTO
                PatientDTO dto = new PatientDTO(id, name, age, gender, address, phone, diagnosis, admissionDate, dischargeDate);
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
}
