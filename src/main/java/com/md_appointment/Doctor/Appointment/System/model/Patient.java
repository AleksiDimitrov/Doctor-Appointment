package com.md_appointment.Doctor.Appointment.System.model;

import javax.persistence.*;

@Entity
@Table(name = "Patient")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="email", column=@Column(name="email")),
        @AttributeOverride(name="name", column=@Column(name="name")),
        @AttributeOverride(name="password", column=@Column(name="password"))

})
public class Patient extends User{

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "age", nullable = false)
    private int age;

    public Patient(String email, String name, String password, String sex, int age) {
        super(email, name, password);
        this.sex = sex;
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Patient patient = (Patient) o;

        if (age != patient.age) return false;
        return sex != null ? sex.equals(patient.sex) : patient.sex == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
