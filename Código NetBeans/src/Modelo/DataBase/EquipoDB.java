package Modelo.DataBase;

import Modelo.Interfaces.CRUD;
import Modelo.DataBase.Conexion;
import Modelo.Simples.Equipo;
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
        int answer = 0;
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            ps.setString(1, equipo.getNombreEquipo());
            ps.setString(2, equipo.getPaisOrigen());
            answer = ps.executeUpdate();
            if (answer == 1) {
                System.out.println("Exito!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar(String query, Object objeto) {
        Equipo equipo = (Equipo) objeto;
        int answer = 0;
        //query="update equipo set nombre_equipo=? pais_origen=? where nombre_equipo=?";
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            ps.setString(1, equipo.getNombreEquipo());
            ps.setString(2, equipo.getPaisOrigen());
            answer = ps.executeUpdate();
            if (answer == 1) {
                System.out.println("Modificado Exitosamente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar2(String query, Object objeto, Object ob) {
        Equipo equipo = (Equipo) objeto;
        Equipo antiguo = (Equipo) ob;
        int answer = 0;
        //query="update equipo set nombre_equipo=?, pais_origen=? where nombre_equipo=?";
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            ps.setString(1, equipo.getNombreEquipo());
            ps.setString(2, equipo.getPaisOrigen());
            ps.setString(3, antiguo.getNombreEquipo());
            answer = ps.executeUpdate();
            if (answer == 1) {
                System.out.println("Modificado Exitosamente!");
            }
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
        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    //Metodo para imprimir en consola
    public void listar(String nombre) {
        String query = "select nombre_equipo, pais_origen from Equipo where nombre_equipo = " + nombre;
        List<Equipo> datos = new ArrayList<>();
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setNombreEquipo(rs.getString(2));
                equipo.setPaisOrigen(rs.getString(3));
                datos.add(equipo);
            }
            for (Equipo dato : datos) {

            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List lista() {
        List<Equipo> datos = new ArrayList<>();
        String query = "select nombre_equipo, pais_origen from Equipo";
        try {
            conector = Conexion.getConnection();
            ps = conector.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setNombreEquipo(rs.getString("nombre_equipo"));
                equipo.setPaisOrigen(rs.getString("pais_origen"));
                datos.add(equipo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

}
