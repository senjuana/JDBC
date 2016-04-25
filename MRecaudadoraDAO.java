
package DAO.Mysql;
import DAO.DAOException;
import DAO.RecaudadoraDAO;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Recaudadora;
/**
 *
 * @author erni
 */
public class MRecaudadoraDAO implements RecaudadoraDAO {
 
     
    final String insert="INSERT INTO Recaudadora(domicilio,telefono) VALUES(?,?)";
    final String update ="UPDATE Recaudadora set domicilio=?,telefono=? where no-recau=?";
    final String delete ="DELETE FROM Recaudadora WHERE no-recau=?";
    final String getall ="select no-recau,domicilio,telefono from Recaudadora";
    final String getone ="select no-recau,domicilio,telefono from Recaudadora where no-recau=?";
     
    private  Connection conn;
    
    public MRecaudadoraDAO(Connection conn){
        this.conn = conn;
    }
    
    
    @Override
    public void insertar(Recaudadora a) throws DAOException {
    PreparedStatement stat = null;
        ResultSet rs=null;
    try{
        stat = conn.prepareStatement(insert);
        stat.setString(1, a.getDomicilio());
        stat.setString(2, a.getTelefono());
        if(stat.executeUpdate()==0){
            throw new DAOException("Puede que no se haya guadardo.");
        }
        rs=stat.getGeneratedKeys();
        if(rs.next()){
            a.setNo_recau(rs.getLong(1));
        }else{
            throw new DAOException("No puedo asignar ese id a esta Recaudadora");
        
        }
        }catch (SQLException ex) {
           throw new DAOException("Error en sql ",ex);
        }finally{
        if(rs!=null){
                try{
                rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en el sql",ex);
                }
            }
        if(stat!= null){
            try{
                stat.close();
            }catch(SQLException ex){
                throw new DAOException("Error en sql",ex);
            }
        }
        }
    }

    @Override
    public void eliminar(Recaudadora a) throws DAOException {
       PreparedStatement stat = null;
    try{
        stat = conn.prepareStatement(delete);
        stat.setLong(1, a.getNo_recau());
        if(stat.executeUpdate()==0){
            throw new DAOException("Puede que no se haya eliminado.");
        }
        }catch (SQLException ex) {
           throw new DAOException("Error en sql ",ex);
        }finally{
        if(stat!= null){
            try{
                stat.close();
            }catch(SQLException ex){
                throw new DAOException("Error en sql",ex);
            }
        }
        }
    }

    @Override
    public void modificar(Recaudadora a) throws DAOException {
        PreparedStatement stat = null;
    try{
        stat = conn.prepareStatement(update);
        stat.setString(1, a.getDomicilio());
        stat.setString(2,a.getTelefono());
        stat.setLong(3,a.getNo_recau());
        if(stat.executeUpdate()==0){
            throw new DAOException("Puede que no se haya modificado.");
        }
        }catch (SQLException ex) {
           throw new DAOException("Error en sql ",ex);
        }finally{
        if(stat!= null){
            try{
                stat.close();
            }catch(SQLException ex){
                throw new DAOException("Error en sql",ex);
            }
        }
        }
    }

    private Recaudadora getconvert(ResultSet rs) throws SQLException {
        long recau=rs.getLong("no-recau");
        String domicilio=rs.getString("domicilio");
        String telefono=rs.getString("telefono");
        Recaudadora row= new Recaudadora(domicilio,telefono);
        row.setNo_recau(rs.getLong("no-recau"));
        return row;
    }
    
    @Override
    public List<Recaudadora> obtenerTodos() throws DAOException {
     PreparedStatement stat =null;
        ResultSet rs=null;
        List<Recaudadora> Recaudadoras=new ArrayList<>();
        try{
        stat =conn.prepareStatement(getall);
        rs=stat.executeQuery();
        while(rs.next()){
            Recaudadoras.add(getconvert(rs));    
        }
        }catch(SQLException ex){
            throw new DAOException("Error de sql",ex);
        }finally{
            if(rs!=null){
                try{
                rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en el sql",ex);
                }
            }
            if(stat!=null){
            try{
                stat.close();
            }catch(SQLException ex){
                new DAOException("Error en el sql",ex);
            }
            }
        }
        
      return Recaudadoras;
    }

    @Override
    public Recaudadora obtener(long id) throws DAOException {
     PreparedStatement stat =null;
        ResultSet rs=null;
        Recaudadora p=null;
        try{
        stat =conn.prepareStatement(getone);
        stat.setLong(1,id);
        rs=stat.executeQuery();
        if(rs.next()){
            p=getconvert(rs);    
        }else{
            throw new DAOException("No se ha encontrado ese registro.");
        }
        }catch(SQLException ex){
            throw new DAOException("Error de sql",ex);
        }finally{
            if(rs!=null){
                try{
                rs.close();
                }catch(SQLException ex){
                    new DAOException("Error en el sql",ex);
                }
            }
            if(stat!=null){
            try{
                stat.close();
            }catch(SQLException ex){
                new DAOException("Error en el sql",ex);
            }
            }
        }
        
      return p;  
    }
    
}
