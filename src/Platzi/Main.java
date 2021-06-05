package Platzi;
import java.util.Date;
import static Platzi.Ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {
        //showMenu();

        Doctor myDoctor = new Doctor("Jose Mancilla", "Neuro cirujano");
        myDoctor.horaDisponible(new Date(), "4 PM");
        myDoctor.horaDisponible(new Date(), "1 PM");
        myDoctor.horaDisponible(new Date(), "12 PM");
        myDoctor.horaDisponible(new Date(), "20 PM");

        for (Doctor.AvailableAppointment aA: myDoctor.getAvailableAppointments()) {
            System.out.println(aA.getDate() + " " + aA.getTime());

        }


    /*
        Patient patient = new Patient("Alejandra", "alejandra@gmail.com");
        Patient patient2 = new Patient("Alejandra", "alejandra@gmail.com");
        System.out.println(patient.getName());
        System.out.println(patient.getEmail());
        System.out.println(patient.getWeight());*/

    }



}