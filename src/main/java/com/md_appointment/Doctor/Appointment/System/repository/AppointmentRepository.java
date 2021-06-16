package com.md_appointment.Doctor.Appointment.System.repository;

import com.md_appointment.Doctor.Appointment.System.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Long> {

}
