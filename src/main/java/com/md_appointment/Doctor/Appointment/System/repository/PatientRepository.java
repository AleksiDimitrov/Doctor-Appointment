package com.md_appointment.Doctor.Appointment.System.repository;

import com.md_appointment.Doctor.Appointment.System.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

}
