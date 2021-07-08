 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Interfaces;

import java.util.List;

public interface CRUD {
    public void registrar(String query, Object objeto);
    public List buscar(String query);
    public void modificar(String query, Object objeto);
    public void remover(String query);
}
