package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.DTOs.AppointmentDTO;
import com.md_appointment.Doctor.Appointment.System.DTOs.PatientDTO;
import com.md_appointment.Doctor.Appointment.System.model.Appointment;
import com.md_appointment.Doctor.Appointment.System.model.Doctor;

public interface IPatientService {

    void registerPatient(PatientDTO patientDTO);
    void logIn(String email,String password);
    void makeAppointment(AppointmentDTO appointmentDTO, String doctorName);
}
