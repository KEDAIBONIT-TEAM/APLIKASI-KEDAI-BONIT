/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.impl;

import tugasbesar.kedaibonit.entity.Pelanggan;
import tugasbesar.kedaibonit.error.PelangganException;
import tugasbesar.kedaibonit.service.PelangganDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author CarakaMR
 */
public class PelangganDaoImpl implements PelangganDao{
    
    private Connection connection;
    
    private final String insertPelanggan = "INSERT INTO PELANGGAN (Nama_Pelanggan, Nomor_HP) VALUES (?,?)";
    
    private final String updatePelanggan = "UPDATE PELANGGAN SET Nama_Pelanggan=?, Nomor_HP=? WHERE ID=?";
    
    private final String getById = "SELECT * FROM PELANGGAN WHERE ID=? ";
    
    private final String selectAll = "SELECT * FROM PELANGGAN";
    
    public PelangganDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    

    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement statement = null;
        try {
           connection.setAutoCommit(false);
            
           statement = connection.prepareStatement (insertPelanggan, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, pelanggan.getNamapelanggan());
           statement.setString(2, pelanggan.getNomorhp());
           statement.executeUpdate();
           
           ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                pelanggan.setId(result.getInt(1));   
            }
           
           connection.commit();
         
        } catch (SQLException  e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement!=null) {
               try {
                   statement.close();
                } catch (SQLException e) {
                } 
            }  
            
        }
    }

    @Override
    public Pelanggan getPelanggan(Integer id) throws PelangganException {
        PreparedStatement statement = null;
        try {
           connection.setAutoCommit(false);
           statement = connection.prepareStatement (getById);
           statement.setInt(1, id);
           
           ResultSet result= statement.executeQuery();
           Pelanggan pelanggan=null;
           
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNamapelanggan(result.getString("Nama_Pelanggan"));
                pelanggan.setNomorhp(result.getString("Nomor_HP"));
            } else {
                throw new PelangganException("Pelanggan dengan id " +id+" tidak ditemukan");
            }
            connection.commit();
            return pelanggan;
        } catch (SQLException  e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement!=null) {
               try {
                   statement.close();
                } catch (SQLException e) {
                } 
            }  
            
        }
    }

    @Override
    public List<Pelanggan> selectAllPelanggan() throws PelangganException {
        Statement statement = null;
        List<Pelanggan> list = new ArrayList<Pelanggan>();
        
        try {
           connection.setAutoCommit(false);
           statement = connection.createStatement();
          
           
           ResultSet result= statement.executeQuery(selectAll);
           Pelanggan pelanggan=null;
           
            while (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNamapelanggan(result.getString("Nama_Pelanggan"));
                pelanggan.setNomorhp(result.getString("Nomor_HP"));
                list.add(pelanggan);
            }
            connection.commit();
            return list;
        }catch (SQLException  e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement!=null) {
               try {
                   statement.close();
                } catch (SQLException e) {
                } 
            }  
            
        }
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement statement = null;
        try {
           connection.setAutoCommit(false);
           statement = connection.prepareStatement (updatePelanggan);
           statement.setString(1, pelanggan.getNamapelanggan());
           statement.setString(2, pelanggan.getNomorhp());
           statement.setInt(3, pelanggan.getId());
           statement.executeUpdate();
           
           connection.commit();
           
        } catch (SQLException  e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement!=null) {
               try {
                   statement.close();
                } catch (SQLException e) {
                } 
            }  
            
        }
    }
    
}
