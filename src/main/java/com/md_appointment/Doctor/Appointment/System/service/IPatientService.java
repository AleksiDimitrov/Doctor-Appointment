package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.DTO.PatientRegistrationDTO;
import com.md_appointment.Doctor.Appointment.System.model.Patient;

public interface IPatientService {

    Patient registerPatient(PatientRegistrationDTO patientRegistrationDTO);
}
