package Modelo.Simples;

/**
 *
 * @author John
 */
public class Equipo {

    private String nombreEquipo;
    private String paisOrigen;

    /**
     * Constructor Parametrizado
     * @param nombreEquipo
     * @param paisOrigen
     */
    public Equipo(String nombreEquipo, String paisOrigen) {
        this.nombreEquipo = nombreEquipo;
        this.paisOrigen = paisOrigen;
    }

    /**
     * Constructor sin Parametros
     */
    public Equipo() {
    }

    /**
     * Obtiene el Nombre del Equipo
     * @return
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Inserta el Nombre del Equipo
     * @param nombreEquipo
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * Obtiene el Pais de Origen
     * @return
     */
    public String getPaisOrigen() {
        return paisOrigen;
    }

    /**
     * Inserta el Pais de Origen
     * @param paisOrigen
     */
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
