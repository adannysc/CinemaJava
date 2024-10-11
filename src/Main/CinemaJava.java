package Main;

import Objetos.Pelicula;
import Objetos.Persona;
import java.util.Scanner;

public class CinemaJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona persona = new Persona(null, 0, 0);
        Pelicula pelicula = new Pelicula("The Godfather", 175, 18,
                "Francis Ford Coppola", 5000);

        Boolean continuar = true;
        while (continuar) {
            System.out.println("""
                           
                            [-----------[BIENVENIDO]-----------]      
                            +---+------------------------------+ 
                            | # |           OPCIÓN             | 
                            +---+------------------------------+         
                            | 1 |  Información de la película  | 
                            +---+------------------------------+  
                            | 2 |    Comprar boleto/Asiento    |      
                            +---+------------------------------+
                            | 3 |          Finalizar           |
                            +---+------------------------------+
                            """);

            Integer menu = pelicula.soloNumeros("Ingrese la opción que desea"
                    + " realizar: ");

            switch (menu) {
                case 1:
                    System.out.print("¿Desea ver la información de la"
                            + " película? [sí / no]: ");
                    String decision = scanner.nextLine();

                    if (decision.equalsIgnoreCase("si")) {
                        System.out.println(pelicula.toString());

                        System.out.print("Escriba [atrás] para volver"
                                + " al menú: ");
                        decision = scanner.nextLine();

                        if (decision.equalsIgnoreCase("atras")) {
                            System.out.println("Volviendo atrás...");
                            break;
                        } else {
                            while (!decision.equalsIgnoreCase("atras")) {
                                System.out.println("Este valor no es admitido.");
                                System.out.print("¡ERROR! Escriba [atrás] para"
                                        + " volver al menú: ");
                                decision = scanner.nextLine();
                            }
                        }
                    } else if (decision.equalsIgnoreCase("no")) {
                        System.out.println("Volviendo atrás...");
                        break;
                    } else {
                        while (!decision.equalsIgnoreCase("atras")) {
                            System.out.println("Este valor no es admitido.");
                            System.out.print("¡ERROR! Escriba [atrás] para"
                                    + " volver al menú: ");
                            decision = scanner.nextLine();
                        }
                    }
                    break;
                case 2:
                    System.out.print("¿Desea comprar un boleto para ver la"
                            + " película? [sí / no]: ");
                    decision = scanner.nextLine();

                    if (decision.equalsIgnoreCase("si")) {
                        pelicula.procesoSeleccion();
                        System.out.print("¿Quiere comprar otro boleto para"
                                + " la película? [sí / no]: ");
                        decision = scanner.nextLine();

                        if (decision.equalsIgnoreCase("si")) {
                            pelicula.pagoVoleto();
                            pelicula.reservar();
                        } else if (decision.equalsIgnoreCase("no")) {
                            System.out.println("Volviendo atrás...");
                            break;
                        } else {
                            while (!decision.equalsIgnoreCase("atras")) {
                                System.out.println("Este valor no es admitido.");
                                System.out.print("¡ERROR! Escriba [atrás] para"
                                        + " volver al menú: ");
                                decision = scanner.nextLine();
                            }
                        }
                        break;
                    } else if (decision.equalsIgnoreCase("no")) {
                        System.out.println("Volviendo atrás...");
                        break;
                    } else {
                        while (!decision.equalsIgnoreCase("atras")) {
                            System.out.println("Este valor no es admitido.");
                            System.out.print("¡ERROR! Escriba [atrás] para"
                                    + " volver al menú: ");
                            decision = scanner.nextLine();
                        }
                    }
                    break;
                case 3:
                    System.out.println("¡ADIOS, VUELVE PRONTO! 👍");
                    continuar = false;
                    break;
                default:
                    while (!menu.equals(1) && !menu.equals(2) &&
                            !menu.equals(3)) {
                        System.out.println("Este valor no es admitido.");
                        menu = pelicula.soloNumeros("Ingrese la opción que"
                                + " desea realizar: ");
                    }
            }
        }
    }
}
