package Problema1NewOP;

// Clase donde se implementa toda la logica de encriptar y desencriptar

import java.util.Scanner;

public class SistemaLogico {
    
    public String encriptar(String texto){
        StringBuilder encriptado = new StringBuilder();
        for(int i = 0; i < texto.length(); i++){
            int ascii = texto.charAt(i);
            encriptado.append(ascii).append(" ");
        }
        return encriptado.toString();
    }

    public String desencriptar(String numeros){
        Scanner lector = new Scanner(numeros);
        StringBuilder texto = new StringBuilder();
        while(lector.hasNextInt()){
            int ascii = lector.nextInt();
            texto.append((char) ascii);
        }
        return texto.toString();
    }
}
