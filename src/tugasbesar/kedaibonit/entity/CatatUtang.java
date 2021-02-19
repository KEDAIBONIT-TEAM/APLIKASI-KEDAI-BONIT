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
public class CatatUtang {
    
    private String idCU;
    private String namacu;
    private String tanggalBerutang;
    private String namaBarang;
    private String nominal;
    private String jatuhTempo;
    private String statusBayar;

    public String getIdCU() {
        return idCU;
    }

    public void setIdCU(String idCU) {
        this.idCU = idCU;
    }

    public String getNamacu() {
        return namacu;
    }

    public void setNamacu(String namacu) {
        this.namacu = namacu;
    }

    public String getTanggalBerutang() {
        return tanggalBerutang;
    }

    public void setTanggalBerutang(String tanggalBerutang) {
        this.tanggalBerutang = tanggalBerutang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(String jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    public String getStatusBayar() {
        return statusBayar;
    }

    public void setStatusBayar(String statusBayar) {
        this.statusBayar = statusBayar;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idCU);
        hash = 61 * hash + Objects.hashCode(this.namacu);
        hash = 61 * hash + Objects.hashCode(this.tanggalBerutang);
        hash = 61 * hash + Objects.hashCode(this.namaBarang);
        hash = 61 * hash + Objects.hashCode(this.nominal);
        hash = 61 * hash + Objects.hashCode(this.jatuhTempo);
        hash = 61 * hash + Objects.hashCode(this.statusBayar);
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
        final CatatUtang other = (CatatUtang) obj;
        if (!Objects.equals(this.idCU, other.idCU)) {
            return false;
        }
        if (!Objects.equals(this.namacu, other.namacu)) {
            return false;
        }
        if (!Objects.equals(this.tanggalBerutang, other.tanggalBerutang)) {
            return false;
        }
        if (!Objects.equals(this.namaBarang, other.namaBarang)) {
            return false;
        }
        if (!Objects.equals(this.nominal, other.nominal)) {
            return false;
        }
        if (!Objects.equals(this.jatuhTempo, other.jatuhTempo)) {
            return false;
        }
        if (!Objects.equals(this.statusBayar, other.statusBayar)) {
            return false;
        }
        return true;
    }
    
   
    
    
    
}
