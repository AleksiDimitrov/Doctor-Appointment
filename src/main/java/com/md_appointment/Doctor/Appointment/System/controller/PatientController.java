package com.md_appointment.Doctor.Appointment.System.controller;

import com.md_appointment.Doctor.Appointment.System.model.Patient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class PatientController{



    @RequestMapping("/register")
    public Patient registerPatient(HttpServletRequest request, HttpServletResponse response){

        String name = request.getParameter("Name");
        int age = Integer.parseInt(request.getParameter("Age"));
        String sex = request.getParameter("Sex");
        String password = request.getParameter("Password");
        String email = request.getParameter("Email");

        Patient pt = new Patient();
        pt.setName(name);
        pt.setAge(age);
        pt.setSex(sex);
        pt.setPassword(password);
        pt.setEmail(email);

        return pt;

    }

    @RequestMapping("/login")
    public void LogIn(HttpServletRequest request,HttpServletResponse response){

    }

}
