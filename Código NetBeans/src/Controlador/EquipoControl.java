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
public class EquipoControl {

    private String nombreEquipo;
    private String pais_origen;
    private Equipo equipo;
    private EquipoDB conector;
    private Conexion conexion;
    private DefaultTableModel tableModel;

    /**
     * Constructor Sin Parametros
     */
    public EquipoControl() {
        this.conector = new EquipoDB();
        this.tableModel = new DefaultTableModel();
    }

    /**
     * Constructor Parametrizado
     *
     * @param nombreEquipo
     * @param paisOrigen
     */
    public EquipoControl(String nombreEquipo, String paisOrigen) {
        this.nombreEquipo = nombreEquipo;
        this.pais_origen = paisOrigen;
        this.equipo = new Equipo(this.nombreEquipo, this.pais_origen);
        this.conector = new EquipoDB();
        this.tableModel = new DefaultTableModel();
    }

    /**
     * Registrar Equipo en DataBase
     */
    public void registrarEquipo() {
        iniciarConector();
        try {
            String query = "insert into Equipo (nombre_equipo, pais_origen) values (?,?)";
            conector.registrar(query, equipo);
            JOptionPane.showMessageDialog(null, "Registro realizado con exito!");
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
        iniciarConector();
        try {
            tableModel = (DefaultTableModel) tablaEquipo.getModel();
            List<Equipo> lista = conector.listar();
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
        iniciarConector();
        boolean validar = false;
        try {
            tableModel = (DefaultTableModel) tablaEquipo.getModel();
            tableModel.setRowCount(0);
            List<Equipo> lista = conector.buscar(nombreBuscado);
            Object[] ob = new Object[2];
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNombreEquipo().compareTo(nombreBuscado) == 0) {
                    ob[0] = lista.get(i).getNombreEquipo();
                    ob[1] = lista.get(i).getPaisOrigen();
                    tableModel.addRow(ob);
                    validar = true;
                }
            }
            if (validar) {
                tablaEquipo.setModel(tableModel);
                JOptionPane.showMessageDialog(null, "Busqueda con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "No existe el equipo");
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
    public void actualizarEquipo(String nombreBuscado) {
        iniciarConector();
        Equipo antiguo = new Equipo(nombreBuscado, "");
        try {
            String query = "update Equipo SET nombre_equipo = ?, pais_origen = ?  where nombre_equipo = ?";
            conector.modificar(query, equipo, antiguo);
            JOptionPane.showMessageDialog(null, "Modificacion realizada con exito!");
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
        iniciarConector();
        Equipo antiguo = new Equipo(nombreBuscado, "");
        try {
            String query = "delete from Equipo where nombre_equipo = ?";
            conector.remover(query, antiguo);
            JOptionPane.showMessageDialog(null, "Eliminacion realizada con exito!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la eliminación....Intentelo de nuevo");
        }
    }

    /**
     * Iniciar Conexión a DataBase
     */
    public void iniciarConector() {
        conector.setConexion(conexion);
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
