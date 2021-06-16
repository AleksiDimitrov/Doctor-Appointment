package com.md_appointment.Doctor.Appointment.System.repository;

import com.md_appointment.Doctor.Appointment.System.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {

}
