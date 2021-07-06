/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Vista.Equipo.FrameEquipo;
import Modelo.DataBase.Conexion;
import Modelo.Compuestas.Contrato;
import Modelo.Simples.Equipo;
import Modelo.DataBase.EquipoDB;
import Modelo.Simples.Estado;

/**
 *
 * @author John
 */
public class Main {

    public static void main(String[] args) {
        FrameEquipo equipo = new FrameEquipo();
        equipo.setVisible(true);
    }
}
