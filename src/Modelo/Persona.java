package Modelo;

public class Persona {

    //Atributos de Una Persona permitiendo Herencia
    protected String cedula;
    protected ActaNacimiento actaNacimiento;
    protected int edad;
    protected String direccion;
    protected String email;

    public Persona() {

    }

    //Constructor Parametrizado
    public Persona(String cedula, ActaNacimiento actaNacimiento, int edad, String direccion, String email) {
        this.cedula = cedula;
        this.actaNacimiento = actaNacimiento;
        this.edad = edad;
        this.direccion = direccion;
        this.email = email;
    }

    //Método para Obtener los Datos de la Acta de Nacimiento
    public String obtenerActaNacimiento() {
        return "Nombres: " + actaNacimiento.getNombres() + "\nApellidos: " + actaNacimiento.getApellidos()
                + "\nNacionalidad: " + actaNacimiento.getNacionalidad();
    }

    //Métodos GET y SET
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public ActaNacimiento getActaNacimiento() {
        return actaNacimiento;
    }

    public void setActaNacimiento(ActaNacimiento actaNacimiento) {
        this.actaNacimiento = actaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
