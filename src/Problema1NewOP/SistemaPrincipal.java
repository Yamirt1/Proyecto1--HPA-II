package Problema1NewOP;

import javax.swing.JOptionPane;

public class SistemaPrincipal {

    private SistemaLogico sistemaL = new SistemaLogico();

    public void mostrarBienvenida() {
        JOptionPane.showMessageDialog(null, "Bienvenidos al menú de ASCII");
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Quiere continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            mostrarMenu();
        }
    }

    private void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            String menu = """
                    Seleccione una de estas opciones:
                    1. Encriptar
                    2. Desencriptar
                    3. Salir""";
            String seleccion = JOptionPane.showInputDialog(null, menu, "Menú principal del ASCII", JOptionPane.QUESTION_MESSAGE);

            if (seleccion == null || seleccion.equals("3")) {
                salir = true;
            } else {
                switch (seleccion) {
                    case "1" ->
                        encriptarTexto();
                    case "2" ->
                        desencriptarTexto();
                    default ->
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                }
            }
        }
    }

    private void encriptarTexto() {
        String texto = JOptionPane.showInputDialog(null, "Escribe algo para encriptarlo:");
        if (texto != null) {
            String encriptado = sistemaL.encriptar(texto);
            JOptionPane.showMessageDialog(null, "Texto en código ASCII:\n" + encriptado);
            JOptionPane.showMessageDialog(null, "Presione 'OK' para volver al menú principal.");
        }
    }

    private void desencriptarTexto() {
        String numeros = JOptionPane.showInputDialog(null, "Escribe los números ASCII separados por espacios para desencriptar:");
        if (numeros != null) {
            String texto = sistemaL.desencriptar(numeros);
            JOptionPane.showMessageDialog(null, "Texto desencriptado:\n" + texto);
            JOptionPane.showMessageDialog(null, "Presione 'OK' para volver al menú principal.");
        }
    }
}
