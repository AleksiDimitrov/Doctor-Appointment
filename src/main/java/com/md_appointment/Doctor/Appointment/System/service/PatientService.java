package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.DTOs.AppointmentDTO;
import com.md_appointment.Doctor.Appointment.System.DTOs.PatientDTO;
import com.md_appointment.Doctor.Appointment.System.model.Appointment;
import com.md_appointment.Doctor.Appointment.System.model.Patient;
import com.md_appointment.Doctor.Appointment.System.model.User;
import com.md_appointment.Doctor.Appointment.System.repository.AppointmentRepository;
import com.md_appointment.Doctor.Appointment.System.repository.DoctorRepository;
import com.md_appointment.Doctor.Appointment.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class PatientService implements IPatientService{

    private Patient currentUser;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public PatientService(PatientRepository patientRepository,DoctorRepository doctorRepository,AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void registerPatient(PatientDTO patientDTO) {

        List<Patient> patientList = patientRepository.findAll();

        Patient newPatient = new Patient(patientDTO.getEmail(), patientDTO.getName(),
                patientDTO.getPassword(), patientDTO.getSex(), patientDTO.getAge());

        if(patientList.contains(newPatient)){
            System.out.println("User already exists.");
        }else{
            patientRepository.save(newPatient);
        }
    }

    @Override
    public void logIn(String email,String password) {
        List<Patient> patientList = patientRepository.findAll();

        for (int i = 0; i<= patientList.size()-1;i++){
            if(patientList.get(i).getEmail().equals(email) && patientList.get(i).getPassword().equals(password)){
                System.out.println("Log in success");
                currentUser = patientList.get(i);
            }
            else {
                System.out.println("Email or password not correct !");
            }

        }

    }

    //Time intervals will be made in the front-end, as the design suggests, they will start from 9am to 5pm and each appointment
    //will last 30 minutes, this eliminates the need of complicated back-end code for the mentioned time intervals.
    @Override
    public void makeAppointment(AppointmentDTO appointmentDTO,String doctorName) {

        LocalDate date = LocalDate.of(appointmentDTO.getYear(), appointmentDTO.getMonth(), appointmentDTO.getDay());
        LocalTime time = LocalTime.of(appointmentDTO.getHour(), appointmentDTO.getMinute());
        if(checkDateAvailable(date,time, doctorRepository.getDoctorId(doctorName))) {
            Appointment newAppointment = new Appointment(date, time, currentUser, doctorRepository.findDoctorByName(doctorName));
             appointmentRepository.save(newAppointment);
        }

    }

    private boolean checkDateAvailable(LocalDate date,LocalTime time,Long docId){
        boolean available = false;
        List<Appointment> doctorAppointments = appointmentRepository.listDoctorAppointments(docId);
        for(Appointment appointment : doctorAppointments){
            if(appointment.getDate().equals(date) && appointment.getTime().equals(time)){
                available = false;
            }else {
                available = true;
                break;
            }
            }
        return available;
    }

}
