package com.md_appointment.Doctor.Appointment.System.controller;

import com.md_appointment.Doctor.Appointment.System.DTO.PatientRegistrationDTO;
import com.md_appointment.Doctor.Appointment.System.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/registration")
    public String showRegistrationPage(){
        return "registration";
    }

   @PostMapping
    public void registerPatientAccount(@ModelAttribute("patient")PatientRegistrationDTO patientRegistrationDTO){
        patientService.registerPatient(patientRegistrationDTO);
    }
}
