
package DAO;
import DAO.TarjetaDAO;
import java.util.List;
import modelo.Tarjeta;
/**
 *
 * @author erni
 */
public interface TarjetaDAO  {
    void insertar(Tarjeta a)throws DAOException;
    void eliminar (Tarjeta a)throws DAOException;
    void modificar (Tarjeta a)throws DAOException;
    
    List<Tarjeta> obtenerTodos()throws DAOException;
    
    Tarjeta obtener (long id)throws DAOException;
}
