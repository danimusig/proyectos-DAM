package org.example;

import java.util.*;

public class ej1_centralMeteorologica {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Double> temperaturasRegistradas = new ArrayList<Double>();

    public static void main(String[] args) {

        int opcionMenu;
        do {
            opcionMenu = menu();
            switch (opcionMenu) {
                case 1: registrarTemperatura(); break;

                case 2: listarRegistros(); break;

                case 3: mostrarInfoProcesada(); break;

                case 4: System.out.println("Saliendo del programa"); break;
            }
        } while(opcionMenu != 4);
        sc.close();
    }

    public static int menu() {
        int opcion = 0;
        try {
            do {
                System.out.println("\n              ⛈\uFE0F CENTRAL METEOROLOGICA ☀\uFE0F \n");
                System.out.println(
                        "* Pulse 1 para añadir un registro de temperatura.\n"
                                + "* Pulse 2 para listar los regitros.\n"
                                + "* Pulse 3 para mostrar las estadísticas meteorológicas.\n"
                                + "* Pulse 4 para salir del programa.\n");
                opcion = sc.nextInt();

            } while (opcion <= 0 || opcion >= 4);
        } catch (InputMismatchException e) {
            System.err.println("ERROR: Introduzca un valor valido. " + e.getMessage());
        }
        return opcion;
    }

    public static void registrarTemperatura() {
        try {
            System.out.println("Introduzca la temperatura a registrar: ");
            double temperatura = sc.nextDouble();
            temperaturasRegistradas.add(temperatura);
        } catch (InputMismatchException e) {
            System.err.println("ERROR: Introduzca un valor valido. " + e.getMessage());
        }
    }

    public static void listarRegistros() {
        if (temperaturasRegistradas.isEmpty()) {
            System.out.println("ALERTA: El registro de temperaturas esta vacio.");
        } else {
            for (Double temp : temperaturasRegistradas) {
                System.out.println(temp);
            }
        }
    }

    public static void mostrarInfoProcesada() {
        if (temperaturasRegistradas.isEmpty()) {
            System.out.println("ALERTA: El registro de temperaturas esta vacio.");
        } else {
            if (temperaturasRegistradas.size() < 3) {
                System.out.println("No hay registros suficientes para procesar (minimo 3 registros)");
            } else {
                double acumuladorTemperaturas = 0;
                double cantidadRegistros = 0;

                for (Double temp : temperaturasRegistradas) {
                    acumuladorTemperaturas += temp;
                    cantidadRegistros++;
                }

                double tempMaxima = Collections.max(temperaturasRegistradas);
                double tempMinima = Collections.min(temperaturasRegistradas);
                double tempMedia = acumuladorTemperaturas / cantidadRegistros;

                System.out.println("Temperatura Maxima: " + tempMaxima);
                System.out.println("Temperatura Minima: " + tempMinima);
                System.out.println("Temperatura Media: " + tempMedia);
            }
        }
    }
}