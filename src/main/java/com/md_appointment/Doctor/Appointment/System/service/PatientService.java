package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.DTO.PatientRegistrationDTO;
import com.md_appointment.Doctor.Appointment.System.model.Patient;

import com.md_appointment.Doctor.Appointment.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService{

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        super();
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient registerPatient(PatientRegistrationDTO patientRegistrationDTO) {
        Patient patient = new Patient(patientRegistrationDTO.getEmail(), patientRegistrationDTO.getName(),
                patientRegistrationDTO.getAge(), patientRegistrationDTO.getSex(), patientRegistrationDTO.getPassword());

        return patientRepository.save(patient);
    }
}
