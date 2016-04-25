/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DAO.AutoDAO;
import java.util.List;
import modelo.Auto;
/**
 *
 * @author erni
 */
public interface AutoDAO //extends DAO<Auto,long> 
{
    void insertar(Auto a)throws DAOException;
    void eliminar (Auto a)throws DAOException;
    void modificar (Auto a)throws DAOException;
    
    List<Auto> obtenerTodos()throws DAOException;
    
    Auto obtener (long id)throws DAOException;
}
