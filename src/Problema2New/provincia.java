package Problema2New;

public class provincia {

    private String nombre;
    private int votosBlanco;

    public provincia(String nombre) {
        this.nombre = nombre;
        this.votosBlanco = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVotosBlanco() {
        return votosBlanco;
    }

    public void agregarVotosBlanco(int cantidad) {
        votosBlanco += cantidad;
    }
}
