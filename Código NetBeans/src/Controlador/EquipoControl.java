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
    
    //Atributos para la gestión de Equipos
    private String nombreEquipo;
    private String pais_origen;
    private Equipo equipo;
    private EquipoDB conector;
    private Conexion conexion;
    private DefaultTableModel tableModel;

    //Constructor sin parametros usados para las busquedas 
    public EquipoControl() {
        this.conector = new EquipoDB();
        this.tableModel = new DefaultTableModel();
    }
    
    //Constructor con parametros usados para los registros y modificaciones
    public EquipoControl(String nombre, String pais_origen) {
        this.nombreEquipo = nombre;
        this.pais_origen = pais_origen;
        this.equipo = new Equipo(this.nombreEquipo, this.pais_origen);
        this.conector = new EquipoDB();
        this.tableModel = new DefaultTableModel();
    }

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

    public void listarEquipo(JTable tabla) {
        iniciarConector();
        try {
            tableModel = (DefaultTableModel) tabla.getModel();
            List<Equipo> lista = conector.listar();
            Object[] ob = new Object[2];
            for (int i = 0; i < lista.size(); i++) {
                ob[0] = lista.get(i).getNombreEquipo();
                ob[1] = lista.get(i).getPaisOrigen();
                tableModel.addRow(ob);
            }
            tabla.setModel(tableModel);
            JOptionPane.showMessageDialog(null, "Busqueda con exito!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda....Intentelo de nuevo");
        }
    }

    public void buscarEquipo(JTable tabla, String nombre) {
        iniciarConector();
        boolean validar = false;
        try {
            tableModel = (DefaultTableModel) tabla.getModel();
            tableModel.setRowCount(0);
            List<Equipo> lista = conector.buscar(nombre);
            Object[] ob = new Object[2];
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getNombreEquipo().compareTo(nombre) == 0) {
                    ob[0] = lista.get(i).getNombreEquipo();
                    ob[1] = lista.get(i).getPaisOrigen();
                    tableModel.addRow(ob);
                    validar = true;
                }
            }
            if (validar) {
                tabla.setModel(tableModel);
                JOptionPane.showMessageDialog(null, "Busqueda con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "No existe el equipo");
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda....Intentelo de nuevo");
        }
    }

    public void actualizarEquipo(String nombre) {
        iniciarConector();
        Equipo antiguo = new Equipo(nombre, "");
        try {
            String query = "update Equipo SET nombre_equipo = ?, pais_origen = ?  where nombre_equipo = ?";
            conector.modificar(query, equipo, antiguo);
            JOptionPane.showMessageDialog(null, "Modificacion realizada con exito!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion....Intentelo de nuevo");
        }
    }

    public void eliminarEquipo(String nombre) {
        iniciarConector();
        Equipo antiguo = new Equipo(nombre, "");
        try {
            String query = "delete from Equipo where nombre_equipo = ?";
            conector.remover(query, antiguo);
            JOptionPane.showMessageDialog(null, "Eliminacion realizada con exito!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la eliminación....Intentelo de nuevo");
        }
    }
    
    //Se inicializa el Conector para la gestión de Equipos
    public void iniciarConector() {
        conector.setConexion(conexion);
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

}
