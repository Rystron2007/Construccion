package Modelo.Interfaces;

import java.util.List;

/**
 * Interfaz con los Métodos CRUD
 *
 * @author John
 */
public interface CRUD {

    /**
     * Método para Insertar
     *
     * @param query Statement de Inserción
     * @param objeto Objeto a Insertar.
     */
    public void insertar(String query, Object objeto);

    /**
     * Método para Consultar
     *
     * @param query Statement de Consulta
     * @return
     */
    public List consultar(String query);

    /**
     * Método para Actualizar
     *
     * @param query Statement de Actualización
     * @param objeto Objeto a Actualizar
     * @param objetoDos Objeto a Comparar
     */
    public void actualizar(String query, Object objeto, Object objetoDos);

    /**
     * Método para Insertar
     *
     * @param query Statement de Eliminación
     * @param objeto Objeto a Eliminar.
     */
    public void eliminar(String query, Object objeto);
}
