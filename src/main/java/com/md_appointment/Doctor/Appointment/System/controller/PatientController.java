package com.md_appointment.Doctor.Appointment.System.controller;

import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.AppointmentDTO;
import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.PatientDTO;
import com.md_appointment.Doctor.Appointment.System.service.HospitalService;
import com.md_appointment.Doctor.Appointment.System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PatientController {

    private HospitalService hospitalService;

    @Autowired
    public PatientController(HospitalService hospitalService) {
        this.hospitalService = hospitalService ;
    }

    @ModelAttribute("patient")
    public PatientDTO patientRegistrationDTO(){
        return new PatientDTO();
    }

    @ModelAttribute("appointment")
    public AppointmentDTO patientAppointmentDTO(){
        return new AppointmentDTO();
    }

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public void registerPatientAccount(@ModelAttribute("patient") PatientDTO patientRegistrationDTO) {
        hospitalService.addPatientAccount(patientRegistrationDTO);
    }

    @GetMapping("/login")
    public String showLogInPage(){
        return "login";
    }

    @PostMapping("/login")
    public void logInPatient(String email,String password){
        hospitalService.logInAsPatient(email,password);
    }

    @GetMapping("/appointment")
    public String appointmentPage(){
        return "appointment";
    }

    @PostMapping("/appointment")
    public void makeAppointment(@ModelAttribute("appointment") AppointmentDTO appointmentDTO,String docName){
        hospitalService.makeAppointment(appointmentDTO,docName);
    }

}

