
import java.util.Scanner;
import javax.swing.JOptionPane;

public class problema1Pane {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenidos al menu de ACSII");

        int respuesta1 = JOptionPane.showConfirmDialog(null, "¿Quiere continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (respuesta1 == JOptionPane.YES_OPTION) {
            boolean salir = false;

            while (!salir) {
                String menu = """
                              Seleccione una de estas opciones:
                              1. Encriptar
                              2. Desencriptar
                              3. Salir""";

                String seleccion = JOptionPane.showInputDialog(null, menu, "Menú principal del ACSII", JOptionPane.QUESTION_MESSAGE);

                if (seleccion == null || seleccion.equals("3")) {
                    salir = true;
                } else {
                    switch (seleccion) {
                        case "1" -> {
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

                        case "2" -> {
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

                        default -> {
                            JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                        }
                    }
                }
            }
        }
    }
}
