package nurse;

import java.io.Serializable;

public class NurseDTO implements Serializable {

    protected int id;
    protected String name;
    protected int age;
    protected String gender;
    protected String address;
    protected String phone;
    protected String staffID;
    protected String department;
    protected String shift;
    protected double salary;
    protected String password;
    protected boolean isAdmin;

    // Constructors
    public NurseDTO() {
    }

    // Constructor with staffID, name, and isAdmin parameters
    public NurseDTO(String staffID, String name, boolean isAdmin) {
        this.staffID = staffID;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public NurseDTO(int id, String name, int age, String gender, String address, String phone, String staffID,
                    String department, String shift,String password, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.password = password;
        this.salary = salary;
    }

    public NurseDTO(int id, String name, int age, String gender, String address, String phone, String staffID,
                    String department, String shift, double salary, String password, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.staffID = staffID;
        this.department = department;
        this.shift = shift;
        this.salary = salary;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and setter for isAdmin
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    public boolean getIsAdmin() {
        return isAdmin;
    }
}
