package com.md_appointment.Doctor.Appointment.System.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Appointments")
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Date date;
    private Time time;
    private int patientId;
    private int doctorId;



    public Long getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (ID != null ? !ID.equals(that.ID) : that.ID != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return time != null ? time.equals(that.time) : that.time == null;
    }

    @Override
    public int hashCode() {
        int result = ID != null ? ID.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "ID=" + ID +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
