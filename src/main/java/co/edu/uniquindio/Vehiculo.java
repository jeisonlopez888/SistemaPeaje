package co.edu.uniquindio;

public abstract class Vehiculo implements Descriptible{
    protected String placa;
    protected int numeroPeajesPagados;
    protected Conductor conductor;

    public Vehiculo(String placa, Conductor conductor) {
        this.placa = placa;
        this.conductor = conductor;
        this.numeroPeajesPagados = 0;
    }

    public abstract double calcularPeaje();

    public String getPlaca() {
        return placa;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroPeajesPagados() {
        return numeroPeajesPagados;
    }

    public void setNumeroPeajesPagados(int numeroPeajesPagados) {
        this.numeroPeajesPagados = numeroPeajesPagados;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    protected double totalPagadoPeajes;

    public double getTotalPagadoPeajes() {
        return totalPagadoPeajes;
    }


    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", numeroPeajesPagados=" + numeroPeajesPagados +
                ", conductor=" + conductor +
                '}';
    }


    public abstract String getDescripcion();



}

