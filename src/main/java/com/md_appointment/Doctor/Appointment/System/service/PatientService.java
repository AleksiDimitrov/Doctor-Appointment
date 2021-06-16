package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.model.Patient;
import com.md_appointment.Doctor.Appointment.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService{

    @Autowired
    private Patient patient;


    @Override
    public void registerPatient(Patient patient) {

    }
}
