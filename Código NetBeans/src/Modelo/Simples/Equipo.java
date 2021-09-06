package Modelo.Simples;

/**
 * Clase Básica de Equipo
 *
 * @author John
 */
public class Equipo {

    private String nombreEquipo;
    private String paisOrigen;

    /**
     * Constructor con Parámetros
     *
     * @param nombreEquipo Nombre del Equipo
     * @param paisOrigen País de Origen del Equipo
     */
    public Equipo(String nombreEquipo, String paisOrigen) {
        this.nombreEquipo = nombreEquipo;
        this.paisOrigen = paisOrigen;
    }

    /**
     * Constructor sin Parámetros
     */
    public Equipo() {
    }

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
