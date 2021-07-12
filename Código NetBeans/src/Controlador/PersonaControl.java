/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Compuestas.Persona;
import Modelo.DataBase.Conexion;
import Modelo.DataBase.PersonaDB;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Eileen
 */
public class PersonaControl {
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected int edad;
    protected String direccion;
    protected String email;
    private Persona persona;
    private PersonaDB conector;
    private Conexion conexion;
    private DefaultTableModel tableModel;
    
    
    //Constructor sin parametros usados para las busquedas 
    public PersonaControl() {
        this.conector = new PersonaDB();
        this.tableModel = new DefaultTableModel();
    }
    
    //Constructor con parametros usados para los registros y modificaciones

    public PersonaControl(String ced, String nombres, String apellidos, int edad, String direccion, String email) {
        this.cedula = ced;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.email = email;
        this.persona = new Persona(this.cedula, this.nombres, this.apellidos, this.edad, this.direccion, this.email);
        this.conector = new PersonaDB();
        this.tableModel = new DefaultTableModel();
    }
    
    
    public void registrarPersona() {
        conector.setConexion(conexion);
        try {
            String query = "INSERT INTO PERSONA (CEDULA, EDAD, NOMBRES, APELLIDOS, DIRECCION, EMAIL) VALUES (?,?,?,?,?,?)";
            conector.registrar(query, persona);
            JOptionPane.showMessageDialog(null, "Registro realizado con exito!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el registro....Intentelo de nuevo");
        }   
    }
    
    /*public void actualizarPersona(String cedula) {
        conector.setConexion(conexion);
        Persona antiguo = new Persona(cedula, "");
        try {
            String query = "update PERSONA SET cedula = ?, nombres = ?, apellidos = ?, edad = ?, direccion = ?, email = ?,  where cedula = ?";
            conector.modificar2(query, persona, antiguo);
            JOptionPane.showMessageDialog(null, "Modificacion realizada con exito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion....Intentelo de nuevo");
        }
    }*/
    
    public void buscarPersona(JTable tabla, String cedula) {
        conector.setConexion(conexion);
        boolean validar = false;
        try {
            tableModel = (DefaultTableModel) tabla.getModel();
            List<Persona> lista = conector.buscar(cedula);
            Object[] ob = new Object[2];
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getCedula().compareTo(cedula) == 0) {
                    ob[0] = lista.get(i).getCedula();
                    ob[1] = lista.get(i).getNombres();
                    ob[2] = lista.get(i).getApellidos();
                    ob[3] = lista.get(i).getEdad();
                    ob[4] = lista.get(i).getDireccion();
                    ob[5] = lista.get(i).getEmail();
                    tableModel.addRow(ob);
                    validar = true;
                }
            }
            tabla.setModel(tableModel);
            if (validar) {
                tabla.setModel(tableModel);
                JOptionPane.showMessageDialog(null, "Busqueda con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "No está registrado");
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda....Intentelo de nuevo");
        }
    }
    
    /*public void eliminarPersona(String cedula) {
        conector.setConexion(conexion);
        Persona antiguo = new Persona(cedula, "");
        try {
            String query = "delete from PERSONA where cedula = ?";
            conector.remover(query, antiguo);
            JOptionPane.showMessageDialog(null, "Eliminacion realizada con exito!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la eliminación....Intentelo de nuevo");
        }
    }*/
    
    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
 
}
