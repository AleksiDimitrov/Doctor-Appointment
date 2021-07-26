package com.md_appointment.Doctor.Appointment.System.data.transfer.objects;

public class PatientDTO extends DTO {

    private String email;
    private String name;
    private int age;
    private String sex;
    private String password;

    public PatientDTO() {
    }

    public PatientDTO(String email, String name, int age, String sex, String password) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
