package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArbitroDB implements CRUD {

    Connection conector;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void registrar(String query, Object objeto) {
        Arbitro arbitro = (Arbitro) objeto;
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            ps.setString(1, arbitro.getCedula());
            ps.setString(2, arbitro.getActaNacimiento().getNUI());
            ps.setString(2, arbitro.getActaNacimiento().getApellidos());
            ps.setString(3, arbitro.getActaNacimiento().getNacionalidad());
            ps.executeUpdate();
        } catch (Exception e) {
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
        List<Arbitro> datos = new ArrayList<>();
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Arbitro arbitro = new Arbitro();
                arbitro.getActaNacimiento().setNombres(rs.getString(2));
                arbitro.getActaNacimiento().setApellidos(rs.getString(3));
                arbitro.getActaNacimiento().setNacionalidad(rs.getString(4));
                datos.add(arbitro);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void modificar(String query, Object objeto) {
        Arbitro arbitro = (Arbitro) objeto;
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            ps.setString(1, arbitro.getActaNacimiento().getNombres());
            ps.setString(2, arbitro.getActaNacimiento().getApellidos());
            ps.setString(3, arbitro.getActaNacimiento().getNacionalidad());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
