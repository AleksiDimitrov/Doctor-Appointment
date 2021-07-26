package com.md_appointment.Doctor.Appointment.System.data.transfer.objects;

import org.springframework.beans.BeanUtils;

public class EntityToDtoConverter {

    public static DTO converter(Object obj){
        if(obj.getClass().getSimpleName() == null){
            return null;
        }
        if(obj.getClass().getSimpleName().equalsIgnoreCase("DOCTOR")){
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(obj,doctorDTO);
            return doctorDTO;
        }
        else if(obj.getClass().getSimpleName().equalsIgnoreCase("PATIENT")){
            PatientDTO patientDTO = new PatientDTO();
            BeanUtils.copyProperties(obj,patientDTO);
            System.out.println("Converted a patient to dto patient!!!!!!!!!!!!");
            return patientDTO;
        }
        if(obj.getClass().getSimpleName().equalsIgnoreCase("APPOINTMENT")){
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            BeanUtils.copyProperties(obj,appointmentDTO);
            return appointmentDTO;
        }
        return null;
    }
}
