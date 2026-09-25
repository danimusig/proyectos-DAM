package org.example;

import java.util.*;

public class ej1_centralMeteorologica {

    private static final Scanner sc = new Scanner(System.in);
    // Se puede crear un scanner para todos los objetos de una misma clase.

    public static void main(String[] args) {

        int opcionMenu;
        List<Double> temperaturasRegistradas = new ArrayList<Double>();

        do {
            opcionMenu = menu();
            switch (opcionMenu) {
                case 1:
                    // Añadir un registro de temperatura.
                    System.out.println("Introduzca la temperatura a registrar: ");
                    double temperatura = sc.nextDouble();
                    temperaturasRegistradas.add(temperatura);
                    break;

                case 2:
                    // Mostrar las estadísticas meteorológicas.
                    for (Double temp : temperaturasRegistradas) {
                        System.out.println(temp);
                    }
                    break;

                case 3:
                    // Procesar los registros y mostrar operaciones.
                    if (temperaturasRegistradas.isEmpty()) {
                        System.out.println("ALERTA: No hay registros suficientes para calcular.");
                    } else {
                        double tempMaxima = Collections.max(temperaturasRegistradas);
                        double tempMinima = Collections.min(temperaturasRegistradas);

                        double acumuladorTemperaturas = 0;
                        double cantidadRegistros = 0;

                        for (Double temp : temperaturasRegistradas) {
                            acumuladorTemperaturas += temp;
                            cantidadRegistros++;
                        }

                        double tempMedia = acumuladorTemperaturas / cantidadRegistros;

                        System.out.println("Temperatura Maxima: " + tempMaxima);
                        System.out.println("Temperatura Minima: " + tempMinima);
                        System.out.println("Temperatura Media: " + tempMedia);
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa");
                    break;
            }
        } while(opcionMenu != 4);

        sc.close();
    }

    public static int menu() {
        int opcion = 0;

            do {
                System.out.println("\n**************************** - CENTRAL METEOROLOGICA - ***************************");
                System.out.println(
                        "* Pulse 1 para añadir un registro de temperatura.\n"
                                + "* Pulse 2 para listar los regitros.\n"
                                + "* Pulse 3 para mostrar las estadísticas meteorológicas.\n"
                                + "* Pulse 4 para salir del programa.\n");
                opcion = sc.nextInt();

            } while (opcion <= 0 || opcion >= 4);

        return opcion;
    }
}