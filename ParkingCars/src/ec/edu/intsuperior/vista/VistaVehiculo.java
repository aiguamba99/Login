package ec.edu.intsuperior.vista;

import javax.swing.*;
import java.awt.*;

public class VistaVehiculo extends JFrame {

    // Componentes de la vista
    public JTextField txtPlaca;
    public JSpinner spnHoraEntrada;
    public JSpinner spnHoraSalida;
    public JCheckBox chkFeriado;
    public JButton btnCalcular;
    public JLabel lblResultado;

    public VistaVehiculo() {
        setTitle("Calcular Costo de Estacionamiento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        // Inicializar componentes
        txtPlaca = new JTextField();
        spnHoraEntrada = new JSpinner(new SpinnerDateModel());
        spnHoraSalida = new JSpinner(new SpinnerDateModel());
        chkFeriado = new JCheckBox("Es feriado");
        btnCalcular = new JButton("Calcular");
        lblResultado = new JLabel("Resultado:");

        // Configurar JSpinner para formato de hora
        JSpinner.DateEditor editorEntrada = new JSpinner.DateEditor(spnHoraEntrada, "HH:mm");
        spnHoraEntrada.setEditor(editorEntrada);
        JSpinner.DateEditor editorSalida = new JSpinner.DateEditor(spnHoraSalida, "HH:mm");
        spnHoraSalida.setEditor(editorSalida);

        // Añadir componentes al frame
        add(new JLabel("Placa:"));
        add(txtPlaca);
        add(new JLabel("Hora de entrada:"));
        add(spnHoraEntrada);
        add(new JLabel("Hora de salida:"));
        add(spnHoraSalida);
        add(chkFeriado);
        add(new JLabel());
        add(btnCalcular);
        add(lblResultado);
    }
}
