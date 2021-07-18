package Modelo.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author John
 */
public class Conexion {

    private static final String DATABASEURL = "jdbc:oracle:thin:@192.168.100.229:1522:XE";
    private static String user;
    private static String password;

    /**
     *
     * @return
     */
    public static Connection establecerConexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connector = DriverManager.getConnection(Conexion.DATABASEURL, Conexion.user, Conexion.password);
            return connector;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Clase no Encontrada.", "Conexión Erronéa", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param connector
     * @return
     */
    public static Connection validarConexion(Connection connector) {
        if (connector != null) {
            JOptionPane.showMessageDialog(null, "¡Conectado Exitosamente!", "Conexion Establecida", JOptionPane.INFORMATION_MESSAGE);
        }
        return connector;
    }
    
    public static void iniciarDatos(String user, String password){
        setUSER(user);
        setPASSWORD(password);
    }

    public static String getUSER() {
        return user;
    }

    public static void setUSER(String USER) {
        Conexion.user = USER;
    }

    public static String getPASSWORD() {
        return password;
    }

    public static void setPASSWORD(String PASSWORD) {
        Conexion.password = PASSWORD;
    }
    
    
}
