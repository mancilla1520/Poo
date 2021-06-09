package Platzi.Ui;

import Platzi.model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    private static Object TreeMap;

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Paciente");
            System.out.println("Bienvenidp: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an appointment \n 2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();
            switch (response) {
                case 1:
                    showBookApointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        } while (response != 0);

    }

    private static void showBookApointmentMenu(){
        int response = 0;
        do {
            System.out.println(":: Book an appointment");
            System.out.println(":: Select a date");
            //Numeracion de la lista de fechas
            //El segundo integer llevara el Indice de la fecha seleccionada
            //El primer integer tendra el indice de los doctores
            //1.- Doctor1
               //El segundo integer tendra el indice de las fehcas-----.------ Array creado dentro de la clase anidada doctor
               //- 1 fecha1
            //doctor2
               //- 2 facha2

            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". "+availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }

            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = sc.nextInt();
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer infexDate=0;
            Doctor doctorSelected = new Doctor("","");
            for (Map.Entry<Integer, Doctor> doc:doctorAvailableSelected.entrySet()) {
                infexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ".Date: "+ doctorSelected.getAvailableAppointments().get(infexDate).getDate()+
                    ". Time: "+ doctorSelected.getAvailableAppointments().get(infexDate).getTime());
            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());
            if (response == 1){
                UIMenu.patientLogged.addAppointmentDoctors(doctorSelected,
                        doctorSelected.getAvailableAppointments().get(infexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(infexDate).getTime());

                showPatientMenu();
            }
        }while (response !=0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println("::My Appointments");
            if (UIMenu.patientLogged.getAppointmentDoctors().size()==0){
                System.out.println("No tienes horas");
                break;
            }
            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i+1;
                System.out.println(j +". "+
                        "Date: "+UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        "Time: "+UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime()+
                        "\nDoctor: "+UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());

            }
            System.out.println("0. Return");
        }while (response!=0);
    }
}
