package Objetos;

import Objetos.Persona;
import java.util.Scanner;

public class Pelicula {

    Scanner scanner = new Scanner(System.in);
    Persona persona = new Persona(null, 0, 0);

    private String titulo;
    private Integer duracion;
    private Integer edadMinima;
    private String director;
    private Integer precio;
    private boolean[][] asientosReservados;
    private final String[][] asientos = {
        {"8A", "8B", "8C", "8D", "8E", "8F", "8G", "8H", "8I"},
        {"7A", "7B", "7C", "7D", "7E", "7F", "7G", "7H", "7I"},
        {"6A", "6B", "6C", "6D", "6E", "6F", "6G", "6H", "6I"},
        {"5A", "5B", "5C", "5D", "5E", "5F", "5G", "5H", "5I"},
        {"4A", "4B", "4C", "4D", "4E", "4F", "4G", "4H", "4I"},
        {"3A", "3B", "3C", "3D", "3E", "3F", "3G", "3H", "3I"},
        {"2A", "2B", "2C", "2D", "2E", "2F", "2G", "2H", "2I"},
        {"1A", "1B", "1C", "1D", "1E", "1F", "1G", "1H", "1I"}
    };

    //Métodos
    public void reservar() {
        asientosDisponibles();

        while (true) {
            System.out.print("Elige un asiento [ejemplo: 5E]: ");
            String eleccion = scanner.nextLine().toUpperCase();

            if (validar(eleccion)) {
                System.out.println(persona.nombre.toUpperCase() +
                        ", tu asiento es el ▶" + eleccion + "◀");
                asientosDisponibles();
                break;
            } else {
                System.out.println("Por favor, intenta de nuevo.");
                asientosDisponibles();
            }
        }
    }

    public void asientosDisponibles() {
        System.out.println("---[Asientos disponibles]---");
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                String estado = asientosReservados[i][j] ? "❎" : asientos[i][j];
                System.out.print("|" + estado);
            }
            System.out.println("|");
        }
    }

    public boolean validar(String eleccion) {
        if (eleccion.length() != 2) {
            System.out.println("Formato de asiento inválido.");
            return false;
        }

        int filaSeleccionada = Character.getNumericValue(eleccion.charAt(0));
        char letraSeleccionada = eleccion.charAt(1);

        if (filaSeleccionada < 1 && filaSeleccionada > 8
                && letraSeleccionada < 'A' && letraSeleccionada > 'I') {
            System.out.println("Asiento fuera de rango.");
            return false;
        }
 
        int fila = 8 - filaSeleccionada;
        int columna = letraSeleccionada - 'A';

        if (asientosReservados[fila][columna]) {
            System.out.println("Este asiento ya está ocupado.");
            return false;
        }

        asientosReservados[fila][columna] = true;
        return true;
    }

    public void pagoVoleto() {
        persona.dinero = soloNumeros("Ingrese aquí el pago de su boleto: ");

        if (persona.dinero < precio) {
            System.out.println("No tienes el dinero suficiente para "
                    + "completar la compra.");
            System.out.println("Por favor, ingresa el dinero completo: ");
            pagoVoleto();
        } else if (persona.dinero > precio) {
            Integer vueltos = persona.dinero - precio;
            System.out.println("Tu pago se ha realizado con éxito 👍"
                    + "\nAquí tienes tu cambio: $"
                    + vueltos);
        } else {
            System.out.println("Tu pago se ha realizado con éxito 👍");
        }
    }

    public void procesoSeleccion() {
        System.out.println("Registro para la compra de boletos de la película.");

        System.out.print("Ingresa tu nombre: ");
        persona.nombre = scanner.nextLine();

        persona.edadPersona = soloNumeros("Ingresa tu edad: ");

        if (persona.edadPersona < edadMinima) {
            System.out.println("No tienes la edad mínima para ver la película.");
        } else {
            System.out.println("¡Perfecto! Cumples con la edad mínima para ver "
                    + "la película.");
            pagoVoleto();
            reservar();
        }
    }

    public int soloNumeros(String texto) {
        while (true) {
            System.out.print(texto);
            try {
                String valor = scanner.nextLine();
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un valor correcto.");
            }
        }
    }

    public Pelicula(String titulo, Integer duracion, Integer edadMinima,
            String director, Integer precio) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
        this.precio = precio;
        this.asientosReservados = new boolean[asientos.length]
                [asientos[0].length];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------[Película]---------------");
        sb.append("\nTítulo de la película = ").append(titulo);
        sb.append("\nDuración de la película = ").append(duracion).append(" min");
        sb.append("\nDirector de la película = ").append(director);
        sb.append("\nEdad mínima = ").append(edadMinima).append(" años");
        sb.append("\nPrecio del boleto = $").append(precio);
        sb.append("\n---------------------------------------");
        return sb.toString();
    }
}
