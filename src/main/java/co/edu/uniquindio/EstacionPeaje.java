package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;

public class EstacionPeaje {
    private final String nombre;
    private final String departamento;
    private double totalRecaudado;
    private final List<Vehiculo> vehiculosRegistrados;
    private final List<Recaudador> recaudadores;

    public EstacionPeaje(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.totalRecaudado = 0;
        this.vehiculosRegistrados = new ArrayList<>();
        this.recaudadores = new ArrayList<>();
    }


    public void calcularPeaje(Vehiculo v) {
        double valor = v.calcularPeaje();
        totalRecaudado += valor;
        v.setNumeroPeajesPagados(v.getNumeroPeajesPagados() + 1);
        v.totalPagadoPeajes += valor;
        vehiculosRegistrados.add(v);
    }

    public void imprimirReporte() {
        System.out.println("--- Reporte de Estación de Peaje ---");
        System.out.println("\nNombre del Peaje: " + nombre);
        System.out.println("Ubicación: " + departamento);
        System.out.println("-----------------------------");
        for (Vehiculo v : vehiculosRegistrados) {
            System.out.println(v.getDescripcion());
            System.out.println("Peaje cobrado: $" + v.calcularPeaje());
            System.out.println("Número de peajes pagados: " + v.getNumeroPeajesPagados());
            System.out.println("Conductor: " + v.getConductor().getNombreCompleto());
            System.out.println("-----------------------------");
        }
        System.out.println("TOTAL RECAUDADO: $" + totalRecaudado);
        System.out.println("-----------------------------");

    }

    // ---------------------------
    // MÉTODOS PARA RECAUDADORES
    // ---------------------------

    public void agregarRecaudador(Recaudador r) {
        recaudadores.add(r);
    }

    public Recaudador buscarRecaudadorPorNombreCompleto(String nombreCompleto) {
        String nombreNormalizado = nombreCompleto.trim().toLowerCase().replaceAll("\\s+", " ");

        for (Recaudador r : recaudadores) {
            if (r.getNombreCompleto().equals(nombreNormalizado)) {
                System.out.println("\n--- Recaudador Encontrado ---");
                r.imprimirDatos();
                return r;
            }
        }

        System.out.println("Recaudador no encontrado con el nombre: " + nombreCompleto);
        return null;
    }





}

