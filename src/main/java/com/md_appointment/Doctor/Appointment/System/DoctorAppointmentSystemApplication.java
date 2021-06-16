package com.md_appointment.Doctor.Appointment.System;

import com.md_appointment.Doctor.Appointment.System.controller.PatientController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DoctorAppointmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorAppointmentSystemApplication.class, args);
	}



}
