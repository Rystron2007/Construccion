package Modelo.Simples;

import Modelo.Compuestas.Persona;

public class DirectorTecnico extends Persona {

    //Cantidad de Equipos Dirigidos con Anterioridad (Experiencia)
    private int equiposDirigidos;

    //Constructor Parametrizado
    public DirectorTecnico(String cedula, String nombres, String apellidos, int edad, String direccion, String email,
            int equiposDirigidos) {
        this.equiposDirigidos = equiposDirigidos;
    }

    public int getEquiposDirigidos() {
        return equiposDirigidos;
    }

    public void setEquiposDirigidos(int equiposDirigidos) {
        this.equiposDirigidos = equiposDirigidos;
    }
}
