package Modelo;

import java.util.Date;

public class Equipo {
    //Atributos pertenecientes a un Equipo
    private String nombreEquipo;
    private String paisOrigen;
    //Contrato Afiliado con un DirectorTécnico
    private Contrato contrato;

    //Constructor Parametrizado
    public Equipo(String nombreEquipo, String paisOrigen) {
        this.nombreEquipo = nombreEquipo;
        this.paisOrigen = paisOrigen;
    }

    //Método para Crear un Contrato asociación un Director Técnico Existente
    public Contrato crearContrato() {
        String codigoContrato = "UG2021CDS";
        Date fechaInicio = new Date();
        Date fechaFin = new Date();
        Estado estado = Estado.PENDIENTE;
        
        //Creación de Prueba para el Director Técnico
        DirectorTecnico directorTecnico = new DirectorTecnico("cedula",
                new ActaNacimiento("01234","John", "Palacios", "Ecuatoriano"), 20, "Sauces", "john@gmail.com", 10);

        Contrato contrato = new Contrato(codigoContrato, fechaInicio, fechaFin, estado, directorTecnico);

        this.contrato = contrato;
        return contrato;
    }
    
    public void eliminarContrato(){
        //Se válida el Contrato existente y se procede con su Eliminación
    }

    //Métodos GET y SET
    public void setContrato() {
        this.contrato = crearContrato();
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

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
