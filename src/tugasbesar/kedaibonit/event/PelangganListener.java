/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.event;

import tugasbesar.kedaibonit.entity.Pelanggan;
import tugasbesar.kedaibonit.model.PelangganModel;

/**
 *
 * @author CarakaMR
 */
public interface PelangganListener {
    
    public void onChange(PelangganModel model);
    public void onInsert(Pelanggan pelanggan);
    public void onUpdate(Pelanggan pelanggan);
}
