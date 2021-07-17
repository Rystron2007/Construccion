 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Interfaces;

import java.util.List;

/**
 *
 * @author John
 */
public interface CRUD {

    /**
     *
     * @param query
     * @param objeto
     */
    public void registrar(String query, Object objeto);

    /**
     *
     * @param query
     * @return
     */
    public List buscar(String query);

    /**
     *
     * @param query
     * @param objeto
     * @param objetoDos
     */
    public void modificar(String query, Object objeto, Object objetoDos);

    /**
     *
     * @param query
     * @param ob
     */
    public void remover(String query, Object ob);
}
