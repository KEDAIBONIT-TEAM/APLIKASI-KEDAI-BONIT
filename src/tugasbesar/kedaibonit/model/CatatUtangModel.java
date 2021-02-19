/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.model;

import tugasbesar.kedaibonit.entity.CatatUtang;
import tugasbesar.kedaibonit.event.CatatUtangListener;
import java.sql.SQLException;
import tugasbesar.kedaibonit.database.KedaiBonitDatabase;
import tugasbesar.kedaibonit.error.CatatUtangException;
import tugasbesar.kedaibonit.service.CatatUtangDao;

/**
 *
 * @author CarakaMR
 */
public class CatatUtangModel {
    
    private String idcu;
    private String namacu;
    private String tanggalBerutang;
    private String namaBarang;
    private String nominal;
    private String jatuhTempo;
    private String statusbayar;
    
    private CatatUtangListener listener;

    public CatatUtangListener getListener() {
        return listener;
    }

    public void setListener(CatatUtangListener listener) {
        this.listener = listener;
    }

   
    

    public String getIdcu() {
        return idcu;
    }

    public void setIdcu(String idcu) {
        this.idcu = idcu;
        fireOnChange();
    }

    public String getNamacu() {
        return namacu;
    }

    public void setNamacu(String namacu) {
        this.namacu = namacu;
        fireOnChange();
    }

    public String getTanggalBerutang() {
        return tanggalBerutang;
    }

    public void setTanggalBerutang(String tanggalBerutang) {
        this.tanggalBerutang = tanggalBerutang;
        fireOnChange();
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
        fireOnChange();
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
        fireOnChange();
    }

    public String getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(String jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
        fireOnChange();
    }

    public String getStatusbayar() {
        return statusbayar;
    }

    public void setStatusbayar(String statusbayar) {
        this.statusbayar = statusbayar;
        fireOnChange();
    }
    
    protected void fireOnChange() {
        if (listener!=null) {
            listener.onChangeCU(this);
        }
    }
   
    protected void fireOnInsert(CatatUtang catatUtang) {
        if (listener!=null) {
            listener.onInsertCU(catatUtang);
        }
    }
    
    protected void fireOnUpdate(CatatUtang catatUtang) {
         if (listener!=null) {
            listener.onUpdateCU(catatUtang);
        }
    }
    
    public void insertCatatUtang() throws SQLException, CatatUtangException {
        CatatUtangDao dao = KedaiBonitDatabase.getCatatUtangDao();
        CatatUtang catatUtang = new CatatUtang();
        catatUtang.setIdCU(idcu);
        catatUtang.setNamacu(namacu);
        catatUtang.setTanggalBerutang(tanggalBerutang);
        catatUtang.setNamaBarang(namaBarang);
        catatUtang.setNominal(nominal);
        catatUtang.setJatuhTempo(jatuhTempo);
        catatUtang.setStatusBayar(statusbayar);
        
        dao.insertUtang(catatUtang);
        fireOnInsert(catatUtang);
        
    }
    
       public void updateCatatUtang() throws SQLException, CatatUtangException {
        CatatUtangDao dao = KedaiBonitDatabase.getCatatUtangDao();
        CatatUtang catatUtang = new CatatUtang();
        catatUtang.setIdCU(idcu);
        catatUtang.setNamacu(namacu);
        catatUtang.setTanggalBerutang(tanggalBerutang);
        catatUtang.setNamaBarang(namaBarang);
        catatUtang.setNominal(nominal);
        catatUtang.setJatuhTempo(jatuhTempo);
        catatUtang.setStatusBayar(statusbayar);
        
        dao.updateUtang(catatUtang);
        fireOnUpdate(catatUtang);
        
    }
       
       public void resetPelangganCU() {
           setIdcu("");
           setNamacu("");
           setTanggalBerutang("");
           setNamaBarang("");
           setNominal("");
           setJatuhTempo("");
           setStatusbayar("");
       }
}
