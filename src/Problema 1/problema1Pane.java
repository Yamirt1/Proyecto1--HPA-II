import java.util.Scanner;
import javax.swing.JOptionPane;

public class problema1Pane {

    public static void main(String[] args) {
        mostrarBienvenida();

        int respuesta = preguntarConfirmacion("¿Quiere continuar?");
        if (respuesta == JOptionPane.YES_OPTION) {
            ejecutarMenu();
        }
    }

    public static void mostrarBienvenida() {
        JOptionPane.showMessageDialog(null, "Bienvenidos al menú de ASCII");
    }

    public static int preguntarConfirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, "Confirmar", JOptionPane.YES_NO_OPTION);
    }

    public static void ejecutarMenu() {
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
                    case "1" -> encriptarTexto();
                    case "2" -> desencriptarTexto();
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                }
            }
        }
    }

    public static void encriptarTexto() {
        String texto = JOptionPane.showInputDialog(null, "Escribe algo para encriptarlo:");
        if (texto != null) {
            StringBuilder encriptado = new StringBuilder();
            for (int i = 0; i < texto.length(); i++) {
                int ascii = texto.charAt(i);
                encriptado.append(ascii).append(" ");
            }
            JOptionPane.showMessageDialog(null, "Texto en código ASCII:\n" + encriptado.toString());
            JOptionPane.showMessageDialog(null, "Presione 'OK' para volver al menú principal.");
        }
    }

    public static void desencriptarTexto() {
        String numeros = JOptionPane.showInputDialog(null, "Escribe los números ASCII separados por espacios para desencriptar:");
        if (numeros != null) {
            Scanner lector = new Scanner(numeros);
            StringBuilder texto = new StringBuilder();

            while (lector.hasNextInt()) {
                int ascii = lector.nextInt();
                texto.append((char) ascii);
            }
            JOptionPane.showMessageDialog(null, "Texto desencriptado:\n" + texto.toString());
            JOptionPane.showMessageDialog(null, "Presione 'OK' para volver al menú principal.");
        }
    }
}
