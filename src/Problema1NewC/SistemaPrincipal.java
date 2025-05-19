package Problema1NewC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SistemaPrincipal {

    private SistemaLogico sistemaL = new SistemaLogico();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void iniciar() throws IOException {
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
                case 1:
                    encriptarTexto();
                    break;
                case 2:
                    desencriptarTexto();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida ");
                    break;
            }
        } while (opcion != 3);
    }

    private void encriptarTexto() throws IOException {
        System.out.println("\nEscribe algo para encriptarlo");
        System.out.println("-------------------------------");
        String palabra = reader.readLine();
        String resultado = sistemaL.encriptar(palabra);
        System.out.println("-------------------------------");
        System.out.println("Palabra en código ASCII: " + resultado);
        volver();
    }

    private void desencriptarTexto() throws IOException {
        System.out.println("\nEscribe con números lo que deseas desencriptar");
        System.out.println("-------------------------------");
        String textoEncriptado = reader.readLine();
        String resultado = sistemaL.desencriptar(textoEncriptado);
        System.out.println("-------------------------------");
        System.out.println("Texto desencriptado: " + resultado);
        volver();
    }

    private void volver() throws IOException {
        int volver;
        do {
            System.out.println("\n-------------------------------");
            System.out.println("Presione 0 para volver al menú principal!");
            System.out.println("-------------------------------");
            volver = System.in.read();
            while(System.in.available() > 0) {
                System.in.read();
            }
        } while (volver != '0');
    }
}
