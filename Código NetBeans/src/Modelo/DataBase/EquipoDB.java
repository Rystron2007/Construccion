package Modelo.DataBase;

import Modelo.Interfaces.CRUD;
import Modelo.Simples.Equipo;
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
 * @author John
 */
public class EquipoDB implements CRUD {

    private Connection connector;
    private PreparedStatement statement;
    private ResultSet result;
    private Conexion conexion;

    /**
     *
     * @param query
     * @param objeto
     * @return
     * @throws SQLException
     */
    public int iniciarStatement(String query, Object objeto) throws SQLException {
        try {
            Equipo equipo = (Equipo) objeto;
            statement = connector.prepareStatement(query);
            statement.setString(1, equipo.getNombreEquipo());
            statement.setString(2, equipo.getPaisOrigen());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo de Consulta", "Registro Fallido", JOptionPane.ERROR_MESSAGE);
        }
        return statement.executeUpdate();
    }

    /**
     *
     * @param equipoRegistrado
     */
    public void validarStatement(int equipoRegistrado) {
        if (equipoRegistrado == 1) {
            JOptionPane.showMessageDialog(null, "¡Se registró correctamente el EQUIPO!", "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Datos incongruentes, porfavor revise la información", "Registro Incompleto", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     *
     * @param query
     * @param objeto
     */
    @Override
    public void registrar(String query, Object objeto) {
        try {
            connector = this.conexion.getConnection();
            validarStatement(iniciarStatement(query, objeto));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fallo de Consulta", "Registro Fallido", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     * @param query
     * @param objeto
     * @param ob
     */
    public void modificar(String query, Object objeto, Object ob) {
        Equipo equipo = (Equipo) objeto;
        Equipo antiguo = (Equipo) ob;
        int answer = 0;
        try {
            connector = Conexion.getConnection();
            statement = connector.prepareStatement(query);
            statement.setString(1, equipo.getNombreEquipo());
            statement.setString(2, equipo.getPaisOrigen());
            statement.setString(3, antiguo.getNombreEquipo());
            answer = statement.executeUpdate();
            if (answer == 1) {
                System.out.println("Modificado Exitosamente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param query
     * @param objeto
     */
    @Override
    public void remover(String query, Object objeto) {
        Equipo equipo = (Equipo) objeto;
        int answer = 0;
        try {
            connector = Conexion.getConnection();
            statement = connector.prepareStatement(query);
            statement.setString(1, equipo.getNombreEquipo());
            answer = statement.executeUpdate();
            if (answer == 1) {
                System.out.println("Eliminado Exitosamente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param nombre
     * @return
     */
    @Override
    //Metodo para imprimir en consola
    public List buscar(String nombre) {
        String query = "select nombre_equipo, pais_origen from Equipo where nombre_equipo = '" + nombre + "'";
        List<Equipo> datos = new ArrayList<>();
        try {
            connector = Conexion.getConnection();
            statement = connector.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()) {
                Equipo equipo = new Equipo();
                equipo.setNombreEquipo(result.getString(1));
                equipo.setPaisOrigen(result.getString(2));
                datos.add(equipo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    /**
     *
     * @return
     */
    public List listar() {
        List<Equipo> datos = new ArrayList<>();
        String query = "select nombre_equipo, pais_origen from Equipo";
        try {
            connector = Conexion.getConnection();
            statement = connector.prepareStatement(query);
            result = statement.executeQuery();

            while (result.next()) {
                Equipo equipo = new Equipo();
                equipo.setNombreEquipo(result.getString("nombre_equipo"));
                equipo.setPaisOrigen(result.getString("pais_origen"));
                datos.add(equipo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    /**
     *
     * @return
     */
    public Conexion getConexion() {
        return conexion;
    }

    /**
     *
     * @param conexion
     */
    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

}
