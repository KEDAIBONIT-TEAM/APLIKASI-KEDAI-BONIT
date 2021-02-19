/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.service;

import java.util.List;
import tugasbesar.kedaibonit.entity.CatatUtang;
import tugasbesar.kedaibonit.error.CatatUtangException;

/**
 *
 * @author CarakaMR
 */
public interface CatatUtangDao {
    
    public void insertUtang(CatatUtang catatutang) throws CatatUtangException;
    public void updateUtang(CatatUtang catatutang) throws CatatUtangException;
    public CatatUtang getUtang(String id) throws CatatUtangException;
    public List<CatatUtang> selectAllUtang() throws CatatUtangException;
    
}
