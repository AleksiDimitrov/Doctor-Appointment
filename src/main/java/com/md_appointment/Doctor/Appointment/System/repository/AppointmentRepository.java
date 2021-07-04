package com.md_appointment.Doctor.Appointment.System.repository;

import com.md_appointment.Doctor.Appointment.System.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    @Query(value = "SELECT * FROM Appointment WHERE doctor_id = :doctor_id",nativeQuery = true)
    List<Appointment> listDoctorAppointments(@Param("doctor_id") Long doctor_id);
}
