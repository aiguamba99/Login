package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.Vehiculo;
import ec.edu.intsuperior.vista.VistaVehiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControladorVehiculo {
    private VistaVehiculo vista;

    public ControladorVehiculo(VistaVehiculo vista) {
        this.vista = vista;

        this.vista.btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCosto();
            }
        });
    }

    public void calcularCosto() {
        try {
            String placa = vista.txtPlaca.getText();
            if (placa.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor, ingrese la placa.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!placa.matches("[A-Z0-9-]+")) {
                JOptionPane.showMessageDialog(vista, "La placa debe contener solo letras, números o guiones.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean esFeriado = vista.chkFeriado.isSelected();

            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date entradaDate = (Date) vista.spnHoraEntrada.getValue();
            Date salidaDate = (Date) vista.spnHoraSalida.getValue();

            LocalTime horaEntrada = LocalTime.parse(dateFormat.format(entradaDate));
            LocalTime horaSalida = LocalTime.parse(dateFormat.format(salidaDate));

            if (horaEntrada.isAfter(horaSalida)) {
                JOptionPane.showMessageDialog(vista, "La hora de entrada no puede ser posterior a la salida.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Vehiculo vehiculo = new Vehiculo(placa, horaEntrada, horaSalida, esFeriado);
            double costo = vehiculo.calcularCosto();

            vista.lblResultado.setText("Costo: $" + String.format("%.2f", costo));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al calcular el costo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


