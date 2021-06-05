package Platzi;
import java.util.ArrayList;
import java.util.Date;


public class Doctor {
    //Atributos
    static int id = 0;
    private String name;
    private String email;
    private String speciality;


    Doctor(){
        System.out.println("Construyendo el Objeto Doctor");
    }

    Doctor(String name, String speciality) {
        System.out.println("El nombre del Doctor asignado es: " + name);
        id++;
        this.name = name;
        this.speciality = speciality;
    }

    //Comportamientos
    public void showName(){
        System.out.println(name);
    }

    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void horaDisponible(Date date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date , time));

    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }




    public static class AvailableAppointment{

        private int id;
        private Date date;
        private String time;

        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }



}
