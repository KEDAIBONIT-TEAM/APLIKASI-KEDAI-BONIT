/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.main;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import tugasbesar.kedaibonit.database.KedaiBonitDatabase;
import tugasbesar.kedaibonit.entity.CatatUtang;
import tugasbesar.kedaibonit.entity.Pelanggan;
import tugasbesar.kedaibonit.error.CatatUtangException;
import tugasbesar.kedaibonit.error.PelangganException;
import tugasbesar.kedaibonit.service.CatatUtangDao;
import tugasbesar.kedaibonit.service.PelangganDao;
import tugasbesar.kedaibonit.view.MainView;


/**
 *
 * @author CarakaMR
 */
public class KedaiBonit {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws tugasbesar.kedaibonit.error.PelangganException
     * @throws tugasbesar.kedaibonit.error.CatatUtangException
     */
    public static void main(String[] args) throws SQLException, PelangganException, CatatUtangException {
   
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainView mainview = new MainView();
                    mainview.loadDatabase();
                    mainview.setVisible(true);
                } catch (SQLException e) {
                } catch (PelangganException ex) {
                    Logger.getLogger(KedaiBonit.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CatatUtangException ex) {
                    Logger.getLogger(KedaiBonit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    }
    
        
                
