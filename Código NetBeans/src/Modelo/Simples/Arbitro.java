package Modelo.Simples;

import Modelo.Compuestas.Persona;

/**
 *
 * @author John
 */
public class Arbitro extends Persona {

    private int partidosArbitrados;

    /**
     *
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param edad
     * @param direccion
     * @param email
     * @param partidosArbitrados
     */
    public Arbitro(String cedula, String nombres, String apellidos, int edad, String direccion, String email,
            int partidosArbitrados) {
        this.partidosArbitrados = partidosArbitrados;
    }

    /**
     *
     */
    public Arbitro() {

    }

    /**
     *
     * @return
     */
    public int getPartidosArbitrados() {
        return partidosArbitrados;
    }

    /**
     *
     * @param partidosArbitrados
     */
    public void setPartidosArbitrados(int partidosArbitrados) {
        this.partidosArbitrados = partidosArbitrados;
    }

}
