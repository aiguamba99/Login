package ec.edu.intsuperior.modelo;

import java.time.LocalTime;

public class Vehiculo {
    private String placa;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private boolean esFeriado;
    private double tarifa;

    public Vehiculo(String placa, LocalTime horaEntrada, LocalTime horaSalida, boolean esFeriado) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.esFeriado = esFeriado;
        this.tarifa = calcularTarifa();
    }

    // Calcula la tarifa en función del día (feriado o fin de semana)
    private double calcularTarifa() {
        return esFeriado || esFinDeSemana() ? 1.0 : 0.5;
    }

    // Método para calcular el costo total
    public double calcularCosto() {
        long horasEstadia = java.time.Duration.between(horaEntrada, horaSalida).toHours();
        if (horasEstadia < 0) {
            horasEstadia += 24; // Ajuste para casos de paso de medianoche
        }
        return horasEstadia * tarifa;
    }

    // Determina si es fin de semana
    private boolean esFinDeSemana() {
        return java.time.LocalDate.now().getDayOfWeek().getValue() >= 6;
    }

    // Getters
    public String getPlaca() {
        return placa;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public boolean isEsFeriado() {
        return esFeriado;
    }
}
