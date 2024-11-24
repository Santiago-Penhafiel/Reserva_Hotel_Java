import java.awt.event.HierarchyBoundsAdapter;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    private String nombre;
    private String ciudad;
    private int estrellas;
    private int capacidad;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Reserva> reservas;

    Scanner scan = new Scanner(System.in);

    public Hotel(int capacidad, String nombre, String ciudad, int estrellas) {
        this.habitaciones = new ArrayList<>();
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        this.capacidad = capacidad;
        this.reservas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void agregarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
    }



    public void realizarReserva(){
        System.out.println("Ingrese el número de habitación a reservar : ");
        int numeroReserva = scan.nextInt();
        for(Habitacion habitacion : habitaciones){
            if (habitacion.getNumHabitacion()==numeroReserva && habitacion.isDisponible()){

                habitacion.detalles();

                habitacion.setDisponible(false);

                reservas.add(habitacion.reservar(this, habitacion,reservas));

                if (reservas.get(reservas.size()-1).getCedula() != 0){
                    System.out.println("\nSe ha realizado la reserva de la habitación " + numeroReserva + " con éxito \n" +
                            "Recuerde que tiene que cancelar la cantidad de $" + habitacion.getPrecioXNoche() + " el día de" +
                            " la llegada" + "\n" +
                            "Muchas gracias y disfrute su estancia en " + this.getNombre());
                } else {
                    reservas.remove(reservas.size()-1);
                }




            } else if (habitacion.getNumHabitacion()==numeroReserva && !habitacion.isDisponible()){
                System.out.println("\nLa habitación seleccionada actualmente se encuentra reservada \n" +
                        "No olvide que tenemos una gran variedad adicional a su disposición");
            }

        }
    }

    public void consultarReserva(){
        boolean existeReserva = false;
        System.out.print("Ingrese el numero de cédula con el que se realizó la reserva : ");
        int ced = scan.nextInt();
        for (Reserva reserva : reservas){
            if (reserva.getCedula()==ced){
                reserva.imprimirDetalles(reserva.getHabitacion());
                existeReserva = true;
            }
        }
        if(!existeReserva){
            System.out.println("No existe una reserva con ese número de cédula\n");
        }
    }

}
