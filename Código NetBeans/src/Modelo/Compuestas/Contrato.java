package Modelo.Compuestas;

import Modelo.Simples.DirectorTecnico;
import Modelo.Simples.Equipo;
import Modelo.Simples.Estado;
import java.util.Date;

public class Contrato {

    //Información de un Contrato entre un Director Técnico y un Equipo
    private String codigoContrato;
    private Date fechaInicio;
    private Date fechaFin;
    //Estado del Contrato (ACEPTADO, CANCELADO, PENDIENTE)
    private Estado estado;
    private Equipo equipo;
    private DirectorTecnico directorTecnico;

    //Constructor Parametrizado
    public Contrato(String codigoContrato, Date fechaInicio, Date fechaFin, Estado estado, Equipo equipo,
            DirectorTecnico directorTecnico) {
        this.codigoContrato = codigoContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.equipo = equipo;
        this.directorTecnico = directorTecnico;
    }

    //Métodos GET y SET
    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public DirectorTecnico getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(DirectorTecnico directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

}
