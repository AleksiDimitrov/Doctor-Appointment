package com.md_appointment.Doctor.Appointment.System.model;


import javax.persistence.*;

@Entity
@Table(name = "Doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(name = "email",nullable = false,unique = true, length = 50)
    private String email;

    @Column(name = "name",nullable = false, length = 50)
    private String name;

    @Column(name = "department",nullable = false, length = 20)
    private String department;

    @Column(name = "password",nullable = false, length = 30)
    private String password;


    public Doctor() {
    }

    public Doctor(Long ID, String name, String department, String email) {
        this.ID = ID;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public Long getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (ID != null ? !ID.equals(doctor.ID) : doctor.ID != null) return false;
        if (name != null ? !name.equals(doctor.name) : doctor.name != null) return false;
        if (department != null ? !department.equals(doctor.department) : doctor.department != null) return false;
        return email != null ? email.equals(doctor.email) : doctor.email == null;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "ID=" + ID +
                ", fullName='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
