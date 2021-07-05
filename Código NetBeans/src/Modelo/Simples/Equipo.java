package Modelo.Simples;

public class Equipo {

    //Atributos pertenecientes a un Equipo
    private String nombreEquipo;
    private String paisOrigen;

    //Constructor Parametrizado
    public Equipo(String nombreEquipo, String paisOrigen) {
        this.nombreEquipo = nombreEquipo;
        this.paisOrigen = paisOrigen;
    }

    public Equipo() {
    }

    //Métodos GET y SET
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
