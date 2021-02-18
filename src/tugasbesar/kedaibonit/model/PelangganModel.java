/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.model;

import tugasbesar.kedaibonit.entity.Pelanggan;
import tugasbesar.kedaibonit.error.PelangganException;
import tugasbesar.kedaibonit.event.PelangganListener;
import java.sql.SQLException;
import tugasbesar.kedaibonit.database.KedaiBonitDatabase;
import tugasbesar.kedaibonit.service.PelangganDao;
/**
 *
 * @author CarakaMR
 */
public class PelangganModel {
    
    private int id;
    private String namaPelanggan;
    private String nohp;
    
    private PelangganListener listener;

    public PelangganListener getListener() {
        return listener;
    }

    public void setListener(PelangganListener listener) {
        this.listener = listener;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
        fireOnChange();
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
        fireOnChange();
    }
    
    protected void fireOnChange() {
        if (listener!=null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Pelanggan pelanggan) {
          if (listener!=null) {
            listener.onInsert(pelanggan);
        }
    }
    
    protected void fireOnUpdate(Pelanggan pelanggan) {
         if (listener!=null) {
            listener.onUpdate(pelanggan);
        }
    }
    
    public void insertPelanggan() throws SQLException, PelangganException{
        
        PelangganDao dao = KedaiBonitDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNamapelanggan(namaPelanggan);
        pelanggan.setNomorhp(nohp);
        
        dao.insertPelanggan(pelanggan);
        fireOnInsert(pelanggan);
    }
    
    public void updatePelanggan() throws SQLException, PelangganException{
        
        PelangganDao dao = KedaiBonitDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNamapelanggan(namaPelanggan);
        pelanggan.setNomorhp(nohp);
        pelanggan.setId(id);
        
        dao.updatePelanggan(pelanggan);
        fireOnUpdate(pelanggan);
    }
    
    public void resetpelanggan() {
        setId(0);
        setNamaPelanggan("");
        setNohp("");
    }

    
   

  
    
}
