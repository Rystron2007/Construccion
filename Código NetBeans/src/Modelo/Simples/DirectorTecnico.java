package Modelo.Simples;

import Modelo.Compuestas.Persona;

/**
 *
 * @author John
 */
public class DirectorTecnico extends Persona {

    private int equiposDirigidos;

    /**
     *
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param edad
     * @param direccion
     * @param email
     * @param equiposDirigidos
     */
    public DirectorTecnico(String cedula, String nombres, String apellidos, int edad, String direccion, String email,
            int equiposDirigidos) {
        this.equiposDirigidos = equiposDirigidos;
    }

    /**
     *
     * @return
     */
    public int getEquiposDirigidos() {
        return equiposDirigidos;
    }

    /**
     *
     * @param equiposDirigidos
     */
    public void setEquiposDirigidos(int equiposDirigidos) {
        this.equiposDirigidos = equiposDirigidos;
    }
}
