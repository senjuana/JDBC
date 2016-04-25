package DAO.Mysql;
import DAO.DAOException;
import DAO.TarjetaDAO;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Tarjeta;

/**
 *
 * @author erni
 */
public class MTarjertaDAO implements TarjetaDAO {

    final String insert="INSERT INTO Tarjeta(fechaRegistro) VALUES(?)";
    final String update ="UPDATE Tarjeta set fechaRegistro=? where idtarjeta=?";
    final String delete ="DELETE FROM Tarjeta WHERE idtarjeta=?";
    final String getall ="select idtarjeta,fechaRegistro from Tarjeta";
    final String getone ="select idtarjeta,fechaRegistro from Tarjeta idtarjeta=?";
     
    private  Connection conn;
    
    public MTarjertaDAO(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public void insertar(Tarjeta a) throws DAOException {
    PreparedStatement stat = null;
        ResultSet rs=null;
    try{
        stat = conn.prepareStatement(insert);
        stat.setString(1, a.getFecharegistro());
        if(stat.executeUpdate()==0){
            throw new DAOException("Puede que no se haya guadardo.");
        }
        rs=stat.getGeneratedKeys();
        if(rs.next()){
            a.setIdtarjeta(rs.getLong(1));
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
    public void eliminar(Tarjeta a) throws DAOException {
       PreparedStatement stat = null;
    try{
        stat = conn.prepareStatement(delete);
        stat.setLong(1, a.getIdtarjeta());
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
    public void modificar(Tarjeta a) throws DAOException {
         PreparedStatement stat = null;
    try{
        stat = conn.prepareStatement(update);
        stat.setString(1, a.getFecharegistro());
        stat.setLong(2,a.getIdtarjeta());
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

    private Tarjeta getconvert(ResultSet rs) throws SQLException {
        long idtarjeta=rs.getLong("idtarjeta");
        String fecha=rs.getString("fechaRegistro");
        Tarjeta row= new Tarjeta(fecha);
        row.setIdtarjeta(rs.getLong("idtarjeta"));
        return row;
    }
    
    
    @Override
    public List<Tarjeta> obtenerTodos() throws DAOException {
     PreparedStatement stat =null;
        ResultSet rs=null;
        List<Tarjeta> tarjetas=new ArrayList<>();
        try{
        stat =conn.prepareStatement(getall);
        rs=stat.executeQuery();
        while(rs.next()){
            tarjetas.add(getconvert(rs));    
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
        
      return tarjetas;
    }

    @Override
    public Tarjeta obtener(long id) throws DAOException {
     PreparedStatement stat =null;
        ResultSet rs=null;
        Tarjeta p=null;
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
