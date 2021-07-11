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
import javax.swing.JOptionPane;
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

    public PersonaControl(String cedula, String nombres, String apellidos, int edad, String direccion, String email) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.email = email;
        this.persona = new Persona(this.cedula, this.nombres, this.apellidos, this.edad, this.direccion, this.email);
        this.conector = new PersonaDB();
        this.tableModel = new DefaultTableModel();
    }
    
    
    public void registrarEquipo() {
        conector.setConexion(conexion);
        try {
            String query = "insert into PERSONA (cedula, edad, direccion, email) values (?,?,?,?)";
            conector.registrar(query, persona);
            JOptionPane.showMessageDialog(null, "Registro realizado con exito!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar el registro....Intentelo de nuevo");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
 
}
