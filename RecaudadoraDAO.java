
package DAO;
import DAO.RecaudadoraDAO;
import java.util.List;
import modelo.Recaudadora;
/**
 *
 * @author erni
 */
public interface RecaudadoraDAO {
    void insertar(Recaudadora a)throws DAOException;
    void eliminar (Recaudadora a)throws DAOException;
    void modificar (Recaudadora a)throws DAOException;
    
    List<Recaudadora> obtenerTodos()throws DAOException;
    
    Recaudadora obtener (long id)throws DAOException;
}
