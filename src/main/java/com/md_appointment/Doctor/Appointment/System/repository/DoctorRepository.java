package com.md_appointment.Doctor.Appointment.System.repository;

import com.md_appointment.Doctor.Appointment.System.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    @Query(value = "SELECT * FROM Doctor WHERE name = :name ", nativeQuery = true)
    Doctor findDoctorByName(@Param("name") String name);

    @Query(value = "Select * FROM Doctor WHERE department = :department",nativeQuery = true)
    List<Doctor> getDoctorsFromDepartment(@Param("department") String department);

    @Query(value = "SELECT id FROM Doctor WHERE name = :name",nativeQuery = true)
    Long getDoctorId(@Param("name") String name);

    @Query(value = "DELETE FROM Doctor WHERE email =:email",nativeQuery = true)
    void deleteDoctorByEmail(@Param("email")String email);

}
