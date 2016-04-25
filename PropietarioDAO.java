/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import modelo.Propietario;
import DAO.PropietarioDAO;
import java.util.List;
import modelo.Auto;
/**
 *
 * @author erni
 */
public interface PropietarioDAO  {
    void insertar(Propietario a)throws DAOException;
    void eliminar (Propietario a)throws DAOException;
    void modificar (Propietario a)throws DAOException;
    
    List<Propietario> obtenerTodos()throws DAOException;
    
    Propietario obtener (long id)throws DAOException;
}
