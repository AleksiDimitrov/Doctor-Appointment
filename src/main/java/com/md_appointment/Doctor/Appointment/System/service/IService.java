package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.DTOs.AppointmentDTO;
import com.md_appointment.Doctor.Appointment.System.DTOs.DoctorDTO;
import com.md_appointment.Doctor.Appointment.System.DTOs.PatientDTO;

public interface IService {
    void addDoctorAccount(DoctorDTO doctorDTO);
    void registerPatient(PatientDTO patientDTO);
    void logIn(String email,String password);
    void makeAppointment(AppointmentDTO appointmentDTO, String doctorName);
    void removeDoctorAccount(String doctorName);
    void removePatient(String email);
}
