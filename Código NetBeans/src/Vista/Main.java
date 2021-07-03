/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Conexion;
import Modelo.Contrato;
import Modelo.Equipo;
import Modelo.EquipoDB;
import Modelo.Estado;

/**
 *
 * @author John
 */
public class Main {

    public static void main(String[] args) {
       /* Equipo equipo = new Equipo("UG2022", "Ecuador");
        EquipoDB conector = new EquipoDB();
        String query = "insert into Equipo (nombre_equipo, pais_origen) values (?,?)";
        conector.registrar(query, equipo);
        query = "update Equipo SET nombre_equipo = ?, pais_origen = ? where id_equipo = 1";
        conector.modificar(query, equipo);
        query = "select * from Equipo";
        conector.listar(query);
        query = "delete from Equipo where id_equipo = 1";
        conector.remover(query);
        query = "select * from Equipo";
        conector.listar(query);
        */
        Equipos equipo = new Equipos();
        equipo.setVisible(true);
        //Fin
    }
}
