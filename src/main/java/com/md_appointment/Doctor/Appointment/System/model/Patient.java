package com.md_appointment.Doctor.Appointment.System.model;

import javax.persistence.*;

@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long ID;

    @Column(name = "email",nullable = false,unique = true, length = 50)
    private String email;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "password", nullable = false, length = 30)
    private String password;


    public Patient(){}


    public Long getID() {
        return ID;
    }

    public String getName(){
        return name;
  }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getPassword() {

        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (age != patient.age) return false;
        if (ID != null ? !ID.equals(patient.ID) : patient.ID != null) return false;
        if (name != null ? !name.equals(patient.name) : patient.name != null) return false;
        if (sex != null ? !sex.equals(patient.sex) : patient.sex != null) return false;
        if (password != null ? !password.equals(patient.password) : patient.password != null) return false;
        return email != null ? email.equals(patient.email) : patient.email == null;
    }

    @Override
    public String
    toString() {
        return "Patient{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
