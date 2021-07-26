package com.md_appointment.Doctor.Appointment.System.model;


import javax.persistence.*;

@Entity
@Table(name = "Receptionist")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="email", column=@Column(name="email")),
        @AttributeOverride(name="name", column=@Column(name="name")),
        @AttributeOverride(name="password", column=@Column(name="password"))

})
public class Receptionist extends User{


    public Receptionist(String email, String name, String password) {
        super(email, name, password);
    }

}
