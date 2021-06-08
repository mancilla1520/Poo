package Platzi.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Doctor extends User{ //Sub Clase
    private String speciality; //Especialidad del doctor


    public Doctor(String name, String email) { //Constructor
        super(name, email); //metodo super-
        //System.out.println("El nombre del Doctor asignado es: " + name);
        this.speciality = speciality;
    }
    //get y set de speciality
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //Array dinamico para las horas disponibles
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void horaDisponible(String date, String time){ //metodo para agregar las horas
        availableAppointments.add(new Doctor.AvailableAppointment(date , time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: "+ speciality + "\nAvailable: "+ "\n"+ availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Valparaíso");
        System.out.println("Departamento: Cirujia");
    }

    public static class AvailableAppointment{ //Clase anidada

        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy");

        public AvailableAppointment(String date, String time) { //Constructor de la clase anidada
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
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

        public String getDate(String DATE) {

            return format.format(date);
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

        @Override
        public String toString() {
            return "Available Appointments \nDate: " + date + "\nTime: "+ time;
        }
    }

}
