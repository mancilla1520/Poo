package Platzi;
import model.Doctor;
import model.Patient;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //showMenu();

        Doctor myDoctor = new Doctor("Jose Mancilla", "");
        myDoctor.horaDisponible(new Date(), "4 PM"); //Creando las horas
        myDoctor.horaDisponible(new Date(), "1 PM"); //Creando las horas
        myDoctor.horaDisponible(new Date(), "12 PM"); //Creando las horas
        myDoctor.horaDisponible(new Date(), "20 PM"); //Creando las horas


        //for (Doctor.AvailableAppointment aA: myDoctor.availableAppointments) { //imprimiendo las horas.
          //  System.out.println(aA.getDate() + " " + aA.getTime() );

       // }

        Patient patient = new Patient("Alejandra", "alejandra@gmail.com");
        Patient patient2 = new Patient("Alejandra", "alejandra@gmail.com");

        //System.out.println(patient);
        System.out.println(myDoctor);

    }



}