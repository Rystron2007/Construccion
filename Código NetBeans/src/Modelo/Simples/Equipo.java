package Modelo.Simples;

/**
 *
 * @author John
 */
public class Equipo {

    private String nombreEquipo;
    private String paisOrigen;

    /**
     *
     * @param nombreEquipo
     * @param paisOrigen
     */
    public Equipo(String nombreEquipo, String paisOrigen) {
        this.nombreEquipo = nombreEquipo;
        this.paisOrigen = paisOrigen;
    }

    /**
     *
     */
    public Equipo() {
    }

    /**
     *
     * @return
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     *
     * @param nombreEquipo
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     *
     * @return
     */
    public String getPaisOrigen() {
        return paisOrigen;
    }

    /**
     *
     * @param paisOrigen
     */
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
