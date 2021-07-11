package Modelo.Simples;

import Modelo.Compuestas.Persona;

public class Arbitro extends Persona {

    //Cantidad de Partidos Arbitrados con Anterioridad (Experiencia)
    private int partidosArbitrados;

    //Constructor Parametrizado
    public Arbitro(String cedula, String nombres, String apellidos, int edad, String direccion, String email,
            int partidosArbitrados) { 
        this.partidosArbitrados = partidosArbitrados;
    }

    public Arbitro() {

    }

    //Metodos GET y SET
    public int getPartidosArbitrados() {
        return partidosArbitrados;
    }

    public void setPartidosArbitrados(int partidosArbitrados) {
        this.partidosArbitrados = partidosArbitrados;
    }

}
