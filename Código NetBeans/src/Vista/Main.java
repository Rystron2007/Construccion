/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Conexion;
import Modelo.Contrato;
import Modelo.Equipo;
import Modelo.Estado;

/**
 *
 * @author John
 */
public class Main {

    public static void main(String[] args) {
        //Creación del Equipo
        /*Equipo equipo = new Equipo("UG2021", "Ecuador");
        System.out.println("Se procederá a crear un nuevo Contrato");
        Contrato test = equipo.crearContrato();
        System.out.println("Estado del Contrato: " + test.getEstado());
        //Cambio de Estado del Contrato (PENDIENTE --> ACEPTADO)
        test.setEstado(Estado.ACEPTADO);
        //Test Para Comprobar la Creación del Contrato y del Director Técnico
        if (test != null) {
            System.out.println("¡Contrato Creado Satisfactoriamente!\n");
            System.out.println("Datos del Contrato");
            System.out.println("Código: " + test.getCodigoContrato()
                    + "\nFecha Inicio: " + test.getFechaInicio()
                    + "\nFecha Fin: " + test.getFechaFin()
                    + "\nEstado: " + test.getEstado()
                    + "\nDatos Director Técnico\n" + test.getDirectorTecnico().obtenerActaNacimiento());
        }*/
        Conexion.getConnection();

        
    }
}
