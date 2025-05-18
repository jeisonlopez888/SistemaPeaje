package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Conductor {
    private final String nombre;
    private final String apellidos;
    private final String documento;
    private final LocalDate fechaNacimiento;
    private final List<Vehiculo> vehiculos;


    public Conductor(String nombre, String apellidos, String documento, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.vehiculos = new ArrayList<>();
    }

    public void asignarVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }

    public double totalPagadoPeajes() {
        return vehiculos.stream().mapToDouble(Vehiculo::calcularPeaje).sum();
    }

    public List<Vehiculo> filtrarVehiculosPorTipo(TipoVehiculo tipo) {
        return vehiculos.stream().filter(v -> {
            switch (tipo) {
                case CARRO: return v instanceof Carro;
                case MOTO: return v instanceof Moto;
                case CAMION: return v instanceof Camion;
                default: return false;
            }
        }).collect(Collectors.toList());
    }

    public boolean tieneCamionAltaCarga() {
        return vehiculos.stream()
                .filter(v -> v instanceof Camion)
                .map(v -> (Camion) v)
                .anyMatch(c -> c.getCapacidadCargaToneladas() > 10);
    }

    public String getNombreCompleto() {
        return (nombre + " " + apellidos ).trim().toLowerCase().replaceAll("\\s+", " ");
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDocumento() {
        return documento;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }



    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public List<Vehiculo> obtenerVehiculosPorTipo(String tipo) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            switch (tipo.toLowerCase()) {
                case "carro":
                    if (v instanceof Carro) resultado.add(v);
                    break;
                case "moto":
                    if (v instanceof Moto) resultado.add(v);
                    break;
                case "camion":
                    if (v instanceof Camion) resultado.add(v);
                    break;
            }
        }
        return resultado;
    }


    public void imprimirDetallePeajesPorVehiculo() {
        System.out.println("=== Total pagado en peajes por vehículos del conductor " + getNombreCompleto() + "  ===\n");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.getDescripcion());
            System.out.println("Total pagado en peajes: $" + vehiculo.getTotalPagadoPeajes());
            System.out.println("-----------------------------------");
        }
    }


    public void imprimirTodosLosVehiculos() {
        System.out.println("=== Vehículos del conductor ===\n");
        System.out.println("Conductor: " + getNombreCompleto() + "\nCedula: " + getDocumento() + "\nFecha de nacimiento: " + getFechaNacimiento());
        if (vehiculos.isEmpty()) {
            System.out.println("No tiene vehículos asignados.");
        } else {
            for (Vehiculo v : vehiculos) {
                System.out.println(v.getDescripcion());
            }
        }
    }





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conductor: ").append(nombre).append(" ").append(apellidos).append("\n");
        sb.append("Documento: ").append(documento).append("\n");
        sb.append("Fecha de nacimiento: ").append(fechaNacimiento).append("\n");
        sb.append("Vehículos asignados:\n");

        for (Vehiculo v : vehiculos) {
            sb.append(" - ").append(v.getDescripcion()).append("\n");
        }

        return sb.toString();
    }

}



