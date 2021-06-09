package Platzi.Ui;

import Platzi.model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {
    public static ArrayList <Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctoMenu(){

        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Bienvenido/a " + UIMenu.doctorLogged.getName());
            System.out.println("1. Add available Appointment");
            System.out.println("2. Scheduled appointments");
            System.out.println("3. Logout");

            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();

            switch (response){
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;

                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while (response !=0);
    }

    private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do {
            System.out.println();
            System.out.println(":: Available Appointment");
            System.out.println(":: Select a Month");

            for (int i=0; i<3 ; i++){
                int j= i +1;
                System.out.println( j + ". "+UIMenu.MONTHS[i]);
            }

            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response >0 && response < 4){
                //1,2,3
                int monthSelected = response;
                System.out.println(monthSelected+" . "+ UIMenu.MONTHS[monthSelected-1]);


                System.out.println("insert the date available: [dd/mm/yyy]");
                String date = sc.nextLine();


                System.out.println("Your date is: " + date + "\n1. correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2){
                    continue;
                }
                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: "+ time +"\n1. Correct \n2.Change time");
                    responseTime = sc.nextInt();

                }while (responseTime == 2);

                UIMenu.doctorLogged.horaDisponible(date , time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);

            }else if(response==0){
                showDoctoMenu();
            }

        }while (response !=0);

    }

    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }

    }


}
