/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

/**
 *
 * @author GIGABYTE
 */
public class PatientDTO {
    protected int id;
    protected String name;
    protected int age;
    protected String address;
    protected String phone;
    protected String diagnosis;
    protected String admissionDate;
    protected String dischargeDate;

    public PatientDTO(int id, String name, int age, String address, String phone, String diagnosis, String admissionDate, String dischargeDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.diagnosis = diagnosis;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
    }

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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
    
}
