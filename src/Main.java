import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel(6,"Hotel Lúmina", "Quito",5);

        hotel.agregarHabitacion(new Habitacion("Individual", 1,25));
        hotel.agregarHabitacion(new Habitacion("Doble", 2,40));
        hotel.agregarHabitacion(new Habitacion("Suite", 3,60));
        hotel.agregarHabitacion(new Habitacion("Familiar",4,75));
        hotel.agregarHabitacion(new Habitacion("Deluxe",5,100));
        hotel.agregarHabitacion(new Habitacion("Penthouse",6,125));

        Scanner scan = new Scanner(System.in);

        boolean continuar = true;
        int opcion;
        String resp;

        System.out.println("Bienvenido a " + hotel.getNombre() + ",\n" +
                "ubicado en la ciudad de " + hotel.getCiudad() + "\n" +
                "Ponemos a su disposición un servicio que nos ha llevado a obtener " + hotel.getEstrellas()  +
                "estrellas de excelencia");

        while (continuar){
            System.out.println("1. Para agendar una nueva reserva  \n" +
                    "2. Para hacer una consulta sobre una reserva");
            opcion = scan.nextInt();
            scan.nextLine();
            switch (opcion){
                case 1 :
                    hotel.realizarReserva();
                    break;
                case 2 :
                    hotel.consultarReserva();
                    break;
            }

            System.out.println("\n¿Desea realizar otra acción? s/n");
            resp = scan.nextLine();

            if (resp.equals("n")){
                continuar = false;
            }
        }
    }
}