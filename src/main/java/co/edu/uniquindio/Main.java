package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Conductor 1
        Conductor conductor1 = new Conductor("Juan", "Perez", "123456", LocalDate.of(1985, 5, 10));
        Carro carro1 = new Carro("ABC123", conductor1, true, true);
        Moto moto1 = new Moto("XYZ987", conductor1, 250);
        Camion camion1 = new Camion("TRK456", conductor1, 4, 12);
        conductor1.asignarVehiculo(carro1);
        conductor1.asignarVehiculo(moto1);
        conductor1.asignarVehiculo(camion1);

        // Conductor 2
        Conductor conductor2 = new Conductor("María", "López", "654321", LocalDate.of(1990, 8, 22));
        Carro carro2 = new Carro("DEF456", conductor2, false, true);
        Moto moto2 = new Moto("LMN543", conductor2, 180);
        conductor2.asignarVehiculo(carro2);
        conductor2.asignarVehiculo(moto2);

        // Conductor 3
        Conductor conductor3 = new Conductor("Carlos", "Ruiz", "789012", LocalDate.of(1978, 12, 3));
        Camion camion3 = new Camion("TRK789", conductor3, 6, 15);
        conductor3.asignarVehiculo(camion3);

        // Estación de Peaje
        EstacionPeaje peaje = new EstacionPeaje("Peaje Norte", "Cundinamarca");

        // Recaudadores
        Recaudador r1 = new Recaudador("Ana", "Ramirez", "456789", LocalDate.of(1990, 3, 20), 2500000);
        Recaudador r2 = new Recaudador("Luis", "Martinez", "987654", LocalDate.of(1982, 11, 15), 2300000);
        peaje.agregarRecaudador(r1);
        peaje.agregarRecaudador(r2);

        // Calcular peajes
        for (Vehiculo v : conductor1.getVehiculos()) {
            peaje.calcularPeaje(v);
        }
        for (Vehiculo v : conductor2.getVehiculos()) {
            peaje.calcularPeaje(v);
        }
        for (Vehiculo v : conductor3.getVehiculos()) {
            peaje.calcularPeaje(v);
        }

        // Reporte general
        peaje.imprimirReporte();

        // Reportes individuales por conductor
        System.out.println("\n--- Reporte individual por conductor ---");
        System.out.println("Conductor: " + conductor1.getNombreCompleto());
        conductor1.imprimirTodosLosVehiculos();
        System.out.println("Total pagado: $" + conductor1.totalPagadoPeajes());

        System.out.println("\nConductor: " + conductor2.getNombreCompleto());
        conductor2.imprimirTodosLosVehiculos();
        System.out.println("Total pagado: $" + conductor2.totalPagadoPeajes());

        System.out.println("\nConductor: " + conductor3.getNombreCompleto());
        conductor3.imprimirTodosLosVehiculos();
        System.out.println("Total pagado: $" + conductor3.totalPagadoPeajes());

        // Buscar recaudador por nombre completo
        Scanner scanner = new Scanner(System.in);
        Recaudador encontrado = null;
        while (encontrado == null) {
            System.out.print("\nIngrese el nombre completo del recaudador (nombre y apellidos): ");
            String nombreCompleto = scanner.nextLine();
            encontrado = peaje.buscarRecaudadorPorNombreCompleto(nombreCompleto);

            if (encontrado == null) {
                System.out.println("Nombre incorrecto. Intente nuevamente.");
            }
        }
        System.out.println("\n--- Recaudador Encontrado ---");
        encontrado.imprimirDatos();


        // Obtener conductores con camiones de más de 10 toneladas
        List<Conductor> todosLosConductores = Arrays.asList(conductor1, conductor2, conductor3);
        List<Conductor> conductoresPesados = obtenerConductoresConCamionesPesados(todosLosConductores);

        // Imprimir al final del reporte
        System.out.println("\n--- Conductores con camiones de más de 10 toneladas ---");
        for (Conductor c : conductoresPesados) {
            System.out.println("Nombre: " + c.getNombreCompleto());
        }
    }

    public static List<Conductor> obtenerConductoresConCamionesPesados(List<Conductor> conductores) {
        List<Conductor> resultado = new ArrayList<>();

        for (Conductor conductor : conductores) {
            for (Vehiculo v : conductor.getVehiculos()) {
                if (v instanceof Camion) {
                    Camion c = (Camion) v;
                    if (c.getCapacidadCargaToneladas() > 10) {
                        resultado.add(conductor);
                        break; // Ya cumple la condición, pasamos al siguiente conductor
                    }
                }
            }
        }

        return resultado;
    }
}







