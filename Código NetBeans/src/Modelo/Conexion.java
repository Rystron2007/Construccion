/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String myDB = "jdbc:oracle:thin:@//localhost:1522/xe";
            Connection cnx = DriverManager.getConnection(myDB, "SYSTEM", "ANHN2007");
            if (cnx != null) {
                System.out.println("Conectado Exitosamente!");
            }
            return cnx;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Fallo el intento de conexión. Intentelo nuevamente más tarde.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR DE CONEXIÓN");
        }

        return null;

    }

}
