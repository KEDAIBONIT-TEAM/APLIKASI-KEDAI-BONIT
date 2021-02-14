/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.service;

import java.util.List;
import tugasbesar.kedaibonit.entity.Pelanggan;
import tugasbesar.kedaibonit.error.PelangganException;

/**
 *
 * @author CarakaMR
 */
public interface PelangganDao {
    
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException;
    
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException;
    
    public Pelanggan getPelanggan(Integer id) throws PelangganException;
    
    public List<Pelanggan> selectAllPelanggan() throws PelangganException;
}
