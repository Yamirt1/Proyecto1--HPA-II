// Amilkar    
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class problema1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion;

        do {
            System.out.println("      Menu");
            System.out.println("---------------");
            System.out.println("1-Encriptar");
            System.out.println("2-Desencriptar");
            System.out.println("3-Salir");
            System.out.println("---------------");

            opcion = Integer.parseInt(reader.readLine());

            switch (opcion) {
                case 1 -> {
                    System.out.println("\nEscribe algo para encriptarlo");
                    System.out.println("-------------------------------");
                    String palabra = reader.readLine();

                    System.out.println("-------------------------------");
                    System.out.print("Palabra en codigo ACSII: ");
                    for (int i = 0; i < palabra.length(); i++) {
                        int ascii = palabra.charAt(i);

                        System.out.print(ascii + " ");
                    }

                    String volver;
                    do {
                        System.out.println("\n-------------------------------");
                        System.out.println("\nPresione 0 para volver al menu principal!");
                        System.out.println("-------------------------------");
                        volver = reader.readLine();
                    } while (!volver.equals("0"));
                }

                case 2 -> {
                    System.out.println("\nEscribe con numeros lo que deseas desencriptar");
                    System.out.println("-------------------------------");
                    String textoEncriptado = reader.readLine();

                    Scanner lector = new Scanner(textoEncriptado);

                    System.out.println("-------------------------------");
                    System.out.print("Texto desencriptado: ");
                    while (lector.hasNextInt()) {
                        int ascii = lector.nextInt();
                        System.out.print((char) ascii);
                    }
                    System.out.println();

                    String volver;
                    do {
                        System.out.println("-------------------------------");
                        System.out.println("\nPresione 0 para volver al menú principal:");
                        System.out.println("------------------------------");
                        volver = reader.readLine();
                    } while (!volver.equals("0"));
                }

                case 3 -> {
                    System.out.println("--------------");
                    System.out.println("Saliendo del programa...!");
                }

                default -> {
                    System.out.println("Opción no valida");
                }
            }
        } while (opcion != 3);
    }
}
