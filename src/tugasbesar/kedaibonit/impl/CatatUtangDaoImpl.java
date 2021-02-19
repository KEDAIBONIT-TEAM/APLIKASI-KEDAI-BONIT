/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.impl;

import java.util.List;
import tugasbesar.kedaibonit.entity.CatatUtang;
import tugasbesar.kedaibonit.error.CatatUtangException;
import tugasbesar.kedaibonit.service.CatatUtangDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CarakaMR
 */
public class CatatUtangDaoImpl implements CatatUtangDao{
    
    private Connection connection;
    
    private final String insertUtang = "INSERT INTO CATAT_UTANG (ID,Nama_Pelanggan,Tanggal_Berutang,Nama_Barang,Nominal_Rp,Jatuh_Tempo,Status_Bayar) VALUES (?,?,?,?,?,?,?)";

    private final String updateUtang = "UPDATE CATAT_UTANG SET ID=?, Nama_Pelanggan=?, Tanggal_Berutang=?, Nama_Barang=?, Nominal_Rp=?, Jatuh_Tempo=?, Status_Bayar=?";
    
    private final String getById = "SELECT * FROM CATAT_UTANG WHERE ID=?";
    
    private final String selectAll = "SELECT * FROM CATAT_UTANG";
    
    public CatatUtangDaoImpl(Connection connection) {
        this.connection = connection;
    }
    

    @Override
    public void insertUtang(CatatUtang catatutang) throws CatatUtangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(insertUtang);
            statement.setString(1, catatutang.getIdCU());
            statement.setString(2, catatutang.getNamacu());
            statement.setString(3, catatutang.getTanggalBerutang());
            statement.setString(4, catatutang.getNamaBarang());
            statement.setString(5, catatutang.getNominal());
            statement.setString(6, catatutang.getJatuhTempo());
            statement.setString(7, catatutang.getStatusBayar());
            statement.executeUpdate();
            
            connection.commit();
         
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new CatatUtangException(e.getMessage());
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
    public void updateUtang(CatatUtang catatutang) throws CatatUtangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateUtang);
            statement.setString(1, catatutang.getIdCU());
            statement.setString(2, catatutang.getNamacu());
            statement.setString(3, catatutang.getTanggalBerutang());
            statement.setString(4, catatutang.getNamaBarang());
            statement.setString(5, catatutang.getNominal());
            statement.setString(6, catatutang.getJatuhTempo());
            statement.setString(7, catatutang.getStatusBayar());
            statement.executeUpdate();
            connection.commit();
         
        }catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new CatatUtangException(e.getMessage());
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
    public List<CatatUtang> selectAllUtang() throws CatatUtangException {
       Statement statement = null;
       List<CatatUtang> list = new ArrayList<CatatUtang>();
       
       try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
           
            
            ResultSet result = statement.executeQuery(selectAll);
            CatatUtang catatutang = null;
            
            while (result.next()) {
                catatutang = new CatatUtang();
                catatutang.setIdCU(result.getString("ID"));
                catatutang.setNamacu(result.getString("Nama_Pelanggan"));
                catatutang.setTanggalBerutang(result.getString("Tanggal_Berutang"));
                catatutang.setNamaBarang(result.getString("Nama_Barang"));
                catatutang.setNominal(result.getString("Nominal_Rp"));
                catatutang.setJatuhTempo(result.getString("Jatuh_Tempo"));
                catatutang.setStatusBayar(result.getString("Status_Bayar"));
                list.add(catatutang);
            }  
             connection.commit();
             return list;
            
         
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new CatatUtangException(e.getMessage());
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
    public CatatUtang getUtang(String id) throws CatatUtangException {
         PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setString(1, id);
            
            ResultSet result = statement.executeQuery();
            CatatUtang catatutang = null;
            
            if (result.next()) {
                catatutang = new CatatUtang();
                catatutang.setIdCU(result.getString("ID"));
                catatutang.setNamacu(result.getString("Nama_Pelanggan"));
                catatutang.setTanggalBerutang(result.getString("Tanggal_Berutang"));
                catatutang.setNamaBarang(result.getString("Nama_Barang"));
                catatutang.setNominal(result.getString("Nominal_Rp"));
                catatutang.setJatuhTempo(result.getString("Jatuh_Tempo"));
                catatutang.setStatusBayar(result.getString("Status_Bayar"));
            }else{
                throw new CatatUtangException("Pelanggan dengan id "+id+" tidak ditemukan");
            }    
             connection.commit();
             return catatutang;
            
         
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new CatatUtangException(e.getMessage());
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
        
    


    
