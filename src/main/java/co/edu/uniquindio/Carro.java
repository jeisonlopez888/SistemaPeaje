package co.edu.uniquindio;

public class Carro extends Vehiculo{
    private boolean electrico;
    private boolean servicioPublico;

    public Carro(String placa, Conductor conductor, boolean electrico, boolean servicioPublico) {
        super(placa, conductor);
        this.electrico = electrico;
        this.servicioPublico = servicioPublico;
    }


    public boolean isElectrico() {

        return electrico;
    }
    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }


    public boolean isServicioPublico() {

        return servicioPublico;
    }
    public void setServicioPublico(boolean servicioPublico) {
        this.servicioPublico = servicioPublico;
    }


    @Override
    public double calcularPeaje() {
        double base = 10000;
        if (electrico) base *= 0.8;
        if (servicioPublico) base *= 1.15;
        return Math.round (base);
    }

    @Override
    public String getDescripcion() {
        return "\nCarro: " +
                " \nPlaca: " + placa +
                ", \nEléctrico: " + (electrico ? "sí" : "no") +
                ", \nServicio Público: " + (servicioPublico ? "sí" : "no")+ '.';

    }




}
