package Modelo.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static String databaseURL;
    private static String user;
    private static String password;

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return iniciarConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Intento de conexión fallido. Intentelo nuevamente más tarde.", "Conexión Erronéa", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Clase no Encontrada.", "Conexión Erronéa", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public static void iniciarDatos(String user, String password, String port) {
        Conexion.databaseURL = "jdbc:oracle:thin:@//192.168.100.229:"+port+"/xe";
        Conexion.user = user;
        Conexion.password = password;
    }

    public static Connection iniciarConexion() throws SQLException {
        Connection connector = DriverManager.getConnection(Conexion.databaseURL, Conexion.user, Conexion.password);
        validarConexion(connector);
        return connector;
    }

    public static void validarConexion(Connection connector) {
        if (connector != null) {
            JOptionPane.showMessageDialog(null, "¡Conectado Exitosamente!", "Conexion Establecida", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
