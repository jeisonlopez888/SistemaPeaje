package co.edu.uniquindio;

import java.time.LocalDate;

public class Recaudador {
    private final String nombre;
    private final String apellidos;
    private final String documento;
    private final LocalDate fechaNacimiento;
    private final double sueldoMensual;

    public Recaudador(String nombre, String apellidos, String documento, LocalDate fechaNacimiento, double sueldoMensual) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoMensual = sueldoMensual;
    }

    public String getNombreCompleto() {
        return (nombre + " " + apellidos).trim().toLowerCase().replaceAll("\\s+", " ");
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

    public double getSueldoMensual() {
        return sueldoMensual;
    }



    public void imprimirDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Documento: " + documento);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Sueldo mensual: $" + sueldoMensual);
    }
}


