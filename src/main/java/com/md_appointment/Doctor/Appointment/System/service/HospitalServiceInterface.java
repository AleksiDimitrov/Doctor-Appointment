package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.AppointmentDTO;
import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.DoctorDTO;
import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.PatientDTO;

public interface HospitalServiceInterface {
    void addDoctorAccount(DoctorDTO doctorDTO);
    void addPatientAccount(PatientDTO patientDTO);
    void logInAsPatient(String email,String password);
    void logInAsDoctor(String email,String password);
    void makeAppointment(AppointmentDTO appointmentDTO, String doctorName);
    void removeDoctorAccount(String email);
    void removePatientAccount(String email);
}
