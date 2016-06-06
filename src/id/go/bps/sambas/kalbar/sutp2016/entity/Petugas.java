/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.entity;

/**
 *
 * @author dekteguh
 */
public class Petugas {
    private Integer tahun;
    private Integer subround;
    private String idProv;
    private String idKab;
    private String nks;
    private String namaPetugas;
    private String namaPengawas;

    public Petugas() {
    }

    public Petugas(Integer tahun, Integer subround, String idProv, String idKab, String nks, String namaPetugas, String namaPengawas) {
        this.tahun = tahun;
        this.subround = subround;
        this.idProv = idProv;
        this.idKab = idKab;
        this.nks = nks;
        this.namaPetugas = namaPetugas;
        this.namaPengawas = namaPengawas;
    }

    public String getNamaPengawas() {
        return namaPengawas;
    }

    public void setNamaPengawas(String namaPengawas) {
        this.namaPengawas = namaPengawas;
    }

    
    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public Integer getSubround() {
        return subround;
    }

    public void setSubround(Integer subround) {
        this.subround = subround;
    }

    public String getIdProv() {
        return idProv;
    }

    public void setIdProv(String idProv) {
        this.idProv = idProv;
    }

    public String getIdKab() {
        return idKab;
    }

    public void setIdKab(String idKab) {
        this.idKab = idKab;
    }

    public String getNks() {
        return nks;
    }

    public void setNks(String nks) {
        this.nks = nks;
    }

    public String getNamaPetugas() {
        return namaPetugas;
    }

    public void setNamaPetugas(String namaPetugas) {
        this.namaPetugas = namaPetugas;
    }
    
    
}
