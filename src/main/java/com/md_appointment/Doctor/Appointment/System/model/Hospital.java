package com.md_appointment.Doctor.Appointment.System.model;

import java.util.List;

public class Hospital {
    private List<Patient> patients;
    private List<Doctor> doctors;


    public List<Patient> getPatients() {
        return patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void addPatient(Patient patient){
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
    }

    public void removeDoctor(int id){
        for (Doctor doctor:doctors) {
            if(doctor.getID() == id){
                doctors.remove(doctor);
            }
        }
    }

    public void removePatient(int id){
        for (Patient patient : patients) {
            if(patient.getID() == id){
                patients.remove(patient);
            }
        }
    }
}
