/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DataBase;

import Modelo.Interfaces.CRUD;
import Modelo.Compuestas.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Eileen
 */
public class PersonaDB implements CRUD{
    private Connection connector;
    private PreparedStatement statement;
    private ResultSet result;
    private Conexion conexion;
    
    
    public int iniciarStatement(String query, Object objeto) throws SQLException {
        try {
            Persona persona = (Persona) objeto;
            statement = connector.prepareStatement(query);
            statement.setString(1, persona.getCedula());
            statement.setString(2, persona.getNombres());
            statement.setString(3, persona.getApellidos());
            statement.setInt(4, persona.getEdad());
            statement.setString(5, persona.getDireccion());
            statement.setString(6, persona.getEmail());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo de Consulta", "Registro Fallido", JOptionPane.ERROR_MESSAGE);
        }
        return statement.executeUpdate();
    }
    
    //Válida que el Registro se realizó correctamente
    public void validarStatement(int valor) {
        if (valor == 1) {
            JOptionPane.showMessageDialog(null, "¡Se registró correctamente!", "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Datos incongruentes, porfavor revise la información", "Registro Incompleto", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    @Override
    public void registrar(String query, Object objeto) {
        try {
            connector = this.conexion.getConnection();
            validarStatement(iniciarStatement(query, objeto));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo de Registro", "Registro Fallido", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void modificar(String query, Object objeto) {
        Persona persona = (Persona) objeto;
        int answer = 0;
        try {
            connector = Conexion.getConnection();
            statement = connector.prepareStatement(query);
            statement.setString(1, persona.getCedula());
            statement.setString(2, persona.getNombres());
            statement.setString(3, persona.getApellidos());
            statement.setInt(4, persona.getEdad());
            statement.setString(5, persona.getDireccion());
            statement.setString(6, persona.getEmail());
            answer = statement.executeUpdate();
            if (answer == 1) {
                System.out.println("Modificado Exitosamente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void modificar2(String query, Object objeto, Object ob) {
        Persona persona = (Persona) objeto;
        Persona antiguo = (Persona) ob;
        int answer = 0;
        try {
            connector = Conexion.getConnection();
            statement = connector.prepareStatement(query);
            statement.setString(1, persona.getCedula());
            statement.setString(2, persona.getNombres());
            statement.setString(3, persona.getApellidos());
            statement.setInt(4, persona.getEdad());
            statement.setString(5, persona.getDireccion());
            statement.setString(6, persona.getEmail());
            statement.setString(7, antiguo.getCedula());
            answer = statement.executeUpdate();
            if (answer == 1) {
                System.out.println("Modificado Exitosamente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @Override
    public void remover(String query,Object objeto) {
        Persona persona = (Persona) objeto;
        int answer = 0;
        try {
            connector = Conexion.getConnection();
            statement = connector.prepareStatement(query);
            statement.setString(1, persona.getCedula());
            answer = statement.executeUpdate();
            if (answer == 1) {
                System.out.println("Eliminado Exitosamente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
   @Override
    //Metodo para imprimir en consola
    public List buscar(String cedula) {
        String query = "select cedula, nombres, apellidos, edad, direccion, email from PERSONA where cedula = '" + cedula + "'";
        List<Persona> datos = new ArrayList<>();
        try {
            connector = Conexion.getConnection();
            statement = connector.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()) {
                Persona persona = new Persona();
                persona.setCedula(result.getString(1));
                persona.setNombres(result.getString(2));
                persona.setApellidos(result.getString(3));
                persona.setEdad(result.getInt(4));
                persona.setDireccion(result.getString(5));
                persona.setEmail(result.getString(6));
                datos.add(persona);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public List listar() {
        List<Persona> datos = new ArrayList<>();
        String query = "select cedula, nombres, apellidos, edad, direccion, email from PERSONA";
        try {
            connector = Conexion.getConnection();
            statement = connector.prepareStatement(query);
            result = statement.executeQuery();

            while (result.next()) {
                Persona persona = new Persona();
                persona.setCedula(result.getString("Cedula"));
                persona.setNombres(result.getString("Nombres"));
                persona.setApellidos(result.getString("Apellidos"));
                persona.setEdad(result.getInt("Edad"));
                persona.setDireccion(result.getString("Direccion"));
                persona.setEmail(result.getString("Email"));
                datos.add(persona);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
    
}
