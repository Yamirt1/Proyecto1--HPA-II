package Problema2New;

public class candidato {
    
    // Guarda el nombre del candidato y los votos por provincia
    private String nombre;
    private int votosPanama;
    private int votosPanamaOeste;
    private int votosChiriqui;
    private int votosColon;

    public candidato(String nombre) {
        this.nombre = nombre;
        this.votosPanama = 0;
        this.votosPanamaOeste = 0;
        this.votosChiriqui = 0;
        this.votosColon = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVotosPanama() {
        return votosPanama;
    }
    public int getVotosPanamaOeste() {
        return votosPanamaOeste;
    }
    public int getVotosChiriqui() {
        return votosChiriqui;
    }
    public int getVotosColon() {
        return votosColon;
    }

    public void agregarVotos(String provincia, int cantidad){
        if (provincia.equals("Panamá")) votosPanama += cantidad;
        else if(provincia.equals("Panamá Oeste")) votosPanamaOeste += cantidad;
        else if(provincia.equals("Chiriquí")) votosChiriqui += cantidad;
        else if(provincia.equals("Colón")) votosColon += cantidad;
    }

    public int getTotalVotos() {
        return votosPanama + votosPanamaOeste + votosChiriqui + votosColon;
    }
}
