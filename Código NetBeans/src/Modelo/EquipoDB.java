package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EquipoDB implements CRUD {

    Connection conector;
    PreparedStatement ps;
    ResultSet rs;

    //Solucionar Problemas de ID
    @Override
    public void registrar(String query, Object objeto) {
        Equipo equipo = (Equipo) objeto;
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            ps.setString(1, equipo.getNombreEquipo());
            ps.setString(2, equipo.getPaisOrigen());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void remover(String query) {
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    @Override
    public void listar(String query) {
        List<ActaNacimiento> datos = new ArrayList<>();
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                ActaNacimiento acta = new ActaNacimiento();
                acta.setNUI(rs.getString(1));
                acta.setNombres(rs.getString(2));
                acta.setApellidos(rs.getString(3));
                acta.setNacionalidad(rs.getString(4));
                datos.add(acta);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void modificar(String query, Object objeto) {
        ActaNacimiento acta = (ActaNacimiento) objeto;
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            ps.setString(1, acta.getNUI());
            ps.setString(2, acta.getNombres());
            ps.setString(3, acta.getApellidos());
            ps.setString(4, acta.getNacionalidad());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
