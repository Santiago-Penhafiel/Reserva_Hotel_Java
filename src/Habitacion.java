import java.util.ArrayList;
import java.util.Scanner;

public class Habitacion {
    private String tipo;
    private int numHabitacion;
    private boolean disponible;
    private double precioXNoche;

    Scanner scan = new Scanner(System.in);

    public Habitacion(String tipo, int numHabitacion, double precioXNoche) {
        this.tipo = tipo;
        this.numHabitacion = numHabitacion;
        this.disponible = true;
        this.precioXNoche = precioXNoche;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getPrecioXNoche() {
        return precioXNoche;
    }

    public void setPrecioXNoche(double precioXNoche) {
        this.precioXNoche = precioXNoche;
    }

    public Reserva reservar (Hotel hotel, Habitacion habitacion, ArrayList<Reserva> reservas){
        this.setDisponible(false);

        int cedula;

        do {
            System.out.print("Ingrese el número de cédula para realizar la reserva (no puede ser 0)=: ");
            cedula = scan.nextInt();
            scan.nextLine();
        } while (cedula==0);

        for (Reserva r : reservas){
            if(r.getCedula()==cedula){
                System.out.println("Esta cédula ya está siendo usada para hacer una reserva");
                return new Reserva();
            }
        }

        System.out.print("Ingrese el nombre al cual se va a poner la reserva : ");
        String cliente = scan.nextLine();

        System.out.print("Ingrese el número de noches las cuales va a permanecer en el hotel : ");
        int noches = scan.nextInt();
        scan.nextLine();


        return new Reserva(cliente,noches,cedula,hotel,habitacion);
    }

    public void detalles(){
        System.out.println("Habitación número : " + this.getNumHabitacion() + "\n" +
                "El tipo de habitación a elegir es " + this.getTipo() + "\n" +
                "El precio por noche es de $" + this.getPrecioXNoche());
    }


}

