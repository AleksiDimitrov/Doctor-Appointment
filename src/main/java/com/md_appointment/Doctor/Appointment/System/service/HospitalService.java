package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.AppointmentDTO;
import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.DoctorDTO;
import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.PatientDTO;
import com.md_appointment.Doctor.Appointment.System.model.Appointment;
import com.md_appointment.Doctor.Appointment.System.model.Doctor;
import com.md_appointment.Doctor.Appointment.System.model.Patient;
import com.md_appointment.Doctor.Appointment.System.repository.AppointmentRepository;
import com.md_appointment.Doctor.Appointment.System.repository.DoctorRepository;
import com.md_appointment.Doctor.Appointment.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class HospitalService implements HospitalServiceInterface {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    private Patient currentPatientUser;
    private  List<Doctor> savedDoctors;
    private   List<Patient> savedPatients;

    public HospitalService(PatientRepository patientRepository,DoctorRepository doctorRepository,AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
        List<Doctor> savedDoctors = doctorRepository.findAll();
        List<Patient> savedPatients = patientRepository.findAll();
    }

    @Override
    public void addDoctorAccount(DoctorDTO doctorDTO) {

        Doctor newDoctor = new Doctor(doctorDTO);
        if(!savedDoctors.contains(newDoctor)){
            doctorRepository.save(newDoctor);
        }else {
            System.out.println("Doctor account already exists");
        }
    }

    @Override
    public void addPatientAccount(PatientDTO patientDTO) {

        Patient newPatient = new Patient(patientDTO);
        if(!savedPatients.contains(newPatient)){
            patientRepository.save(newPatient);
        }else{
            System.out.println("User already exists.");
        }
    }
    @Override
    public void logInAsPatient(String email, String password) {

        for(Patient patient:savedPatients){
            if(patient.getEmail().equals(email) && patient.getPassword().equals(password)){
                currentPatientUser = patient;
            }
        }
    }

    @Override
    public void logInAsDoctor(String email, String password) {
        for(Patient patient:savedPatients){
            if(patient.getEmail().equals(email) && patient.getPassword().equals(password)){
                currentPatientUser = patient;
            }
        }
    }

    @Override
    public void makeAppointment(AppointmentDTO appointmentDTO,String doctorName) {

        LocalDate dateOfAppointment = LocalDate.of(appointmentDTO.getYear(), appointmentDTO.getMonth(), appointmentDTO.getDay());
        LocalTime timeOfAppointment = LocalTime.of(appointmentDTO.getHour(), appointmentDTO.getMinute());
        if(checkIfDateAvailable(dateOfAppointment,timeOfAppointment, doctorRepository.getDoctorId(doctorName)) && checkForValidDateTime(dateOfAppointment,timeOfAppointment)) {
            Appointment newAppointment = new Appointment(dateOfAppointment, timeOfAppointment, currentPatientUser, doctorRepository.findDoctorByName(doctorName));
            appointmentRepository.save(newAppointment);
        }

    }

    private boolean checkIfDateAvailable(LocalDate date, LocalTime time, Long docId) {

        List<Appointment> doctorAppointments = appointmentRepository.listDoctorAppointments(docId);
        for (Appointment appointment : doctorAppointments) {
            if (appointment.getDate().equals(date) && appointment.getTime().equals(time)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForValidDateTime(LocalDate date, LocalTime time){
        if(date.isAfter(LocalDate.now()) && time.isAfter(LocalTime.now())){
            return true;
        }
        return false;
    }

    @Override
    public void removeDoctorAccount(String email) {
        doctorRepository.deleteDoctorByEmail(email);
    }

    @Override
    public void removePatientAccount(String email) {
        patientRepository.deletePatientByEmail(email);
    }
}
