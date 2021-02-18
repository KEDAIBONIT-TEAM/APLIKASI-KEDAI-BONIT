/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.event;

import tugasbesar.kedaibonit.entity.CatatUtang;
import tugasbesar.kedaibonit.model.CatatUtangModel;

/**
 *
 * @author CarakaMR
 */
public interface CatatUtangListener {
    
    public void onChangeCU(CatatUtangModel modelcu);
    public void onInsertCU(CatatUtang catatUtang);
    public void onUpdateCU(CatatUtang catatUtang);
    
}
