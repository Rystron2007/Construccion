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

    public EquipoDB() {
        this.connector = Conexion.establecerConexion();
    }

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
    @Override
    public void modificar(String query, Object objeto, Object ob) {
        Equipo equipo = (Equipo) objeto;
        Equipo antiguo = (Equipo) ob;
        try {
            statement = connector.prepareStatement(query);
            statement.setString(1, equipo.getNombreEquipo());
            statement.setString(2, equipo.getPaisOrigen());
            statement.setString(3, antiguo.getNombreEquipo());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Se modificó correctamente al EQUIPO!", "Modificar Completo", JOptionPane.INFORMATION_MESSAGE);
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
        try {
            statement = connector.prepareStatement(query);
            statement.setString(1, equipo.getNombreEquipo());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "¡Se eliminó correctamente el EQUIPO!", "Eliminar Completo", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param equipoBuscado
     * @return
     */
    @Override
    //Metodo para imprimir en consola
    public List buscar(String equipoBuscado) {
        String query = "select nombre_equipo, pais_origen from Equipo where nombre_equipo = '" + equipoBuscado + "'";
        List<Equipo> datos = new ArrayList<>();
        try {
            statement = connector.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()) {
                Equipo equipo = new Equipo();
                equipo.setNombreEquipo(result.getString(1));
                equipo.setPaisOrigen(result.getString(2));
                datos.add(equipo);
            }
            JOptionPane.showMessageDialog(null, "¡Se encontró correctamente al EQUIPO!", "Buscar Completo", JOptionPane.INFORMATION_MESSAGE);
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

}
