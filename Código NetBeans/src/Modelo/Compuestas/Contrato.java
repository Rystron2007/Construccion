package Modelo.Compuestas;

import Modelo.Simples.DirectorTecnico;
import Modelo.Simples.Equipo;
import Modelo.Simples.Estado;
import java.util.Date;

/**
 *
 * @author John
 */
public class Contrato {

    private String codigoContrato;
    private Date fechaInicio;
    private Date fechaFin;
    private Estado estado;
    private Equipo equipo;
    private DirectorTecnico directorTecnico;

    /**
     * Constructor Parametrizado
     *
     * @param codigoContrato
     * @param fechaInicio
     * @param fechaFin
     * @param estadoContrato
     * @param equipoAsociado
     * @param directorTecnico
     */
    public Contrato(String codigoContrato, Date fechaInicio, Date fechaFin, Estado estadoContrato, Equipo equipoAsociado,
            DirectorTecnico directorTecnico) {
        this.codigoContrato = codigoContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estadoContrato;
        this.equipo = equipoAsociado;
        this.directorTecnico = directorTecnico;
    }

    /**
     * Código Contrato
     *
     * @return
     */
    public String getCodigoContrato() {
        return codigoContrato;
    }

    /**
     * Código Contrato
     *
     * @param codigoContrato
     */
    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    /**
     * Fecha Inicio
     *
     * @return
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Fecha Inicio
     *
     * @param fechaInicio
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Fecha Fin
     *
     * @return
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Fecha Fin
     *
     * @param fechaFin
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Estado
     *
     * @return
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Estado
     *
     * @param estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Equipo
     *
     * @return
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Equipo
     *
     * @param equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Director Tecnico
     *
     * @return
     */
    public DirectorTecnico getDirectorTecnico() {
        return directorTecnico;
    }

    /**
     * Director Tecnico
     *
     * @param directorTecnico
     */
    public void setDirectorTecnico(DirectorTecnico directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

}
