package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.AppointmentDTO;
import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.DoctorDTO;

public interface IAdministratiorService {

    void addDoctorAccount(DoctorDTO doctorDTO);
    void removeDoctorAccount(String doctorName);
    void removePatient(String email);
    void addAppointment(AppointmentDTO appointmentDTO,String docName);
    //void removeAppointment();
}
