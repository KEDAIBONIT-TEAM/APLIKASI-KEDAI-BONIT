/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.controller;

import javax.swing.JOptionPane;
import tugasbesar.kedaibonit.model.PelangganModel;
import tugasbesar.kedaibonit.view.MainPanelView;


/**
 *
 * @author CarakaMR
 */
public class PelangganController {
    
    private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }

    
    public void resetPelanggan(MainPanelView view) {
        model.resetpelanggan();
    }
    
    public void insertPelanggan(MainPanelView view) {
        String nama    = view.getTxtNamaPelanggan().getText();
        String telepon = view.getTxtNoHp().getText();
        
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Dan Nama Tidak Boleh Kosong");
        } else if (nama.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Lebih Dari 255 Karakter");
        }else if (telepon.length()>12) {
            JOptionPane.showMessageDialog(view, "Nomor Telepon Tidak Boleh Lebih Dari 12 Digit");
        }else {
            model.setNamaPelanggan(nama);
            model.setNohp(telepon);
            
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Ditambahkan");
                model.resetpelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan", throwable.getMessage()});
            }
        }
    }
    
    public void updatePelanggan(MainPanelView view) {
        
        if (view.getTablePelanggan().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi Baris Data Yang Akan Diubah");
            return;
        }
        
        Integer id = Integer.parseInt(view.getTxtId().getText());
        
        String nama    = view.getTxtNamaPelanggan().getText();
        String telepon = view.getTxtNoHp().getText();
        
        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong");
        }else if (nama.length()>255) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Lebih Dari 255 Karakter");
        }else if (telepon.length()>12) {
            JOptionPane.showMessageDialog(view, "Nomor Telepon Tidak Boleh Lebih Dari 12 Digit");
        }else {
            model.setId(id);
            model.setNamaPelanggan(nama);
            model.setNohp(telepon);
            
            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Diubah");
                model.resetpelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database Dengan Pesan", throwable.getMessage()});
            }
        }
        
    }

    
            
    
}
