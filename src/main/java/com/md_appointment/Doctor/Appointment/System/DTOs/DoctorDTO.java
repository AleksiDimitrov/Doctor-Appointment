package com.md_appointment.Doctor.Appointment.System.DTOs;


public class DoctorDTO {

    private String email;
    private String name;
    private String department;
    private String password;

    public DoctorDTO(){

    }
    public DoctorDTO(String email, String department, String name, String password) {
        this.email = email;
        this.name = name;
        this.department = department;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
