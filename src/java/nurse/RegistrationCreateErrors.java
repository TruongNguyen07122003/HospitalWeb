/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nurse;

import java.io.Serializable;

/**
 *
 * @author GIGABYTE
 */
public class RegistrationCreateErrors implements Serializable{
    private String userIDLengthErr; 
    private String fullNameLengthErr;
    private int ageLengthErr;
    private String addressLengthErr;
    private String phoneLengthErr;
    private String staffIDErr;
    private String departmentLengthErr;
    private String ShiftErr;
    private double salaryErr;
    private String passworrdLengthErr;
    private String confirmLengthErr;

    public RegistrationCreateErrors(String userIDLengthErr, String fullNameLengthErr, int ageLengthErr, String addressLengthErr, String phoneLengthErr, String staffIDErr, String departmentLengthErr, String ShiftErr, double salaryErr, String passworrdLengthErr, String confirmLengthErr) {
        this.userIDLengthErr = userIDLengthErr;
        this.fullNameLengthErr = fullNameLengthErr;
        this.ageLengthErr = ageLengthErr;
        this.addressLengthErr = addressLengthErr;
        this.phoneLengthErr = phoneLengthErr;
        this.staffIDErr = staffIDErr;
        this.departmentLengthErr = departmentLengthErr;
        this.ShiftErr = ShiftErr;
        this.salaryErr = salaryErr;
        this.passworrdLengthErr = passworrdLengthErr;
        this.confirmLengthErr = confirmLengthErr;
    }

    public String getUserIDLengthErr() {
        return userIDLengthErr;
    }

    public void setUserIDLengthErr(String userIDLengthErr) {
        this.userIDLengthErr = userIDLengthErr;
    }

    public String getFullNameLengthErr() {
        return fullNameLengthErr;
    }

    public void setFullNameLengthErr(String fullNameLengthErr) {
        this.fullNameLengthErr = fullNameLengthErr;
    }

    public int getAgeLengthErr() {
        return ageLengthErr;
    }

    public void setAgeLengthErr(int ageLengthErr) {
        this.ageLengthErr = ageLengthErr;
    }

    public String getAddressLengthErr() {
        return addressLengthErr;
    }

    public void setAddressLengthErr(String addressLengthErr) {
        this.addressLengthErr = addressLengthErr;
    }

    public String getPhoneLengthErr() {
        return phoneLengthErr;
    }

    public void setPhoneLengthErr(String phoneLengthErr) {
        this.phoneLengthErr = phoneLengthErr;
    }

    public String getStaffIDErr() {
        return staffIDErr;
    }

    public void setStaffIDErr(String staffIDErr) {
        this.staffIDErr = staffIDErr;
    }

    public String getDepartmentLengthErr() {
        return departmentLengthErr;
    }

    public void setDepartmentLengthErr(String departmentLengthErr) {
        this.departmentLengthErr = departmentLengthErr;
    }

    public String getShiftErr() {
        return ShiftErr;
    }

    public void setShiftErr(String ShiftErr) {
        this.ShiftErr = ShiftErr;
    }

    public double getSalaryErr() {
        return salaryErr;
    }

    public void setSalaryErr(double salaryErr) {
        this.salaryErr = salaryErr;
    }

    public String getPassworrdLengthErr() {
        return passworrdLengthErr;
    }

    public void setPassworrdLengthErr(String passworrdLengthErr) {
        this.passworrdLengthErr = passworrdLengthErr;
    }

    public String getConfirmLengthErr() {
        return confirmLengthErr;
    }

    public void setConfirmLengthErr(String confirmLengthErr) {
        this.confirmLengthErr = confirmLengthErr;
    }

}