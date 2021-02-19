/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar.kedaibonit.entity;

import java.util.Objects;

/**
 *
 * @author CarakaMR
 */
public class Pelanggan {
    
    private Integer id;
    private String namapelanggan;
    private String nomorhp;
    
    public Pelanggan() {
        
    }

    public Pelanggan(String namapelanggan, String nomorhp) {
        this.namapelanggan = namapelanggan;
        this.nomorhp = nomorhp;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamapelanggan() {
        return namapelanggan;
    }

    public void setNamapelanggan(String namapelanggan) {
        this.namapelanggan = namapelanggan;
    }

    public String getNomorhp() {
        return nomorhp;
    }

    public void setNomorhp(String nomorhp) {
        this.nomorhp = nomorhp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.namapelanggan);
        hash = 29 * hash + Objects.hashCode(this.nomorhp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelanggan other = (Pelanggan) obj;
        if (!Objects.equals(this.namapelanggan, other.namapelanggan)) {
            return false;
        }
        if (!Objects.equals(this.nomorhp, other.nomorhp)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
