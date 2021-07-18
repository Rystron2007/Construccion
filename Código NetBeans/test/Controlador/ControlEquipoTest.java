/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DataBase.Conexion;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author John
 */
public class ControlEquipoTest {

    public ControlEquipoTest() {
    }

    public void inicioTest() {
        String user = "john";
        String password = "1234";
        Conexion.iniciarDatos(user, password);
    }

    @Test
    public void testRegistrarEquipo() {
        System.out.println("registrarEquipo");
        inicioTest();
        ControlEquipo instance = new ControlEquipo("Guayaquil-FC", "Ecuador");
        instance.registrarEquipo();
    }

    @Test
    public void testEliminarEquipo() {
        System.out.println("eliminarEquipo");
        inicioTest();
        String nombreBuscado = "Guayaquil-FC";
        ControlEquipo instance = new ControlEquipo();
        instance.eliminarEquipo(nombreBuscado);
    }

    @Test
    public void testBuscarEquipo() {
        System.out.println("buscarEquipo");
        inicioTest();
        JTable tablaEquipo = new JTable();
        String nombreBuscado = "Guayaquil-FC";
        ControlEquipo instance = new ControlEquipo();
        instance.buscarEquipo(tablaEquipo, nombreBuscado);
    }

    @Test
    public void testActualizarEquipo() {
        System.out.println("actualizarEquipo");
        inicioTest();
        String nombreBuscado = "Guayaquil-FC";
        ControlEquipo instance = new ControlEquipo();
        instance.modificarEquipo(nombreBuscado);
    }
    /*
  
    
    
      
    
    @Test
    public void testListarEquipo() {
        System.out.println("listarEquipo");
        JTable tablaEquipo = null;
        ControlEquipo instance = new ControlEquipo();
        instance.listarEquipo(tablaEquipo);
        fail("The test case is a prototype.");
    }

    

    @Test
    public void testActualizarEquipo() {
        System.out.println("modificarEquipo");
        String nombreBuscado = "";
        ControlEquipo instance = new ControlEquipo();
        instance.modificarEquipo(nombreBuscado);
        fail("The test case is a prototype.");
    }

   

    @Test
    public void testIniciarConector() {
        System.out.println("iniciarConector");
        ControlEquipo instance = new ControlEquipo();
        instance.iniciarConector();
        fail("The test case is a prototype.");
    }*/
}
