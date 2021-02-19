/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tugasbesar.kedaibonit.entity.CatatUtang;

/**
 *
 * @author CarakaMR
 */
public class TabelCatatUtangModel extends AbstractTableModel{
    
    private List<CatatUtang> list = new ArrayList<CatatUtang>();

    public void setList(List<CatatUtang> list) {
        this.list = list;
    }
    
    

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    public boolean add(CatatUtang e) {
        try {
            return list.add(e);
        }finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public CatatUtang get(int index) {
        return list.get(index);
    }

    public CatatUtang set(int index, CatatUtang element) {
        try {
        return list.set(index, element);    
        } finally {
            fireTableRowsUpdated(index, index);
        }
        
    }

    public CatatUtang remove(int index) {
        try {
        return list.remove(index);    
        } finally {
            fireTableRowsDeleted(index, index);
        }
        
    }
    
    

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 :
                return "ID";
            case 1 :
                return "Nama_Pelanggan";
            case 2 :
                return "Tanggal_Berutang";
            case 3 :
                return "Nama_Barang";
            case 4 :
                return "Nominal_Rp";
            case 5 :
                return "Jatuh_Tempo";
            case 6 :
                return "Status_Bayar";
            default:
                return null;
        }
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : 
                return list.get(rowIndex).getIdCU();
            case 1 : 
                return list.get(rowIndex).getNamacu();
            case 2 : 
                return list.get(rowIndex).getTanggalBerutang();
            case 3 : 
                return list.get(rowIndex).getNamaBarang();
            case 4 : 
                return list.get(rowIndex).getNominal();
            case 5 : 
                return list.get(rowIndex).getJatuhTempo();
            case 6 : 
                return list.get(rowIndex).getStatusBayar();
            default:
                return null;
            
        }
    }

   
    
    
    
   
}
