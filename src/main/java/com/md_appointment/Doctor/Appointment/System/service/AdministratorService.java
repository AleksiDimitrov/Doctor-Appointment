package com.md_appointment.Doctor.Appointment.System.service;

import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.AppointmentDTO;
import com.md_appointment.Doctor.Appointment.System.data.transfer.objects.DoctorDTO;
import com.md_appointment.Doctor.Appointment.System.model.Doctor;
import com.md_appointment.Doctor.Appointment.System.repository.DoctorRepository;
import com.md_appointment.Doctor.Appointment.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService implements IAdministratiorService{

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public AdministratorService(DoctorRepository doctorRepository,PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void addDoctorAccount(DoctorDTO doctorDTO) {
        List<Doctor> savedDoctors = doctorRepository.findAll();

        Doctor newDoctor = new Doctor(doctorDTO);
        if(!savedDoctors.contains(newDoctor)){
            doctorRepository.save(newDoctor);
        }else {
            System.out.println("Doctor account already exists");
        }
    }

    @Override
    public void removeDoctorAccount(String doctorName) {
       // doctorRepository.deleteDoctorByName(doctorName);
    }

    @Override
    public void removePatient(String email) {
        patientRepository.deletePatientByEmail(email);
    }

    @Override
    public void addAppointment(AppointmentDTO appointmentDTO,String docName) {

    }


}
