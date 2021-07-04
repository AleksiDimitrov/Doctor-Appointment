package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.DTOs.AppointmentDTO;
import com.md_appointment.Doctor.Appointment.System.DTOs.DoctorDTO;
import com.md_appointment.Doctor.Appointment.System.model.Doctor;
import com.md_appointment.Doctor.Appointment.System.repository.DoctorRepository;
import com.md_appointment.Doctor.Appointment.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService implements IAdministratiorService{

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public AdministratorService(DoctorRepository doctorRepository,PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void addDoctorAccount(DoctorDTO doctorDTO) {
        List<Doctor> doctorList = doctorRepository.findAll();

        Doctor newDoctor = new Doctor(doctorDTO.getEmail(), doctorDTO.getPassword(), doctorDTO.getName(), doctorDTO.getDepartment());
        if(doctorList.contains(newDoctor)){
            System.out.println("Doctor account already exists");
        }else {
            doctorRepository.save(newDoctor);
        }
    }

    @Override
    public void removeDoctorAccount(String doctorName) {
        doctorRepository.deleteDoctorByName(doctorName);
    }

    @Override
    public void removePatient(String email) {
        patientRepository.deletePatientByEmail(email);
    }

    @Override
    public void addAppointment(AppointmentDTO appointmentDTO,String docName) {

    }


}
