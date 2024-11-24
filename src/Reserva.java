import javax.naming.spi.ResolveResult;
import java.util.Scanner;

public class Reserva {

    private Hotel hotel;
    private Habitacion habitacion;
    private String cliente;
    private int noches;
    private int cedula;

    public Reserva(){}

    public Reserva(String cliente, int noches, int cedula, Hotel hotel, Habitacion habitacion) {
        this.cliente = cliente;
        this.noches = noches;
        this.cedula = cedula;
        this.hotel = hotel;
        this.habitacion = habitacion;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNoches() {
        return noches;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void imprimirDetalles(Habitacion habitacion){
        System.out.println("\nLa reservación se encuentra a nombre de  : " + this.getCliente() + "\n" +
                "Durante " + this.getNoches() + " noches \n" +
                "Se reservó la habitación número " + habitacion.getNumHabitacion() + "\n" +
                "De tipo " + habitacion.getTipo() + "\n" +
                "Al precio de $" + habitacion.getPrecioXNoche() + " cada noche");
    }


}
