package co.edu.uniquindio;

public class Camion extends Vehiculo{
    private final int numeroEjes;
    private final double capacidadCargaToneladas;

    public Camion(String placa, Conductor conductor, int numeroEjes, double capacidadCarga) {
        super(placa, conductor);
        this.numeroEjes = numeroEjes;
        this.capacidadCargaToneladas = capacidadCarga;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    @Override
    public double calcularPeaje() {
        double base = 7000 * numeroEjes;
        if (capacidadCargaToneladas > 10) base *= 1.1;
        return Math.round(base); // Redondea al entero más cercano
    }




    public double getCapacidadCargaToneladas() {
        return capacidadCargaToneladas;
    }



    @Override
    public String getDescripcion() {
        return "\nCamion: " +
                " \nPlaca: " + placa +
                "\nNumeroEjes: " + numeroEjes +
                ", \nCapacidad Carga: " + capacidadCargaToneladas +

                '.';
    }




}
