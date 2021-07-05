package Modelo.Compuestas;

import Modelo.Simples.DirectorTecnico;
import Modelo.Simples.Estado;
import java.util.Date;

public class Contrato {

    //Información de un Contrato entre un Director Técnico y un Equipo
    private String codigoContrato;
    private Date fechaInicio;
    private Date fechaFin;
    //Estado del Contrato (ACEPTADO, CANCELADO, PENDIENTE)
    private Estado estado;
    private DirectorTecnico directorTecnico;

    //Constructor Parametrizado
    public Contrato(String codigoContrato, Date fechaInicio, Date fechaFin, Estado estado,
            DirectorTecnico directorTecnico) {
        this.codigoContrato = codigoContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.directorTecnico = directorTecnico;
    }

    //Métodos GET y SET
    public String getCodigoContrato() {
        return codigoContrato;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public Estado getEstado() {
        return estado;
    }

    public DirectorTecnico getDirectorTecnico() {
        return directorTecnico;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setDirectorTecnico(DirectorTecnico directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

}
