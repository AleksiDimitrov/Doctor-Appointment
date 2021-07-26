package com.md_appointment.Doctor.Appointment.System.data.transfer.objects;

import com.md_appointment.Doctor.Appointment.System.model.Patient;

public class Testmain {

    public static void main(String[] args) {
        Patient p1 = new Patient("adasd","name","pass","frog",23);
        System.out.println( EntityToDtoConverter.converter(p1).toString());

    }
}
