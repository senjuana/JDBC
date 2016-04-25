/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Mysql;
import DAO.AutoDAO;
import DAO.DAOException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Auto;
/**
 *
 * @author erni
 */
public class MAutoDAO implements AutoDAO {

    final String insert ="INSERT INTO Auto(modelo,placas,color,idprop) VALUES(?,?,?,?)";
    final String update ="UPDATE Auto set modelo=?,placas=?,color=?,idprop=? where idcar=?";
    final String delete ="DELETE FROM Auto WHERE idcar=?";
    final String getall ="select idcar,modelo,placas,color,idprop from Auto";
    final String getone ="select modelo,placas,color,idprop from Auto where idcar=?";
    
    
    private  Connection conn;
    
    public MAutoDAO(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public void insertar(Auto a) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs=null;
    try{
        stat = conn.prepareStatement(insert);
        stat.setString(1, a.getModelo());
        stat.setString(2, a.getPlacas());
        stat.setString(3,a.getColor());
        stat.setLong(4,a.getIdprop());
        if(stat.executeUpdate()==0){
            throw new DAOException("Puede que no se haya guadardo.");
        }
        rs=stat.getGeneratedKeys();
        if(rs.next()){
            a.setIdcar(rs.getLong(1));
        }else{
            throw new DAOException("No puedo asignar id a ese auto");
        
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
    public void eliminar(Auto a) throws DAOException {
         PreparedStatement stat = null;
    try{
        stat = conn.prepareStatement(delete);
        stat.setLong(1, a.getIdcar());
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
    public void modificar(Auto a) throws DAOException {
             PreparedStatement stat = null;
    try{
        stat = conn.prepareStatement(update);
        stat.setString(1, a.getModelo());
        stat.setString(2,a.getPlacas());
        stat.setString(3,a.getColor());
        stat.setLong(4,a.getIdprop());
        stat.setLong(5,a.getIdcar());
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
    
    //select modelo,placas,color,idprop from Auto where idcar=?
    //long idcar, String modelo, String placas, String color, long idprop
    private Auto getconvert(ResultSet rs) throws SQLException {
        String modelo=rs.getString("modelo");
        String placas=rs.getString("placas");
        String color=rs.getString("color");
        long idprop=rs.getLong("idprop");
        Auto row= new Auto(modelo,placas,color,idprop);
        row.setIdcar(rs.getLong("idcar"));
        return row;
    }
    
    @Override
    public List<Auto> obtenerTodos() throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs=null;
        List<Auto> autos=new ArrayList<>();
        try{
        stat =conn.prepareStatement(getall);
        rs=stat.executeQuery();
        while(rs.next()){
            autos.add(getconvert(rs));    
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
        
      return autos;
    }

    @Override
    public Auto obtener(long id) throws DAOException {
        PreparedStatement stat =null;
        ResultSet rs=null;
        Auto a=null;
        try{
        stat =conn.prepareStatement(getone);
        stat.setLong(1,id);
        rs=stat.executeQuery();
        if(rs.next()){
            a=getconvert(rs);    
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
        
      return a;  
    }
 
   
    
}
