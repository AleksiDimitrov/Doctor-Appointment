package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.AppointmentDTO;
import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.PatientDTO;

public interface IPatientService {

    void registerPatient(PatientDTO patientDTO);
    void logIn(String email,String password);
    void makeAppointment(AppointmentDTO appointmentDTO, String doctorName);
}
