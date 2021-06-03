package Platzi;
import static Platzi.Ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {
        //showMenu();

        Doctor myDoctor = new Doctor("Jose Mancilla", "Neuro cirujano");
        System.out.println(myDoctor.name);
        System.out.println(myDoctor.speciality);

        Patient patient = new Patient("Alejandra", "alejandra@gmail.com");
        Patient patient2 = new Patient("Alejandra", "alejandra@gmail.com");
        System.out.println(patient.getName());
        System.out.println(patient.getEmail());

        patient.setWeight(60.6);
        patient.setHeight(1.65);

        System.out.println(patient.getWeight() + " Kilos");
        System.out.println(patient.getHeight()+ " Metros");

    }



}