package com.md_appointment.Doctor.Appointment.System.model;


import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.DoctorDTO;

import javax.persistence.*;

@Entity
@Table(name = "Doctor")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="email", column=@Column(name="email")),
        @AttributeOverride(name="name", column=@Column(name="name")),
        @AttributeOverride(name="password", column=@Column(name="password"))

})
public class Doctor extends User{

    @Column(name = "department",nullable = false, length = 20)
    private String department;


    public Doctor(DoctorDTO doctorDTO) {
        super(doctorDTO.getEmail(), doctorDTO.getName(), doctorDTO.getPassword());
        this.department = doctorDTO.getDepartment();

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Doctor doctor = (Doctor) o;

        return department != null ? department.equals(doctor.department) : doctor.department == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "department='" + department + '\'' +
                '}';
    }
}
