/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.entity;

/**
 *
 * @author dekteguh
 */
public class Operator {
    private Integer tahun;
    private Integer subround;
    private String idProv;
    private String idKab;
    private String nip;
    private String namaOperator;
    private Integer kategoriOperator;
    private String jabatan;
    private String noTelp;
    private String username;
    private String password;
    
    public Operator() {
    }

    public Operator(String username,String password,Integer tahun, Integer subround, String idProv, String idKab, String nip, String namaOperator, Integer kategoriOperator, String jabatan, String noTelp) {
        this.username = username;
        this.password = password;
        this.tahun = tahun;
        this.subround = subround;
        this.idProv = idProv;
        this.idKab = idKab;
        this.nip = nip;
        this.namaOperator = namaOperator;
        this.kategoriOperator = kategoriOperator;
        this.jabatan = jabatan;
        this.noTelp = noTelp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNamaOperator() {
        return namaOperator;
    }

    public void setNamaOperator(String namaOperator) {
        this.namaOperator = namaOperator;
    }

    public Integer getKategoriOperator() {
        return kategoriOperator;
    }

    public void setKategoriOperator(Integer kategoriOperator) {
        this.kategoriOperator = kategoriOperator;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    
}
