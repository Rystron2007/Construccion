/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Simples.Equipo;
import Modelo.DataBase.EquipoDB;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lozano
 */
public class Administrar_Equipo {
    String nombre="";
    String pais_origen="";
    Equipo equipo;
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Administrar_Equipo(String nombre, String pais_origen){
        this.nombre= nombre;
        this.pais_origen= pais_origen;
        equipo = new Equipo(this.nombre, this.pais_origen);
    }
    
    public Administrar_Equipo(){
    
    }
    EquipoDB conector = new EquipoDB();
    
    public void Registrar_db(){
        try{
            String query = "insert into Equipo (nombre_equipo, pais_origen) values (?,?)";
            conector.registrar(query, equipo);
            JOptionPane.showMessageDialog(null, "Registro realizado con exito!");
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "No se pudo realizar el registro....Intentelo de nuevo");
        }
    }
    public void Buscar_db(JTable tabla){
        try{
            modelo = (DefaultTableModel)tabla.getModel();
            List<Equipo>lista= conector.lista();
            Object[]ob =new Object[2];
            for(int i=0; i<lista.size();i++){
                ob[0]=lista.get(i).getNombreEquipo();
                ob[1]=lista.get(i).getPaisOrigen();
                modelo.addRow(ob);
            }
            tabla.setModel(modelo);
            JOptionPane.showMessageDialog(null, "Busqueda con exito!");
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda....Intentelo de nuevo");
        }
    }
    public void Buscar_db(JTable tabla, String nombre){
        boolean validar=false;
        try{
            modelo = (DefaultTableModel)tabla.getModel();
            List<Equipo>lista= conector.lista();
            Object[]ob =new Object[2];
            for(int i=0; i<lista.size();i++){
                if(lista.get(i).getNombreEquipo().compareTo(nombre)==0){
                  ob[0]=lista.get(i).getNombreEquipo();
                  ob[1]=lista.get(i).getPaisOrigen();
                  modelo.addRow(ob);
                  validar=true;
                }
                
            }
            
            tabla.setModel(modelo);
            if(validar){
                tabla.setModel(modelo);
                JOptionPane.showMessageDialog(null, "Busqueda con exito!");  
            }
            else{
               JOptionPane.showMessageDialog(null, "No existe el equipo"); 
            }
            
            
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda....Intentelo de nuevo");
        }
    }   
    
    public void Modificar(String nombre){
        Equipo antiguo = new Equipo(nombre,"");
        try{
            String query= "update Equipo SET nombre_equipo = ?, pais_origen = ?  where nombre_equipo = ?";
            conector.modificar2(query, equipo, antiguo);
            JOptionPane.showMessageDialog(null, "Modificacion realizada con exito!");
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "No se pudo realizar la modificacion....Intentelo de nuevo");
        }
    }
}
