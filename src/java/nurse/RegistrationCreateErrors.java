package nurse;

import java.io.Serializable;

/**
 * Represents errors that can occur during nurse registration.
 */
public class RegistrationCreateErrors implements Serializable {
    private String userIDLengthErr;
    private String fullNameLengthErr;
    private String ageLengthErr;  // Changed type to String
    private String addressLengthErr;
    private String phoneLengthErr;
    private String staffIDErr;
    private String departmentLengthErr;
    private String shiftErr;  // Changed from ShiftErr to shiftErr for consistency
    private String salaryErr;  // Changed type to String
    private String passwordLengthErr;  // Corrected typo in variable name
    private String confirmLengthErr;
    private String userIDIsExisted;

    // Removed the unsupported constructor

    public RegistrationCreateErrors() {
        // Default constructor
    }

    public String getUserIDIsExisted() {
        return userIDIsExisted;
    }

    public void setUserIDIsExisted(String userIDIsExisted) {
        this.userIDIsExisted = userIDIsExisted;
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

    public String getAgeLengthErr() {
        return ageLengthErr;
    }

    public void setAgeLengthErr(String ageLengthErr) {
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
        return shiftErr;
    }

    public void setShiftErr(String shiftErr) {
        this.shiftErr = shiftErr;
    }

    public String getSalaryErr() {
        return salaryErr;
    }

    public void setSalaryErr(String salaryErr) {
        this.salaryErr = salaryErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getConfirmLengthErr() {
        return confirmLengthErr;
    }

    public void setConfirmLengthErr(String confirmLengthErr) {
        this.confirmLengthErr = confirmLengthErr;
    }
}
