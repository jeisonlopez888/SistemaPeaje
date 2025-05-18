package co.edu.uniquindio;

public class Moto extends Vehiculo{
    private final int cilindraje;

    public Moto(String placa, Conductor conductor, int cilindraje) {
        super(placa, conductor);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    @Override
    public double calcularPeaje() {
        double base = 5000;
        if (cilindraje > 200) base += 2000;
        return Math.round (base);
    }


    @Override
    public String getDescripcion() {
        return "\nMoto: " +
                " \nPlaca: " + placa +
                "\nCilindraje: " + cilindraje +
                '.';
    }

}
