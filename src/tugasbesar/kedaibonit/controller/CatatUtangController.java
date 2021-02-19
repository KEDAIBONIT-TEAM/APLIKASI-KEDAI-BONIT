/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.controller;

import javax.swing.JOptionPane;
import tugasbesar.kedaibonit.model.CatatUtangModel;
import tugasbesar.kedaibonit.view.MainPanelView;

/**
 *
 * @author CarakaMR
 */
public class CatatUtangController {
    
    private CatatUtangModel modelcu;

    public void setModel(CatatUtangModel modelcu) {
        this.modelcu = modelcu;
    }
    
    public void resetCatatUtang(MainPanelView view) {
        modelcu.resetPelangganCU();
    }
           
    public void insertCatatUtang(MainPanelView view) {
        String idcu = view.getTxtIDCU().getText();
        String namaPelanggan = view.getTxtNamaCU().getText();
        String tanggalBerutang = view.getTxtTglUtangCU().getText();
        String namaBarang = view.getTxtNamaBarangCU().getText();
        String nominal = view.getTxtNominalCU().getText();
        String jatuhTempo = view.getTxtJatuhTempoCU().getText();
        String statusBayar = view.getTxtStatusBayarCU().getText();
        
        if (namaPelanggan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Dan Nama Tidak Boleh Kosong");
        } else if (namaPelanggan.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Lebih Dari 255 Karakter");
        } else if (!statusBayar.contains("Lunas")||!statusBayar.contains("Belum Lunas")) {
            JOptionPane.showMessageDialog(view, "Status Bayar Tidak Valid");
          
        } else {
            modelcu.setIdcu(idcu);
            modelcu.setNamacu(namaPelanggan);
            modelcu.setTanggalBerutang(tanggalBerutang);
            modelcu.setNamaBarang(namaBarang);
            modelcu.setNominal(nominal);
            modelcu.setJatuhTempo(jatuhTempo);
            modelcu.setStatusbayar(statusBayar);
            
            try {
                modelcu.insertCatatUtang();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Ditambahkan");
                modelcu.resetPelangganCU();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan", throwable.getMessage()});
            }
        }
    }
    
    public void updateCatatUtang(MainPanelView view) {
        
        if (view.getTableCatatUtang().getSelectedRowCount()==0) {
           JOptionPane.showMessageDialog(view, "Silahkan Seleksi Baris Data Yang Akan Diubah ");
           return;
        }
        
        String idcu = view.getTxtIDCU().getText();
        String namaPelanggan = view.getTxtNamaCU().getText();
        String tanggalBerutang = view.getTxtTglUtangCU().getText();
        String namaBarang = view.getTxtNamaBarangCU().getText();
        String nominal = view.getTxtNominalCU().getText();
        String jatuhTempo = view.getTxtJatuhTempoCU().getText();
        String statusBayar = view.getTxtStatusBayarCU().getText();
        
        if (idcu.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Dan Nama Tidak Boleh Kosong");
        } else if (namaPelanggan.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Lebih Dari 255 Karakter");
        } else {
            modelcu.setIdcu(idcu);
            modelcu.setNamacu(namaPelanggan);
            modelcu.setTanggalBerutang(tanggalBerutang);
            modelcu.setNamaBarang(namaBarang);
            modelcu.setNominal(nominal);
            modelcu.setJatuhTempo(jatuhTempo);
            modelcu.setStatusbayar(statusBayar);
            
            try {
                modelcu.updateCatatUtang();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Diubah");
                modelcu.resetPelangganCU();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan", throwable.getMessage()});
            }
        }
    }
    
}
