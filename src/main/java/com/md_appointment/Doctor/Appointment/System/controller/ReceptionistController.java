package com.md_appointment.Doctor.Appointment.System.controller;

import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.DoctorDTO;
import com.md_appointment.Doctor.Appointment.System.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReceptionistController {

    private AdministratorService administratorService;

    @Autowired
    public ReceptionistController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @ModelAttribute("doctor")
    public DoctorDTO doctorRegistrationDTO(){
        return new DoctorDTO();
    }

    @GetMapping("/registerdoctor")
    public String doctorRegistrationPage(){
        return "registerdoctor";
    }

    @PostMapping("/registerdoctor")
    public void registerDoctor(@ModelAttribute("doctor")DoctorDTO doctorDTO){
        administratorService.addDoctorAccount(doctorDTO);
    }





}
