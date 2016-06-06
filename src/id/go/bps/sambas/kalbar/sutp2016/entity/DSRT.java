/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bps.sambas.kalbar.sutp2016.entity;

/**
 *
 * @author dekteguh
 */
public class DSRT {
    private Integer tahun;
    private Integer subround;
    private String idProv;
    private String idKab;
    private String nks;
    private String pcl;
    private String pml;
    private double AR;
    private Integer nurtSampel;
    private String BF;
    private String BS;
    private Integer nurtListing;
    private String namaKrt;
    private String jenisTanaman;
    private Integer perkiraanPanen;
    private String jenisSampel;
    private Integer realisasiPanen;
    private Integer berhasilPanen;
    private String alasanTidakBerhasilPanen;
    private Integer ubinanBersama;
    private double hasilUbinan;
    private String username;
    
    public DSRT() {
    }

    public DSRT(String username, Integer tahun, Integer subround, String idProv, String idKab, String nks, String pcl, String pml, double AR, Integer nurtSampel, String BF, String BS, Integer nurtListing, String namaKrt, String jenisTanaman, Integer perkiraanPanen, String jenisSampel, Integer realisasiPanen, Integer berhasilPanen, String alasanTidakBerhasilPanen, Integer ubinanBersama, double hasilUbinan) {
        this.tahun = tahun;
        this.subround = subround;
        this.idProv = idProv;
        this.idKab = idKab;
        this.nks = nks;
        this.pcl = pcl;
        this.pml = pml;
        this.AR = AR;
        this.nurtSampel = nurtSampel;
        this.BF = BF;
        this.BS = BS;
        this.nurtListing = nurtListing;
        this.namaKrt = namaKrt;
        this.jenisTanaman = jenisTanaman;
        this.perkiraanPanen = perkiraanPanen;
        this.jenisSampel = jenisSampel;
        this.realisasiPanen = realisasiPanen;
        this.berhasilPanen = berhasilPanen;
        this.alasanTidakBerhasilPanen = alasanTidakBerhasilPanen;
        this.ubinanBersama = ubinanBersama;
        this.hasilUbinan = hasilUbinan;
        this.username = username;
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

    public String getNks() {
        return nks;
    }

    public void setNks(String nks) {
        this.nks = nks;
    }

    public String getPcl() {
        return pcl;
    }

    public void setPcl(String pcl) {
        this.pcl = pcl;
    }

    public String getPml() {
        return pml;
    }

    public void setPml(String pml) {
        this.pml = pml;
    }

    public double getAR() {
        return AR;
    }

    public void setAR(double AR) {
        this.AR = AR;
    }

    public Integer getNurtSampel() {
        return nurtSampel;
    }

    public void setNurtSampel(Integer nurtSampel) {
        this.nurtSampel = nurtSampel;
    }

    public String getBF() {
        return BF;
    }

    public void setBF(String BF) {
        this.BF = BF;
    }

    public String getBS() {
        return BS;
    }

    public void setBS(String BS) {
        this.BS = BS;
    }

    public Integer getNurtListing() {
        return nurtListing;
    }

    public void setNurtListing(Integer nurtListing) {
        this.nurtListing = nurtListing;
    }

    public String getNamaKrt() {
        return namaKrt;
    }

    public void setNamaKrt(String namaKrt) {
        this.namaKrt = namaKrt;
    }

    public String getJenisTanaman() {
        return jenisTanaman;
    }

    public void setJenisTanaman(String jenisTanaman) {
        this.jenisTanaman = jenisTanaman;
    }

    public Integer getPerkiraanPanen() {
        return perkiraanPanen;
    }

    public void setPerkiraanPanen(Integer perkiraanPanen) {
        this.perkiraanPanen = perkiraanPanen;
    }

    public String getJenisSampel() {
        return jenisSampel;
    }

    public void setJenisSampel(String jenisSampel) {
        this.jenisSampel = jenisSampel;
    }

    public Integer getRealisasiPanen() {
        return realisasiPanen;
    }

    public void setRealisasiPanen(Integer realisasiPanen) {
        this.realisasiPanen = realisasiPanen;
    }

    public Integer getBerhasilPanen() {
        return berhasilPanen;
    }

    public void setBerhasilPanen(Integer berhasilPanen) {
        this.berhasilPanen = berhasilPanen;
    }

    public String getAlasanTidakBerhasilPanen() {
        return alasanTidakBerhasilPanen;
    }

    public void setAlasanTidakBerhasilPanen(String alasanTidakBerhasilPanen) {
        this.alasanTidakBerhasilPanen = alasanTidakBerhasilPanen;
    }

    public Integer getUbinanBersama() {
        return ubinanBersama;
    }

    public void setUbinanBersama(Integer ubinanBersama) {
        this.ubinanBersama = ubinanBersama;
    }

    public double getHasilUbinan() {
        return hasilUbinan;
    }

    public void setHasilUbinan(double hasilUbinan) {
        this.hasilUbinan = hasilUbinan;
    }

    
}
