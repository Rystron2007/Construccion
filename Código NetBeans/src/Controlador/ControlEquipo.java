/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DataBase.Conexion;
import Modelo.Simples.Equipo;
import Modelo.DataBase.EquipoDB;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lozano
 */
public class ControlEquipo {

    private Equipo equipo;
    private EquipoDB equipoDB;
    private Conexion conexion;
    private DefaultTableModel tableModel;

    /**
     * Constructor Sin Parámetros
     */
    public ControlEquipo() {
        this.equipoDB = new EquipoDB();
        this.tableModel = new DefaultTableModel();
    }

    /**
     * Constructor Parametrizado
     *
     * @param nombreEquipo
     * @param paisOrigen
     */
    public ControlEquipo(String nombreEquipo, String paisOrigen) {
        this.equipo = new Equipo(nombreEquipo, paisOrigen);
        this.equipoDB = new EquipoDB();
        this.tableModel = new DefaultTableModel();
    }

    /**
     * Registrar Equipo en DataBase
     */
    public void registrarEquipo() {

        try {
            String query = "insert into Equipo (nombre_equipo, pais_origen) values (?,?)";
            equipoDB.registrar(query, equipo);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el registro....Intentelo de nuevo");
        }
    }

    /**
     * Listar Equipos de DataBase
     *
     * @param tablaEquipo
     */
    public void listarEquipo(JTable tablaEquipo) {

        try {
            tableModel = (DefaultTableModel) tablaEquipo.getModel();
            List<Equipo> lista = equipoDB.listar();
            Object[] ob = new Object[2];
            for (int i = 0; i < lista.size(); i++) {
                ob[0] = lista.get(i).getNombreEquipo();
                ob[1] = lista.get(i).getPaisOrigen();
                tableModel.addRow(ob);
            }
            tablaEquipo.setModel(tableModel);
            JOptionPane.showMessageDialog(null, "Busqueda con exito!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda....Intentelo de nuevo");
        }
    }

    /**
     * Buscar Equipo en DataBase
     *
     * @param tablaEquipo
     * @param nombreBuscado
     */
    public void buscarEquipo(JTable tablaEquipo, String nombreBuscado) {
        try {
            tableModel = (DefaultTableModel) tablaEquipo.getModel();
            tableModel.setRowCount(0);
            List<Equipo> lista = equipoDB.buscar(nombreBuscado);
            Object[] ob = new Object[2];
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNombreEquipo().compareTo(nombreBuscado) == 0) {
                    ob[0] = lista.get(i).getNombreEquipo();
                    ob[1] = lista.get(i).getPaisOrigen();
                    tableModel.addRow(ob);
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda....Intentelo de nuevo");
        }
    }

    /**
     * Actualizar Equipo en DataBase
     *
     * @param nombreBuscado
     */
    public void modificarEquipo(String nombreBuscado) {
        equipo = new Equipo();
        Equipo antiguo = new Equipo(nombreBuscado, "");
        try {
            String query = "update Equipo SET nombre_equipo = ?, pais_origen = ?  where nombre_equipo = ?";
            equipoDB.modificar(query, equipo, antiguo);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion....Intentelo de nuevo");
        }
    }

    /**
     * Eliminar Equipo de DataBase
     *
     * @param nombreBuscado
     */
    public void eliminarEquipo(String nombreBuscado) {
        Equipo antiguo = new Equipo(nombreBuscado, "");
        try {
            String query = "delete from Equipo where nombre_equipo = ?";
            equipoDB.remover(query, antiguo);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la eliminación....Intentelo de nuevo");
        }
    }

    /**
     * Retornar Conexión
     *
     * @return
     */
    public Conexion getConexion() {
        return conexion;
    }

    /**
     * Asignar Conexión
     *
     * @param conexion
     */
    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

}
