package Modelo;

public class ActaNacimiento {

    //Atributos pertenecientes a una Persona
    private String NUI;
    private String nombres;
    private String apellidos;
    private String nacionalidad;

    //Constructor Parametrizado
    public ActaNacimiento(String NUI,String nombres, String apellidos, String nacionalidad) {
        this.NUI = NUI;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
    }

    public ActaNacimiento() {

    }

    //Métodos GET y SET
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getNUI() {
        return NUI;
    }

    public void setNUI(String NUI) {
        this.NUI = NUI;
    }
    
    

}
