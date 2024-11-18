package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.vista.VistaVehiculo;

public class App {

    public static void main(String[] args) {
        VistaVehiculo vista = new VistaVehiculo();
        new ControladorVehiculo(vista);
        vista.setVisible(true);
    }
}
