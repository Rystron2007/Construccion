package Modelo;

public class DirectorTecnico extends Persona {
    //Cantidad de Equipos Dirigidos con Anterioridad (Experiencia)
    private int equiposDirigidos;

    //Constructor Parametrizado
    public DirectorTecnico(String cedula, ActaNacimiento actaNacimiento, int edad, String direccion, String email,
            int equiposDirigidos) {
        super(cedula, actaNacimiento, edad, direccion, email);
        this.equiposDirigidos = equiposDirigidos;
    }

    public int getEquiposDirigidos() {
        return equiposDirigidos;
    }

    public void setEquiposDirigidos(int equiposDirigidos) {
        this.equiposDirigidos = equiposDirigidos;
    }
}
