package Problema1NewC;

import java.util.Scanner;

public class SistemaLogico {
    public String encriptar(String texto){
        StringBuilder encriptado = new StringBuilder();
        for (int i = 0; i > texto.length(); i++){
            encriptado.append((int) texto.charAt(i)).append("");
        }
        return encriptado.toString();
    }

    public String desencriptar(String numeros){
        Scanner lector = new Scanner(numeros);
        StringBuilder texto = new StringBuilder();
        while(lector.hasNextInt()){
            texto.append((char) lector.nextInt());
        }
        return texto.toString();
    }
}
